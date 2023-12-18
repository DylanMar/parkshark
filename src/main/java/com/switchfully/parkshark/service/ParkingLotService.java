package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotGdprDto;
import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;
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
//    private final DivisionRepository divisionRepository;
//    private final AddressRepository addressRepository;
//    private final ContactRepository contactRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLostMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLostMapper = parkingLostMapper;
    }

    public ParkingLotDto createParkingLot(CreateParkingLotDto createParkingLotDto) {
//        Division division = null;
//        Address address = null;
//        Contact contact = null;
//        try {
//            division = divisionRepository.findById( createParkingLotDto.getDivisionId() ).get();
//            address = addressRepository.findById( createParkingLotDto.getAddressId() ).get();
//            contact = contactRepository.findById( createParkingLotDto.getContactId() ).get();
//        } catch (Exception e) { }

        ParkingLot parkingLot = parkingLostMapper.mapCreateParkingLotToParkingLot(createParkingLotDto);
        return parkingLostMapper.mapParkingLotToParkingLotDto( parkingLotRepository.save(parkingLot) );
    }

    public List<ParkingLotGdprDto> getAllParkingLots() {
        return parkingLotRepository.findAll().stream()
                .map(parkingLostMapper::mapParkingLotToParkingLotGdprDto)
                .collect(Collectors.toList());
    }
}
