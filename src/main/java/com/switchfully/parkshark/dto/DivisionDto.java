package com.switchfully.parkshark.dto;

public class DivisionDto {
    private long id;
    private String name;
    private String originalName;
    private String director;
    private DivisionDto division;

    public DivisionDto() {
    }

    public DivisionDto(long id, String name, String originalName, String director, DivisionDto division) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.division = division;
    }


    // --- Getters ------------------------------------------

    public long getId() {
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

    public void setId(long id) {
        this.id = id;
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

    public void setDivision(DivisionDto division) {
        this.division = division;
    }
}
