package com.example.Carting.service.implementation;

import com.example.Carting.DTO.AdminDTO;
import com.example.Carting.model.Admin;
import com.example.Carting.repository.AdminRepository;
import com.example.Carting.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    public AdminServiceImplementation(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public Admin createAdmin(Admin admin){
        return  adminRepository.save(admin);
    }
    @Override
    public Admin findByUsername(String username){
        return adminRepository.findAdminByUsername(username);
    }
    public AdminDTO findByUsernameDTO(String username){
        return adminRepository.findAdminDTOByUsername(username);
    }

    @Override
    public Admin findByEmail(String email){
        return adminRepository.findAdminByEmail(email);
    }
    @Override
    public void deleteAdmin(String username){
        Admin deleteAdmin = adminRepository.findAdminByUsername(username);
        adminRepository.delete(deleteAdmin);
    }
    @Override
    public Admin updateAdmin(Admin admin){
        Admin updateAdmin = adminRepository.findById(admin.getId()).get();
        updateAdmin.setUsername(admin.getUsername());
        updateAdmin.setPassword(admin.getPassword());
        updateAdmin.setEmail(admin.getEmail());
        adminRepository.save(updateAdmin);
        return  updateAdmin;
    }

//    public Boolean logIn(String username,String password){
//        Admin admin1 = adminRepository.findAdminByUsername(username);
//        Admin admin2 = adminRepository.findAdminByPassword(password);
//        if(admin1.equals(admin2))
//            return true;
//        else
//            return false;
//    }
}
