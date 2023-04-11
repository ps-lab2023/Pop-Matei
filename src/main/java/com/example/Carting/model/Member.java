package com.example.Carting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Categories> categories;

    @ManyToOne
    private Course course;

    public Course getCourses() {
        return course;
    }

    public void setCourses(Course course) {
        this.course = course;
    }
}
