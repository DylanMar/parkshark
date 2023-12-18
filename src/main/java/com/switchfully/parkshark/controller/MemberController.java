package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;
import com.switchfully.parkshark.service.AdminService;
import com.switchfully.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;
    private AdminService adminService;

    public MemberController(MemberService memberService, AdminService adminService) {
        this.memberService = memberService;
        this.adminService = adminService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(CREATED)
    public MemberDto addMember(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.addMember(createMemberDto);
    }

    @GetMapping
    public List<MemberDto> getAllMembers(@RequestHeader String email, @RequestHeader String password){
        adminService.authenticate(email, password);
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public MemberDto getMemberById(@RequestHeader String email, @RequestHeader String password, @PathVariable Long id){
        adminService.authenticate(email, password);
        return memberService.getById(id);
    }

}
