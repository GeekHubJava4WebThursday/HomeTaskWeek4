package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * Manager
 */
public class Manager implements TaskManager {

    private Map<Date, Task> table;

    public Manager() {
        table = new HashMap<>();
    }

    @Override
    public void addTask(Date date, Task task) throws InterruptedException {
        table.put(date, task);
    }

    @Override
    public void removeTask(Date date) {
        table.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        Collection<String> categories = new ArrayList<>();
        for (Map.Entry entry : table.entrySet()) {
            Task task = (Task) entry.getValue();

            // check for original categories
            boolean original = true;
            for (String string : categories) {
                if (string.equals(task.getCategory())) {
                    original = false;
                    break;
                }
            }
            if (original == true) {
                categories.add(task.getCategory());
            }
        }

        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        TreeMap<String, List<Task>> treeMap = new TreeMap<>();

        for (Map.Entry entry : table.entrySet()) {
            Task task = (Task) entry.getValue();
            String category = task.getCategory();

            boolean original = true;

            for (Map.Entry tree : treeMap.entrySet()) {
                if (category.equals(tree.getKey())) {
                    original = false;
                    break;
                }
            }

            if (original == true) {
                LinkedList<Task> list = (LinkedList<Task>) getTasksByCategory(category);
                treeMap.put(category, list);
            }
        }
        return treeMap;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        LinkedList<Task> tasks = new LinkedList<>();
        for (Map.Entry entry : table.entrySet()) {
            Task current = (Task) entry.getValue();
            if (current.getCategory().equals(category)) {
                tasks.add(current);
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> list = new LinkedList<>();
        Date current = new Date();
        int year = current.getYear();
        int month = current.getMonth();
        int day = current.getDay();

        for (Map.Entry entry : table.entrySet()) {
            Date date = (Date) entry.getKey();
            if (year == date.getYear() && month == date.getMonth() && day == date.getDay()) {
                list.add((Task) entry.getValue());
            }
        }
        return list;
    }

    public void showAll() {
        if (table.size() == 0) {
            System.out.println("Task table is empty");
        } else {
            for (Map.Entry<Date, Task> entry : table.entrySet()) {
                System.out.println("Date : [" + entry.getKey() + "]\t" + entry.getValue());
            }
        }
    }
}
