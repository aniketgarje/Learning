package com.phase.one.advice;

import com.phase.one.exception.EmptyInputException;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(NoSuchElementException.class)
   public ResponseEntity<String> nosuchElementHandler(NoSuchElementException e){
     return new  ResponseEntity<String>("We have no data associed with the specified id , please check the db", HttpStatus.NOT_FOUND);

   }

   @ExceptionHandler(EmptyInputException.class)
   public  ResponseEntity<String> emptyNameHandler( EmptyInputException e){
    return new ResponseEntity<String>("Input fields are empty",HttpStatus.BAD_REQUEST);
   }

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>("Method is invalid not used here , please change your http media type",HttpStatus.METHOD_NOT_ALLOWED);
    }
    }

