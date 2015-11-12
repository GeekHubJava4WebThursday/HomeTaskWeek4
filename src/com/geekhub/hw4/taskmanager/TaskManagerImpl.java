package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * Created by Kvart on 12.11.2015.
 */
public class TaskManagerImpl implements TaskManager {
    private Map<Date,Task> tasks = new HashMap<>();
    @Override
    public void addTask(Date date, Task task) {
        tasks.put(date,task);
    }

    @Override
    public void removeTask(Date date) {
        tasks.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        return getTasksByCategories().keySet();
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map <String, List<Task>> tasksByCategories = new HashMap<>();
        for (Date date:tasks.keySet()){
            Task task = tasks.get(date);
            String category = task.getCategory();
            List<Task> taskList = tasksByCategories.get(category);
            if (taskList == null){
                taskList = new ArrayList<>();
            }
            taskList.add(task);
            tasksByCategories.put(category,taskList);
        }
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return getTasksByCategories().get(category);
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();
        Calendar today = Calendar.getInstance();
        Calendar taskDate = Calendar.getInstance();
        for (Date date:tasks.keySet()){
            taskDate.setTime(date);
            if (today.get(Calendar.YEAR)== taskDate.get(Calendar.YEAR) && today.get(Calendar.MONTH)== taskDate.get(Calendar.MONTH) && today.get(Calendar.DATE)== taskDate.get(Calendar.DATE)){
                Task task = tasks.get(taskDate.getTime());
                tasksForToday.add(task);
            }
        }

        return tasksForToday;
    }
}
