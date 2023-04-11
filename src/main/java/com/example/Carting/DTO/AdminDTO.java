package com.example.Carting.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
}
