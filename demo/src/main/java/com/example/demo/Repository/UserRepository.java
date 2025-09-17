package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // 自动生成查询方法
    List<User> findByUsername(String username);
}
