package com.example.Carting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String email;
    private String username;
    private String password;


}
