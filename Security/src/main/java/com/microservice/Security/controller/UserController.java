package com.microservice.Security.controller;

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

    @GetMapping("hello")
    public ResponseEntity<String> sayHello() {
        String currentUserName = "";
        String role = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
            role = authentication.getAuthorities().toString();
        }
        return ResponseEntity.ok(currentUserName + ": Hello from secured entryPoint"
                + "\n" + role);
    }
}
