package com.project.food_delivery.exceptions;

public class ApiRequestExceptionAlreadyReported extends RuntimeException{
    public ApiRequestExceptionAlreadyReported(String message) {
        super(message);
    }
}
