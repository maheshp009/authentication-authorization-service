package com.example.authenticationauthorizationservice.controller;

import com.example.authenticationauthorizationservice.model.JWTRequest;
import com.example.authenticationauthorizationservice.model.UserDto;
import org.hibernate.validator.internal.xml.CloseIgnoringInputStream;

import static com.example.authenticationauthorizationservice.constfile.ConstFiles.firstName;

public class ServiceAuth {


    public Object signup(UserDto userDto) {
        return null;
    }


    public Object login(JWTRequest jwtRequest) {
        return firstName;
    }
}
