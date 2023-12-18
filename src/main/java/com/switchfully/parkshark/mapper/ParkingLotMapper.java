package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.entity.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {
    private final DivisionMapper divisionMapper;
    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;

    public ParkingLotMapper(DivisionMapper divisionMapper, AddressMapper addressMapper, ContactMapper contactMapper) {
        this.divisionMapper = divisionMapper;
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
    }

    public ParkingLot mapCreateParkingLotToParkingLot(CreateParkingLotDto createParkingLotDto, Division division, Address address, Contact contact) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getCategory(),
                createParkingLotDto.getMax_capacity(),
                division,
                address,
                contact
        );
    }
    public ParkingLotDto mapParkingLotToParkingLotDto(ParkingLot parkingLot) {
        return new ParkingLotDto(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getCategory(),
                parkingLot.getMax_capacity(),
                parkingLot.getDivision() != null ? divisionMapper.mapDivisionToDivisionDto( parkingLot.getDivision() ) : null,
                parkingLot.getAddress() != null ? addressMapper.mapAddressToAddressDto( parkingLot.getAddress() ) : null,
                parkingLot.getContact() != null ? contactMapper.mapContactToContactDto( parkingLot.getContact() ) : null
        );
    }
}
