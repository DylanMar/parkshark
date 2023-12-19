package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Category;

public class ParkingLotGdprDto {
    private long id;
    private String name;
    private int max_capacity;
    private ContactGdprDto contactGdprDto;
    public ParkingLotGdprDto() {
    }

    public ParkingLotGdprDto(long id, String name, int max_capacity, ContactGdprDto contactGdprDto) {
        this.id = id;
        this.name = name;
        this.max_capacity = max_capacity;
        this.contactGdprDto = contactGdprDto;
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

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public ContactGdprDto getContactGdprDto() {
        return contactGdprDto;
    }

    public void setContactGdprDto(ContactGdprDto contactGdprDto) {
        this.contactGdprDto = contactGdprDto;
    }
}
