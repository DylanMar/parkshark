package com.switchfully.parkshark.entity;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column(name = "original_name")
    private String originalName;
    @Column
    private String director;
    @ManyToOne(cascade = {PERSIST})
    @JoinColumn(name="division_id")
    private Division division;

    public Division() {
    }

    public Division(String name, String originalName, String director, Division division) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.division = division;
    }

    // --- Getters ---------------------------

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

    public void setId(long id) {
        this.id = id;
    }
}
