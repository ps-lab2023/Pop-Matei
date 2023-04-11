package com.example.Carting.repository;

import com.example.Carting.DTO.AdminDTO;
import com.example.Carting.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUsername(String username);
    AdminDTO findAdminDTOByUsername(String username);
    Admin findAdminByEmail(String email);
}
