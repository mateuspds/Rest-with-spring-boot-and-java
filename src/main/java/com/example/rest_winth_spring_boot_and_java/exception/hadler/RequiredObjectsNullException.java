package com.example.rest_winth_spring_boot_and_java.exception.hadler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectsNullException extends RuntimeException {
    public RequiredObjectsNullException(String message) {
        super(message);
    }
    
    public RequiredObjectsNullException() {
        super("It is not allowed to persisted null");
    }
}
