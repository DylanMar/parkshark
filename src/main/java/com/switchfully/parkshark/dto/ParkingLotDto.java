package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;

public class ParkingLotDto {
    private long id;
    private String name;
    private Category category;
    private int max_capacity;
    private DivisionDto divisionDto;
    private AddressDto addressDto;
    private ContactDto contactDto;
    public ParkingLotDto() {
    }

    public ParkingLotDto(long id, String name, Category category, int max_capacity, DivisionDto divisionDto, AddressDto addressDto, ContactDto contactDto) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.max_capacity = max_capacity;
        this.divisionDto = divisionDto;
        this.addressDto = addressDto;
        this.contactDto = contactDto;
    }


    // --- Getters -------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }

    public void setDivisionDto(DivisionDto divisionDto) {
        this.divisionDto = divisionDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public ContactDto getContactDto() {
        return contactDto;
    }

    public void setContactDto(ContactDto contactDto) {
        this.contactDto = contactDto;
    }
}
