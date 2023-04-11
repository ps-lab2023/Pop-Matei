package com.example.Carting.repository;

import com.example.Carting.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findCourseByCourseName(String courseName);
}
