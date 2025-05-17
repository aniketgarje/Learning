package com.phase.one.globalexceptionhandler;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElement(NoSuchElementException e) {
        return new ResponseEntity<String>("No such element found in database, please check you request parameter", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleObjectNull(NullPointerException e) {
        return new ResponseEntity<String>("No such element found in database, please check you request parameter", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomEmptyListException.class)
    public ResponseEntity<String> handleEmptyListException(CustomEmptyListException e) {
        return new ResponseEntity<String>("No such element found in database, please check you request parameter", HttpStatus.NOT_FOUND);
    }

    @Override
    public   ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>("Media type is incorrect, please check once again", HttpStatus.METHOD_NOT_ALLOWED);    }
}
