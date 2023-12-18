package com.switchfully.parkshark.dto;

public class DivisionDto {
    private int id;
    private String name;
    private String originalName;
    private String director;
    //    private int divisionId;
    private DivisionDto division;

    public DivisionDto() {
    }

    public DivisionDto(int id, String name, String originalName, String director, DivisionDto division) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.division = division;
    }


    // --- Getters ------------------------------------------

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public DivisionDto getDivision() {
        return division;
    }
}
