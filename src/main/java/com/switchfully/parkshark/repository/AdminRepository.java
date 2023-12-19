package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Admin;
import com.switchfully.parkshark.service.AdminService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
