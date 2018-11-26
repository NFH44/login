package com.test.navy.controller;

import com.test.navy.entity.Navy;
import com.test.navy.service.NavyService;
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
public class NavyController {
    @Resource
    private NavyService navyService;

    @RequestMapping("navy")
    public String navy(){
        return "navy";
    }

    @RequestMapping("navyAdd")
    @ResponseBody
    public String navyAdd(@RequestParam Map<String,Object> map){
        String nationId = map.get("nationId").toString();
        String job = map.get("job").toString();
        String lv = map.get("lv").toString();
        String coin = map.get("coin").toString();
        String latent = map.get("latent").toString();
        String hit = map.get("hit").toString();
        String reload = map.get("reload").toString();
        String torpedo = map.get("torpedo").toString();
        String aa = map.get("AA").toString();
        String repair = map.get("repair").toString();
        String mending = map.get("mending").toString();
        String machine = map.get("machine").toString();
        String scout = map.get("scout").toString();
        String plane = map.get("plane").toString();
        String bomb = map.get("bomb").toString();


        Navy navy = new Navy();
        navy.setNationId(Integer.valueOf(nationId));
        navy.setJob(job);
        navy.setLv(Integer.valueOf(lv));
        navy.setCoin(Integer.valueOf(coin));
        navy.setLatent(Integer.valueOf(latent));
        navy.setHit(Integer.valueOf(hit));
        navy.setReload(Integer.valueOf(reload));
        navy.setTorpedo(Integer.valueOf(torpedo));
        navy.setAa(Integer.valueOf(aa));
        navy.setRepair(Integer.valueOf(repair));
        navy.setMending(Integer.valueOf(mending));
        navy.setMachine(Integer.valueOf(machine));
        navy.setScout(Integer.valueOf(scout));
        navy.setPlane(Integer.valueOf(plane));
        navy.setBomb(Integer.valueOf(bomb));

        String ser = navyService.NavyAdd(navy);
        return ser;
    }

    @RequestMapping("queryNavy")
    @ResponseBody
    public List<Plane> queryPlane(@RequestParam Map<String,Object> map){
        map.get("id").toString();
        map.get("job").toString();
        map.get("lv").toString();
        map.get("sortName").toString();
        map.get("sortOrder").toString();
        map.get("currPageIndex").toString();
        String currPageSize = map.get("currPageSize").toString();

        int size = Integer.parseInt(currPageSize);
        int totle = navyService.queryListCount(map);
        int curnum = (totle+size-1)/size;
        List ls = new ArrayList();
        List<Navy> list = navyService.queryNavy(map);
        ls.add(list);
        ls.add(totle);
        ls.add(curnum);
        return ls;
    }
    @RequestMapping("navyUpdate")
    @ResponseBody
    public String navyUpdate(@RequestParam Map<String,Object> map){
        String id = map.get("id").toString();
        String nationId = map.get("nationId").toString();
        String job = map.get("job").toString();
        String lv = map.get("lv").toString();
        String coin = map.get("coin").toString();
        String latent = map.get("latent").toString();
        String hit = map.get("hit").toString();
        String reload = map.get("reload").toString();
        String torpedo = map.get("torpedo").toString();
        String aa = map.get("AA").toString();
        String repair = map.get("repair").toString();
        String mending = map.get("mending").toString();
        String machine = map.get("machine").toString();
        String scout = map.get("scout").toString();
        String plane = map.get("plane").toString();
        String bomb = map.get("bomb").toString();

        Navy navy = new Navy();
        navy.setId(Integer.valueOf(id));
        navy.setNationId(Integer.valueOf(nationId));
        navy.setJob(job);
        navy.setLv(Integer.valueOf(lv));
        navy.setCoin(Integer.valueOf(coin));
        navy.setLatent(Integer.valueOf(latent));
        navy.setHit(Integer.valueOf(hit));
        navy.setReload(Integer.valueOf(reload));
        navy.setTorpedo(Integer.valueOf(torpedo));
        navy.setAa(Integer.valueOf(aa));
        navy.setRepair(Integer.valueOf(repair));
        navy.setMending(Integer.valueOf(mending));
        navy.setMachine(Integer.valueOf(machine));
        navy.setScout(Integer.valueOf(scout));
        navy.setPlane(Integer.valueOf(plane));
        navy.setBomb(Integer.valueOf(bomb));

        String ser = navyService.NavyUpdate(navy);
        return ser;
    }

    @RequestMapping("navyDelete")
    @ResponseBody
    public String navyDelete(@RequestParam String id){
        String ser = navyService.NavyDelete(id);
        return ser;
    }
}
