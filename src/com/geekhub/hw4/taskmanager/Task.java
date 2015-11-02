package com.geekhub.hw4.taskmanager;


public class Task {

    private String category;
    private String description;

    public Task(String category , String description) {
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return "category : [" + category + "]\tdescription : [" + description + "]";
    }

    public String getCategory() { return category; }

    public String getDescription() { return description; }
}
