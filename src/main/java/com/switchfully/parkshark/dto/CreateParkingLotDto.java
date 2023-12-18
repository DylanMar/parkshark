package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int max_capacity;
    private long divisionId;
    private CreateAddressDto address;
    private CreateContactDto contact;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(String name, Category category, int max_capacity, long divisionId, CreateAddressDto address, CreateContactDto contact) {
        this.name = name;
        this.category = category;
        this.max_capacity = max_capacity;
        this.divisionId = divisionId;
        this.address = address;
        this.contact = contact;
    }





    // --- Getters -------------------------------

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

    public long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(long divisionId) {
        this.divisionId = divisionId;
    }

    public CreateAddressDto getAddress() {
        return address;
    }

    public void setAddress(CreateAddressDto address) {
        this.address = address;
    }

    public CreateContactDto getContact() {
        return contact;
    }

    public void setContact(CreateContactDto contact) {
        this.contact = contact;
    }
}
