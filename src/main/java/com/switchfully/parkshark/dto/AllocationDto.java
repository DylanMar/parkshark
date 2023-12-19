package com.switchfully.parkshark.dto;

import com.switchfully.parkshark.entity.*;
import jakarta.persistence.*;

import java.time.*;

public class AllocationDto {

    private Long id;

    private String licensePlate;

    private AllocationStatus status;

    private LocalDateTime startTime;

    private LocalDateTime stopTime;

    private MemberDto member;

    private ParkingLotDto parkingLot;


    public AllocationDto() {
    }

    public AllocationDto(Long id, String licensePlate, AllocationStatus status, LocalDateTime startTime, LocalDateTime stopTime, MemberDto member, ParkingLotDto parkingLot) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.status = status;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.member = member;
        this.parkingLot = parkingLot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public AllocationStatus getStatus() {
        return status;
    }

    public void setStatus(AllocationStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public ParkingLotDto getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotDto parkingLot) {
        this.parkingLot = parkingLot;
    }
}
