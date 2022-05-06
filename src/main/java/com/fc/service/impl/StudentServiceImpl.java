package com.fc.service.impl;

import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.entity.StudentExample;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectByExample(null);
    }

    @Override
    public void add(Student student) {
        studentMapper.insertSelective(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public Student findBySn(String sn) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andSnEqualTo(sn);
        List<Student> students = studentMapper.selectByExample(example);
        return students.get(0);
    }

    @Override
    public List<Student> findByName(String name) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Student> students = studentMapper.selectByExample(example);
        Map<String, Object> map = new HashMap<>();
        map.put("data",students);
        return students;
    }

    @Override
    public void delete(String id) {
        studentMapper.deleteByPrimaryKey(id);
    }
}
