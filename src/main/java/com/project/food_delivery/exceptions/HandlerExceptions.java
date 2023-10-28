package com.project.food_delivery.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.project.food_delivery.rest_controllers")
public class HandlerExceptions {
    @ExceptionHandler(value = {ApiRequestExceptionNotFound.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorResponse handleApiRequestException(@NonNull HttpServletRequest request, ApiRequestExceptionNotFound exception){
        return new ErrorResponse(request.getRequestURI(), exception.getMessage());
    }

    @ExceptionHandler(value = {ApiRequestExceptionAlreadyReported.class})
    @ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
    public ErrorResponse handleApiRequestExceptionAlreadyReported(@NonNull HttpServletRequest request, ApiRequestExceptionAlreadyReported exception){
        return new ErrorResponse(request.getRequestURI(), exception.getMessage());
    }
}
