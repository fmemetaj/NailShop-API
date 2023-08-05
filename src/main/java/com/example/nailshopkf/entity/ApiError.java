package com.example.nailshopkf.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private String message;
    private LocalDateTime timestamp;
}
