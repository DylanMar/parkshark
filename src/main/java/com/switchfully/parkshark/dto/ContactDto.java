package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;

public class ContactDto {
    private int id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String phoneNumber;
    private String email;
    private Address address;

    public ContactDto() {
    }

    public ContactDto(int id, String firstName, String lastName, String mobileNumber, String phoneNumber, String email, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
    // --- Getters ------------------------------

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
