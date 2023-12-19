package com.switchfully.parkshark.service;

import com.switchfully.parkshark.entity.Admin;
import com.switchfully.parkshark.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin authenticate(String email, String password){
        Admin admin = adminRepository.findByEmail(email);
        System.out.println(admin);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(password, admin.getPassword())){
            throw new RuntimeException();
        }
        return admin;
    }


}
