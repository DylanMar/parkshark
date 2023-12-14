package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Division;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DivisionRepository {
    private final EntityManager entityManager;

    public DivisionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Division createDivision(Division division) {
        entityManager.persist(division);
        return entityManager
                .createQuery("SELECT d FROM Division d WHERE d=:division", Division.class)
                .setParameter("division", division)
                .getSingleResult();
    }

    public List<Division> getAllDivisions() {
        return entityManager
                .createQuery("SELECT d FROM Division d", Division.class)
                .getResultList();
    }

    public Division getdivisionById(int id) {
        return entityManager
                .createQuery("SELECT d FROM Division d WHERE d.id=:id", Division.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
