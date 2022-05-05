package com.fc.controller;

import com.fc.dao.DormitoryMapper;
import com.fc.entity.Dormitory;
import com.fc.entity.DormitoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    //查询所有
    @GetMapping("findAll")
    public List<Dormitory> findAll() {
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(null);
        return dormitories;
    }

    //删除
    @GetMapping("delete")
    public void delete(String id) {
        dormitoryMapper.deleteByPrimaryKey(id);
    }

    //findBySn
    @PostMapping("findBySn")
    public Dormitory findBySn(String sn) {
        DormitoryExample example = new DormitoryExample();
        DormitoryExample.Criteria criteria = example.createCriteria();

        criteria.andSnEqualTo(sn);

        List<Dormitory> dormitories = dormitoryMapper.selectByExample(example);

        return dormitories.get(0);
    }

    //update
    @PostMapping("update")
    public void update(@RequestBody Dormitory dormitory) {

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
