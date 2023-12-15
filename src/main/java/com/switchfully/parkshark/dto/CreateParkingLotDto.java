package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int max_capacity;
    private DivisionDto divisionDto;
    private AddressDto addressDto;
    private ContactDto contactDto;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(String name, Category category, int max_capacity, DivisionDto divisionDto, AddressDto addressDto, ContactDto contactDto) {
        this.name = name;
        this.category = category;
        this.max_capacity = max_capacity;
        this.divisionDto = divisionDto;
        this.addressDto = addressDto;
        this.contactDto = contactDto;
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

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public ContactDto getContactDto() {
        return contactDto;
    }
}
