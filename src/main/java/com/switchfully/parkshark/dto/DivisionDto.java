package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.Division;

public class DivisionDto {
    private int id;
    private String name;
    private String orignalName;
    private String director;
    private int divisionId;

    public DivisionDto() {
    }

    public DivisionDto(int id, String name, String orignalName, String director, Division division) {
        this.id = id;
        this.name = name;
        this.orignalName = orignalName;
        this.director = director;
        this.divisionId = (division != null) ? division.getId() : -1;
    }


    // --- Getters ------------------------------------------

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrignalName() {
        return orignalName;
    }

    public String getDirector() {
        return director;
    }

    public int getDivisionId() {
        return divisionId;
    }
}
