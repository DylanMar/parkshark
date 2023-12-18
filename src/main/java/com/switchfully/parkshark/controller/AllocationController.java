package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.*;
import com.switchfully.parkshark.entity.*;
import com.switchfully.parkshark.service.*;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/allocations")
public class AllocationController {

    private AllocationService allocationService;
    private MemberService memberService;

    public AllocationController(AllocationService allocationService, MemberService memberService) {
        this.allocationService = allocationService;
        this.memberService = memberService;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(CREATED)
    public AllocationDto createAllocation(@RequestHeader String email, @RequestHeader String password, @RequestBody CreateAllocationDto createAllocationDto){
        Member member = memberService.authenticate(email, password);
        allocationService.checkLicensePlate(member, createAllocationDto);

        return allocationService.startAllocation(member, createAllocationDto);
    }

}
