package com.fc.dao;

import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String id);

    int insert(Admin row);

    int insertSelective(Admin row);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("row") Admin row, @Param("example") AdminExample example);

    int updateByExample(@Param("row") Admin row, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin row);

    int updateByPrimaryKey(Admin row);

    Admin findByName(@Param("name") String name);
}