package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.WeekUser;
import org.example.mapper.WeekUserMapper;
import org.example.service.WeekUserService;
import org.springframework.stereotype.Service;

/**
* @author 库里
* @description 针对表【week_user】的数据库操作Service实现
* @createDate 2024-12-19 18:50:48
*/
@Service
public class WeekUserServiceImpl extends ServiceImpl<WeekUserMapper, WeekUser>
    implements WeekUserService{

}




