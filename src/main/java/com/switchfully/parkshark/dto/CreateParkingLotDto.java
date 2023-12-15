package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int max_capacity;
    private Division division;
    private Address address;
    private Contact contact;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(String name, Category category, int max_capacity, Division division, Address address, Contact contact) {
        this.name = name;
        this.category = category;
        this.max_capacity = max_capacity;
        this.division = division;
        this.address = address;
        this.contact = contact;
    }


    // --- Getters -------------------------------
    public String getName() {
        return name;
    }
    public Category getCategory() {
        return category;
    }
    public int getMax_capacity() {
        return max_capacity;
    }
    public Division getDivision() {
        return division;
    }
    public Address getAddress() {
        return address;
    }
    public Contact getContact() {
        return contact;
    }
}
