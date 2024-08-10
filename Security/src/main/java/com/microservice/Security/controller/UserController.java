package com.microservice.Security.controller;

import com.microservice.Security.dto.UserDto;
import com.microservice.Security.security.JwtGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JwtGenerator jwtGenerator;

    @GetMapping("/info")
    public ResponseEntity<UserDto> sayHello() {
        String currentUserName = "";
        String role = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
            role = authentication.getAuthorities().toString();
        }
        UserDto userDto = UserDto.builder()
                .username(currentUserName)
                .role(role)
                .build();
        return ResponseEntity.ok(userDto);
    }
}
