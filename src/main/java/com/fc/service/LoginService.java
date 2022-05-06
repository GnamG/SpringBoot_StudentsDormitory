package com.fc.service;

import com.fc.vo.LoginReqVo;
import com.fc.vo.LoginRespVo;

import javax.servlet.http.HttpSession;

public interface LoginService {
    LoginRespVo<Object> login(LoginReqVo loginReqVo, HttpSession session);

    LoginRespVo<Object> Logout(LoginReqVo loginReqVo, HttpSession session);
}
