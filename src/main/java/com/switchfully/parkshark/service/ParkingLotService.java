package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotGdprDto;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.mapper.ParkingLotMapper;
import com.switchfully.parkshark.repository.AddressRepository;
import com.switchfully.parkshark.repository.ContactRepository;
import com.switchfully.parkshark.repository.DivisionRepository;
import com.switchfully.parkshark.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotMapper parkingLostMapper;
    private final DivisionRepository divisionRepository;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLostMapper, DivisionRepository divisionRepository, AddressRepository addressRepository, ContactRepository contactRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLostMapper = parkingLostMapper;
        this.divisionRepository = divisionRepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    public ParkingLotDto createParkingLot(CreateParkingLotDto createParkingLotDto) {
        ParkingLot parkingLot = parkingLostMapper.mapCreateParkingLotToParkingLot(createParkingLotDto);
        return parkingLostMapper.mapParkingLotToParkingLotDto( parkingLotRepository.save(parkingLot) );
    }

    public List<ParkingLotGdprDto> getAllParkingLots() {
        return parkingLotRepository.findAll().stream()
                .map(parkingLostMapper::mapParkingLotToParkingLotGdprDto)
                .collect(Collectors.toList());
    }

    public ParkingLotDto getParkingLotById(long id) {
        return parkingLostMapper.mapParkingLotToParkingLotDto(
                parkingLotRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("ParkingLot with id " + id + " does not exist.")));
    }
}
