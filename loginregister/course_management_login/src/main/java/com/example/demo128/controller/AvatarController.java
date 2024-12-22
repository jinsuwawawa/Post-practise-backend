package com.example.demo128.controller;

import com.example.demo128.Response.AvatarResponse;
import com.example.demo128.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class AvatarController {

    @Autowired
    UserMapper userMapper;

    String path = "D:\\avatar";

    @PostMapping(value = "/changeAvatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AvatarResponse changeAvatar(
            @RequestParam("手机号") String phoneNumber,
            @RequestPart("头像") MultipartFile file) {
        // 创建响应对象
        AvatarResponse Response = new AvatarResponse();

        String fileName = file.getOriginalFilename();
        String filePath = path + "/" + fileName;

        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 更新用户头像
        userMapper.updateAvatar(filePath, phoneNumber);
        return Response;
    }

    @PostMapping(path = "/download")
    public @ResponseBody byte[] download(int id) throws IOException {
        String address = userMapper.findAvatarById(id);
        FileInputStream fis = new FileInputStream(address);
        return fis.readAllBytes();
    }
}
