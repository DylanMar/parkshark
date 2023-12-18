package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateDivisionDto;
import com.switchfully.parkshark.dto.DivisionDto;
import com.switchfully.parkshark.service.AdminService;
import com.switchfully.parkshark.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("division")
public class DivisionController {

    private final DivisionService divisionService;
    private final AdminService adminService;

    public DivisionController(DivisionService divisionService, AdminService adminService) {
        this.divisionService = divisionService;
        this.adminService = adminService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DivisionDto createDivision(@RequestBody CreateDivisionDto createDivisionDto,
                                      @RequestHeader String email, @RequestHeader String password) {
        adminService.authenticate(email, password);
        return divisionService.createDivision(createDivisionDto);
    }

    @GetMapping(produces = "application/json")
    public List<DivisionDto> getAllDivisions(@RequestHeader String email, @RequestHeader String password) {
        adminService.authenticate(email, password);
        return divisionService.getAllDivisions();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public DivisionDto getDivisionById(@PathVariable long id,
                                       @RequestHeader String email, @RequestHeader String password) {
        adminService.authenticate(email, password);
        return divisionService.getDivisionById(id);
    }

    @PostMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public DivisionDto createSubDivision(@PathVariable long id, @RequestBody CreateDivisionDto createDivisionDto,
                                        @RequestHeader String email, @RequestHeader String password) {
        adminService.authenticate(email, password);
        return divisionService.createSubDivision(createDivisionDto,id);
    }
}
