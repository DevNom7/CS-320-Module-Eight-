/*
 * Name: Naim Lindsay
 * Professor: David Handlos
 * Date: 2024-06-14
 *
 * This is the Task class for the mobile app services project.
 * It stores information about a task and enforces validation rules.
 */
package com.grandstrand.systems;

// The Task class represents a single task in the system
public class Task {
    // The task's unique ID (cannot be changed after creation)
    private final String taskId;
    // The task's name
    private String name;
    // The task's description
    private String description;

    // Constructor to create a new Task object
    public Task(String taskId, String name, String description) {
        // Validate taskId
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be null and must be 10 characters or less");
        }
        // Validate name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and must be 20 characters or less");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less");
        }

        // Set fields
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters (methods to access the fields)
    public String getTaskId() { return taskId; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    // Setters (methods to update the fields)
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and must be 20 characters or less");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less");
        }
        this.description = description;
    }
} 