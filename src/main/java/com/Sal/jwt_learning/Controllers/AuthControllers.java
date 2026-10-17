
package com.Sal.jwt_learning.Controllers;
import com.Sal.jwt_learning.entity.LoginRequest;
import com.Sal.jwt_learning.entity.User;
import com.Sal.jwt_learning.repository.UserRepo;
import com.Sal.jwt_learning.entity.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllers {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final com.Sal.jwt_learning.util.JwtUtil jwtUtil;


    @PostMapping("/register")

    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles("USER");

        userRepo.save(user);




        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User successfully registered");
    }

    @GetMapping
    public String hi() {

        return "this path is authenticated";
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        String token = jwtUtil.generateToken(authentication.getName());

        return  ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(Map.of("token", token));
    }


}
