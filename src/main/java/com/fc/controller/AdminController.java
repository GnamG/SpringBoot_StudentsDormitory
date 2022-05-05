package com.fc.controller;

import com.fc.entity.Admin;
import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("findByName")
    public Admin findByName(String name){
        return adminService.findByName(name);
    }

    @GetMapping("findAll")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(Admin admin){
        //六位随机数加字母
        StringBuilder randomCode = new StringBuilder();
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (randomCode.toString().contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomCode.append(c);
        }

        if (admin.getId() != null){
            adminService.update(admin);
        }else {
            admin.setCreateTime(new Date());
            admin.setId(randomCode.toString());
            adminService.add(admin);
        }
    }

    @GetMapping("delete")
    public void delete(String id){
        adminService.delete(id);
    }
}
