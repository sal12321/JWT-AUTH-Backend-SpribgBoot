
package com.Sal.jwt_learning.entity;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
