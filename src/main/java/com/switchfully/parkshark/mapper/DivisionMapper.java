package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.dto.DivisionDto;
import com.switchfully.parkshark.entity.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division mapCreateDivisionDtoToDivision(CreateDivisionDto createDivisionDto, Division parentDivision) {
        return new Division(
                createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                createDivisionDto.getDirector(),
                parentDivision
        );
    }
//    public Division mapDivisionDtoToDivision(DivisionDto divisionDto) {
//        return new Division(
//                divisionDto.getName(),
//                divisionDto.getOriginalName(),
//                divisionDto.getDirector(),
//                divisionDto.getDivisionId() != null ? mapDivisionDtoToDivision( divisionDto.getDivisionId()) : -1
//        );
//    }
    public DivisionDto mapDivisionToDivisionDto(Division division) {
        if (division == null) return null;

        return new DivisionDto(
                division.getId(),
                division.getName(),
                division.getOriginalName(),
                division.getDirector(),
                mapDivisionToDivisionDto(division.getDivision())
        );
    }

}
