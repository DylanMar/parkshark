package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.LevelType;

public class LevelDto {

    private Long id;

    private double monthlyCost;

    private double allocationReduction;

    private double maximumTime;

    private LevelType levelType;

    public LevelDto() {}

    public LevelDto(Long id, double monthlyCost, double allocationReduction, double maximumTime, LevelType levelType) {
        this.id = id;
        this.monthlyCost = monthlyCost;
        this.allocationReduction = allocationReduction;
        this.maximumTime = maximumTime;
        this.levelType = levelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
