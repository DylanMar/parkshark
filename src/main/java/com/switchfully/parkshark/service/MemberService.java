package com.switchfully.parkshark.service;

import com.switchfully.parkshark.dto.CreateMemberDto;
import com.switchfully.parkshark.dto.MemberDto;
import com.switchfully.parkshark.entity.LevelType;
import com.switchfully.parkshark.entity.Member;
import com.switchfully.parkshark.mapper.MemberMapper;
import com.switchfully.parkshark.repository.LevelRepository;
import com.switchfully.parkshark.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.MetaMessage;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        if(createMemberDto.getLevelType() instanceof LevelType){
            member.setLevel(levelRepository.findByLevelType(createMemberDto.getLevelType()));
        } else {
            member.setLevel(levelRepository.findByLevelType(LevelType.BRONZE));
        }
        return memberMapper.memberToMemberDto(memberRepository.save(member));
    }

    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream().map(member -> memberMapper.memberToMemberDto(member)).collect(Collectors.toList());
    }

    public MemberDto getById(Long id) {
        Member member = memberRepository.findById(id).get();
        return memberMapper.memberToMemberDto(member);
    }
}
