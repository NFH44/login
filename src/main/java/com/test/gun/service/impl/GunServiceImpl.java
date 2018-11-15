package com.test.gun.service.impl;

import com.test.gun.dao.GunDao;
import com.test.gun.entity.Gun;
import com.test.gun.service.GunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GunServiceImpl implements GunService{
    @Resource
    private GunDao gunDao;

    @Override
    public int insert(Gun gun) {
        int i = gunDao.insert(gun);

        return i;
    }

    @Override
    public Integer delete(String id) {
        return gunDao.delete(id);
    }

    @Override
    public Integer update(Map<String, Object> queryMap) {
        Integer i = gunDao.update(queryMap);
        return i;
    }

    @Override
    public List<Gun> queryList(Map<String, Object> queryMap) {
        List<Gun> list = gunDao.queryList(queryMap);
        return list;
    }

    @Override
    public Integer queryListCount(Map<String, Object> queryMap) {
        Integer list =gunDao.queryListCount(queryMap);
        return list;
    }
}
