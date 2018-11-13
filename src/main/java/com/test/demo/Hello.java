package com.test.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping(path = {"/hi"})
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
