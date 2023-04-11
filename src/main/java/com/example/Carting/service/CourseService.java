package com.example.Carting.service;

import com.example.Carting.model.Course;

public interface CourseService {
    Course createCourse(Course course);
    Course findByCourseName(String courseName);

    Course findAll();

    void deleteCourse(String courseName);
    Course updateCourse(Course course);
}
