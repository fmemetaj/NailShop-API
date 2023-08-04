package com.example.nailshopkf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NailServiceNotFoundException extends RuntimeException {

    public NailServiceNotFoundException() {
        super("Nail Service not found");
    }

    public NailServiceNotFoundException(String message) {
        super(message);
    }
}
