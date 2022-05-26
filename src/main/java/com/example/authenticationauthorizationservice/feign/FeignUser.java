package com.example.authenticationauthorizationservice.feign;


import com.example.authenticationauthorizationservice.model.UserDto;
import com.example.authenticationauthorizationservice.model.UserWithOutPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="user-service")
public interface FeignUser {
    @PostMapping("/users")
    UserWithOutPassword createUser(UserDto userDto);

    @GetMapping("/users/getUserByEmail/{emailId}")
    UserWithOutPassword getUserDetailsByEmail(@PathVariable("emailId") String emailId);
}
