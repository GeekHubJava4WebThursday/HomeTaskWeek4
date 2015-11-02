package com.geekhub.hw4.taskmanager;

import java.util.*;

public class TaskHandler implements TaskManager {

    private Map<Date, Task> tasks;

    public TaskHandler() {
        tasks = new TreeMap<>();
    }

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
        Set<String> categories = new HashSet<>();

        for (Map.Entry<Date, Task> entry : tasks.entrySet()) {
            categories.add(entry.getValue().getCategory());
        }

        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> tasksByCategories = new HashMap<>();

        for (Map.Entry<Date, Task> entry : tasks.entrySet()) {
            String category = entry.getValue().getCategory();
            List<Task> tasksByCategory = tasksByCategories.get(category);
            if (tasksByCategory == null) {
                tasksByCategory = new ArrayList<>();
                tasksByCategories.put(category, tasksByCategory);
            }
            tasksByCategory.add(entry.getValue());
        }

        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = new ArrayList<>();

        for (Map.Entry<Date, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getCategory().equals(category)) {
                tasksByCategory.add(entry.getValue());
            }
        }

        return tasksByCategory;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();

        Calendar currentDate = Calendar.getInstance();
        Calendar currentTaskDate = Calendar.getInstance();

        for (Date taskDate : tasks.keySet()) {
            currentTaskDate.setTime(taskDate);
            if (isSameDay(currentDate, currentTaskDate)) {
                tasksForToday.add(tasks.get(taskDate));
            }
        }

        return tasksForToday;
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }
}
