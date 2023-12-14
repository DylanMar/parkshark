package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Level;
import jakarta.persistence.*;

import java.time.LocalDate;

public class MemberDto {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Address address;

    private String licensePlate;

    private Level level;

    private LocalDate registrationDate;

    public MemberDto(Long id, String email, String password, String firstName, String lastName, Address address, String licensePlate, Level level, LocalDate registrationDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.licensePlate = licensePlate;
        this.level = level;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
