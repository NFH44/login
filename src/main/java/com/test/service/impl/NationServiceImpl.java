package com.test.service.impl;

import com.test.dao.NationDao;
import com.test.entity.Nation;
import com.test.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NationServiceImpl implements NationService{
    @Autowired
    private NationDao nationDao;
    @Override
    public void insert(Nation nation) {
        nationDao.insert(nation);
    }

    @Override
    public Nation findByNation(String nation) {
        Nation n = nationDao.findByNation(nation);
        return n;
    }

    @Override
    public List<Nation> findAll() {
        return nationDao.findAll();
    }

    @Override
    public boolean delete(int id) {
        return nationDao.delete(id);
    }

    @Override
    public void update(Nation nation) {
        nationDao.update(nation);

    }

    @Override
    public Nation findById(int id) {
        Nation nation = nationDao.findById(id);
        return nation;
    }
}
