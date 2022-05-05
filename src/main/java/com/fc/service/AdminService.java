package com.fc.service;

import com.fc.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin findByName(String name);

    List<Admin> findAll();

    void update(Admin admin);

    void add(Admin admin);

    void delete(String id);
}
