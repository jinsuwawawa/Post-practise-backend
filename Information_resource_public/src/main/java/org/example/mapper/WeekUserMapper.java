package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.model.WeekUser;

/**
* @author 库里
* @description 针对表【week_user】的数据库操作Mapper
* @createDate 2024-12-19 18:50:48
* @Entity com.course.entity.WeekUser
*/
public interface WeekUserMapper extends BaseMapper<WeekUser> {
    WeekUser selectById(Integer time_id);
}




