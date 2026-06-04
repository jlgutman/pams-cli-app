package com.pams.model;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address mailingAddress;
    private LocalDate dateOfBirth;

    public Patient(int id, String firstName, String lastName, String phoneNumber,
                   String email, Address mailingAddress, LocalDate dateOfBirth) {
        this.id             = id;
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.phoneNumber    = phoneNumber;
        this.email          = email;
        this.mailingAddress = mailingAddress;
        this.dateOfBirth    = dateOfBirth;
    }

    public int     getId()             { return id;             }
    public String  getFirstName()      { return firstName;      }
    public String  getLastName()       { return lastName;       }
    public String  getPhoneNumber()    { return phoneNumber;    }
    public String  getEmail()          { return email;          }
    public Address getMailingAddress() { return mailingAddress; }
    public LocalDate getDateOfBirth()  { return dateOfBirth;    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
