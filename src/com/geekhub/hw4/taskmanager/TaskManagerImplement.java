package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * Created by Вадимка on 01.11.2015.
 */
public class TaskManagerImplement implements TaskManager {

    private Map<Date,Task> dateTaskMap;

    public TaskManagerImplement(){
        dateTaskMap = new TreeMap <>();
    }

    @Override
    public void addTask(Date date, Task task) {
        dateTaskMap.put(date,task);
    }

    @Override
    public void removeTask(Date date) {
        dateTaskMap.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        Set<String> categories = new HashSet<String>();
        for(Map.Entry<Date, Task> entry : dateTaskMap.entrySet()){
            categories.add(entry.getValue().getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> stringListMap = new HashMap<>();
        for(String category : getCategories()){
            stringListMap.put(category, getTasksByCategory(category));
        }
        return stringListMap;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> taskList = new ArrayList<Task>();
        for(Map.Entry<Date, Task> map : dateTaskMap.entrySet()){
            if(category.equals(map.getValue().getCategory())){
                taskList.add(map.getValue());
            }
        }
        return taskList;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> taskList = new ArrayList<>();
        Date date = new Date();
        for(Map.Entry<Date, Task> mapTask : dateTaskMap.entrySet()){
            if(date.getDay() == mapTask.getKey().getDay() &&
                    date.getMonth() == mapTask.getKey().getMonth() &&
                    date.getYear() == mapTask.getKey().getYear())
                taskList.add(mapTask.getValue());
        }
        return taskList;
    }


}
