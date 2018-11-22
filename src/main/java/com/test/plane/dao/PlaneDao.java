package com.test.plane.dao;

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
public interface PlaneDao {
    Integer planeAdd(Object object);
    Integer planeUpdate(Object object);
    Integer planeDelete(@Param("id") String id);
    List<Plane> queryList(@Param("queryMap")Map<String,Object> queryMap );
    Integer queryListCount(@Param("queryMap")Map<String,Object>queryMap );
    List<Plane> queryById(@Param("id") String id);
}
