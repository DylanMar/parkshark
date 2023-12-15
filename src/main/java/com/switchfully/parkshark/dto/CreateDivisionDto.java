package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;

public class CreateDivisionDto {
    private String name;
    private String originalName;
    private String director;
//    private DivisionDto divisionDto;
    private int parentDivisionId;

    public CreateDivisionDto() {
    }

    public CreateDivisionDto(String name, String originalName, String director, int parentDivisionId) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentDivisionId = parentDivisionId;
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


    public int getParentDivisionId() {
        return parentDivisionId;
    }
    public void setName(String name) {
        this.name = name;
    }

}
