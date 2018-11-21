package com.test.torpedo.dao;

import com.test.torpedo.entity.Torpedo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: TorpedoDao.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-20
 */
public interface TorpedoDao {
    Integer add(Torpedo torpedo);
    Integer update(Torpedo torpedo);
    Integer delete(@Param("id") String id);
    List<Torpedo> queryList(@Param("queryMap") Map<String, Object> queryMap);
    Integer queryListCount(@Param("queryMap") Map<String, Object> queryMap);
    List<Torpedo> queryById(@Param("id") String id);
}
