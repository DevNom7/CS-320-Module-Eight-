/*
 * Name: Naim Lindsay
 * Professor: David Handlos
 * Date: 2024-06-14
 *
 * This is the Contact class for the mobile app services project.
 * It stores information about a contact and enforces validation rules.
 */
package com.grandstrand.systems;

// The Contact class represents a single contact in the system
public class Contact {
    // The contact's unique ID (cannot be changed after creation)
    private final String contactId;
    // The contact's first name
    private String firstName;
    // The contact's last name
    private String lastName;
    // The contact's phone number (must be exactly 10 digits)
    private String phone;
    // The contact's address
    private String address;

    // Constructor to create a new Contact object
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate contactId
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or less");
        }
        // Validate firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
        // Validate lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
        // Validate phone (must be 10 digits)
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }

        // Set fields
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters (methods to access the fields)
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters (methods to update the fields)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }
        this.address = address;
    }
} 