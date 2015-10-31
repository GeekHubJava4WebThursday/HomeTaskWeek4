package com.geekhub.hw4.taskmanager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManagerImpl implements TaskManager {
    private Map<Date, Task> tasks = new TreeMap<>();

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
        Collection<String> categories = new HashSet<>();

        for(Task task: tasks.values()) {
            categories.add(task.getCategory());
        }

        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> tasksByCategories = new HashMap<>();

        for(String category: getCategories()) {
            tasksByCategories.put(category, getTasksByCategory(category));
        }

        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = new ArrayList<>();

        for (Task task : tasks.values()) {
            if(task.getCategory().equals(category)) {
                tasksByCategory.add(task);
            }
        }

        return tasksByCategory;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Date date : tasks.keySet()){
            if(dateFormat.format(date).equals(dateFormat.format(new Date()))) {
                tasksForToday.add(tasks.get(date));
            }
        }

        return tasksForToday;
    }
}
