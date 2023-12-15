package com.switchfully.parkshark.entity;

import jakarta.persistence.*;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MONTHLY_COST")
    private double monthlyCost;
    @Column(name = "ALLOCATION_REDUCTION")
    private double allocationReduction;
    @Column(name = "MAXIMUM_TIME")
    private double maximumTime;
    @Column(name = "LEVEL_TYPE")
    @Enumerated(EnumType.STRING)
    private LevelType levelType;

    public Level() {}

    public Long getId() {
        return id;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public double getAllocationReduction() {
        return allocationReduction;
    }

    public void setAllocationReduction(double allocationReduction) {
        this.allocationReduction = allocationReduction;
    }

    public double getMaximumTime() {
        return maximumTime;
    }

    public void setMaximumTime(double maximumTime) {
        this.maximumTime = maximumTime;
    }

    public LevelType getLevelType() {
        return levelType;
    }
    public void setLevelType(LevelType levelType) {
        this.levelType = levelType;
    }
}
