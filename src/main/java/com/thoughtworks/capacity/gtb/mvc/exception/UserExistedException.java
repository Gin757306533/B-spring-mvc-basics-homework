package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserExistedException extends RuntimeException{
    public UserExistedException(String message){
        super(message);
    }
}
