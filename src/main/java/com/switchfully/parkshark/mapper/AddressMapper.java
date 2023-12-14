package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.AddressDto;
import com.switchfully.parkshark.dto.CreateAddressDto;
import com.switchfully.parkshark.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address createAddressDtoToAddress(CreateAddressDto createAddressDto) {
        return new Address(createAddressDto.getStreetName(), createAddressDto.getStreetNumber(), createAddressDto.getPostalCode());
    }

    public AddressDto addressToAddressDto(Address address) {
        return new AddressDto(address.getId(), address.getStreetName(), address.getStreetNumber(), address.getPostalCode());
    }
}
