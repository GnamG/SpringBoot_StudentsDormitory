package com.fc.controller;

import com.fc.service.LoginService;
import com.fc.vo.LoginReqVo;
import com.fc.vo.LoginRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
@Api("登录模块")
@RestController

public class LoginController {
    @Autowired
    private LoginService loginService;
    @ApiOperation("登录权限")
    @PostMapping("login")
    public LoginRespVo<Object> login(@RequestBody LoginReqVo loginReqVo, HttpSession session){
        return loginService.login(loginReqVo,session);
    }

}
