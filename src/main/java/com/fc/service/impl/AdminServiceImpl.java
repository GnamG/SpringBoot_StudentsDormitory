package com.fc.service.impl;

import com.fc.dao.AdminMapper;
import com.fc.entity.Admin;
import com.fc.entity.AdminExample;
import com.fc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findByName(String name) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);
        return admins.get(0);
    }

    @Override
    public List<Admin>  findAll() {
        return adminMapper.selectByExample(null);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public void add(Admin admin) {
        adminMapper.insertSelective(admin);
    }

    @Override
    public void delete(String id) {
        adminMapper.deleteByPrimaryKey(id);
    }
}
