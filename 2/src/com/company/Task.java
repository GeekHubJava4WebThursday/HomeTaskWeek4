package com.company;

/**
 * Created by InnaBakum on 09.11.2015.
 */
public class Task {
    private String category;
    private String description;

    public Task(String category, String description){
        this.category = category;
        this.description = description;
    }

    public String getCategory(){
        return category;
    }

    public String getDescription(){
        return description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return " " + category + " " + description + " ";
    }
}
