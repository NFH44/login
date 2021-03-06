package com.test.gun.service;

import com.test.gun.entity.Gun;
import java.util.List;
import java.util.Map;

public interface GunService {
    int insert(Gun gun);
    String delete(String id);
    String update(Map<String, Object> queryMap);

    /**
     *
     * @param pageNo 页码
     * @param pageSize 条数
     * @return
     */
    List<Gun> queryListPage(int pageNo, int pageSize);
    List<Gun> queryList(Map<String, Object> queryMap);
    Integer queryListCount(Map<String, Object> queryMap);
    List<Gun> findById(String id);
    List<Gun> findByGunName(String gunName);
}
