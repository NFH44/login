package com.test.torpedo.controller;

import com.test.torpedo.entity.Torpedo;
import com.test.torpedo.service.TorpedoService;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @ClassName: Controller.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-20
 */
@org.springframework.stereotype.Controller
public class TorpedoController {
    @Resource
    private TorpedoService torpedoService;

    @RequestMapping("torpedo")
    public String torpedo(){
        return "torpedo";
    }

    @RequestMapping("torpedoAdd")
    @ResponseBody
    public String torpedoAdd(@RequestParam("nationId") Integer nationId,
                             @RequestParam("torpedoName") String torpedoName,
                             @RequestParam("lv") Integer lv,
                             @RequestParam("price") Integer price,
                             @RequestParam("amount") Integer amount,
                             @RequestParam("time") Integer time,
                             @RequestParam("caliber") Integer caliber){
        Torpedo torpedo = new Torpedo();
        torpedo.setNationId(nationId);
        torpedo.setName(torpedoName);
        torpedo.setLv(lv);
        torpedo.setPrice(price);
        torpedo.setAmount(amount);
        torpedo.setTime(time);
        torpedo.setCaliber(caliber);
        String a =  torpedoService.add(torpedo);
        return a;
    }

    @RequestMapping("torpedoList")
    @ResponseBody
    public List<Torpedo> torpedoList(@RequestParam Map<String, Object> map){
        String id = map.get("id").toString();
        String name = map.get("name").toString();
        map.get("lv").toString();
        map.get("amount").toString();
        map.get("caliber").toString();
        map.get("sortName").toString();
        map.get("sortOrder").toString();
        map.get("currPageIndex").toString();
        String currPageSize = map.get("currPageSize").toString();

        int size = Integer.parseInt(currPageSize);
        int totle = torpedoService.queryListCount(map);
        int curnum = (totle+size-1)/size;

        List ls = new ArrayList<>();
        List<Torpedo> list = torpedoService.queryList(map);
        ls.add(list);
        ls.add(totle);
        ls.add(curnum);
        return ls;
    }

    @RequestMapping("torpedoUpdate")
    @ResponseBody
    public String torpedoUpdate(@RequestParam("id") Integer id,
                                @RequestParam("nationId") Integer nationId,
                                @RequestParam("torpedoName") String torpedoName,
                                @RequestParam("lv") Integer lv,
                                @RequestParam("price") Integer price,
                                @RequestParam("amount") Integer amount,
                                @RequestParam("time") Integer time,
                                @RequestParam("caliber") Integer caliber){

        Torpedo torpedo = new Torpedo();
        torpedo.setId(id);
        torpedo.setNationId(nationId);
        torpedo.setName(torpedoName);
        torpedo.setLv(lv);
        torpedo.setPrice(price);
        torpedo.setAmount(amount);
        torpedo.setTime(time);
        torpedo.setCaliber(caliber);

        String ser = torpedoService.update(torpedo);
        return ser;
    }

    @RequestMapping("torpedoDelete")
    @ResponseBody
    public String torpedoDelete(@RequestParam String id){
        String ser = torpedoService.delete(id);
        return ser;
    }

    @RequestMapping("/torpedoQueryId")
    @ResponseBody
    public List<Torpedo> torpedoQueryId(@RequestParam String id){
        List<Torpedo> list = torpedoService.queryById(id);
        return list;
    }
}
