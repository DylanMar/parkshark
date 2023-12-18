package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.dto.DivisionDto;
import com.switchfully.parkshark.entity.Division;
import com.switchfully.parkshark.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("division")
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DivisionDto createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
        return divisionService.createDivision(createDivisionDto);
    }

    @GetMapping(produces = "application/json")
    public List<DivisionDto> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public DivisionDto getDivisionById(@PathVariable long id) {
        return divisionService.getDivisionById(id);
    }

    @PostMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public DivisionDto createSubDivision(@PathVariable long id, @RequestBody CreateDivisionDto createDivisionDto) {
        return divisionService.createSubDivision(createDivisionDto,id);
    }
}
