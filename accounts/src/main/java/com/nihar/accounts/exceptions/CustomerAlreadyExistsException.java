package com.nihar.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 8528493828609871813L;

    public CustomerAlreadyExistsException(String msg) {
        super(msg);
    }
}
