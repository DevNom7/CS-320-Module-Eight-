/*
 * Name: Naim Lindsay
 * Professor: David Handlos
 * Date: 2024-06-14
 *
 * This is the TaskService class for the mobile app services project.
 * It manages a collection of Task objects in memory.
 */
package com.grandstrand.systems;

import java.util.HashMap;
import java.util.Map;

// The TaskService class manages tasks (add, delete, update)
public class TaskService {
    // This map stores tasks by their unique ID
    private final Map<String, Task> tasks;

    // Constructor initializes the tasks map
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Add a new task to the service
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        // Make sure the task ID is unique
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with ID " + task.getTaskId() + " already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }
        tasks.remove(taskId);
    }

    // Update fields of a task by ID
    public void updateTask(String taskId, String name, String description) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }

        Task task = tasks.get(taskId);
        // Only update fields if new values are provided (not null)
        if (name != null) task.setName(name);
        if (description != null) task.setDescription(description);
    }

    // Get a task by ID
    public Task getTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        return tasks.get(taskId);
    }
} 