package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;
import com.switchfully.parkshark.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    private AddressMapper addressMapper;

    public MemberMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        return new Member(
                createMemberDto.getEmail(),
                createMemberDto.getPassword(),
                createMemberDto.getFirstName(),
                createMemberDto.getLastName(),
                addressMapper.mapCreateAddressDtoToAddress(createMemberDto.getCreateAddressDto()),
                createMemberDto.getLicensePlate()
        );
    }

    public MemberDto memberToMemberDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getEmail(),
                member.getPassword(),
                member.getFirstName(),
                member.getLastName(),
                addressMapper.mapAddressToAddressDto(member.getAddress()),
                member.getLicensePlate(),
                member.getLevel(),
                member.getRegistrationDate()
        );
    }
}
