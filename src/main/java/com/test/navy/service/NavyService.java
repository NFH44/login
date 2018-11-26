package com.test.navy.service;

import com.test.navy.entity.Navy;
import com.test.plane.entity.Plane;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: PlaneService.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-22
 */
public interface NavyService {
    String NavyAdd(Object object);
    String NavyUpdate(Object object);
    String NavyDelete(String id);
    List<Navy> queryNavy(Map<String, Object> queryMap);
    Integer queryListCount(Map<String, Object> queryMap);
    List<Navy> queryById(String id);
}
