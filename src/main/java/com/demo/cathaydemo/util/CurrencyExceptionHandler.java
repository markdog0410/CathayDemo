package com.demo.cathaydemo.util;

public class CurrencyExceptionHandler extends RuntimeException{
    private ErrorCode errorCode;

    public CurrencyExceptionHandler(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
