package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        // 简单的验证
        if (user.getUsername() == null) {
            return "用户名不能为空";
        }
        userRepository.save(user);
        return "添加用户成功：" + user.getUsername();
    }

    @PutMapping("/user/{id}")
    public String update(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        
        if (!optionalUser.isPresent()) {
            return "用户不存在，ID：" + id;           
        }

        User existingUser = optionalUser.get();

        // 只更新提供的字段，避免覆盖未提供的字段
        if (userDetails.getUsername() != null) {
            existingUser.setUsername(userDetails.getUsername());
        }

        if (userDetails.getPassword() != null) {
            existingUser.setPassword(userDetails.getPassword());
        }

        userRepository.save(existingUser);
        return "更新用户成功，ID：" + id;
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
        return "根据ID删除用户成功，ID：" + id;
    }
}
