package org.example.controller;


import org.example.Response.ChangePasswordResponse;
import org.example.model.User;
import  org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChangePasswordController {
    @Autowired
    public UserMapper userMapper;

    @PostMapping("api/update")
    public ChangePasswordResponse ChangePassword(
            @RequestParam String phoneNumber,
            @RequestParam String name,
            @RequestParam String newPassword) {

        User user=new User();
        user.setphoneNumber(phoneNumber);
        user.setName(name);
        user.setPassword(newPassword);

        userMapper.insert(user);


        // 创建响应对象
        ChangePasswordResponse response = new ChangePasswordResponse();
        // 校验用户名是否为空
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            response.setSuccess(false);
            response.setMessage("手机号不允许为空");
            return response;
        }


        // 校验新密码是否为空
        if (newPassword == null || newPassword.isEmpty()) {
            response.setSuccess(false);
            response.setMessage("新密码不能为空");
            return response;
        }

        // 校验新密码长度
        if (newPassword.length() < 6) {
            response.setSuccess(false);
            response.setMessage("新密码长度不能小于6个字符");
            return response;
        }

        // 查询用户信息

        userMapper.selectuser(phoneNumber);
        if (user == null) {
            response.setSuccess(false);
            response.setMessage("用户不存在");
            return response;
        }


        return response;
    }
}