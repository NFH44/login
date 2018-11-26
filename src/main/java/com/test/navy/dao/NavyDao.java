package com.test.navy.dao;

import com.test.navy.entity.Navy;
import com.test.plane.entity.Plane;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: PlaneDao.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-22
 */
public interface NavyDao {
    Integer NavyAdd(Object object);
    Integer NavyUpdate(Object object);
    Integer NavyDelete(@Param("id") String id);
    List<Navy> queryNavy(@Param("queryMap") Map<String, Object> queryMap);
    Integer queryListCount(@Param("queryMap") Map<String, Object> queryMap);
    List<Navy> queryById(@Param("id") String id);
}
