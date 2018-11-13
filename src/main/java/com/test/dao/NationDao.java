package com.test.dao;

import com.test.entity.Nation;

import java.util.List;

public interface NationDao {
    void insert(Nation nation);
    Nation findByNation(String nation);
    List<Nation> findAll();
    boolean delete(int id);
    void update(Nation nation);
    Nation findById(int id);
}
