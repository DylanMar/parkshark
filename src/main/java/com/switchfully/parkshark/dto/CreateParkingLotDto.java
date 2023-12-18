package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int max_capacity;
    private CreateDivisionDto division;
    private CreateAddressDto address; //long addressId;
    private CreateContactDto contact; //long contactId;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(String name, Category category, int max_capacity, CreateDivisionDto division, CreateAddressDto address, CreateContactDto contact) {
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

    public CreateDivisionDto getDivision() {
        return division;
    }

    public CreateAddressDto getAddress() {
        return address;
    }

    public CreateContactDto getContact() {
        return contact;
    }
}
