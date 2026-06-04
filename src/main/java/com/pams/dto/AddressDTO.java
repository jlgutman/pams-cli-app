package com.pams.dto;

public class AddressDTO {

    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public AddressDTO(String street, String city, String state, String zip) {
        this.street = street;
        this.city   = city;
        this.state  = state;
        this.zip    = zip;
    }

    public String getStreet() { return street; }
    public String getCity()   { return city;   }
    public String getState()  { return state;  }
    public String getZip()    { return zip;    }
}
