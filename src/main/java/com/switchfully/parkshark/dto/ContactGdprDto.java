package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;

public class ContactGdprDto {
    private String mobileNumber;
    private String phoneNumber;
    private String email;

    public ContactGdprDto() {
    }

    public ContactGdprDto(String mobileNumber, String phoneNumber, String email) {
        this.mobileNumber = mobileNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    // --- Getters ---------------------------------

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
