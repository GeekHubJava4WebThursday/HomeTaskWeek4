package com.geekhub.hw4.taskmanager;

public class Task implements Comparable<Task> {

    private String category;
    private String description;

    public Task(String category, String description) {
        this.category = category;
        this.description = description;
    }

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

    @Override
    public String toString() {
        return category + ": " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return category.equals(task.category) && description.equals(task.description);

    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
