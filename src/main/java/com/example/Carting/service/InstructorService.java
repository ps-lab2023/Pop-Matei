package com.example.Carting.service;

import com.example.Carting.model.Instructor;

public interface InstructorService {
    Instructor createInstructor(Instructor instructor);
    Instructor findByLastName(String lastName);

    Instructor findByFirstName(String firstName);

    Instructor findByEmail(String email);

    void deleteInstructor(String lastName);
    Instructor updateInstructor(Instructor instructor);
}
