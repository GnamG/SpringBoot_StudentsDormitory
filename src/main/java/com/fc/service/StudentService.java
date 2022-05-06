package com.fc.service;

import com.fc.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void add(Student student);

    void update(Student student);

    Student findBySn(String sn);

    List<Student> findByName(String name);

    void delete(String id);
}
