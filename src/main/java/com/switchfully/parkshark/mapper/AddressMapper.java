package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.AddressDto;
import com.switchfully.parkshark.dto.CreateAddressDto;
import com.switchfully.parkshark.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapCreateAddressDtoToAddress(CreateAddressDto createAddressDto) {
        return new Address(createAddressDto.getStreetName(), createAddressDto.getStreetNumber(), createAddressDto.getPostalCode());
    }

    public AddressDto mapAddressToAddressDto(Address address) {
        return new AddressDto(address.getId(), address.getStreetName(), address.getStreetNumber(), address.getPostalCode());
    }

    public Address mapAddressDtoToAddress(AddressDto addressDto) {
        return new Address(addressDto.getStreetName(), addressDto.getStreetNumber(), addressDto.getPostalCode());
    }


}
