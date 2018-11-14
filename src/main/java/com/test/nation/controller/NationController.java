package com.test.nation.controller;

import com.test.nation.entity.Nation;
import com.test.nation.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;


@Controller
public class NationController {
    @Autowired
    private NationService nationService;

    @RequestMapping("/nation")
    public String nation(@RequestParam(value = "nation",required = false) String nation,
                         @RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "port",required = false) String port,
                         @RequestParam(value = "ename",required = false) String ename
                         ){
        if (nation == null){
            nationService.findByNation(nation);
            System.out.println("存在");
        }else {
            Nation n = new Nation();
            n.setNation(nation);
            n.setName(name);
            n.setPort(port);
            n.setEname(ename);
            System.out.println(n);
            nationService.insert(n);
            System.out.println("成功");

        }
        return "nation";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Nation> getAll(){
        List<Nation> list = nationService.findAll();
        System.out.println(list);
        return list;
    }
    @RequestMapping("/listHtml")
    public String listHtml(){
        return "list";
    }

    @RequestMapping("del")
    public String del(@RequestParam("checkedIds") int checkedIds){
        System.out.println(checkedIds);
        boolean i = nationService.delete(checkedIds);
        if (i==true){
            System.out.println("删除成功");
        }
        return "list";
    }

    @RequestMapping("update")
    public String up(@RequestParam(value = "nation",required = false) String nation,
                     @RequestParam(value = "name",required = false) String name,
                     @RequestParam(value = "port",required = false) String port,
                     @RequestParam(value = "ename",required = false) String ename,
                     @RequestParam("checkedIds") int checkedIds ,Model model){
        Nation na = nationService.findById(checkedIds);
        System.out.println("++++++++++++++"+checkedIds+"---------"+na);
        model.addAttribute("nation",na);

        na.setId(checkedIds);
        na.setNation(nation);
        na.setName(name);
        na.setPort(port);
        na.setEname(ename);
        nationService.update(na);
        System.out.println("1111111111"+na);
        return "update";
    }

}
