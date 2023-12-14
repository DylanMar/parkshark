package com.switchfully.parkshark.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepository {
    @Autowired
    private EntityManager entityManager;
}
