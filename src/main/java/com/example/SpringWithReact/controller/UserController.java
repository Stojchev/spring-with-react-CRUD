package com.example.SpringWithReact.controller;

import com.example.SpringWithReact.controller.exception.UserNotFoundException;
import com.example.SpringWithReact.model.User;
import com.example.SpringWithReact.repository.UserRepository;
import com.example.SpringWithReact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User newUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService
                .findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    return userService.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    User deleteUser(@PathVariable Long id) {
        return userService.removeUserById(id);
    }
}
