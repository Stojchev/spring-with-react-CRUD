package com.example.SpringWithReact.service;

import com.example.SpringWithReact.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User newUser);

    List<User> findAll();
    Optional<User> findById(Long id);
    User removeUserById(Long id);
}
