package com.switchfully.parkshark.entity;

import jakarta.persistence.*;

import java.time.*;

@Entity
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="LICENSE_PLATE")
    private String licensePlate;
    @Column(name="STATUS")
    @Enumerated(EnumType.STRING)
    private AllocationStatus status;
    @Column(name="START_TIME")
    private LocalDateTime startTime;
    @Column(name="STOP_TIME")
    private LocalDateTime stopTime;
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;
    @ManyToOne
    @JoinColumn(name="PARKING_LOT_ID")
    private ParkingLot parkingLot;


    public Allocation() {
    }

    public Allocation(String licensePlate, AllocationStatus status, LocalDateTime startTime) {
        this.licensePlate = licensePlate;
        this.status = status;
        this.startTime = startTime;
    }

    public Allocation(Long id, String licensePlate, AllocationStatus status, LocalDateTime startTime, LocalDateTime stopTime, Member member, ParkingLot parkingLot) {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
