package com.geekhub.hw4.taskmanager;

import java.util.*;

public interface TaskManager {
    /**
     * @param date schedule date
     * @param task task which should be added
     */
    void addTask(Date date, Task task) throws InterruptedException;

    /**
     * removes task by schedule date
     * @param date
     */
    void removeTask(Date date);

    /**
     * @return all categories
     */
    Collection<String> getCategories();

    /**
     * @return tasks by categories sorted by scheduled date
     */
    Map<String, List<Task>> getTasksByCategories();

    /**
     * @param category name of the category
     * @return category task list sorted by scheduled date
     */
    List<Task> getTasksByCategory(String category);

    /**
     * @return list of task, should be scheduled today, sorted by scheduled date
     */
    List<Task> getTasksForToday();
}
