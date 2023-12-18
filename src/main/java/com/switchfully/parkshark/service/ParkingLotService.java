package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
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
        Division division = null;
        Address address = null;
        Contact contact = null;
        try {
            division = divisionRepository.getDivisionById(createParkingLotDto.getDivisionId());
            address = addressRepository.findById( createParkingLotDto.getAddressId() ).get();
            contact = contactRepository.findById( createParkingLotDto.getContactId() ).get();
        } catch (Exception e) { }

        ParkingLot parkingLot = parkingLostMapper.mapCreateParkingLotToParkingLot(createParkingLotDto,division, address, contact);
        ParkingLot createdParkingLot = parkingLotRepository.createParkingLot(parkingLot);
        return parkingLostMapper.mapParkingLotToParkingLotDto(createdParkingLot);
    }
}
