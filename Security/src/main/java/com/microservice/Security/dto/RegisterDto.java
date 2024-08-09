package com.microservice.Security.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
