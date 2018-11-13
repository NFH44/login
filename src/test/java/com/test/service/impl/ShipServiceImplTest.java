package com.test.service.impl;

import com.test.dao.ShipDao;
import com.test.entity.Page;
import com.test.entity.Ship;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipServiceImplTest {
    @Autowired
    public ShipDao shipDao;
    @Test
    public void pageCount() {
        int i = shipDao.pageCount();
        System.out.println(i+"+++++++++++++++");
    }

    @Test
    public void findAll() {
        Page page = new Page();
        page.setPageSize(5);
        page.setPageNo(0);
        List<Ship> list = shipDao.findAll(4,page);
        System.out.println(list);
    }
    @Test
    public void findCountAndShipName() {
        int i = shipDao.findCountAndShipName(4,"z");
        System.out.println(i);
    }
}