package dsa_final.todo;

import java.util.Date;

public class Task {
    private String name;
    private Date dueDate;
    private boolean isUrgent;
    private String category;
    private String priority;

    // Constructor

    public Task() {

    }

    public Task(String name, Date dueDate, boolean isUrgent, String category) {
        // Validate input parameters
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty.");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("Due date cannot be null.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }

        this.name = name;
        this.dueDate = new Date(dueDate.getTime()); // Ensure immutability of the date
        this.isUrgent = isUrgent;
        this.category = category;
        this.priority = (isUrgent ? "Urgent" : "Normal");
        if (priority == null || priority.trim().isEmpty()) {
            throw new IllegalArgumentException("Priority cannot be null or empty.");
        }
    }

    public String getName() {
        return name;
    }

    public Date getDueDate() {
        return new Date(dueDate.getTime()); // Return a copy to maintain immutability
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", isUrgent=" + isUrgent +
                ", category='" + category + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
