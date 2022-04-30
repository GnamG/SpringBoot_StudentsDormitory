package com.fc.dao;

import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryManagerMapper {
    long countByExample(DormitoryManagerExample example);

    int deleteByExample(DormitoryManagerExample example);

    int deleteByPrimaryKey(String id);

    int insert(DormitoryManager row);

    int insertSelective(DormitoryManager row);

    List<DormitoryManager> selectByExample(DormitoryManagerExample example);

    DormitoryManager selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") DormitoryManager row, @Param("example") DormitoryManagerExample example);

    int updateByExample(@Param("row") DormitoryManager row, @Param("example") DormitoryManagerExample example);

    int updateByPrimaryKeySelective(DormitoryManager row);

    int updateByPrimaryKey(DormitoryManager row);
}