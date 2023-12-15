package com.switchfully.parkshark.dto;

public class LevelDto {

    private Long id;

    private double monthlyCost;

    private double allocationReduction;

    private double maximumTime;

    public LevelDto() {}

    public LevelDto(Long id, double monthlyCost, double allocationReduction, double maximumTime) {
        this.id = id;
        this.monthlyCost = monthlyCost;
        this.allocationReduction = allocationReduction;
        this.maximumTime = maximumTime;
    }

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
}
