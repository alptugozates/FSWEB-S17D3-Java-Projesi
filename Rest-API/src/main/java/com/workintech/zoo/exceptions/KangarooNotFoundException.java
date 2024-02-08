package com.workintech.zoo.exceptions;

import lombok.Data;

@Data
public class KangarooNotFoundException extends RuntimeException{
    public KangarooNotFoundException(String message) {
        super(message);
    }
}
