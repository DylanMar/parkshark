package com.switchfully.parkshark.controller;

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
    public Division createDivision(@RequestBody Division division) {
        return divisionService.createDivision(division);
    }

    @GetMapping(produces = "application/json")
    public List<Division> getAllDivisions() {
        return divisionService.getAllDivisions();
    }
    @GetMapping(path ="/{id}", produces = "application/json")
    public Division getDivisionById(@PathVariable int id) {
        return divisionService.getDivisionById(id);
    }
}
