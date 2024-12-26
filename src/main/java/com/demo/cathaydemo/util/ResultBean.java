package com.demo.cathaydemo.util;

public class ResultBean {
    private String rsCode;
    private String message;

    public ResultBean() {}

    public ResultBean(ErrorCode errorCode) {
        this.rsCode = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public String getRsCode() {
        return rsCode;
    }

    public void setRsCode(String rsCode) {
        this.rsCode = rsCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
