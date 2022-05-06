package com.fc.service;

import com.fc.entity.Building;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<Building> findAll();

    void delete(String id);

    Building findByName(String name);

    void add(Building building);

    void update(Building building);
}
