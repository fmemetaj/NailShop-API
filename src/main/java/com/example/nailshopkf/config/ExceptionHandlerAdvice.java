package com.example.nailshopkf.config;

import com.example.nailshopkf.entity.ApiError;
import com.example.nailshopkf.exceptions.AppointmentNotFoundException;
import com.example.nailshopkf.exceptions.NailServiceNotFoundException;
import com.example.nailshopkf.exceptions.ProductNotFoundException;
import com.example.nailshopkf.exceptions.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        ApiError error = new ApiError();
        error.setMessage("An unexpected error occurred.");
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ApiError> handleAppointmentNotFound(AppointmentNotFoundException ex) {
        ApiError error = new ApiError();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NailServiceNotFoundException.class)
    public ResponseEntity<ApiError> handleNailServiceNotFound(NailServiceNotFoundException ex) {
        ApiError error = new ApiError();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> handleProductNotFound(ProductNotFoundException ex) {
        ApiError error = new ApiError();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ApiError> handleTransactionNotFound(TransactionNotFoundException ex) {
        ApiError error = new ApiError();
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}