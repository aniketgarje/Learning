package com.phase.one.exception;

public class EmptyInputException extends RuntimeException{


    String errCode;
    String errMessage;

    @Override
    public String toString() {
        return "EmptyInputException{" +
                "errCode='" + errCode + '\'' +
                ", errMessage='" + errMessage + '\'' +
                '}';
    }

    public EmptyInputException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
