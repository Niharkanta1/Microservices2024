package com.nihar.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardAlreadyExistsException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 340146886020298212L;

    public CardAlreadyExistsException(String message) {
        super(message);
    }

}
