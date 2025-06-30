/*
 * Name: Naim Lindsay
 * Professor: David Handlos
 * Date: 2024-06-14
 *
 * This is the Appointment class for the mobile app services project.
 * It stores information about an appointment and enforces validation rules.
 */
package com.grandstrand.systems;

import java.util.Date;

// The Appointment class represents a single appointment in the system
public class Appointment {
    // The appointment's unique ID (cannot be changed after creation)
    private final String appointmentId;
    // The date and time of the appointment
    private Date appointmentDate;
    // The appointment's description
    private String description;

    // Constructor to create a new Appointment object
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointmentId
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must not be null and must be 10 characters or less");
        }
        // Validate appointmentDate (must not be null or in the past)
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date must not be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less");
        }

        // Set fields
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters (methods to access the fields)
    public String getAppointmentId() { return appointmentId; }
    public Date getAppointmentDate() { return appointmentDate; }
    public String getDescription() { return description; }

    // Setters (methods to update the fields)
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date must not be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less");
        }
        this.description = description;
    }
} 