package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import java.util.List;


@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("delete")
    public void delete(String id){
        studentService.delete(id);
    }
    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Student student){
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
        if (student.getId()==null){
            student.setId(randomCode.toString());
            student.setCreateTime(new Date());
            studentService.add(student);
        }else {
            studentService.update(student);
        }


    }

    @GetMapping("findBySn")
    public Student findBySn(String sn){
        return studentService.findBySn(sn);
    }

    @GetMapping("findByName")
    public List<Student> findByName(String name){
        return studentService.findByName(name);
    }

}
