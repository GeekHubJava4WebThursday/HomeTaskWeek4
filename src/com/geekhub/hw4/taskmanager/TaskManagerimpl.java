package com.geekhub.hw4.taskmanager;

import java.util.*;

/**
 * Created by COMRADE on 01.11.2015.
 */
public class TaskManagerimpl implements TaskManager {

    private Map<Date, Task> dateTaskMap = new TreeMap<Date, Task>();

    @Override
    public void addTask(Date date, Task task) {
        dateTaskMap.put(date, task);
    }

    @Override
    public void removeTask(Date date) {
        dateTaskMap.remove(date);
    }

    @Override
    public Collection<String> getCategories() {
        Set<String> categories = new HashSet<String>();
        for(Map.Entry<Date, Task> entry : dateTaskMap.entrySet()){
            categories.add(entry.getValue().getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> stringListMap = new HashMap<>();
        for(String category : getCategories()){
            stringListMap.put(category, getTasksByCategory(category));
        }
        return stringListMap;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> taskList = new ArrayList<Task>();
        for(Map.Entry<Date, Task> map : dateTaskMap.entrySet()){
            if(category.equals(map.getValue().getCategory())){
                taskList.add(map.getValue());
            }
        }
        return taskList;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> taskList = new ArrayList<>();
        Date date = new Date();
        for(Map.Entry<Date, Task> mapTask : dateTaskMap.entrySet()){
            if(date.getDay() == mapTask.getKey().getDay() &&
                    date.getMonth() == mapTask.getKey().getMonth() &&
                    date.getYear() == mapTask.getKey().getYear())
                taskList.add(mapTask.getValue());
        }
        return taskList;
    }

    public static void main(String args[]){
        TaskManagerimpl taskManagerimpl = new TaskManagerimpl();
        Task task1 = new Task();
        task1.setCategory("object - oriented language");
        task1.setDescription("Java");
        taskManagerimpl.dateTaskMap.put(new Date(456132),task1 );

        Task task2 = new Task();
        task2.setCategory("object - oriented language");
        task2.setDescription("C#");
        taskManagerimpl.dateTaskMap.put(new Date(45686), task2);

        Task task3 = new Task();
        task3.setCategory("compiled statically typed language");
        task3.setDescription("C++");
        taskManagerimpl.dateTaskMap.put(new Date(123456), task3);

        Task task4 = new Task();
        task4.setCategory("compiled statically typed language");
        task4.setDescription("C");
        taskManagerimpl.dateTaskMap.put(new Date(), task4);
        System.out.println(taskManagerimpl.getCategories());
        System.out.println(taskManagerimpl.getTasksByCategories());
        System.out.println(taskManagerimpl.getTasksForToday());
        System.out.println(taskManagerimpl.getTasksByCategory("compiled statically typed language"));

    }


}
