package com.example.SpringWithReact.controller.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super(String.format("User with id %d was not found",id));
    }
}
