package com.fc.controller;

import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.entity.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {// 使用三层架构，后替换掉这个测试
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("findAll")
    public List<Student> findAll(){
        List<Student> lives = studentMapper.selectByExample(null);
        return lives;
    }
//    @PostMapping("add")
//    public void add(@RequestBody Student student){
//
//    }
    @GetMapping("delete")
    public void delete(String id){
        studentMapper.deleteByPrimaryKey(id);
    }
    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Student student){
        if (student.getId()==null){
            student.setId("123486");
            student.setCreateTime(new Date());
            studentMapper.insertSelective(student);
        }else {
            studentMapper.updateByPrimaryKeySelective(student);
        }


    }

    @GetMapping("findBySn")
    public Student findBySn(String sn){
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andSnEqualTo(sn);
        List<Student> students = studentMapper.selectByExample(example);
        return students.get(0);
    }

    @GetMapping("findByName")
    public List<Student> findByName(String name){
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Student> students = studentMapper.selectByExample(example);
        Map<String, Object> map = new HashMap<>();
        map.put("data",students);
        return students;
    }

}
