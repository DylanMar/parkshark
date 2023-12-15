package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Level;
import com.switchfully.parkshark.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@SpringBootTest
@Sql("/data.sql")
class MemberRepositoryTest {
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void givenMember_whenAddMember_thenMemberIsAdded() {
        // GIVEN
        Level level = levelRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + 1));
        Address address = new Address("streetName", "streetNumber", "postalCode");
        Member member = new Member("email", "password", "firstName", "lastName", address, "licensePlate");
        member.setLevel(level);
        member.setRegistrationDate(LocalDate.now());

        // WHEN
        Member actual = memberRepository.save(member);

        // THEN
        Assertions.assertThat(actual).isInstanceOf(Member.class);
    }
}