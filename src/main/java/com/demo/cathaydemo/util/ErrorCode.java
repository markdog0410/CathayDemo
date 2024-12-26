package com.demo.cathaydemo.util;

public enum ErrorCode {

    SUCCESS("0000", "Success"),
    FETCH_COINDESK_API_ERROR("0010","Fetch coindeskapi error."),
    TRANSFORM_DATA_ERROR("0020", "Transform data error."),
    TRANSFORM_DATA_FAILED("0021", "Transform data failed."),
    INSERT_NEW_CURRENCY_ERROR("0030", "Insert new currency error."),
    CURRENCY_ALREADY_EXISTED("0031", "Currency already existed."),
    UPDATE_CURRENCY_ERROR("0032", "Update currency error."),
    NOT_MATCH_CURRENCY("0033", "Not match currency."),
    DELETE_CURRENCY_ERROR("0034", "Delete currency error."),
//    DELETE_CURRENCY_FAILED("0035", "Delete currency failed."),
    SYSTEM_ERROR("9999", "System error."),
    ;

    private String code;
    private String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
