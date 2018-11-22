package com.test.armour.dao;

import com.test.armour.entity.Armour;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: ArmDao.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-21
 */
public interface ArmDao {
    Integer armAdd(Object object);
    Integer armUpdate(Object object);
    Integer armDelete(@Param("id") String id);
    List<Armour> queryList(@Param("queryMap")Map<String,Object>queryMap );
    Integer queryListCount(@Param("queryMap")Map<String,Object>queryMap );
    List<Armour> queryById(@Param("id") String id);
}
