package com.microservice.Security.service.Inter;

import com.microservice.Security.dto.AuthResponseDto;
import com.microservice.Security.dto.LoginDto;
import com.microservice.Security.dto.RegisterDto;

public interface AuthService {
    AuthResponseDto register(RegisterDto register);

    AuthResponseDto login(LoginDto login);
}
