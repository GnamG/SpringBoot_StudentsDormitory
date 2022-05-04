package com.fc.vo;

import lombok.Data;

@Data
public class LoginReqVo {
    private String requestId;
    private String operator;
    private String account;
    private String password;
    private String captcha;
    private String type;
}
