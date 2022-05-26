package com.example.authenticationauthorizationservice.repo;


import com.example.authenticationauthorizationservice.model.JWTRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepo extends MongoRepository<JWTRequest,String> {
    public JWTRequest findByemail(String email);
}
