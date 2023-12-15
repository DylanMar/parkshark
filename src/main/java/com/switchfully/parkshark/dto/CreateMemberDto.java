package com.switchfully.parkshark.dto;

import java.time.LocalDate;

public class CreateMemberDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private CreateAddressDto address;
    private String licensePlate;
    private LocalDate registrationDate;

    public CreateMemberDto(String email, String password, String firstName, String lastName, CreateAddressDto address, String licensePlate, LocalDate registrationDate) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
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

    public CreateAddressDto getCreateAddressDto() {
        return address;
    }

    public void setCreateAddressDto(CreateAddressDto address) {
        this.address = address;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

}
