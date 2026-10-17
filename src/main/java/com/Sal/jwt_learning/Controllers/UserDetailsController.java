package com.Sal.jwt_learning.Controllers;

import com.Sal.jwt_learning.entity.User;
import com.Sal.jwt_learning.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.Authentication;

@RestController



public class UserDetailsController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication authentication) throws Exception {


            User user = userRepo.findByUsername(authentication.getName()).orElseThrow(() -> new Exception("Username not found")) ;
            user.setPassword(null);
            user.setId(null);

       return ResponseEntity

               .status(HttpStatus.ACCEPTED)
               .body(user);



    }


}
