package com.cotivitiapp.productAPI.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
