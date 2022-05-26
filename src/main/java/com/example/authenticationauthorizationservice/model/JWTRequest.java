package com.example.authenticationauthorizationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table
@Document(collection = "auth")
public class JWTRequest {
    @Id
    private Integer id;
    private String email;
    private String password;

    public JWTRequest(String email, String password) {
        this.email=email;
        this.password=password;
    }
}
