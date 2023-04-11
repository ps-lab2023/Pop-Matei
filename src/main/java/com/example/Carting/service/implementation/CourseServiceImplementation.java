package com.example.Carting.service.implementation;

import com.example.Carting.model.Course;
import com.example.Carting.repository.CourseRepository;
import com.example.Carting.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public CourseServiceImplementation(CourseRepository courseRepository){this.courseRepository = courseRepository;}
    @Override
    public Course createCourse(Course course){return courseRepository.save(course);}
    @Override
    public Course findByCourseName(String courseName){
        return courseRepository.findCourseByCourseName(courseName);
    }
    @Override
    public Course findAll(){
        return (Course) courseRepository.findAll();
    }
    @Override
    public void deleteCourse(String courseName){
        Course deleteCourse = courseRepository.findCourseByCourseName(courseName);
        courseRepository.delete(deleteCourse);
    }
    @Override
    public Course updateCourse(Course course){
        Course updateCourse = courseRepository.findById(course.getId()).get();
        updateCourse.setCourseName(course.getCourseName());
        updateCourse.setCourseDuration(course.getCourseDuration());
        updateCourse.setMembers(course.getMembers());
        updateCourse.setInstructor(course.getInstructor());
        updateCourse.setCategory(course.getCategory());
        courseRepository.save(updateCourse);
        return updateCourse;
    }

}
