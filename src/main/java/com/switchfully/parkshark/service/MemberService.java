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
        member.setRegistrationDate(LocalDate.now());
        member.setLevel(levelRepository.findById(1L).get());

        return memberMapper.memberToMemberDto(memberRepository.save(member));
    }

    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream().map(member -> memberMapper.memberToMemberDto(member)).collect(Collectors.toList());
    }
}
