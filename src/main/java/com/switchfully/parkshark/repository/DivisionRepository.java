package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Contact;
import com.switchfully.parkshark.entity.Division;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {

}
