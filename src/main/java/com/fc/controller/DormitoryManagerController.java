package com.fc.controller;

import com.fc.entity.DormitoryManager;
import com.fc.service.DormitoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dormitoryManager")
public class DormitoryManagerController {

    @Autowired
    private DormitoryManagerService dormitoryManagerService;

    //根据name查找， 查到返回对象否则返回空
    @GetMapping("findByName")
    public List<DormitoryManager> findByName(String name) {
        return dormitoryManagerService.findByName(name);
    }


    //根据宿管编号查询
    @PostMapping("findBySn")
    public DormitoryManager findBySn(String sn) {
        return dormitoryManagerService.findBySn(sn);
    }

    //查询所有学生,返回一个json对象，date中放入查询到的所有值
    @GetMapping("findAll")
    public List<DormitoryManager> findAll() {
        return dormitoryManagerService.findAll();
    }

    //有id就修改，没有id就添加id和createtime
    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody DormitoryManager dormitoryManager) {
        dormitoryManagerService.addOrUpdate(dormitoryManager);

    }

    //删除
    @GetMapping("delete")
    public void delete(String id) {
        dormitoryManagerService.delete(id);
    }

}
