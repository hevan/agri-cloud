package com.agri.mis.util;

public class CustomException  extends RuntimeException{
    private Integer errCode;
    public CustomException(Integer errCode, String message) {
        super(message);
        this.errCode = errCode;
    }
}
