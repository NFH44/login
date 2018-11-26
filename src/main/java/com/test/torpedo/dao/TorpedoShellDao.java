package com.test.torpedo.dao;

import com.test.torpedo.entity.Torpedo;
import com.test.torpedo.entity.TorpedoShell;
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
public interface TorpedoShellDao {
    Integer tShellAdd(TorpedoShell torpedoShell);
    Integer tShellUpdate(TorpedoShell torpedoShell);
    Integer tShellDelete(@Param("id") String id);
    List<TorpedoShell> queryList(@Param("queryMap") Map<String, Object> queryMap);
    Integer queryListCount(@Param("queryMap") Map<String, Object> queryMap);
    List<TorpedoShell> queryById(@Param("id") String id);
}
