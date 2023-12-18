package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.dto.ParkingLotDto;
import com.switchfully.parkshark.entity.ParkingLot;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
//    private final EntityManager entityManager;

//    public ParkingLotRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public ParkingLot createParkingLot(ParkingLot parkingLot) {
//        entityManager.persist(parkingLot);
//        return entityManager
//                .createQuery("SELECT pl FROM ParkingLot pl WHERE pl=:parkingLot",ParkingLot.class)
//                .setParameter("parkingLot", parkingLot)
//                .getSingleResult();
//    }

    public ParkingLot findById(Long id){
        return entityManager.createQuery("SELECT pl FROM ParkingLot pl WHERE id=:id", ParkingLot.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
