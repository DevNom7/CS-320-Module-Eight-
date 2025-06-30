package com.grandstrand.systems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.grandstrand.systems.Task;
import com.grandstrand.systems.TaskService;

public class TaskServiceTest {
    
    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Complete Project", "Finish the project by Friday");
        
        // Test adding a valid task
        service.addTask(task);
        Task retrieved = service.getTask("1234567890");
        assertEquals("Complete Project", retrieved.getName());
        assertEquals("Finish the project by Friday", retrieved.getDescription());
        
        // Test adding null task
        assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
        
        // Test adding duplicate task
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task));
    }
    
    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Complete Project", "Finish the project by Friday");
        service.addTask(task);
        
        // Test deleting existing task
        service.deleteTask("1234567890");
        assertNull(service.getTask("1234567890"));
        
        // Test deleting non-existent task
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("1234567890"));
        
        // Test deleting with null ID
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask(null));
    }
    
    @Test
    void testUpdateTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Complete Project", "Finish the project by Friday");
        service.addTask(task);
        
        // Test updating all fields
        service.updateTask("1234567890", "New Task", "New description");
        Task updated = service.getTask("1234567890");
        assertEquals("New Task", updated.getName());
        assertEquals("New description", updated.getDescription());
        
        // Test updating single field
        service.updateTask("1234567890", "Another Task", null);
        updated = service.getTask("1234567890");
        assertEquals("Another Task", updated.getName());
        assertEquals("New description", updated.getDescription());
        
        // Test updating non-existent task
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateTask("9999999999", "New Task", "New description")
        );
        
        // Test updating with null ID
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateTask(null, "New Task", "New description")
        );
    }
    
    @Test
    void testGetTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Complete Project", "Finish the project by Friday");
        service.addTask(task);
        
        // Test getting existing task
        Task retrieved = service.getTask("1234567890");
        assertEquals("Complete Project", retrieved.getName());
        assertEquals("Finish the project by Friday", retrieved.getDescription());
        
        // Test getting non-existent task
        assertNull(service.getTask("9999999999"));
        
        // Test getting with null ID
        assertThrows(IllegalArgumentException.class, () -> service.getTask(null));
    }
} 