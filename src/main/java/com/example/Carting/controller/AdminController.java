package com.example.Carting.controller;

import com.example.Carting.DTO.AdminDTO;
import com.example.Carting.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/{username}")
    public AdminDTO findByUsername(@PathVariable String username){
        return adminService.findByUsernameDTO(username);
    }
}
