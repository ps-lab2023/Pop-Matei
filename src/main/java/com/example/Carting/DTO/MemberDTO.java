package com.example.Carting.DTO;

import com.example.Carting.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Course course;
}
