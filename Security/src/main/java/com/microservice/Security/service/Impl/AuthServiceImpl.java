package com.microservice.Security.service.Impl;

import com.microservice.Security.dto.AuthResponseDto;
import com.microservice.Security.dto.LoginDto;
import com.microservice.Security.dto.RegisterDto;
import com.microservice.Security.models.User;
import com.microservice.Security.repository.RoleRepository;
import com.microservice.Security.repository.UserRepository;
import com.microservice.Security.security.JwtGenerator;
import com.microservice.Security.service.Inter.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    @Override
    public AuthResponseDto register(RegisterDto register) {
        User user = User.builder()
                .firstname(register.getFirstname())
                .lastname(register.getLastname())
                .username(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .roles(Collections.singletonList(roleRepository.findByName("USER").get()))
                .build();
        userRepository.save(user);
        LoginDto loginDto = LoginDto.builder()
                .username(register.getUsername())
                .password(register.getPassword())
                .build();
        return login(loginDto);
    }

    @Override
    public AuthResponseDto login(LoginDto login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(),
                        login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new AuthResponseDto(token);
    }
}
