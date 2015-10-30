package com.geekhub.hw4.taskmanager;

public class Task implements Comparable<Task> {
    private String category;
    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Task o) {
        return category.compareTo(o.getCategory());
    }
}
