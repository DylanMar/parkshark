package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.*;

import java.time.*;

public class CreateAllocationDto {
    private String licensePlate;

    private LocalDateTime startTime;

    private Long memberId;

    private Long parkingLotId;

    public CreateAllocationDto() {
    }

    public CreateAllocationDto(String licensePlate, LocalDateTime startTime) {
        this.licensePlate = licensePlate;
        this.startTime = startTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
