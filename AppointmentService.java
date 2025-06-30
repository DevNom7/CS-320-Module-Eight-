/*
 * Name: Naim Lindsay
 * Professor: David Handlos
 * Date: 2024-06-14
 *
 * This is the AppointmentService class for the mobile app services project.
 * It manages a collection of Appointment objects in memory.
 */
package com.grandstrand.systems;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

// The AppointmentService class manages appointments (add, delete, update)
public class AppointmentService {
    // This map stores appointments by their unique ID
    private final Map<String, Appointment> appointments;

    // Constructor initializes the appointments map
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Add a new appointment to the service
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        // Make sure the appointment ID is unique
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment with ID " + appointment.getAppointmentId() + " already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " does not exist");
        }
        appointments.remove(appointmentId);
    }

    // Update fields of an appointment by ID
    public void updateAppointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " does not exist");
        }

        Appointment appointment = appointments.get(appointmentId);
        // Only update fields if new values are provided (not null)
        if (appointmentDate != null) appointment.setAppointmentDate(appointmentDate);
        if (description != null) appointment.setDescription(description);
    }

    // Get an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        return appointments.get(appointmentId);
    }
} 