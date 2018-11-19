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
    public String delete(String id) {
        List<Gun> list =  gunDao.findById(id);
        if (list.size()<=0){
            return "未找到该记录";
        }else {
            gunDao.delete(id);
        }
        return "删除成功";
    }

    @Override
    public String update(Map<String, Object> queryMap) {
        Gun gun = new Gun();
        List<?> list = findByGunName(gun.getGunName());
        if (list.size() <= 0){
            return "未找到该记录";
        }else {
            gunDao.update(queryMap);
        }
        return "更新成功";
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

    @Override
    public List<Gun> findById(String id) {
        List<Gun> list = gunDao.findById(id);
        if (list ==null){
            return list;
        }else {
            return list;
        }
    }

    @Override
    public List<Gun> findByGunName(String gunName) {
        List<Gun> list = gunDao.findByGunName(gunName);
        return list;
    }
}
