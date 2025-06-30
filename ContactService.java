/*
 * Name: Naim Lindsay
 * Professor: David Handlos
 * Date: 2024-06-14
 *
 * This is the ContactService class for the mobile app services project.
 * It manages a collection of Contact objects in memory.
 */
package com.grandstrand.systems;

import java.util.HashMap;
import java.util.Map;

// The ContactService class manages contacts (add, delete, update)
public class ContactService {
    // This map stores contacts by their unique ID
    private final Map<String, Contact> contacts;

    // Constructor initializes the contacts map
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add a new contact to the service
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        // Make sure the contact ID is unique
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getContactId() + " already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        contacts.remove(contactId);
    }

    // Update fields of a contact by ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }

        Contact contact = contacts.get(contactId);
        // Only update fields if new values are provided (not null)
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    // Get a contact by ID
    public Contact getContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        return contacts.get(contactId);
    }
} 