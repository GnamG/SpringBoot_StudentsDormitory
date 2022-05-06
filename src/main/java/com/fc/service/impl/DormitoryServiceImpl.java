package com.fc.service.impl;

import com.fc.dao.DormitoryMapper;
import com.fc.entity.Dormitory;
import com.fc.entity.DormitoryExample;
import com.fc.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Dormitory> findAll() {
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(null);
        return dormitories;
    }

    @Override
    public void delete(String id) {
        dormitoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Dormitory findBySn(String sn) {
        DormitoryExample example = new DormitoryExample();
        DormitoryExample.Criteria criteria = example.createCriteria();

        criteria.andSnEqualTo(sn);

        List<Dormitory> dormitories = dormitoryMapper.selectByExample(example);

        return dormitories.get(0);
    }

    @Override
    public void update(Dormitory dormitory) {

        if (dormitory.getId() == null) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            dormitory.setId(uuid);
            dormitory.setCreateTime(new Date());

            dormitoryMapper.insertSelective(dormitory);
        } else {
            dormitoryMapper.updateByPrimaryKeySelective(dormitory);
        }

    }
}
