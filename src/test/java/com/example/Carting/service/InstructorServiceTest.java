package com.example.Carting.service;

import com.example.Carting.model.Admin;
import com.example.Carting.model.Instructor;
import com.example.Carting.repository.InstructorRepository;
import com.example.Carting.service.implementation.AdminServiceImplementation;
import com.example.Carting.service.implementation.InstructorServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.relational.core.sql.In;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class InstructorServiceTest {
    private static final String INSTRUCTOR_LAST_NAME = "Morgan";
    private static final String INSTRUCTOR_FIRST_NAME = "Arthur";
    private static final String EMAIL= "email@email.com";
    private static final String NOT_INSTRUCTOR_LAST_NAME = "NotMorgan";
    private static final String NOT_INSTRUCTOR_FIRST_NAME = "NotArthur";
    private static final String NOT_EMAIL= "NOTemail@email.com";
    private InstructorServiceImplementation instructorServiceImplementation;
    @Mock
    private InstructorRepository instructorRepository;
    private Instructor instructor;

    @BeforeEach
    void init(){
        initMocks(this);
        instructor = new Instructor();
        instructor.setLastName(INSTRUCTOR_LAST_NAME);
        instructor.setEmail(EMAIL);
        instructor.setFirstName(INSTRUCTOR_FIRST_NAME);
        when(instructorRepository.findInstructorByLastName(INSTRUCTOR_LAST_NAME)).thenReturn(instructor);
        when(instructorRepository.findInstructorByFirstName(INSTRUCTOR_FIRST_NAME)).thenReturn(instructor);
        when(instructorRepository.findInstructorByEmail(EMAIL)).thenReturn(instructor);
    }
    @Test
    void testFindByFirstName_whenExisting(){
        instructorServiceImplementation = new InstructorServiceImplementation(instructorRepository);
        Instructor instructor = instructorServiceImplementation.findByFirstName(INSTRUCTOR_FIRST_NAME);
        assertNotNull(instructor);
        assertEquals(INSTRUCTOR_FIRST_NAME,instructor.getFirstName());
    }
    @Test
    void testFindByFirstName_whenNonExisting(){
        instructorServiceImplementation = new InstructorServiceImplementation(instructorRepository);
        Instructor instructor = instructorServiceImplementation.findByFirstName(NOT_INSTRUCTOR_FIRST_NAME);
        assertNull(instructor);
    }
    @Test
    void testFindByLastName_whenExisting(){
        instructorServiceImplementation = new InstructorServiceImplementation(instructorRepository);
        Instructor instructor = instructorServiceImplementation.findByLastName(INSTRUCTOR_LAST_NAME);
        assertNotNull(instructor);
        assertEquals(INSTRUCTOR_LAST_NAME,instructor.getLastName());
    }
    @Test
    void testFindByLastName_whenNonExisting(){
        instructorServiceImplementation = new InstructorServiceImplementation(instructorRepository);
        Instructor instructor = instructorServiceImplementation.findByLastName(NOT_INSTRUCTOR_LAST_NAME);       assertNull(instructor);
    }
    @Test
    void testFindByEmail_whenExisting(){
        instructorServiceImplementation = new InstructorServiceImplementation(instructorRepository);
        Instructor instructor = instructorServiceImplementation.findByEmail(EMAIL);
        assertNotNull(instructor);
        assertEquals(EMAIL,instructor.getEmail());
    }
    @Test
    void testFindByEmail_whenNonExisting(){
        instructorServiceImplementation = new InstructorServiceImplementation(instructorRepository);
        Instructor instructor = instructorServiceImplementation.findByEmail(NOT_EMAIL);
        assertNull(instructor);
    }
}
