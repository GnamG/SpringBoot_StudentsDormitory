package com.fc.service.impl;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class DormitoryManagerServiceImpl implements DormitoryManagerService {
    @Autowired
    private DormitoryManagerMapper dormitoryManagerMapper;

    //findByName
    @Override
    public List<DormitoryManager> findByName(String name) {
        DormitoryManagerExample example = new DormitoryManagerExample();
        DormitoryManagerExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);

        List<DormitoryManager> dormitoryManagers = dormitoryManagerMapper.selectByExample(example);

        HashMap<String, Object> map = new HashMap<>();

        if (dormitoryManagers.size() > 0) {

            map.put("data", dormitoryManagers);
        }

        return dormitoryManagers;
    }

    //findBySn
    @Override
    public DormitoryManager findBySn(String sn) {
        //新建一个例子
        DormitoryManagerExample example = new DormitoryManagerExample();
        DormitoryManagerExample.Criteria criteria = example.createCriteria();
        criteria.andSnEqualTo(sn);
        List<DormitoryManager> dormitoryManagers = dormitoryManagerMapper.selectByExample(example);

        return dormitoryManagers.get(0);
    }

    @Override
    public List<DormitoryManager> findAll() {
        List<DormitoryManager> dormitoryManagers = dormitoryManagerMapper.selectByExample(null);

        return dormitoryManagers;
    }

    @Override
    public void addOrUpdate(DormitoryManager dormitoryManager) {
        if (dormitoryManager.getId() == null) {
            //没有id就添加,createtime
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            dormitoryManager.setId(uuid);
            dormitoryManager.setCreateTime(new Date());
            //插入一个
            dormitoryManagerMapper.insertSelective(dormitoryManager);
        } else {
            //修改
            dormitoryManagerMapper.updateByPrimaryKeySelective(dormitoryManager);
        }
    }

    @Override
    public void delete(String id) {
        dormitoryManagerMapper.deleteByPrimaryKey(id);
    }

}
