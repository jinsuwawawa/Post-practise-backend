package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.Users;
import org.example.model.dto.UserGroupDto;
import org.example.model.vo.UserGroupVo;
import org.example.model.dto.UserGroupDto;

/**
* @author 库里
* @description 针对表【users(用户表（用户与权限管理模块）)】的数据库操作Service
* @createDate 2024-12-19 14:25:15
*/
public interface UsersService extends IService<Users> {



    UserGroupVo listPagesUser(UserGroupDto userGroupDto);

    UserGroupVo listGroup(String groupName);

}
