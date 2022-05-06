package com.fc.service;

import com.fc.entity.DormitoryManager;

import java.util.List;

public interface DormitoryManagerService {
    List<DormitoryManager> findByName(String name);

    DormitoryManager findBySn(String sn);

    List<DormitoryManager> findAll();

    void addOrUpdate(DormitoryManager dormitoryManager);

    void delete(String id);
}
