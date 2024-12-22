package com.example.demo128.controller;

import com.example.demo128.mapper.UserMapper;
import com.example.demo128.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 用户注册
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // 检查用户名是否已存在
        User existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser != null) {
            return "用户名已存在";
        }

        // 插入新用户
        userMapper.insertUser(user);
        return "注册成功";
    }

    // 用户登录
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 根据用户名查询用户
        User user = userMapper.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return "用户名或密码错误";
        }
        return "登录成功";
    }

    // 更新用户信息
    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
        return "用户信息更新成功";
    }

    // 删除用户
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
        userMapper.deleteUser(userId);
        return "用户删除成功";
    }
}
