package com.Sal.jwt_learning.entity;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
}
