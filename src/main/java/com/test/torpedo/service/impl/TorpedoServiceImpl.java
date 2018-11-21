package com.test.torpedo.service.impl;

import com.test.torpedo.dao.TorpedoDao;
import com.test.torpedo.entity.Torpedo;
import com.test.torpedo.service.TorpedoService;
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
public class TorpedoServiceImpl implements TorpedoService {
    @Resource
    private TorpedoDao torpedoDao;

    @Override
    public String add(Torpedo torpedo) {
        int i = torpedoDao.add(torpedo);
        if (i == 1){
            return "添加成功";
        }else {
            return "添加失败";
        }

    }

    @Override
    public String update(Torpedo torpedo) {
        Integer i = torpedoDao.update(torpedo);
        if (i != null){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    @Override
    public String delete(String id) {
        int i = torpedoDao.delete(id);
        if (i != 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @Override
    public List<Torpedo> queryList(Map<String, Object> queryMap) {
        List<Torpedo> list = torpedoDao.queryList(queryMap);
        if (list.size()<0){
            //return "未找到记录";
        }else {

        }
        return list;
    }

    @Override
    public Integer queryListCount(Map<String, Object> queryMap) {
        int i = torpedoDao.queryListCount(queryMap);
        return i;
    }

    @Override
    public List<Torpedo> queryById(String id) {
        List<Torpedo> list = torpedoDao.queryById(id);
        return list;
    }
}
