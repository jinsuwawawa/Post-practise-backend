package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.model.Users;
import org.example.model.dto.UserGroupDto;
import org.example.model.vo.GroupCountVo;
import org.example.model.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 库里
* @description 针对表【users(用户表（用户与权限管理模块）)】的数据库操作Mapper
* @createDate 2024-12-19 14:25:15
* @Entity com.course.entity.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    List<UserVo> listPagesUser(@Param("userDto")UserGroupDto userGroupDto);

    List<UserVo> listGroup(@Param("groupName")String groupName);

    List<GroupCountVo> getGroupCounts();

}




