package com.ilisi.roommatebackend.core.exception;

public class BusinessException extends Exception {
    private String message;
    public BusinessException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
