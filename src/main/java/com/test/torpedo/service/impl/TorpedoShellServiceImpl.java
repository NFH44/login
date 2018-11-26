package com.test.torpedo.service.impl;

import com.test.torpedo.dao.TorpedoDao;
import com.test.torpedo.dao.TorpedoShellDao;
import com.test.torpedo.entity.Torpedo;
import com.test.torpedo.entity.TorpedoShell;
import com.test.torpedo.service.TorpedoService;
import com.test.torpedo.service.TorpedoShellService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: TorpedoServiceImpl.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-20
 */
@Service
public class TorpedoShellServiceImpl implements TorpedoShellService {
    @Resource
    private TorpedoShellDao tsd;

    @Override
    public String tShellAdd(TorpedoShell torpedoShell) {
        int i = tsd.tShellAdd(torpedoShell);
        if (i == 1){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @Override
    public String tShellUpdate(TorpedoShell torpedoShell) {
        int i = tsd.tShellUpdate(torpedoShell);
        if (i != 0){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @Override
    public String tShellDelete(String id) {
        int i = tsd.tShellDelete(id);
        if (i != 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @Override
    public List<TorpedoShell> queryList(Map<String, Object> queryMap) {
        List<TorpedoShell> list = tsd.queryList(queryMap);
        if (list.size()<0){
            //return "未找到记录";
        }else {

        }
        return list;
    }

    @Override
    public Integer queryListCount(Map<String, Object> queryMap) {
        int i = tsd.queryListCount(queryMap);
        return i;
    }

    @Override
    public List<TorpedoShell> queryById(String id) {
        List<TorpedoShell> list = tsd.queryById(id);
        return list;
    }
}
