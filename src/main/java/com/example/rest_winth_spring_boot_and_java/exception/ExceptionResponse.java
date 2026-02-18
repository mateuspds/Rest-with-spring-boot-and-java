package com.example.rest_winth_spring_boot_and_java.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String status) {
}
