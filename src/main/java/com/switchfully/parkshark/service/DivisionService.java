package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.mapper.DivisionMapper;
import com.switchfully.parkshark.repository.DivisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DivisionService {
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public Division createDivision(CreateDivisionDto createDivisionDto) {
        Division division = divisionMapper.mapCreateDivisionDtoToDivision(createDivisionDto);
        return divisionRepository.createDivision(division);
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.getAllDivisions();
    }

    public Division getDivisionById(int id) {
        return divisionRepository.getDivisionById(id);
    }
}
