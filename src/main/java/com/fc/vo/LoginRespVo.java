package com.fc.vo;

import lombok.Data;

@Data
public class LoginRespVo<T> {
    private String requestId;
    private String operator;
    private long timestamp ;
    private String code;
    private String info;
    private T data;
}
