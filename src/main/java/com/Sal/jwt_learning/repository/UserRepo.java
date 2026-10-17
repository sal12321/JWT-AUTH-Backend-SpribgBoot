package com.Sal.jwt_learning.repository;

import com.Sal.jwt_learning.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
}
