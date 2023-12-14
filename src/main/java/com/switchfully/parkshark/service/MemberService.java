package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.mapper.MemberMapper;
import com.switchfully.parkshark.repository.LevelRepository;
import com.switchfully.parkshark.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class MemberService {
    private LevelRepository levelRepository;
    private MemberMapper memberMapper;
    private MemberRepository memberRepository;

    public MemberService(LevelRepository levelRepository, MemberMapper memberMapper, MemberRepository memberRepository) {
        this.levelRepository = levelRepository;
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public MemberDto addMember(CreateMemberDto createMemberDto) {
        Member member = memberMapper.createMemberDtoToMember(createMemberDto);
        member.setRegistrationDate(LocalDate.now());
        member.setLevel(levelRepository.find(1));

        return memberMapper.memberToMemberDto(memberRepository.addMember(member));
    }
}
