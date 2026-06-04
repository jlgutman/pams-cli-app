package com.pams.dto;

public class PatientDTO {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final AddressDTO mailingAddress;
    private final String dateOfBirth;
    private final int age;

    public PatientDTO(int id, String firstName, String lastName, String phoneNumber,
                      String email, AddressDTO mailingAddress, String dateOfBirth, int age) {
        this.id             = id;
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.phoneNumber    = phoneNumber;
        this.email          = email;
        this.mailingAddress = mailingAddress;
        this.dateOfBirth    = dateOfBirth;
        this.age            = age;
    }

    public int        getId()             { return id;             }
    public String     getFirstName()      { return firstName;      }
    public String     getLastName()       { return lastName;       }
    public String     getPhoneNumber()    { return phoneNumber;    }
    public String     getEmail()          { return email;          }
    public AddressDTO getMailingAddress() { return mailingAddress; }
    public String     getDateOfBirth()    { return dateOfBirth;    }
    public int        getAge()            { return age;            }
}
