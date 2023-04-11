package com.example.Carting.service;

import com.example.Carting.model.Course;
import com.example.Carting.repository.CourseRepository;
import com.example.Carting.service.implementation.CourseServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class CourseServiceTest {
    private static final String COURSE_NAME = "Riding Course";

    private static final String NOT_COURSE_NAME = "Curs";

    private CourseServiceImplementation courseServiceImplementation;

    @Mock
    private CourseRepository courseRepository;
    private Course course;

    @BeforeEach
    void init(){
        initMocks(this);
        course = new Course();
        course.setCourseName(COURSE_NAME);
        when(courseRepository.findCourseByCourseName(COURSE_NAME)).thenReturn(course);
    }
    @Test
    void testFindByName_whenExisting(){
        courseServiceImplementation = new CourseServiceImplementation(courseRepository);
        Course course = courseServiceImplementation.findByCourseName(COURSE_NAME);
        assertNotNull(course);
        assertEquals(COURSE_NAME,course.getCourseName());
    }
    @Test
    void testFindByUsername_whenNonExisting(){
        courseServiceImplementation = new CourseServiceImplementation(courseRepository);
        Course course = courseServiceImplementation.findByCourseName(NOT_COURSE_NAME);
        assertNull(course);
    }
}
