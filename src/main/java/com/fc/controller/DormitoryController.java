package com.fc.controller;

import com.fc.entity.Dormitory;
import com.fc.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    //查询所有
    @GetMapping("findAll")
    public List<Dormitory> findAll() {

        return dormitoryService.findAll();
    }

    //删除
    @GetMapping("delete")
    public void delete(String id) {
        dormitoryService.delete(id);
    }

    //findBySn
    @PostMapping("findBySn")
    public Dormitory findBySn(String sn) {
        return dormitoryService.findBySn(sn);
    }

    //update
    @PostMapping("update")
    public void update(@RequestBody Dormitory dormitory) {
        dormitoryService.update(dormitory);
    }


}
