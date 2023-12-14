package com.switchfully.parkshark.service;

import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.repository.DivisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DivisionService {
    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division createDivision(Division division) {
        return divisionRepository.createDivision(division);
    }

    public List<Division> getAllDivisions() {
        return divisionRepository.getAllDivisions();
    }

    public Division getDivisionById(int id) {
        return divisionRepository.getDivisionById(id);
    }
}
