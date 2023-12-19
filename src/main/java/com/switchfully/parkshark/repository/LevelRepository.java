package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Level;
import com.switchfully.parkshark.entity.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    Level findByLevelType(LevelType levelType);
}
