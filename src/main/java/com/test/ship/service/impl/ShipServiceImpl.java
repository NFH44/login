package com.test.ship.service.impl;

import com.test.ship.dao.ShipDao;
import com.test.ship.entity.Ship;
import com.test.ship.service.ShipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService {
    @Resource
    private ShipDao shipDao;
    @Override
    public void insert(Ship ship) {
        shipDao.insert(ship);
    }

    @Override
    public void update(Ship ship) {
        shipDao.update(ship);
    }

    @Override
    public void delete(int id) {
        shipDao.delete(id);
    }

    @Override
    public List<Ship> findAll(Map<String, Object> queryMap) {
        return shipDao.findAll(queryMap);
    }

    @Override
    public Integer queryAllCount(Map<String, Object> queryMap) {
        return shipDao.queryAllCount(queryMap);
    }
}
