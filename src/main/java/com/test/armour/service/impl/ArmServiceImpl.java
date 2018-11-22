package com.test.armour.service.impl;

import com.test.armour.dao.ArmDao;
import com.test.armour.entity.Armour;
import com.test.armour.service.ArmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: armServiceImpl.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-21
 */
@Service
public class ArmServiceImpl implements ArmService {
    @Resource
     private ArmDao armDao;

    @Override
    public String armAdd(Object object) {
        Armour armour = (Armour)object;
        int i = armDao.armAdd(object);
        if (i >0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @Override
    public String armUpdate(Object object) {
        Armour armour = (Armour)object;
        int i = armDao.armUpdate(object);
        if (i >0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @Override
    public String armDelete(String id) {
        Integer ser = armDao.armDelete(id);
        if (ser != null){
            return "删除成功";
        }else {
            return "未找到记录";
        }
    }

    @Override
    public List<Armour> queryList(Map<String, Object> queryMap) {
        List<Armour> list = armDao.queryList(queryMap);
        return list;
    }

    @Override
    public Integer queryListCount(Map<String, Object> queryMap) {
        int i = armDao.queryListCount(queryMap);
        if (i != 0){
            return i;
        }else {
            return 0;
        }
    }

    @Override
    public List<Armour> queryById(String id) {
        List<Armour> list = armDao.queryById(id);
        return list;
    }
}
