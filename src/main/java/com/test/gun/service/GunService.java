package com.test.gun.service;

import com.test.gun.entity.Gun;
import java.util.List;
import java.util.Map;

public interface GunService {
    int insert(Gun gun);
    Integer delete(String id);
    Integer update(Map<String, Object> queryMap);
    List<Gun> queryList(Map<String, Object> queryMap);
    Integer queryListCount(Map<String, Object> queryMap);

}
