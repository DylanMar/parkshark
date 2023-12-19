package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;

public class CreateDivisionDto {
    private String name;
    private String originalName;
    private String director;
    private CreateDivisionDto parentDivision;
    public CreateDivisionDto() {
    }

    public CreateDivisionDto(String name, String originalName, String director, CreateDivisionDto parentDivision) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentDivision = parentDivision;
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

    public CreateDivisionDto getParentDivision() {
        return parentDivision;
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

    public void setParentDivision(CreateDivisionDto parentDivision) {
        this.parentDivision = parentDivision;
    }
}
