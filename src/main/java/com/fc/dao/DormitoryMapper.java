package com.fc.dao;

import com.fc.entity.Dormitory;
import com.fc.entity.DormitoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryMapper {
    long countByExample(DormitoryExample example);

    int deleteByExample(DormitoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(Dormitory row);

    int insertSelective(Dormitory row);

    List<Dormitory> selectByExample(DormitoryExample example);

    Dormitory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Dormitory row, @Param("example") DormitoryExample example);

    int updateByExample(@Param("row") Dormitory row, @Param("example") DormitoryExample example);

    int updateByPrimaryKeySelective(Dormitory row);

    int updateByPrimaryKey(Dormitory row);
}