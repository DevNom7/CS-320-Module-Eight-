package com.grandstrand.systems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.grandstrand.systems.Contact;

public class ContactTest {
    
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactIdValidation() {
        // Test null contact ID
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "123 Main St")
        );

        // Test contact ID too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St")
        );
    }

    @Test
    void testFirstNameValidation() {
        // Test null first name
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St")
        );

        // Test first name too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St")
        );
    }

    @Test
    void testLastNameValidation() {
        // Test null last name
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", null, "1234567890", "123 Main St")
        );

        // Test last name too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St")
        );
    }

    @Test
    void testPhoneValidation() {
        // Test null phone
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", null, "123 Main St")
        );

        // Test phone not exactly 10 digits
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St")
        );

        // Test phone with non-digits
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "123456789a", "123 Main St")
        );
    }

    @Test
    void testAddressValidation() {
        // Test null address
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "1234567890", null)
        );

        // Test address too long
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "1234567890", 
                "1234567890123456789012345678901")
        );
    }

    @Test
    void testSetters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        // Test valid updates
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("456 Oak Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());

        // Test invalid updates
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJohn"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("SmithSmithSmith"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> 
            contact.setAddress("1234567890123456789012345678901")
        );
    }
} 