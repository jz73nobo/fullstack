package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.User;

@RestController
public class UserController {
    
    @Autowired  // 注入Repository
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> "用户： " + user.getUsername())
                .orElse("用户不存在") ;
    }

    @PostMapping("/user")
    public String save(User user) {
        userRepository.save(user);
        return "添加用户成功：" + user.getUsername();
    }

    @PutMapping("/user")
    public String update(User user) {
        userRepository.save(user);
        return "更新用户成功：" + user.getUsername();
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
        return "根据ID删除用户成功，ID：" + id;
    }
}
