package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.*;
import com.switchfully.parkshark.service.ParkingLotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parkinglot")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLostService) {
        this.parkingLotService = parkingLostService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        return parkingLotService.createParkingLot(createParkingLotDto);
    }
    @GetMapping(produces = "application/json")
    public List<ParkingLotGdprDto> getAllParkingLots() {
        return parkingLotService.getAllParkingLots();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ParkingLotDto getParkingLotById(@PathVariable long id) {
        return parkingLotService.getParkingLotById(id);
    }
}
