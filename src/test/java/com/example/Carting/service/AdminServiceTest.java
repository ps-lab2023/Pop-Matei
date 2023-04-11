package com.example.Carting.service;

import com.example.Carting.model.Admin;
import com.example.Carting.repository.AdminRepository;
import com.example.Carting.service.implementation.AdminServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class  AdminServiceTest {
    private static final String USERNAME = "Admin";
    private static final String PASS = "admin";
    private static final String EMAIL = "admin@aplicatie.com";
    private static final String NEW_USERNAME = "NewAdmin";
    private static final String NEW_PASS = "newadmin";
    private static final String NEW_EMAIL = "newadmin@aplicatie.com";
    private static final String NOT_USERNAME = "cel_fara_de_nume";
    private static final String NOT_PASS = "aualeu";
    private static final String NOT_EMAIL = "nuimail";


    private AdminServiceImplementation adminServiceImplementation;

    @Mock
    private AdminRepository adminRepository;
    private Admin admin;

    @BeforeEach
    void init(){
        initMocks(this);
        admin = new Admin();
//        admin.setId(2L);
        admin.setUsername(USERNAME);
        admin.setEmail(EMAIL);
        admin.setPassword(PASS);
        when(adminRepository.findAdminByUsername(USERNAME)).thenReturn(admin);
        when(adminRepository.findAdminByUsername(NOT_USERNAME)).thenReturn(null);
        when(adminRepository.findAdminByEmail(EMAIL)).thenReturn(admin);
        when(adminRepository.findAdminByEmail(NOT_EMAIL)).thenReturn(null);
    }
    @Test
    void testFindByUsername_whenExisting(){
        adminServiceImplementation = new AdminServiceImplementation(adminRepository);
        Admin admin = adminServiceImplementation.findByUsername(USERNAME);
        assertNotNull(admin);
        assertEquals(USERNAME,admin.getUsername());
    }
    @Test
    void testFindByUsername_whenNonExisting(){
        adminServiceImplementation = new AdminServiceImplementation(adminRepository);
        Admin admin = adminServiceImplementation.findByUsername(NOT_USERNAME);
        assertNull(admin);
    }
    @Test
    void testFindByEmail_whenExisting(){
        adminServiceImplementation = new AdminServiceImplementation(adminRepository);
        Admin admin = adminServiceImplementation.findByEmail(EMAIL);
        assertNotNull(admin);
        assertEquals(EMAIL,admin.getEmail());
    }
    @Test
    void testFindByEmail_whenNonExisting(){
        adminServiceImplementation = new AdminServiceImplementation(adminRepository);
        Admin admin = adminServiceImplementation.findByEmail(NOT_EMAIL);
        assertNull(admin);
    }
//    @Test
//    void testUpdate(){
//        adminServiceImplementation = new AdminServiceImplementation(adminRepository);
//        Admin newAdmin = new Admin();
//        newAdmin.setId(1L);
//        newAdmin.setUsername(NEW_USERNAME);
//        newAdmin.setPassword(NEW_PASS);
//        newAdmin.setEmail(NEW_EMAIL);
//        Admin admin = adminServiceImplementation.updateAdmin(newAdmin);
//        assertNotNull(admin);
//        assertEquals(admin,newAdmin);
//    }
}
