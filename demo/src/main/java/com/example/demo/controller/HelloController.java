package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
public class HelloController {

//  http://localhost:8080/hello    部署到云端以后才能用公网IP
//  http://localhost:8080/hello?nickname=messi&phone=123
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String nickname, String phone){
        System.out.println(phone);
        return "阿伟罗给" + nickname + "跪下！！！";
    }

    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    public String getTest3(@RequestParam("nickname") String name){
        System.out.println("nickname: "+name);
        return "GET请求";
    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public String postTest1(){
        return "POST请求";
    }

// 可以写在Body或Query里  ->   postTest2,3
    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(String username, String password){
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "POST请求";
    }

// JSON类型
    @RequestMapping(value = "/postTest4", method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){
        System.out.println(user);
        return "POST请求";
    }

// 通配符请求 -> /test/后面加什么无所谓，因为是两个*
    @GetMapping("/test/**")
    public String test(){
        return "通配符请求";
    }
}
