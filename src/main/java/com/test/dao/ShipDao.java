package com.test.dao;

import com.test.entity.Page;
import com.test.entity.Ship;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShipDao {
    int pageCount();
    void insert(Ship ship);
    List<Ship> findAll(@Param("id") int id,
                       @Param("page") Page page);
    void update(Ship ship);
    void delete(int id);
    List<Ship> findByNaionIdAndShipName(@Param("id") int id,
                                        @Param("shipName") String shipName);
    int findCountAndShipName(@Param("id") int id,
                             @Param("shipName") String shipName);
    List<Ship> findByNaionIdAndLv(@Param("id") int id,
                                        @Param("Lv") int Lv);
    List<Ship> findByNaionIdAndShipType(@Param("id") int id,
                                        @Param("shipType") String ShipType);
    List<Ship> findByNaionIdAndNote(@Param("id") int id,
                                        @Param("note") String note);
}
