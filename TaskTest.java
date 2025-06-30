package com.grandstrand.systems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.grandstrand.systems.Task;

public class TaskTest {
    
    @Test
    void testValidTaskCreation() {
        Task task = new Task("1234567890", "Complete Project", "Finish the project by Friday");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Complete Project", task.getName());
        assertEquals("Finish the project by Friday", task.getDescription());
    }

    @Test
    void testTaskIdValidation() {
        // Test null task ID
        assertThrows(IllegalArgumentException.class, () -> 
            new Task(null, "Complete Project", "Finish the project by Friday")
        );

        // Test task ID too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Task("12345678901", "Complete Project", "Finish the project by Friday")
        );
    }

    @Test
    void testNameValidation() {
        // Test null name
        assertThrows(IllegalArgumentException.class, () -> 
            new Task("1234567890", null, "Finish the project by Friday")
        );

        // Test name too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Task("1234567890", "This name is way too long for a task", "Finish the project by Friday")
        );
    }

    @Test
    void testDescriptionValidation() {
        // Test null description
        assertThrows(IllegalArgumentException.class, () -> 
            new Task("1234567890", "Complete Project", null)
        );

        // Test description too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Task("1234567890", "Complete Project", 
                "This description is way too long for a task and should throw an exception")
        );
    }

    @Test
    void testSetters() {
        Task task = new Task("1234567890", "Complete Project", "Finish the project by Friday");
        
        // Test valid updates
        task.setName("New Task Name");
        task.setDescription("New task description");

        assertEquals("New Task Name", task.getName());
        assertEquals("New task description", task.getDescription());

        // Test invalid updates
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> 
            task.setName("This name is way too long for a task")
        );
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> 
            task.setDescription("This description is way too long for a task and should throw an exception")
        );
    }
} 