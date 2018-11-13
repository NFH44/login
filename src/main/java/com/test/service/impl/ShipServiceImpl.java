package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.dao.ShipDao;
import com.test.entity.Page;
import com.test.entity.Ship;
import com.test.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipDao shipDao;
    @Override
    public void insert(Ship ship) {
        shipDao.insert(ship);
    }

    @Override
    public int pageCount() {
        return shipDao.pageCount();
    }

    @Override
    public List<Ship> findAll(int id,Page page) {
        return shipDao.findAll(id,page);
    }

    @Override
    public void update(Ship ship) {
        shipDao.update(ship);
    }

    @Override
    public void deltet(int id) {
        shipDao.delete(id);
    }

    @Override
    public List<Ship> findByNaionIdAndShipName(int id, String shipName) {
        return shipDao.findByNaionIdAndShipName(id,shipName);
    }

    @Override
    public int findCountAndShipName(int id, String shipName) {
        return shipDao.findCountAndShipName(id,shipName);
    }

    @Override
    public List<Ship> findByNaionIdAndLv(int id, int Lv) {
        return shipDao.findByNaionIdAndLv(id,Lv);
    }

    @Override
    public List<Ship> findByNaionIdAndShipType(int id, String shipType) {
        return shipDao.findByNaionIdAndShipType(id,shipType);
    }

    @Override
    public List<Ship> findByNaionIdAndNote(int id, String note) {
        return shipDao.findByNaionIdAndNote(id,note);
    }
}
