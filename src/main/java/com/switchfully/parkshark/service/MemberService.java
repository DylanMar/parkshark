package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;

import com.switchfully.parkshark.mapper.MemberMapper;
import com.switchfully.parkshark.repository.LevelRepository;
import com.switchfully.parkshark.repository.MemberRepository;

import com.switchfully.parkshark.entity.LevelType;
import com.switchfully.parkshark.entity.Member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {
    private final LevelRepository levelRepository;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    public MemberService(LevelRepository levelRepository, MemberMapper memberMapper, MemberRepository memberRepository) {
        this.levelRepository = levelRepository;
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public MemberDto addMember(CreateMemberDto createMemberDto) {

        Member member = memberMapper.createMemberDtoToMember(createMemberDto);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        member.setPassword(bCryptPasswordEncoder.encode(createMemberDto.getPassword()));
        member.setRegistrationDate(LocalDate.now());
        if(createMemberDto.getLevelType() != null){
            member.setLevel(levelRepository.findByLevelType(createMemberDto.getLevelType()));
        } else {
            member.setLevel(levelRepository.findByLevelType(LevelType.BRONZE));
        }
        return memberMapper.memberToMemberDto(memberRepository.save(member));
    }

    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream().map(memberMapper::memberToMemberDto).collect(Collectors.toList());
    }

    public MemberDto getById(Long id) {
        Member member = memberRepository.findById(id).get();
        return memberMapper.memberToMemberDto(member);
    }

    public Member authenticate(String email, String password){
        Member member = memberRepository.findByEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(password, member.getPassword())){
            throw new RuntimeException();
        }
        return member;
    }
}
