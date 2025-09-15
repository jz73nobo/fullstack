package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//  http://localhost:8080/hello    部署到云端以后才能用公网IP
    @GetMapping("/hello")
    public String hello(){
        return "阿伟罗跪下！！！ 梅西牛逼";
    }
}
