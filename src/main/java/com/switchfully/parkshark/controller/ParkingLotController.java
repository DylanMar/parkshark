package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.service.ParkingLotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parkinglot")
public class ParkingLotController {
    private final ParkingLotService parkingLostService;

    public ParkingLotController(ParkingLotService parkingLostService) {
        this.parkingLostService = parkingLostService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        return parkingLostService.createParkingLot(createParkingLotDto);
    }
}
