package com.test.armour.controller;

import com.test.armour.entity.Armour;
import com.test.armour.service.ArmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述
 *
 * @ClassName: ArmController.java
 * @Description: java类功能描述
 * @Author: peng
 * @Date: 2018-11-21
 */
@Controller
public class ArmController {
    @Autowired
    private ArmService armService;

    @RequestMapping("arm")
    public String arm(){
        return "arm";
    }

    @RequestMapping("armAdd")
    @ResponseBody
    public String armAdd(@RequestParam Map<String,Object> map){
        String nationId = map.get("nationId").toString();
        String armName = map.get("armName").toString();
        String kg = map.get("kg").toString();
        String price = map.get("price").toString();
        String APdefense = map.get("APdefense").toString();
        String HEdefense = map.get("HEdefense").toString();
        String waterCabin = map.get("waterCabin").toString();
        String torpedo = map.get("torpedo").toString();

        Armour armour = new Armour();
        armour.setNationId(Integer.valueOf(nationId));
        armour.setArmName(armName);
        armour.setKg(Integer.valueOf(kg));
        armour.setPrice(Double.valueOf(price));
        armour.setAPdefense(Double.valueOf(APdefense));
        armour.setHEdefense(Double.valueOf(HEdefense));
        armour.setWaterCabin(Double.valueOf(waterCabin));
        armour.setTorpedo(Integer.valueOf(torpedo));

        String ser = armService.armAdd(armour);
        return ser;
    }

    @RequestMapping("armList")
    @ResponseBody
    public List<Armour> armList(@RequestParam Map<String,Object> map){

        map.get("id").toString();
        String armName = map.get("armName").toString();
        String sortName = map.get("sortName").toString();
        String sortOrder = map.get("sortOrder").toString();
        String currPageIndex = map.get("currPageIndex").toString();
        String currPageSize = map.get("currPageSize").toString();

        int size = Integer.parseInt(currPageSize);
        int totle = armService.queryListCount(map);
        int curnum = (totle+size-1)/size;
        List ls = new ArrayList();
        List<Armour> list = armService.queryList(map);
        ls.add(list);
        ls.add(totle);
        ls.add(curnum);
        return ls;
    }

    @RequestMapping("armUpdate")
    @ResponseBody
    public String armUpdate(@RequestParam Map<String,Object> map){
        String id = map.get("id").toString();
        String nationId = map.get("nationId").toString();
        String armName = map.get("armName").toString();
        String kg = map.get("kg").toString();
        String price = map.get("price").toString();
        String APdefense = map.get("APdefense").toString();
        String HEdefense = map.get("HEdefense").toString();
        String waterCabin = map.get("waterCabin").toString();
        String torpedo = map.get("torpedo").toString();

        Armour armour = new Armour();
        armour.setId(Integer.valueOf(id));
        armour.setNationId(Integer.valueOf(nationId));
        armour.setArmName(armName);
        armour.setKg(Integer.valueOf(kg));
        armour.setPrice(Double.valueOf(price));
        armour.setAPdefense(Double.valueOf(APdefense));
        armour.setHEdefense(Double.valueOf(HEdefense));
        armour.setWaterCabin(Double.valueOf(waterCabin));
        armour.setTorpedo(Integer.valueOf(torpedo));

        String ser = armService.armUpdate(armour);
        return ser;
    }

    @RequestMapping("/armById")
    @ResponseBody
    public List<Armour> armById(@RequestParam String id){
        List<Armour> list = armService.queryById(id);
        return list;
    }

    @RequestMapping("/armDelete")
    @ResponseBody
    public String armDelete(@RequestParam String id){
        String ser = armService.armDelete(id);
        return ser;
    }
}
