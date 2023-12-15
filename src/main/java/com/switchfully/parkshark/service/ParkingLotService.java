//package com.switchfully.parkshark.service;
//
//import com.switchfully.parkshark.dto.CreateParkingLotDto;
//import com.switchfully.parkshark.dto.ParkingLotDto;
//import com.switchfully.parkshark.entity.ParkingLot;
//import com.switchfully.parkshark.mapper.ParkingLotMapper;
//import com.switchfully.parkshark.repository.ParkingLotRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class ParkingLotService {
//    private final ParkingLotRepository parkingLotRepository;
//    private final ParkingLotMapper parkingLostMapper;
//
//    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLostMapper) {
//        this.parkingLotRepository = parkingLotRepository;
//        this.parkingLostMapper = parkingLostMapper;
//    }
//
//    public ParkingLotDto createParkingLot(CreateParkingLotDto createParkingLotDto) {
//        ParkingLot parkingLot = parkingLostMapper.mapCreateParkingLotToParkingLot(createParkingLotDto);
//        ParkingLot createdParkingLot = parkingLotRepository.createParkingLot(parkingLot);
//        return parkingLostMapper.mapParkingLotToParkingLotDto(createdParkingLot);
//    }
//}
