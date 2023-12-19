package com.switchfully.parkshark.dto;

import java.time.*;

public class UpDateAllocationDto {
    private LocalDateTime stopTime;

    public UpDateAllocationDto() {
    }

    public UpDateAllocationDto(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }
}
