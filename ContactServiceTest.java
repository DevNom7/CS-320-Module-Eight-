package com.grandstrand.systems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.grandstrand.systems.Contact;
import com.grandstrand.systems.ContactService;

public class ContactServiceTest {
    
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        // Test adding a valid contact
        service.addContact(contact);
        Contact retrieved = service.getContact("1234567890");
        assertEquals("John", retrieved.getFirstName());
        assertEquals("Doe", retrieved.getLastName());
        
        // Test adding null contact
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
        
        // Test adding duplicate contact
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }
    
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        // Test deleting existing contact
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
        
        // Test deleting non-existent contact
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1234567890"));
        
        // Test deleting with null ID
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
    }
    
    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        // Test updating all fields
        service.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave");
        Contact updated = service.getContact("1234567890");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("9876543210", updated.getPhone());
        assertEquals("456 Oak Ave", updated.getAddress());
        
        // Test updating single field
        service.updateContact("1234567890", "Mary", null, null, null);
        updated = service.getContact("1234567890");
        assertEquals("Mary", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("9876543210", updated.getPhone());
        assertEquals("456 Oak Ave", updated.getAddress());
        
        // Test updating non-existent contact
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateContact("9999999999", "Jane", "Smith", "9876543210", "456 Oak Ave")
        );
        
        // Test updating with null ID
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateContact(null, "Jane", "Smith", "9876543210", "456 Oak Ave")
        );
    }
    
    @Test
    void testGetContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        // Test getting existing contact
        Contact retrieved = service.getContact("1234567890");
        assertEquals("John", retrieved.getFirstName());
        assertEquals("Doe", retrieved.getLastName());
        
        // Test getting non-existent contact
        assertNull(service.getContact("9999999999"));
        
        // Test getting with null ID
        assertThrows(IllegalArgumentException.class, () -> service.getContact(null));
    }
} 