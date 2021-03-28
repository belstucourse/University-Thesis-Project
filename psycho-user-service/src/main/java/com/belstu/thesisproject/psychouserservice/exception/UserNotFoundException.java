package com.belstu.thesisproject.psychouserservice.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User not found");
    }
}
