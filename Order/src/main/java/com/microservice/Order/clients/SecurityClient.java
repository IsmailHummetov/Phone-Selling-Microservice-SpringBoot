package com.microservice.Order.clients;

import com.microservice.Order.external.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Security")
public interface SecurityClient {
    @GetMapping("/info")
    public UserDto getUsername(@RequestHeader("Authorization") String token);
}
