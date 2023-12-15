package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.entity.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {
    public ParkingLot mapCreateParkingLotToParkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getCategory(),
                createParkingLotDto.getMax_capacity(),
                createParkingLotDto.getDivision(),
                createParkingLotDto.getAddress(),
                createParkingLotDto.getContact()
        );
    }
    public ParkingLotDto mapParkingLotToParkingLotDto(ParkingLot parkingLot) {
        return new ParkingLotDto(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getCategory(),
                parkingLot.getMax_capacity(),
                parkingLot.getDivision(),
                parkingLot.getAddress(),
                parkingLot.getContact()
        );
    }
}
