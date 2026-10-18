package com.Sal.jwt_learning.Controllers;


import com.Sal.jwt_learning.entity.User;
import com.Sal.jwt_learning.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
@Slf4j
public class PublicControllers {

    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String hi(){
        return "hello";
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() throws Exception {

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("hey, This is a public api...");


    }


}

