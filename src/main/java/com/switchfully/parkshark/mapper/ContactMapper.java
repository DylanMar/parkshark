package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.ContactDto;
import com.switchfully.parkshark.dto.ContactGdprDto;
import com.switchfully.parkshark.dto.CreateContactDto;
import com.switchfully.parkshark.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contact mapCreateContactDtoToContact(CreateContactDto createContactDto) {
        return new Contact(
                createContactDto.getFirstName(),
                createContactDto.getLastName(),
                createContactDto.getMobileNumber(),
                createContactDto.getPhoneNumber(),
                createContactDto.getEmail(),
                createContactDto.getAddress()
        );
    }
    public ContactDto mapContactToContactDto(Contact contact) {
        return new ContactDto(
                contact.getId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getMobileNumber(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getAddress()
        );
    }

    public Contact mapContactDtoToContact(ContactDto contactDto) {
        return new Contact(
                contactDto.getFirstName(),
                contactDto.getLastName(),
                contactDto.getMobileNumber(),
                contactDto.getPhoneNumber(),
                contactDto.getEmail(),
                contactDto.getAddress()
        );
    }
    public ContactGdprDto mapContactToContactGdprDto(Contact contact) {
        return new ContactGdprDto(
                contact.getMobileNumber(),
                contact.getPhoneNumber(),
                contact.getEmail()
        );
    }
}
