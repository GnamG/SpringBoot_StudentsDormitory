package com.fc.service;

import com.fc.entity.Dormitory;

import java.util.List;

public interface DormitoryService {
    List<Dormitory> findAll();

    void delete(String id);

    Dormitory findBySn(String sn);

    void addOrUpdate(Dormitory dormitory);

}
