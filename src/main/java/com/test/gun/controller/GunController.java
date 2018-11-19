package com.test.gun.controller;

import com.test.gun.entity.Gun;
import com.test.gun.service.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GunController {
    @Autowired
    private GunService gunService;
    @RequestMapping("gun")
    public String gun(){
        return "gun";
    }
    @RequestMapping("gunInsert")
    @ResponseBody
    public String gunInsert(Gun gun){
        gunService.insert(gun);
        return "添加成功";
    }

    @RequestMapping("gunDelete")
    @ResponseBody
    public String gunDelete(String id){
        gunService.delete(id);
        return "删除成功";
    }

    @RequestMapping("gunUpdate")
    @ResponseBody
    public String gunUpdate(@RequestParam Map<String, Object> map){

        map.get("id").toString();
        map.get("nationId").toString();
        map.get("gunName").toString();
        map.get("Lv").toString();
        map.get("Price").toString();
        map.get("caliber").toString();
        map.get("gunType").toString();
        map.get("note").toString();
        gunService.update(map);
        return "修改成功";
    }

    @RequestMapping("queryList")
    @ResponseBody
    public List<Gun> queryList(@RequestParam Map<String, Object> map){

        String id = map.get("id").toString();
        String gunName = map.get("gunName").toString();
        String Lv = map.get("Lv").toString();
        String caliber = map.get("caliber").toString();
        String gunType = map.get("gunType").toString();
        String note = map.get("note").toString();
        String sortName = map.get("sortName").toString();
        String sortOrder = map.get("sortOrder").toString();
        String currPageIndex = map.get("currPageIndex").toString();
        String currPageSize = map.get("currPageSize").toString();

        List<Gun> list = gunService.queryList(map);
        System.out.println(list);
        return list;
    }

    @RequestMapping("queryListCount")
    @ResponseBody
    public Integer queryListCount(@RequestParam Map<String, Object> map){

        String id = map.get("id").toString();
        String gunName = map.get("gunName").toString();
        String Lv = map.get("Lv").toString();
        String caliber = map.get("caliber").toString();
        String gunType = map.get("gunType").toString();
        String note = map.get("note").toString();

        Integer list = gunService.queryListCount(map);
        System.out.println(list);
        return list;
    }
}
