package com.agri.mis.config;

import com.agri.mis.exception.BusiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusiNotFoundException.class)
    ProblemDetail handleBookmarkNotFoundException(BusiNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setProperty("entityId", e.getEntityId());
        problemDetail.setProperty("entityName", e.getEntityName());
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}
