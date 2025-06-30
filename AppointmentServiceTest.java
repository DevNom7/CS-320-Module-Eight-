package com.grandstrand.systems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;
import com.grandstrand.systems.Appointment;
import com.grandstrand.systems.AppointmentService;

public class AppointmentServiceTest {
    
    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        
        // Test adding a valid appointment
        service.addAppointment(appointment);
        Appointment retrieved = service.getAppointment("1234567890");
        assertEquals(futureDate, retrieved.getAppointmentDate());
        assertEquals("Doctor's appointment", retrieved.getDescription());
        
        // Test adding null appointment
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
        
        // Test adding duplicate appointment
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment));
    }
    
    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        service.addAppointment(appointment);
        
        // Test deleting existing appointment
        service.deleteAppointment("1234567890");
        assertNull(service.getAppointment("1234567890"));
        
        // Test deleting non-existent appointment
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("1234567890"));
        
        // Test deleting with null ID
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null));
    }
    
    @Test
    void testUpdateAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        service.addAppointment(appointment);
        
        // Test updating all fields
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date newFutureDate = calendar.getTime();
        service.updateAppointment("1234567890", newFutureDate, "Dentist appointment");
        Appointment updated = service.getAppointment("1234567890");
        assertEquals(newFutureDate, updated.getAppointmentDate());
        assertEquals("Dentist appointment", updated.getDescription());
        
        // Test updating single field
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date anotherFutureDate = calendar.getTime();
        service.updateAppointment("1234567890", anotherFutureDate, null);
        updated = service.getAppointment("1234567890");
        assertEquals(anotherFutureDate, updated.getAppointmentDate());
        assertEquals("Dentist appointment", updated.getDescription());
        
        // Test updating non-existent appointment
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateAppointment("9999999999", newFutureDate, "New appointment")
        );
        
        // Test updating with null ID
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateAppointment(null, newFutureDate, "New appointment")
        );
    }
    
    @Test
    void testGetAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        service.addAppointment(appointment);
        
        // Test getting existing appointment
        Appointment retrieved = service.getAppointment("1234567890");
        assertEquals(futureDate, retrieved.getAppointmentDate());
        assertEquals("Doctor's appointment", retrieved.getDescription());
        
        // Test getting non-existent appointment
        assertNull(service.getAppointment("9999999999"));
        
        // Test getting with null ID
        assertThrows(IllegalArgumentException.class, () -> service.getAppointment(null));
    }
} 