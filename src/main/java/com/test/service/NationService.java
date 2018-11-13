package com.test.service;

import com.test.entity.Nation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NationService {
    void insert(Nation nation);
    Nation findByNation(@Param("nation") String nation);
    List<Nation> findAll();
    boolean delete(int id);
    void update(Nation nation);
    Nation findById(int id);
}
