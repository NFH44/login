package com.test.plane.controller;

import com.test.plane.entity.Plane;
import com.test.plane.service.PlaneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: PlaneController.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-22
 */
@Controller
public class PlaneController {
    @Resource
    private PlaneService planeService;

    @RequestMapping("plane")
    public String plane(){
        return "plane";
    }

    @RequestMapping("planeAdd")
    @ResponseBody
    public String planeAdd(@RequestParam Map<String,Object> map){
        String nationId = map.get("nationId").toString();
        String planeName = map.get("planeName").toString();
        String kg = map.get("kg").toString();
        String lv = map.get("lv").toString();
        String price = map.get("price").toString();
        String attribute = map.get("attribute").toString();
        String dp = map.get("dp").toString();
        String speed = map.get("speed").toString();
        String oil = map.get("oil").toString();
        String radarRange = map.get("radarRange").toString();
        String fireRange = map.get("fireRange").toString();
        String time = map.get("time").toString();


        Plane plane = new Plane();
        plane.setNationId(Integer.valueOf(nationId));
        plane.setPlaneName(planeName);
        plane.setKg(Integer.valueOf(kg));
        plane.setLv(Integer.valueOf(lv));
        plane.setPrice(Integer.valueOf(price));
        plane.setAttribute(attribute);
        plane.setDp(Integer.valueOf(dp));
        plane.setSpeed(Integer.valueOf(speed));
        plane.setOil(Integer.valueOf(oil));
        plane.setRadarRange(Integer.valueOf(radarRange));
        plane.setFireRange(Integer.valueOf(fireRange));
        plane.setTime(Integer.valueOf(time));

        String ser = planeService.planeAdd(plane);
        return ser;
    }

    @RequestMapping("queryPlane")
    @ResponseBody
    public List<Plane> queryPlane(@RequestParam Map<String,Object> map){
        map.get("id").toString();
        map.get("planeName").toString();
        map.get("lv").toString();
        map.get("attribute").toString();
        String sortName = map.get("sortName").toString();
        String sortOrder = map.get("sortOrder").toString();
        String currPageIndex = map.get("currPageIndex").toString();
        String currPageSize = map.get("currPageSize").toString();

        int size = Integer.parseInt(currPageSize);
        int totle = planeService.queryListCount(map);
        int curnum = (totle+size-1)/size;
        List ls = new ArrayList();
        List<Plane> list = planeService.queryList(map);
        ls.add(list);
        ls.add(totle);
        ls.add(curnum);
        return ls;
    }

    @RequestMapping("planeUpdate")
    @ResponseBody
    public String planeUpdate(@RequestParam Map<String,Object> map){
        String id = map.get("id").toString();
        String nationId = map.get("nationId").toString();
        String planeName = map.get("planeName").toString();
        String kg = map.get("kg").toString();
        String lv = map.get("lv").toString();
        String price = map.get("price").toString();
        String attribute = map.get("attribute").toString();
        String dp = map.get("dp").toString();
        String speed = map.get("speed").toString();
        String oil = map.get("oil").toString();
        String radarRange = map.get("radarRange").toString();
        String fireRange = map.get("fireRange").toString();
        String time = map.get("time").toString();


        Plane plane = new Plane();
        plane.setId(Integer.valueOf(id));
        plane.setNationId(Integer.valueOf(nationId));
        plane.setPlaneName(planeName);
        plane.setKg(Integer.valueOf(kg));
        plane.setLv(Integer.valueOf(lv));
        plane.setPrice(Integer.valueOf(price));
        plane.setAttribute(attribute);
        plane.setDp(Integer.valueOf(dp));
        plane.setSpeed(Integer.valueOf(speed));
        plane.setOil(Integer.valueOf(oil));
        plane.setRadarRange(Integer.valueOf(radarRange));
        plane.setFireRange(Integer.valueOf(fireRange));
        plane.setTime(Integer.valueOf(time));

        String ser = planeService.planeUpdate(plane);
        return ser;
    }

    @RequestMapping("planeDelete")
    @ResponseBody
    public String planeDelete(@RequestParam String id){
        String ser = planeService.planeDelete(id);
        return ser;
    }
}
