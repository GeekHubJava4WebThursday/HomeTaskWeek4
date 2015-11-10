package com.geekhub.hw4.taskmanager;

import java.time.DayOfWeek;
import java.util.*;

public class TaskManImp implements TaskManager {

    private Map<Date, List<Task>> dateTaskMap = new TreeMap<Date, List<Task>>();

    public void addTask(Date date, Task task) {
        if (dateTaskMap.containsKey(date)){
            dateTaskMap.get(date).add(task);
        }
        else {
            List<Task> temp = new ArrayList<>();
            temp.add(task);
            dateTaskMap.put(date,temp);
        };
    }


    @Override
    public void removeTask(Date date) {
        dateTaskMap.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        Set <String> categoriesSet = new HashSet<String>();
        for (Map.Entry<Date, List<Task>> entry : dateTaskMap.entrySet()){
            for (Task task : entry.getValue()){
                categoriesSet.add(task.getCategory());
            }
        }
        return categoriesSet;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> mapList = new HashMap<>();
        for(String category : getCategories()){
            mapList.put(category, getTasksByCategory(category));
        }
        return mapList;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> categoryList = new ArrayList<Task>();
        for (Map.Entry<Date, List<Task>> entry : dateTaskMap.entrySet()){
            for (Task task : entry.getValue()){
                if (task.getCategory().equals(category)){
                    categoryList.add(task);
                }
            }
        }
        return categoryList;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> todayList = new ArrayList<Task>();
        //Date date = new Date();
        for (Map.Entry<Date,List<Task>> entry:dateTaskMap.entrySet()){
            Calendar today = Calendar.getInstance();
            today.setTime(entry.getKey());
            if (Calendar.getInstance().get(Calendar.DAY_OF_YEAR)==today.get(Calendar.DAY_OF_YEAR)){
                for (Task task :entry.getValue()){
                    todayList.add(task);
                }
            }
        }
      return todayList;
    }
}
