package com.test.plane.service.impl;

import com.test.plane.dao.PlaneDao;
import com.test.plane.entity.Plane;
import com.test.plane.service.PlaneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: PlaneServiceImpl.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-22
 */
@Service
public class PlaneServiceImpl implements PlaneService{
    @Resource
    private PlaneDao planeDao;

    @Override
    public String planeAdd(Object object) {
        Plane plane = (Plane)object;
        int i = planeDao.planeAdd(object);
        if (i > 0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @Override
    public String planeUpdate(Object object) {
        Plane plane = (Plane)object;
        int i = planeDao.planeUpdate(object);
        if (i > 0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @Override
    public String planeDelete(String id) {
        Integer i = planeDao.planeDelete(id);
        if ( i != 0){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    @Override
    public List<Plane> queryList(Map<String, Object> queryMap) {
        List<Plane> list = planeDao.queryList(queryMap);
        if (list != null){
            return list;
        }else {
            return null;
        }
    }

    @Override
    public Integer queryListCount(Map<String, Object> queryMap) {
        int i = planeDao.queryListCount(queryMap);
        if (i != 0){
            return i;
        }else {
            return 0;
        }
    }

    @Override
    public List<Plane> queryById(String id) {
        return null;
    }
}
