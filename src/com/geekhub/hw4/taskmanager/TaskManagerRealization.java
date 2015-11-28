package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * Created by developer on 28.11.2015.
 */
public class TaskManagerRealization implements TaskManager {
    Map<Date, Task> tasks = new TreeMap<>();
    @Override
    public void addTask(Date date, Task task) {
        tasks.put(date, task);
    }

    @Override
    public void removeTask(Date date) {
        tasks.remove(date);

    }

    @Override
    public Collection<String> getCategories() {
        Collection<String> categories = new ArrayList<>();
        for (Task task : tasks.values()) {
            categories.add(task.getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> taskByCategories = new HashMap<>();
        for(String category: getCategories()) {
            taskByCategories.put(category, getTasksByCategory(category));
        }

        return taskByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = new ArrayList<>();
        for (Task task : tasks.values()){
            if (task.getCategory().equals(category)){
            tasksByCategory.add(task);
        }
        }
        return null;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();

        for (Date date : tasks.keySet()){
            if(date.equals(new Date())){
                tasksForToday.add(tasks.get(date));
            }
        }

        return tasksForToday;
    }
}
