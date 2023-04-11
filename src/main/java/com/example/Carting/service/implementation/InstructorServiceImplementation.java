package com.example.Carting.service.implementation;

import com.example.Carting.model.Instructor;
import com.example.Carting.repository.InstructorRepository;
import com.example.Carting.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImplementation implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public InstructorServiceImplementation(InstructorRepository instructorRepository){this.instructorRepository = instructorRepository;}
    @Override
    public Instructor createInstructor(Instructor instructor){return instructorRepository.save(instructor);}
    @Override
    public Instructor findByLastName(String lastName){
        return instructorRepository.findInstructorByLastName(lastName);
    }
    @Override
    public Instructor findByFirstName(String firstName){
        return instructorRepository.findInstructorByFirstName(firstName);
    }
    @Override
    public Instructor findByEmail(String email){
        return instructorRepository.findInstructorByEmail(email);
    }
    @Override
    public void deleteInstructor(String lastName){
        Instructor deleteINstructor = instructorRepository.findInstructorByLastName(lastName);
        instructorRepository.delete(deleteINstructor);
    }
    @Override
    public Instructor updateInstructor(Instructor instructor){
        Instructor updateInstructor = instructorRepository.findById(instructor.getId()).get();
        updateInstructor.setEmail(instructor.getEmail());
        updateInstructor.setPassword(instructor.getPassword());
        instructorRepository.save(updateInstructor);
        return updateInstructor;
    }

//    public Boolean logIn(String lastName,String firstName,String password){
//        Instructor instructor1 = instructorRepository.findInstructorByLastName(lastName);
//        Instructor instructor2 = instructorRepository.findInstructorByFirstName(firstName);
//        Instructor instructor3 = instructorRepository.findInstructorByPassword(password);
//        if(instructor1.equals(instructor2)){
//            if(instructor1.equals(instructor3))
//                return true;
//            else
//                return false;
//        }
//        else
//            return false;
//    }
}
