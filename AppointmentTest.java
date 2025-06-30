package com.grandstrand.systems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;
import com.grandstrand.systems.Appointment;

public class AppointmentTest {
    
    @Test
    void testValidAppointmentCreation() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Set date to tomorrow
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    @Test
    void testAppointmentIdValidation() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        // Test null appointment ID
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment(null, futureDate, "Doctor's appointment")
        );

        // Test appointment ID too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345678901", futureDate, "Doctor's appointment")
        );
    }

    @Test
    void testAppointmentDateValidation() {
        // Test null date
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("1234567890", null, "Doctor's appointment")
        );

        // Test past date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1); // Set date to yesterday
        Date pastDate = calendar.getTime();
        
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("1234567890", pastDate, "Doctor's appointment")
        );
    }

    @Test
    void testDescriptionValidation() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        // Test null description
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("1234567890", futureDate, null)
        );

        // Test description too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("1234567890", futureDate, 
                "This description is way too long for an appointment and should throw an exception")
        );
    }

    @Test
    void testSetters() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        
        // Test valid updates
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date newFutureDate = calendar.getTime();
        appointment.setAppointmentDate(newFutureDate);
        appointment.setDescription("Dentist appointment");

        assertEquals(newFutureDate, appointment.getAppointmentDate());
        assertEquals("Dentist appointment", appointment.getDescription());

        // Test invalid updates
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
        
        calendar.add(Calendar.DAY_OF_MONTH, -3); // Set date to 2 days ago
        Date pastDate = calendar.getTime();
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
        
        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> 
            appointment.setDescription("This description is way too long for an appointment and should throw an exception")
        );
    }
} 