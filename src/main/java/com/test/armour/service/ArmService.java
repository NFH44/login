package com.test.armour.service;

import com.test.armour.entity.Armour;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: ArmService.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-21
 */
public interface ArmService {
    String armAdd(Object object);
    String armUpdate(Object object);
    String armDelete(String id);
    List<Armour> queryList(Map<String,Object> queryMap );
    Integer queryListCount(Map<String,Object> queryMap );
    List<Armour> queryById(String id);
}
