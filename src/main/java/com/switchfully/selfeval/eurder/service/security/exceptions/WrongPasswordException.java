package com.switchfully.selfeval.eurder.service.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String message) {
        super(message);
    }
}
