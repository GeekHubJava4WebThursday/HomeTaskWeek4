package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * Created by sergei on 10/30/15.
 */
public class TaskManagerImpl implements TaskManager {
    private Map<Date, Task> tasks = new TreeMap<>();

    @Override
    public void addTask(Date date, Task task) {
        tasks.put(date, task);
    }

    @Override
    public void removeTask(Date date) {
        if (tasks.containsKey(date)) {
            tasks.remove(date);
        }
    }

    @Override
    public Collection<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for (Task task : tasks.values()) {
            categories.add(task.getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> tasksByCategories = new TreeMap<>();

        for (String category : getCategories()) {
            tasksByCategories.put(category, getTasksByCategory(category));
        }
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasksByCategory = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getCategory().equals(category)) {
                tasksByCategory.add(task);
            }
        }
        return tasksByCategory;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();
        for (Map.Entry<Date, Task> taskEntry : tasks.entrySet()) {
            if (isToday(taskEntry.getKey())) {
                tasksForToday.add(taskEntry.getValue());
            }
        }
        return tasksForToday;
    }

    private boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        Date today = new Date();
        if (date.getYear() == today.getYear() &&
                date.getMonth() == today.getMonth() &&
                date.getDay() == today.getDay()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        taskManager.addTask(new Date(100),new Task("eat","eat breakfast"));
        taskManager.addTask(new Date(33),new Task("eat","eat diner"));
        taskManager.addTask(new Date(10000),new Task("work","do homework"));
        taskManager.addTask(new Date(),new Task("relax","go out"));

        System.out.println(taskManager.getCategories());
        System.out.println(taskManager.getTasksByCategory("eat"));
        System.out.println(taskManager.getTasksByCategories());
        System.out.println(taskManager.getTasksForToday());

        taskManager.removeTask(new Date(10000));
        System.out.println(taskManager.getCategories());

    }

}
