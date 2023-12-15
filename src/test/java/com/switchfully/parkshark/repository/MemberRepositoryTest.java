package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Address;
import com.switchfully.parkshark.entity.Level;
import com.switchfully.parkshark.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@SpringBootTest
@AutoConfigureTestDatabase
//@TestPropertySource(locations = "classpath:application.properties")
class MemberRepositoryTest {
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void givenMember_whenAddMember_thenMemberIsAdded() {
        // GIVEN
        Level level = levelRepository.find(1);
        Address address = new Address("streetName", "streetNumber", "postalCode");
        Member member = new Member("email", "password", "firstName", "lastName", address, "licensePlate");
        member.setLevel(level);
        member.setRegistrationDate(LocalDate.now());

        // WHEN
        Member actual = memberRepository.addMember(member);

        // THEN
        Assertions.assertThat(actual).isInstanceOf(Member.class);
    }
}