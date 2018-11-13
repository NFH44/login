package com.test.controller;

import com.test.entity.Page;
import com.test.entity.Ship;
import com.test.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ShipController {
    @Autowired
    private ShipService shipService;
    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestParam("nationId") int nationId,
                      @RequestParam("shipName") String shipName,
                      @RequestParam("Lv") int Lv,
                      @RequestParam("shipType") String shipType,
                      @RequestParam("Price") Double Price,
                      @RequestParam("DP") int DP,
                      @RequestParam("Displacement") int Displacement,
                      @RequestParam("Soldier") int Soldier,
                      @RequestParam("Pos") int Pos,
                      @RequestParam("Aid") int Aid,
                      @RequestParam("lowSpeed") int lowSpeed,
                      @RequestParam("extSpeed") int extSpeed,
                      @RequestParam("note") String note){
        Ship ship = new Ship();
        ship.setNationId(nationId);
        ship.setShipName(shipName);
        ship.setLv(Lv);
        ship.setShipType(shipType);
        ship.setPrice(Price);
        ship.setDP(DP);
        ship.setDisplacement(Displacement);
        ship.setSoldier(Soldier);
        ship.setPos(Pos);
        ship.setAid(Aid);
        ship.setLowSpeed(lowSpeed);
        ship.setExtSpeed(extSpeed);
        if (note == ""){
            ship.setNote(null);
        }else {
            ship.setNote(note);
        }
        shipService.insert(ship);
        return "添加成功";
    }

    @RequestMapping("/ship")
    @ResponseBody
    public  List<Ship> ship(@RequestParam("id") int id,
                            @RequestParam("pageSize") int pageSize,
                            @RequestParam("pageNo") int pageNo){
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        int i = shipService.pageCount();
        List<Ship> list = shipService.findAll(id,page);
        return list;
    }

    @RequestMapping("shipList")
    public String shipList(){
        return "ship";
    }

    @RequestMapping("/shipUpdate")
    @ResponseBody
    public String shipUpdate(
            @RequestParam("id") int id,
            @RequestParam("nationId") int nationId,
            @RequestParam("shipName") String shipName,
            @RequestParam("Lv") int Lv,
            @RequestParam("shipType") String shipType,
            @RequestParam("Price") Double Price,
            @RequestParam("DP") int DP,
            @RequestParam("Displacement") int Displacement,
            @RequestParam("Soldier") int Soldier,
            @RequestParam("Pos") int Pos,
            @RequestParam("Aid") int Aid,
            @RequestParam("lowSpeed") int lowSpeed,
            @RequestParam("extSpeed") int extSpeed,
            @RequestParam("note") String note){
        Ship ship = new Ship();
        ship.setId(id);
        ship.setNationId(nationId);
        ship.setShipName(shipName);
        ship.setLv(Lv);
        ship.setShipType(shipType);
        ship.setPrice(Price);
        ship.setDP(DP);
        ship.setDisplacement(Displacement);
        ship.setSoldier(Soldier);
        ship.setPos(Pos);
        ship.setAid(Aid);
        ship.setLowSpeed(lowSpeed);
        ship.setExtSpeed(extSpeed);
        if (note == ""){
            ship.setNote(null);
        }else {
            ship.setNote(note);
        }
        shipService.update(ship);
        return "更新成功";
    }

    @RequestMapping("/shipDelete")
    @ResponseBody
    public String shipDelete(@RequestParam("id") int id){
        System.out.println("===================="+id);
        shipService.deltet(id);
        return "删除成功";
    }

    @RequestMapping("/selectNaionIdAndShipName")
    @ResponseBody
    public List<Ship> selectNaionIdAndShipName(
            @RequestParam("id") int id,
            @RequestParam("shipName") String shipName){
        List<Ship> list = shipService.findByNaionIdAndShipName(id,shipName);
        return list;
    }

    @RequestMapping("/selectNaionIdAndLv")
    @ResponseBody
    public List<Ship> selectNaionIdAndLv(
            @RequestParam("id") int id,
            @RequestParam("Lv") int Lv){
        List<Ship> list = shipService.findByNaionIdAndLv(id,Lv);
        return list;
    }

    @RequestMapping("/selectNaionIdAndShipType")
    @ResponseBody
    public List<Ship> selectNaionIdAndShipType(
            @RequestParam("id") int id,
            @RequestParam("shipType") String shipType){
        List<Ship> list = shipService.findByNaionIdAndShipType(id,shipType);
        return list;
    }

    @RequestMapping("/selectNaionIdAndNote")
    @ResponseBody
    public List<Ship> selectNaionIdAndNote(
            @RequestParam("id") int id,
            @RequestParam("note") String note){
        List<Ship> list = shipService.findByNaionIdAndNote(id,note);
        return list;
    }
}
