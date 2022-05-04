package com.fc.dao;

import com.fc.entity.Student;
import com.fc.entity.StudentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Student row);

    int insertSelective(Student row);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Student row, @Param("example") StudentExample example);

    int updateByExample(@Param("row") Student row, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student row);

    int updateByPrimaryKey(Student row);
    List<Student> findByName(String name);
    Student findBySn(String sn);
}