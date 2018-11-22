package com.test.plane.service;

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
public interface PlaneService {
    String planeAdd(Object object);
    String planeUpdate(Object object);
    String planeDelete(String id);
    List<Plane> queryList(Map<String,Object> queryMap );
    Integer queryListCount(Map<String,Object> queryMap );
    List<Plane> queryById(String id);
}
