package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.dao.DormitoryManagerMapper;
import com.fc.dao.StudentMapper;
import com.fc.entity.Admin;
import com.fc.entity.DormitoryManager;
import com.fc.entity.Student;
import com.fc.service.LoginService;
import com.fc.vo.LoginReqVo;
import com.fc.vo.LoginRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 验证码有效时间
     * 60秒
     */
    private static final long cpachaTimeout = 86400000;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DormitoryManagerMapper dormitoryManagerMapper;
    @Override
    public LoginRespVo<Object> login(@RequestBody LoginReqVo loginReqVo, HttpSession session) {
        LoginRespVo<Object> respVo = new LoginRespVo<>();
        respVo.setRequestId(loginReqVo.getRequestId());
        respVo.setOperator(loginReqVo.getOperator());
        // 验证码判断
        Object cpacha = session.getAttribute("cpacha");
        if (cpacha == null||!StringUtils.hasLength(String.valueOf(cpacha))) {
            respVo.setCode("0002");
            respVo.setInfo("验证码已失效、验证码已过期、验证码输入错误");
            return respVo;
        }else {
            String[] cpachaCode = cpacha.toString().split("_");
            long time = Long.parseLong(cpachaCode[1]);
            long now = System.currentTimeMillis();
            if (now - time > cpachaTimeout){
                respVo.setCode("0002");
                respVo.setInfo("验证码已失效、验证码已过期、验证码输入错误");
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            }

            if (!loginReqVo.getCaptcha().toUpperCase().equals(cpachaCode[0].toUpperCase())){
                respVo.setCode("0002");
                respVo.setInfo("验证码已失效、验证码已过期、验证码输入错误");
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            }

        }

        if (loginReqVo.getType().equals("1")){
            // 管理员登录
            Admin admin = adminMapper.findByName(loginReqVo.getAccount());

            if (admin == null) {
                respVo.setCode("0002");
                respVo.setInfo("账号不存在，请您检查录入的账号信息！");
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            }else {
                if (!admin.getPassword().equals(loginReqVo.getPassword())) {
                    respVo.setCode("0004");
                    respVo.setInfo("密码错误，如需重置密码请联系管理员！");
                    respVo.setTimestamp(System.currentTimeMillis());
                    return respVo;
                }else {
                    respVo.setCode("0000");
                    respVo.setInfo("登录成功！");
                    session.setAttribute("user",loginReqVo.getAccount());
                    session.setAttribute("userType",loginReqVo.getType());
                    respVo.setTimestamp(System.currentTimeMillis());
                    return respVo;
                }
            }
        } else if (loginReqVo.getType().equals("3")) {
            // 学生登录
            Student student = studentMapper.findBySn(loginReqVo.getAccount());
            if (student == null){
                List<Student> students = studentMapper.findByName(loginReqVo.getAccount());
                // 表示有重名学生
                if (students.size() > 1){
                    respVo.setCode("0005");
                    respVo.setCode("登录失败，请使用学号登录！");
                    respVo.setTimestamp(System.currentTimeMillis());
                    return respVo;
                } else if (students.size() == 1){
                    student = students.get(0);
                }else {
                    respVo.setCode("0002");
                    respVo.setInfo("账号不存在，请您检查录入的账号信息！");
                    respVo.setTimestamp(System.currentTimeMillis());
                    return respVo;
                }
            }

            if (!student.getPassword().equals(loginReqVo.getPassword())){
                respVo.setCode("0004");
                respVo.setInfo("密码错误，如需重置密码请联系管理员！");
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            } else {
                respVo.setCode("0000");
                respVo.setInfo("登录成功！");
                session.setAttribute("user",loginReqVo.getAccount());
                session.setAttribute("userType",loginReqVo.getType());
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            }
        } else if (loginReqVo.getType().equals("2")) {
            // 宿管
            DormitoryManager dm = dormitoryManagerMapper.findBySn(loginReqVo.getAccount());

            if (dm == null) {
                List<DormitoryManager> managers = dormitoryManagerMapper.findByName(loginReqVo.getAccount());
                if (managers.size() > 1) {
                    respVo.setCode("0005");
                    respVo.setCode("登录失败，请使用学号登录！");
                    respVo.setTimestamp(System.currentTimeMillis());
                    return respVo;
                } else if (managers.size() == 1) {
                    dm = managers.get(0);
                } else {
                    respVo.setCode("0002");
                    respVo.setInfo("账号不存在，请您检查录入的账号信息！");
                    respVo.setTimestamp(System.currentTimeMillis());
                    return respVo;
                }
            }
            if (!dm.getPassword().equals(loginReqVo.getPassword())) {
                respVo.setCode("0004");
                respVo.setInfo("密码错误，如需重置密码请联系管理员！");
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            } else {
                respVo.setCode("0000");
                respVo.setInfo("登录成功！");
                session.setAttribute("user",loginReqVo.getAccount());
                session.setAttribute("userType",loginReqVo.getType());
                respVo.setTimestamp(System.currentTimeMillis());
                return respVo;
            }
        }
      return respVo;
    }
}
