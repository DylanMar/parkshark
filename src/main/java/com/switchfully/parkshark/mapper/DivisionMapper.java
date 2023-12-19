package com.switchfully.parkshark.mapper;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.dto.DivisionDto;
import com.switchfully.parkshark.entity.Division;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division mapCreateDivisionDtoToDivision(CreateDivisionDto createDivisionDto) {
//        if (createDivisionDto.getParentDivision() == null) return null;
        return new Division(
                createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                createDivisionDto.getDirector(),
                (createDivisionDto.getParentDivision() != null ? mapCreateDivisionDtoToDivision( createDivisionDto.getParentDivision() ) : null)
        );
    }

    public DivisionDto mapDivisionToDivisionDto(Division division) {
        if (division == null) return null;

        return new DivisionDto(
                division.getId(),
                division.getName(),
                division.getOriginalName(),
                division.getDirector(),
                mapDivisionToDivisionDto( division.getDivision() )
        );
    }

}
