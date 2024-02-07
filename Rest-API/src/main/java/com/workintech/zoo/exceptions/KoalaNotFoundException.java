package com.workintech.zoo.exceptions;

public class KoalaNotFoundException extends RuntimeException{
    public KoalaNotFoundException(String message) {
        super(message);
    }
}
