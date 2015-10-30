package com.geekhub.hw4.taskmanager;

import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManagerImpl implements TaskManager {

    private Map<Date, Task> taskMap;

    public TaskManagerImpl() {
        taskMap = new HashMap<>();
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
        Map<String, List<Task>> categoriesMap = new HashMap<>();
        for (Task task : taskMap.values()) {
            String category = task.getCategory();
            if (!categoriesMap.containsKey(category)) {
                categoriesMap.put(category, getTasksByCategory(category));
            }
        }
        return null;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> taskList = new ArrayList<>();
        for (Task task : sortTaskByDate().values()) {
            if (category.equals(task.getCategory())) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> taskList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        String todayDate = sdf.format(Calendar.getInstance().getTime());

        for (Map.Entry<Date, Task> entry : sortTaskByDate().entrySet()) {
            if (todayDate.equals(sdf.format(entry.getKey()))) {
                taskList.add(entry.getValue());
            }
        }

        return taskList;
    }

    private Map<Date, Task> sortTaskByDate() {
        return new TreeMap<>(taskMap);
    }
}
