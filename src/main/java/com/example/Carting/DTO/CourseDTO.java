package com.example.Carting.DTO;

import com.example.Carting.model.Categories;
import com.example.Carting.model.Instructor;
import com.example.Carting.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Long id;
    private String courseName;
    private  int courseDuration;
    private Categories category;
    private Instructor instructor;
    private List<Member> members;
}
