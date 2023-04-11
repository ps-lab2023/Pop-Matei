package com.example.Carting.repository;

import com.example.Carting.model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    Instructor findInstructorByLastName(String lastName);
    Instructor findInstructorByFirstName(String firstName);
    Instructor findInstructorByEmail(String email);
}
