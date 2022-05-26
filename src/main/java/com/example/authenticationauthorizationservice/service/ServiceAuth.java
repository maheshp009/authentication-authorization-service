package com.example.authenticationauthorizationservice.service;

import com.example.authenticationauthorizationservice.feign.FeignUser;

import com.example.authenticationauthorizationservice.model.AuthDto;
import com.example.authenticationauthorizationservice.model.JWTRequest;
import com.example.authenticationauthorizationservice.model.UserDto;
import com.example.authenticationauthorizationservice.model.UserWithOutPassword;
import com.example.authenticationauthorizationservice.repo.AuthRepo;
import com.example.authenticationauthorizationservice.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuth {
    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private FeignUser feignUser;


    public UserWithOutPassword signup(UserDto userDto){
        JWTRequest jwtRequest =new JWTRequest(userDto.getEmail(),userDto.getPassword());
        authRepo.save(jwtRequest);
        feignUser.createUser(userDto);
        return new UserWithOutPassword(userDto.getUserId(),userDto.getFirstName(),userDto.getMiddleName(),
                userDto.getLastName(),userDto.getPhoneNumber(),userDto.getDateOfBirth(),userDto.getGender(),userDto.getAddress(),
                userDto.getEmployeeNumber(),userDto.getEmail());
    }

    public AuthDto login(JWTRequest jwtRequest) throws Exception {
        try {
            JWTRequest jwtReq = authRepo.findByemail(jwtRequest.getEmail());
            if (jwtReq.getPassword().equals(jwtRequest.getPassword()) ){
                AuthDto authDto=new AuthDto();
                String token = jwtUtil.generateToken(jwtRequest.getEmail());
                UserWithOutPassword userWithOutPassword1= feignUser.getUserDetailsByEmail(jwtRequest.getEmail());
                authDto.setJwtToken(token);
                authDto.setUserWithOutPassword(userWithOutPassword1);
                return authDto;
            } else {
                throw new JwtException("Password InCorrect");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


//    private class AuthRepo {
//        public void save(JWTRequest jwtRequest) {
//        }
//
//        public JWTRequest findByemail(String email) {
//            return null;
//        }
//    }
}
