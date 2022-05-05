package com.fc.service.impl;

import com.fc.dao.LiveMapper;
import com.fc.entity.Live;
import com.fc.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveServiceImpl implements LiveService {
    @Autowired
    private LiveMapper liveMapper;
    @Override
    public List<Live> findAll() {
        return liveMapper.selectByExample(null);
    }

    @Override
    public void delete(String id) {
        liveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Live live) {
        liveMapper.insertSelective(live);
    }

    @Override
    public void update(Live live) {
        liveMapper.updateByPrimaryKeySelective(live);
    }
}
