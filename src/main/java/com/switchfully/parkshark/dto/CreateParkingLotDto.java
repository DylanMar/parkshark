package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Category;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int max_capacity;
    private Integer divisionId;
    private long addressId;
    private long contactId;

    public CreateParkingLotDto() {
    }

    public CreateParkingLotDto(String name, Category category, int max_capacity, Integer divisionId, long addressId, long contactId) {
        this.name = name;
        this.category = category;
        this.max_capacity = max_capacity;
        this.divisionId = divisionId;
        this.addressId = addressId;
        this.contactId = contactId;
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

    public Integer getDivisionId() {
        return divisionId;
    }

    public long getAddressId() {
        return addressId;
    }

    public long getContactId() {
        return contactId;
    }
}
