package com.phase.one.globalexceptionhandler;

import org.springframework.http.HttpStatus;

public class CustomEmptyListException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public CustomEmptyListException(String number, String noDataFoundInDatabase) {
    }

/*    public CustomEmptyListException(String message, HttpStatus notFound) {
        super(message);

    }*/

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
