package com.switchfully.parkshark.entity;

import jakarta.persistence.*;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private Category category;
    @Column
    private int max_capacity;
    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;
    @OneToOne
    private Address address;
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public ParkingLot() {
    }

    public ParkingLot(String name, Category category, int max_capacity, Division division, Address address, Contact contact) {
        this.name = name;
        this.category = category;
        this.max_capacity = max_capacity;
        this.division = division;
        this.address = address;
        this.contact = contact;
    }


    // --- Getters -------------------------------
    public int getId() {
        return id;
    }
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
