package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
}
