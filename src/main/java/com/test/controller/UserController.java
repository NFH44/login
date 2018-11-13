package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    private User user;
    @RequestMapping("/index")
    public String index(HttpSession session){
        session.getAttribute("userLogin");
        return "index";
    }
    @RequestMapping("/regies")
    public String regies(){
        return "regies";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("uregies")
    @ResponseBody
    public String regies(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("password1") String password1,
                         @RequestParam("gender") String gender
    ){
        if (password.equals(password1)){
            user = userDao.findByUsername(username);
            System.out.println("+++++++++++"+user);
            if (user == null){
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(gender);
                userDao.insert1(user);

                System.out.println(username);
                System.out.println(password);
                System.out.println(gender);

                return "success";
            }else {
                return "error";
            }
        }else {
            return "error";
        }
    }

    @RequestMapping("/ulogin")
    @ResponseBody
    public String ulogin(@RequestParam("username") String username,
                         @RequestParam("password") String password){
        user = userDao.findByUsernameAndPassword(username,password);
        if (user != null){
            return "success";
        }
        return "error";
    }
}
