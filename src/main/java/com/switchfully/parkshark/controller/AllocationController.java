package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.*;
import com.switchfully.parkshark.entity.*;
import com.switchfully.parkshark.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    private AllocationService allocationService;
    private MemberService memberService;
    private AdminService adminService;

    public AllocationController(AllocationService allocationService, MemberService memberService, AdminService adminService) {
        this.allocationService = allocationService;
        this.memberService = memberService;
        this.adminService = adminService;
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    @ResponseStatus(CREATED)
    public AllocationDto createAllocation(@RequestHeader String email, @RequestHeader String password, @RequestBody CreateAllocationDto createAllocationDto){
        Member member = memberService.authenticate(email, password);
        allocationService.checkLicensePlate(member, createAllocationDto);

        return allocationService.startAllocation(member, createAllocationDto);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(CREATED)
    public AllocationDto stopAllocation(@RequestHeader String email, @RequestHeader String password, @PathVariable Long id, @RequestBody UpDateAllocationDto upDateAllocationDto){
        Member member = memberService.authenticate(email, password);
        allocationService.checkAllocation(member, id);
        return allocationService.stopAllocation(member, id, upDateAllocationDto);
    }

    @GetMapping
    public List<AllocationDto> getAllAllocations(@RequestHeader String email, @RequestHeader String password, @RequestParam(required = false) AllocationStatus allocationStatus){
        adminService.authenticate(email, password);
        return allocationService.getAllAllocations(allocationStatus);
    }

}
