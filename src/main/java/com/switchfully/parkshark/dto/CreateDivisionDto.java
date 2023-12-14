package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;

public class CreateDivisionDto {
    private String name;
    private String originalName;
    private String director;
    private Division division;

    public CreateDivisionDto() {
    }

    public CreateDivisionDto(String name, String originalName, String director, Division division) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.division = division;
    }

    // --- Getters -----------------------

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public Division getDivision() {
        return division;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
