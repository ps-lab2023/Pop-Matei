package com.example.Carting.mapper;

import com.example.Carting.DTO.AdminDTO;
import com.example.Carting.model.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public static AdminDTO mapModelToDto(Admin admin){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPassword(admin.getPassword());

        return adminDTO;
    }
}
