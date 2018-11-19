package com.test.gun.dao;

import com.test.gun.entity.Gun;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface GunDao {
    int insert(Gun gun);
    String update(@Param("queryMap") Map<String, Object> queryMap);
    String delete(@Param("id") String id);
    List<Gun> queryList(@Param("queryMap") Map<String, Object> queryMap);
    Integer queryListCount(@Param("queryMap") Map<String, Object> queryMap);
    List<Gun> findById(@Param("id") String id);
    List<Gun> findByGunName(@Param("gunName") String gunName);
}
