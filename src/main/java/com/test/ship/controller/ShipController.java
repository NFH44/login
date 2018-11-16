package com.test.ship.controller;

import com.test.ship.entity.Ship;
import com.test.ship.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        shipService.delete(id);
        return "删除成功";
    }

    @RequestMapping("/ship")
    @ResponseBody
    public  List<Ship> ship(@RequestParam (required = true) Map<String, Object> map){

        String id = map.get("id").toString();
        String shipName = map.get("shipName").toString();
        String Lv = map.get("Lv").toString();
        String shipType = map.get("shipType").toString();
        String note = map.get("note").toString();
        String sortName = map.get("sortName").toString();
        String sortOrder = map.get("sortOrder").toString();
        String currPageIndex = map.get("currPageIndex").toString();
        String currPageSize = map.get("currPageSize").toString();

        int size = Integer.parseInt(currPageSize);
        int totle = shipService.queryAllCount(map);
        int curnum = (totle+size-1)/size;
        System.out.println(curnum+"++++++++++++++");
        List ls = new ArrayList();
        List<Ship> list = shipService.findAll(map);
        ls.add(list);
        ls.add(totle);
        ls.add(curnum);
        System.out.println(ls);
        return ls;
    }
}
