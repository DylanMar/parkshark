package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotGdprDto;
import com.switchfully.parkshark.service.ParkingLotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(produces = "application/json")
    public List<ParkingLotGdprDto> getAllParkingLots() {
        return parkingLostService.getAllParkingLots();
    }
}
