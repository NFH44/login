package com.test.gun.service.impl;

import com.test.gun.dao.GunDao;
import com.test.gun.entity.Gun;
import com.test.gun.service.GunService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GunServiceImplTest {
@Resource
public GunDao dao;

@Resource
public GunService gunService;
    @Test
    public void queryListCount() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id",4);

        for(Object m: queryMap.keySet()){
            System.out.println(m+"---"+queryMap.get(m));
        }

        //int j = dao.queryListCount(queryMap);
        System.out.println(dao.queryListCount(queryMap));
    }

    @Test
    public void quertListPage(){
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id",4);
        queryMap.put("sortName","lv");
        queryMap.put("sortOrder","asc");
        queryMap.put("currPageIndex",0);
        queryMap.put("currPageSize",10);
        int pageno = 1;
        int pageSize = 10;
        List<Gun> list = gunService.queryListPage(pageno,pageSize);
        System.out.println(list);
    }
}