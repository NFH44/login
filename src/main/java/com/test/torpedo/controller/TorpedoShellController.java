package com.test.torpedo.controller;

import com.test.torpedo.entity.Torpedo;
import com.test.torpedo.entity.TorpedoShell;
import com.test.torpedo.service.TorpedoService;
import com.test.torpedo.service.TorpedoShellService;
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
public class TorpedoShellController {
    @Resource
    private TorpedoShellService torpedoShellService;

    @RequestMapping("torpedoShell")
    public String torpedoShell(){
        return "torpedoShell";
    }

    @RequestMapping("tShellAdd")
    @ResponseBody
    public String tShellAdd(@RequestParam("torpedoId") Integer torpedoId,
                             @RequestParam("shellName") String shellName,
                             @RequestParam("slow") String slow,
                             @RequestParam("fast") String fast,
                             @RequestParam("near") String near,
                             @RequestParam("far") String far,
                             @RequestParam("harm") String harm){
        TorpedoShell torpedoShell = new TorpedoShell();
        torpedoShell.setTorpedoId(torpedoId);
        torpedoShell.setShellName(shellName);
        torpedoShell.setSlow(slow);
        torpedoShell.setFast(fast);
        torpedoShell.setNear(near);
        torpedoShell.setFar(far);
        torpedoShell.setHarm(harm);
        String a =  torpedoShellService.tShellAdd(torpedoShell);
        return a;
    }

    /*@RequestMapping("torpedoList")
    @ResponseBody
    public List<Torpedo> torpedoList(@RequestParam Map<String, Object> map){
        //String id = map.get("id").toString();
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
        System.out.println(list);
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
    }*/
}
