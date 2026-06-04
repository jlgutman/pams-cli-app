package com.pams.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void constructorSetsAllFields() {
        LocalDate dob = LocalDate.of(1990, 6, 15);
        Address address = new Address("10 Main St", "Springfield", "IL", "62701");
        Patient p = new Patient(1, "Jane", "Doe", "(555) 000-1111", "jane@example.com", address, dob);

        assertEquals(1, p.getId());
        assertEquals("Jane", p.getFirstName());
        assertEquals("Doe", p.getLastName());
        assertEquals("(555) 000-1111", p.getPhoneNumber());
        assertEquals("jane@example.com", p.getEmail());
        assertSame(address, p.getMailingAddress());
        assertEquals(dob, p.getDateOfBirth());
    }

    @Test
    void getAgeReturnsCorrectAge() {
        LocalDate dob = LocalDate.now().minusYears(30);
        Patient p = new Patient(2, "John", "Smith", null, null, null, dob);
        assertEquals(30, p.getAge());
    }

    @Test
    void nullableFieldsAllowedInConstructor() {
        Patient p = new Patient(3, "Marcus", "Garvey", null, null, null, LocalDate.of(2001, 9, 18));
        assertNull(p.getPhoneNumber());
        assertNull(p.getEmail());
        assertNull(p.getMailingAddress());
    }

    @Test
    void mailingAddressFieldsAreAccessible() {
        Address address = new Address("4 East Ave", "Chicago", "IL", "60601");
        Patient p = new Patient(4, "Marcus", "Garvey", null, null, address, LocalDate.of(2001, 9, 18));

        assertEquals("4 East Ave", p.getMailingAddress().getStreet());
        assertEquals("Chicago",    p.getMailingAddress().getCity());
        assertEquals("IL",         p.getMailingAddress().getState());
        assertEquals("60601",      p.getMailingAddress().getZip());
    }
}
