package com.geekhub.hw4.taskmanager;

import java.util.Date;

public class Task implements Comparable<Task>{

    private String category;
    private String description;
    private Date dateCreated;

    public Task(String category, String description) {
        this.category = category;
        this.description = description;
    }

    @Override
    public int compareTo(Task anotherTask) {
        if (category.compareTo(anotherTask.getCategory()) == 0) {
            return description.compareTo(anotherTask.getDescription());
        }
        return category.compareTo(anotherTask.getCategory());
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!category.equals(task.category)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
