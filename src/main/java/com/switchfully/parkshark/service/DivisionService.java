package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.dto.DivisionDto;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DivisionService {
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public DivisionDto createDivision(CreateDivisionDto createDivisionDto) {
        Division division = divisionMapper.mapCreateDivisionDtoToDivision(createDivisionDto);
        return divisionMapper.mapDivisionToDivisionDto( divisionRepository.save(division) );
    }

    public List<DivisionDto> getAllDivisions() {
        List<Division> divisions = divisionRepository.findAll(); // getAllDivisions();;
        return divisions.stream()
                .map(divisionMapper::mapDivisionToDivisionDto)
                .collect(Collectors.toList());
    }

    public DivisionDto getDivisionById(long id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("Id "+id+", not found."));
        return divisionMapper.mapDivisionToDivisionDto(division);
    }

    public DivisionDto createSubDivision(CreateDivisionDto createDivisionDto, long id) {
        Division division = divisionMapper.mapCreateDivisionDtoToDivision(createDivisionDto);
        division.setDivision( divisionRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("Parent id "+id+", not found.")));
        return divisionMapper.mapDivisionToDivisionDto( divisionRepository.save(division) );
    }
}
