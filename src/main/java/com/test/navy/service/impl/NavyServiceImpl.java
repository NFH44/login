package com.test.navy.service.impl;


import com.test.navy.dao.NavyDao;
import com.test.navy.entity.Navy;
import com.test.navy.service.NavyService;

import com.test.plane.entity.Plane;

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
public class NavyServiceImpl implements NavyService{
    @Resource
    private NavyDao navyDao;

    @Override
    public String NavyAdd(Object object) {
        Navy navy = (Navy)object;
        int i = navyDao.NavyAdd(object);
        if (i > 0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @Override
    public String NavyUpdate(Object object) {
        Navy navy = (Navy)object;
        int i = navyDao.NavyUpdate(object);
        if (i > 0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @Override
    public String NavyDelete(String id) {
        Integer i = navyDao.NavyDelete(id);
        if ( i != 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @Override
    public List<Navy> queryNavy(Map<String, Object> queryMap) {
        List<Navy> list = navyDao.queryNavy(queryMap);
        if (list != null){
            return list;
        }else {
            return null;
        }
    }

    @Override
    public Integer queryListCount(Map<String, Object> queryMap) {
        int i = navyDao.queryListCount(queryMap);
        if (i != 0){
            return i;
        }else {
            return 0;
        }
    }

    @Override
    public List<Navy> queryById(String id) {
        return null;
    }
}
