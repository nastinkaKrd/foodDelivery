package com.project.food_delivery.exceptions;

public class ApiRequestExceptionNotFound extends RuntimeException{
    public ApiRequestExceptionNotFound(String message) {
        super(message);
    }

}
