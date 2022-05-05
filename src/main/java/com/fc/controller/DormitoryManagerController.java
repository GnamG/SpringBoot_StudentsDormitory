package com.fc.controller;

import com.fc.dao.DormitoryManagerMapper;
import com.fc.entity.DormitoryManager;
import com.fc.entity.DormitoryManagerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {

    @Autowired
    private DormitoryManagerMapper dormitoryManagerMapper;

    //根据name查找， 查到返回对象否则返回空
    @GetMapping("findByName")
    public List<DormitoryManager> findByName(String name) {
        //新建一个例子
        DormitoryManagerExample example = new DormitoryManagerExample();
        DormitoryManagerExample.Criteria criteria = example.createCriteria();
        //把传递过来的name去放到example里去
        criteria.andNameEqualTo(name);
        //然后通过例子去数据库中查询，有就存到dormitoryManagers集合里
        List<DormitoryManager> dormitoryManagers = dormitoryManagerMapper.selectByExample(example);

        if (dormitoryManagers.size() > 0) {

            //新建一个map当成data去传递
            HashMap<String, Object> map = new HashMap<>();
            map.put("data", dormitoryManagers);

            //返回对象
            return dormitoryManagers;
        } else {
            return null;
        }
    }


    //根据宿管编号查询
    @PostMapping("findBySn")
    public DormitoryManager findBySn(String sn) {
        //新建一个例子
        DormitoryManagerExample example = new DormitoryManagerExample();
        DormitoryManagerExample.Criteria criteria = example.createCriteria();
        criteria.andSnEqualTo(sn);
        List<DormitoryManager> dormitoryManagers = dormitoryManagerMapper.selectByExample(example);

        return dormitoryManagers.get(0);
    }

    //查询所有学生,返回一个json对象，date中放入查询到的所有值
    @GetMapping("findAll")
    public List<DormitoryManager> findAll() {
        List<DormitoryManager> dormitoryManagers = dormitoryManagerMapper.selectByExample(null);

        return dormitoryManagers;
    }

    //有id就修改，没有id就添加id和createtime
    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody DormitoryManager dormitoryManager) {

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

    //删除
    @GetMapping("delete")
    public void delete(String id){
       dormitoryManagerMapper.deleteByPrimaryKey(id);
    }


}
