package com.geekhub.hw4.taskmanager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TaskManagerTest {

    public static void test() {
        TaskManagerUtility taskManagerUtility = new TaskManagerUtility(new HashMap<>());
        taskManagerUtility.addTask(new Date(), new Task("Test", "Test classes"));
        taskManagerUtility.addTask(new Date(), new Task("Bugs", "Bug fixing"));
        taskManagerUtility.addTask(new Date(), new Task("Test", "Test SetOperations"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Calendar.OCTOBER, 12);
        taskManagerUtility.addTask(calendar.getTime(), new Task("Coding", "Coding Task class"));
        calendar.set(Calendar.YEAR, Calendar.OCTOBER, 15);
        taskManagerUtility.addTask(calendar.getTime(), new Task("Test", "Test TaskManager"));

        System.out.println(taskManagerUtility.getCategories());
        System.out.println(taskManagerUtility.getTasksByCategory("Test"));
        System.out.println(taskManagerUtility.toString());

    }
}
