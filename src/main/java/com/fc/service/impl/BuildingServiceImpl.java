package com.fc.service.impl;

import com.fc.dao.BuildingMapper;
import com.fc.entity.Building;
import com.fc.entity.BuildingExample;
import com.fc.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;
    @Override
    public List<Building> findAll() {
        return buildingMapper.selectByExample(null);
    }

    @Override
    public void delete(String id) {
        buildingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Building findByName(@RequestBody String name) {
        BuildingExample example = new BuildingExample();
        BuildingExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Building> buildings = buildingMapper.selectByExample(example);
        return buildings.get(0);
    }

    @Override
    public void add(Building building) {
        buildingMapper.insertSelective(building);
    }

    @Override
    public void update(Building building) {
        buildingMapper.updateByPrimaryKeySelective(building);
    }
}
