package com.microservice.Security.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    public AuthResponseDto(String accessToken){
        this.accessToken = accessToken;
    }
}
