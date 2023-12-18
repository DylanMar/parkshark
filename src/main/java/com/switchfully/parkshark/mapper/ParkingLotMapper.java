package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.dto.ParkingLotGdprDto;
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

    public ParkingLot mapCreateParkingLotToParkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getCategory(),
                createParkingLotDto.getMax_capacity(),
                divisionMapper.mapCreateDivisionDtoToDivision(createParkingLotDto.getDivision()),
                addressMapper.mapCreateAddressDtoToAddress(createParkingLotDto.getAddress()),
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
                addressMapper.mapAddressToAddressDto(parkingLot.getAddress()),
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
