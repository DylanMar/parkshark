package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;
import com.switchfully.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(CREATED)
    public MemberDto addMember(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.addMember(createMemberDto);
    }

    @GetMapping
    public List<MemberDto> getAllMembers(){
        return memberService.getAllMembers();
    }

}
