package com.test.service;

import com.test.entity.Page;
import com.test.entity.Ship;

import java.util.List;

public interface ShipService {
    void insert(Ship ship);
    int pageCount();
    List<Ship> findAll(int id,Page page);
    void update(Ship ship);
    void deltet(int id);
    List<Ship> findByNaionIdAndShipName(int id,String shipName);
    int findCountAndShipName(int id, String shipName);
    List<Ship> findByNaionIdAndLv(int id,int Lv);
    List<Ship> findByNaionIdAndShipType(int id,String shipType);
    List<Ship> findByNaionIdAndNote(int id,String note);
}
