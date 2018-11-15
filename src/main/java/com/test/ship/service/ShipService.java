package com.test.ship.service;

import com.test.ship.entity.Ship;
import java.util.List;
import java.util.Map;

public interface ShipService {
    void insert(Ship ship);
    void update(Ship ship);
    void delete(int id);
    List<Ship> findAll(Map<String, Object> queryMap);
    Integer queryAllCount(Map<String, Object> queryMap);
}
