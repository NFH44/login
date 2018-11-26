package com.test.torpedo.service;

import com.test.torpedo.entity.Torpedo;
import com.test.torpedo.entity.TorpedoShell;

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
public interface TorpedoShellService {
    String tShellAdd(TorpedoShell torpedoShell);
    String tShellUpdate(TorpedoShell torpedoShell);
    String tShellDelete(String id);
    List<TorpedoShell> queryList(Map<String, Object> queryMap);
    Integer queryListCount(Map<String, Object> queryMap);
    List<TorpedoShell> queryById(String id);
}
