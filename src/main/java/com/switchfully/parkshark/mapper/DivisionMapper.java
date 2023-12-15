package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.dto.DivisionDto;
import com.switchfully.parkshark.entity.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division mapCreateDivisionDtoToDivision(CreateDivisionDto createDivisionDto) {
        return new Division(
                createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                createDivisionDto.getDirector(),
                createDivisionDto.getDivision()
        );
    }
    public DivisionDto mapDivisionToDivisionDto(Division division) {
        return new DivisionDto(
                division.getId(),
                division.getName(),
                division.getOriginalName(),
                division.getDirector(),
                division.getDivision()
        );
    }

}
