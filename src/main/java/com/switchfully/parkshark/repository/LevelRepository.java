package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Level;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LevelRepository {
    @Autowired
    private EntityManager entityManager;

    public Level find(Integer id) {
        return entityManager.createQuery("SELECT l FROM Level l WHERE id = :id", Level.class).setParameter("id", id).getSingleResult();
    }
}
