package com.azship.api.infra.repository.exception;

public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message);
    }
}
