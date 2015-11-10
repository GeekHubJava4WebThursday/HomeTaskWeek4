package com.company;

import java.util.*;

/**
 * Created by InnaBakum on 10.11.2015.
 */
public class TaskManagerImplements implements TaskManager {

    private Map<Date, List<Task>> task = new WeakHashMap<Date, List<Task>>();


    @Override
    public void addTask(Date date, Task task){
        if (!this.task.containsKey(date)) {
            List<Task> lTask = new ArrayList<Task>();
            lTask.add(task);
            this.task.put(date, lTask);
        } else {
            for (Map.Entry<Date, List<Task>> entry : this.task.entrySet()) {
                Date entryDate = entry.getKey();
                if (entryDate.compareTo(date) == 0) {
                    List<Task> lTask = entry.getValue();
                    lTask.add(task);
                    this.task.replace(date, lTask);
                    break;
                }
            }
        }

    }

    @Override
    public void removeTask(Date date) {
        if (this.task.containsKey(date)) {
            this.task.remove(date);
        }
    }

    @Override
    public Collection<String> getCategories() {
        Set<String> category = new HashSet<String>();
        if (!this.task.isEmpty()) {
            for (Map.Entry<Date, List<Task>> entry : this.task.entrySet()) {
                List<Task> lTask = entry.getValue();
                Iterator<Task> iter = lTask.iterator();
                while (iter.hasNext()) {
                    Task item = iter.next();
                    category.add(item.getCategory());
                }
            }
            return category;
        } else {
            return null;
        }
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> categoryMap = new HashMap<String, List<Task>>();
        Set<String> categories = new HashSet<String>();
        List<Task> lTask = new ArrayList<Task>();
        String nameCategory;
        if (!this.task.isEmpty()) {
            categories.addAll(getCategories());
            for (String s: categories) {
                categoryMap.put(s, null);
            }
            for (Map.Entry<String, List<Task>> entry : categoryMap.entrySet()) {
                nameCategory = entry.getKey();
                lTask = getTasksByCategory(nameCategory);
                categoryMap.replace(nameCategory, lTask);
            }
        }
        return categoryMap;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return getTasksByCategories().get(category);
    }

    @Override
    public List<Task> getTasksForToday() {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date = c.getTime();
        List<Task> taskList = new ArrayList<Task>();
        if (!this.task.isEmpty()) {
            for (Map.Entry<Date, List<Task>> entry : this.task.entrySet()) {
                Date dateTask = entry.getKey();
                if (date.compareTo(dateTask) == 0) {
                    taskList.addAll(entry.getValue());
                }
            }
        }
        return taskList;
    }

    public String toString() {
        String str = new String("");
        for (Map.Entry<Date, List<Task>> entry : this.task.entrySet()) {
            str += entry.getKey().toString() + "\n" +
                    entry.getValue().toString() + "\n";
        }
        return str;
    }
}

