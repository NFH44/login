package com.test.torpedo.service;

import com.test.torpedo.entity.Torpedo;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: TorpedoService.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-20
 */
public interface TorpedoService {
    String add(Torpedo torpedo);
    String update(Torpedo torpedo);
    String delete(String id);
    List<Torpedo> queryList(Map<String, Object> queryMap);
    Integer queryListCount(Map<String, Object> queryMap);
    List<Torpedo> queryById(String id);
}
