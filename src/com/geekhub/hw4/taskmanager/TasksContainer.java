package com.geekhub.hw4.taskmanager;

import java.util.*;

public class TasksContainer implements TaskManager {

    private Map<Date, Task> tasks;

    public TasksContainer() {
        tasks = new TreeMap<>();
    }

    /**
     * @param date schedule date
     * @param task task which should be added
     */
    @Override
    public void addTask(Date date, Task task) {
        tasks.put(date, task);
    }

    /**
     * removes task by schedule date
     * @param date
     */
    @Override
    public void removeTask(Date date) {
        tasks.remove(date);
    }

    /**
     * @return all categories
     */
    @Override
    public Collection<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for(Map.Entry<Date,Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            categories.add(task.getCategory());
        }
        return categories;
    }

    /**
     * @return tasks by categories sorted by scheduled date
     */
    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String,List<Task>> tasksByCategories = new HashMap<>();
        for (Map.Entry<Date,Task> taskEntry : tasks.entrySet()) {
            String category = taskEntry.getValue().getCategory();
            List<Task> categoryTasksList = tasksByCategories.get(category);
            if (categoryTasksList == null) {
                categoryTasksList = new ArrayList<>();
                tasksByCategories.put(category, categoryTasksList);
            }
            categoryTasksList.add(taskEntry.getValue());
        }
        // tasks will be sorted by date in each list, because it is used TreeMap in tasks field (sorted by date)
        // consequently, tasks will be iterated in date order and will be added in date order too
        return tasksByCategories;
    }

    /**
     * @param category name of the category
     * @return category task list sorted by scheduled date
     */
    @Override
    public List<Task> getTasksByCategory(String category) {
        if (category == null) {
            return null;
        }

        List<Task> tasksOfCategory = new ArrayList<>();
        for (Map.Entry<Date, Task> task : tasks.entrySet()) {
            if (category.equals(task.getValue().getCategory())) {
                tasksOfCategory.add(task.getValue());
            }
        }
        return tasksOfCategory; // will be sorted by date
    }

    /**
     * @return list of task, should be scheduled today, sorted by scheduled date
     */
    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksListForToday = new ArrayList<>();
        Calendar today = Calendar.getInstance();
        Calendar taskDate = Calendar.getInstance();
        for (Date date : tasks.keySet()) {
            taskDate.setTime(date);
            if (today.get(Calendar.YEAR) == taskDate.get(Calendar.YEAR)
                    && today.get(Calendar.DAY_OF_YEAR) == taskDate.get(Calendar.DAY_OF_YEAR)) {
                tasksListForToday.add(tasks.get(date));
            }
        }
        return tasksListForToday;
    }

}
