package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotGdprDto;
import com.switchfully.parkshark.entity.ParkingLot;
import com.switchfully.parkshark.repository.DivisionRepository;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {
    private final DivisionMapper divisionMapper;
    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;
    private final DivisionRepository divisionRepository;

    public ParkingLotMapper(DivisionMapper divisionMapper, AddressMapper addressMapper, ContactMapper contactMapper, DivisionRepository divisionRepository) {
        this.divisionMapper = divisionMapper;
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
        this.divisionRepository = divisionRepository;
    }

    public ParkingLot mapCreateParkingLotToParkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getCategory(),
                createParkingLotDto.getMax_capacity(),
                divisionRepository.findById( createParkingLotDto.getDivisionId() )
                        .orElseThrow( () -> new IllegalArgumentException("Division Id does not exist.")),
                addressMapper.createAddressDtoToAddress(createParkingLotDto.getAddress()),
                contactMapper.mapCreateContactDtoToContact(createParkingLotDto.getContact())
        );
    }
    public ParkingLotDto mapParkingLotToParkingLotDto(ParkingLot parkingLot) {
        return new ParkingLotDto(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getCategory(),
                parkingLot.getMax_capacity(),
                divisionMapper.mapDivisionToDivisionDto(parkingLot.getDivision()),
                addressMapper.addressToAddressDto(parkingLot.getAddress()),
                contactMapper.mapContactToContactDto(parkingLot.getContact())
//                parkingLot.getDivision() != null ? divisionMapper.mapDivisionToDivisionDto( parkingLot.getDivision() ) : null,
//                parkingLot.getAddress() != null ? addressMapper.mapAddressToAddressDto( parkingLot.getAddress() ) : null,
//                parkingLot.getContact() != null ? contactMapper.mapContactToContactDto( parkingLot.getContact() ) : null
        );
    }
    public ParkingLotGdprDto mapParkingLotToParkingLotGdprDto(ParkingLot parkingLot) {
        return new ParkingLotGdprDto (
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getMax_capacity(),
                parkingLot.getContact() != null ? contactMapper.mapContactToContactGdprDto(parkingLot.getContact()) : null
        );
    }
}
