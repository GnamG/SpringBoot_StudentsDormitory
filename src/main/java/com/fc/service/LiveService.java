package com.fc.service;

import com.fc.entity.Live;

import java.util.List;

public interface LiveService {
    List<Live> findAll();

    void delete(String id);

    void add(Live live);

    void update(Live live);
}
