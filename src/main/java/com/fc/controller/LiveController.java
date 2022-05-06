package com.fc.controller;

import com.fc.entity.Live;
import com.fc.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("live")
public class LiveController {
    @Autowired
    private LiveService liveService;

    @GetMapping("findAll")
    public List<Live> findAll (){
        return liveService.findAll();
    }

    @GetMapping("delete")
    public void delete(String id){
        liveService.delete(id);
    }

    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Live live){
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
        if (live.getId() == null){
            live.setCreateTime(new Date());
            live.setId(randomCode.toString());
            liveService.add(live);
        }else {
            liveService.update(live);
        }
    }
}
