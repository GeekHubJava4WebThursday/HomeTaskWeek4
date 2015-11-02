package com.geekhub.hw4.taskmanager;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  Implement some methods from TaskManager interface
 */
public class TaskManagerImplement implements TaskManager {

    @Override
    public void addTask(Date date, Task task) {

    }

    @Override
    public void removeTask(Date date) {

    }

    @Override
    public Collection<String> getCategories() {
        return null;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return null;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        return null;
    }

    @Override
    public List<Task> getTasksForToday() {
        return null;
    }
}
