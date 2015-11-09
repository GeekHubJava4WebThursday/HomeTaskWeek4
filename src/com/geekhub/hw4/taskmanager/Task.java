package com.geekhub.hw4.taskmanager;

public class Task {
    private String category;
    private String description;

    public Task(String category, String description) {
        this.category = category;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
