package com.fc.controller;

import com.fc.entity.Building;
import com.fc.entity.Student;
import com.fc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("building")
public class buildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("findAll")
    public List<Building> findAll(){
        return buildingService.findAll();
    }

    @GetMapping("delete")
    public void delete(String id){
        buildingService.delete(id);
    }

    @GetMapping("findByName")
    public Building findByName(String name){
        return buildingService.findByName(name);
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Building building){
        //六位随机数加字母
        StringBuilder randomCode = new StringBuilder();
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (randomCode.toString().contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomCode.append(c);
        }
        if (building.getId()==null){
            building.setCreateTime(new Date());
            building.setId(randomCode.toString());
            buildingService.add(building);
        }else {
            buildingService.update(building);
        }
    }
}
