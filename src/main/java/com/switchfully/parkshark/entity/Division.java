package com.switchfully.parkshark.entity;

import jakarta.persistence.*;

@Entity
public class Division {
    @Id
    private int id;
    @Column
    private String name;
    @Column(name = "original_name")
    private String originalName;
    @Column
    private String director;
    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;

    public Division() {
    }

    public Division(int id, String name, String originalName, String director, Division division) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.division = division;
    }






    // --- Getters ---------------------------
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
    public Division getDivision() {
        return division;
    }
}
