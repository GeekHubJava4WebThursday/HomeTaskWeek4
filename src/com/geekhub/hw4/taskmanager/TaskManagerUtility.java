package com.geekhub.hw4.taskmanager;

import java.util.*;

public class TaskManagerUtility implements TaskManager {

    private HashMap<Date, Task> tasks;

    public TaskManagerUtility(HashMap<Date, Task> tasks) {
        this.tasks = tasks;
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
        Collection<String> categories = new HashSet<>();
        for (Task task: tasks.values()) {
            categories.add(task.getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> tasksByCategories = new HashMap<>();
        Collection<String> categories = getCategories();
        for (String category: categories) {
            tasksByCategories.put(category, getTasksByCategory(category));
        }
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = new ArrayList<>();
        for (Task task: tasks.values()) {
            if (task.getCategory().equals(category)) {
                tasksByCategory.add(task);
            }
        }
        return tasksByCategory;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();
        for (Task task: tasks.values()) {
            if (task.getDateCreated().compareTo(new Date()) == 0) {
                tasksForToday.add(task);
            }
        }
        return tasksForToday;
    }

    @Override
    public String toString() {
        String out = "";
        for (Map.Entry<Date, Task> entry: tasks.entrySet()) {
            out += ("Date: " + entry.getKey().toString() + ", " + entry.getValue().toString()) + "\n";
        }
        return out;
    }
}
