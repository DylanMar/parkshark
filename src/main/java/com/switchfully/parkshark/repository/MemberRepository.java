package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Member;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @Autowired
    private EntityManager entityManager;

    public Member addMember(Member member) {
        entityManager.persist(member);

        return member;
    }
}
