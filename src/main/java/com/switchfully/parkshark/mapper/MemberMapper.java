package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;
import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Member;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MemberMapper {
    private AddressMapper addressMapper;
    private LevelMapper levelMapper;

    public MemberMapper(AddressMapper addressMapper, LevelMapper levelMapper) {
        this.addressMapper = addressMapper;
        this.levelMapper = levelMapper;
    }

    public Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        return new Member(
                createMemberDto.getEmail(),
                createMemberDto.getPassword(),
                createMemberDto.getFirstName(),
                createMemberDto.getLastName(),
                addressMapper.createAddressDtoToAddress(createMemberDto.getCreateAddressDto()),
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
                addressMapper.addressToAddressDto(member.getAddress()),
                member.getLicensePlate(),
                levelMapper.levelToLevelDto(member.getLevel()),
                member.getRegistrationDate()
        );
    }
}
