package com.example.authenticationauthorizationservice.controller;



import com.example.authenticationauthorizationservice.model.AuthDto;
import com.example.authenticationauthorizationservice.model.JWTRequest;
import com.example.authenticationauthorizationservice.model.UserDto;
import com.example.authenticationauthorizationservice.model.UserWithOutPassword;;
import com.example.authenticationauthorizationservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ServiceAuth authService;

    @PostMapping("/auth/login")
    public ResponseEntity<AuthDto> login(@RequestBody JWTRequest jwtRequest) throws Exception {
        return new ResponseEntity<AuthDto>((AuthDto) authService.login(jwtRequest) ,
                HttpStatus.OK);
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<UserWithOutPassword> register(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<UserWithOutPassword>((UserWithOutPassword) authService.signup(userDto) , HttpStatus.OK);
    }



}
