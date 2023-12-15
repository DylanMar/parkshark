package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.entity.ParkingLot;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class ParkingLotRepository {
    private final EntityManager entityManager;

    public ParkingLotRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        entityManager.persist(parkingLot);
        return entityManager
                .createQuery("SELECT pl FROM ParkingLot pl WHERE pl=:parkingLot",ParkingLot.class)
                .setParameter("parkinglot", parkingLot)
                .getSingleResult();
    }
}