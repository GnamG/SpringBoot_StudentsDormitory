package com.fc.dao;

import com.fc.entity.Building;
import com.fc.entity.BuildingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingMapper {
    long countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Building row);

    int insertSelective(Building row);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Building row, @Param("example") BuildingExample example);

    int updateByExample(@Param("row") Building row, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building row);

    int updateByPrimaryKey(Building row);
}