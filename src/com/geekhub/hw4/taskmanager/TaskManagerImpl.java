package com.geekhub.hw4.taskmanager;

import java.util.*;

public class TaskManagerImpl implements TaskManager {

    private Map<Date, Task> taskMap;

    public TaskManagerImpl(Map<Date, Task> taskMap) {
        this.taskMap = taskMap;
    }

    @Override
    public void addTask(Date date, Task task) {
        taskMap.put(date, task);
    }

    @Override
    public void removeTask(Date date) {
        taskMap.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        List<String> categoriesList = new ArrayList<>();
        for (Task task : taskMap.values()) {
            categoriesList.add(task.getCategory());
        }
        return categoriesList;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        List<Task> taskList;
        Map<String, List<Task>> categoriesMap = new HashMap<>();
        for (Task task : taskMap.values()) {
            String category = task.getCategory();
            if (!categoriesMap.keySet().contains(category)) {
                taskList = new ArrayList<>();
                taskList.add(task);
                categoriesMap.put(category, taskList);
            } else {
                taskList = categoriesMap.get(category);
                taskList.add(task);
            }
        }
        return null;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return null;
    }

    @Override
    public List<Task> getTasksForToday() {
        return null;
    }
}
