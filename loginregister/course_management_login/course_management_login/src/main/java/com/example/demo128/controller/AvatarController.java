package com.example.demo128.controller;

import com.example.demo128.domain.User;
import com.example.demo128.mapper.UserMapper;
import com.example.demo128.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
public class AvatarController {

    @Autowired
    UserMapper userMapper;

    // 设置文件存储路径
    String path = "D:\\avatar";

    @PostMapping(value = "/changeAvatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AvatarResponse changeAvatar(
            @RequestParam("手机号") String phoneNumber,
            @RequestPart("头像") MultipartFile file) {
        // 创建响应对象
        AvatarResponse response = new AvatarResponse();

        // 检查目标路径是否存在，不存在则创建
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 获取文件名和路径
        String fileName = file.getOriginalFilename();
        String filePath = path + "/" + fileName;

        // 保存文件
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            response.setSuccess(false);
            response.setMessage("文件保存失败：" + e.getMessage());
            return response;
        }

        // 查询用户
        User user = userMapper.selectuser(phoneNumber);
        if (user == null) {
            response.setSuccess(false);
            response.setMessage("用户不存在");
            return response;
        }

        // 更新用户头像路径
        user.setAvatar(filePath);
        userMapper.updateAvatar(phoneNumber, filePath);

        response.setSuccess(true);
        response.setMessage("头像更新成功");
        response.setAvatarUrl(filePath);
        return response;
    }

    @PostMapping(path = "/download")
    public @ResponseBody byte[] download(@RequestParam("id") int id) throws IOException {
        // 查询用户是否存在
        Optional<User> optionalUser = userMapper.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("用户不存在");
        }

        // 获取用户头像路径
        String address = optionalUser.get().getAvatar();
        if (address == null || address.isEmpty()) {
            throw new RuntimeException("用户未上传头像");
        }

        // 返回文件字节流
        FileInputStream fis = new FileInputStream(address);
        return fis.readAllBytes();
    }
}
