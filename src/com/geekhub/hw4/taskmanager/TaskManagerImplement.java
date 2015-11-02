package com.geekhub.hw4.taskmanager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  Implement some methods from TaskManager interface
 */
public class TaskManagerImplement implements TaskManager {
    private Map<Date, Task> tasksMap = new TreeMap<>();

    @Override
    public void addTask(Date date, Task task) {
        tasksMap.put(date, task);
    }

    @Override
    public void removeTask(Date date) {
        tasksMap.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        Set<String> categories = new HashSet<String>();
        for(Map.Entry<Date, Task> entry : tasksMap.entrySet()){
                 categories.add(entry.getValue().getCategory());
        }
        return categories;

    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> taskList = new ArrayList<Task>();
        for(Map.Entry<Date, Task> map : tasksMap.entrySet()){
            if(category.equals(map.getValue().getCategory())){
                taskList.add(map.getValue());
            }
        }
        return taskList;
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
    public List<Task> getTasksForToday() {

        List<Task> tasksForToday = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Date date : tasksMap.keySet()){
            if(dateFormat.format(date).equals(dateFormat.format(new Date()))) {
                tasksForToday.add(tasksMap.get(date));
            }
        }

        return tasksForToday;
    }
}
