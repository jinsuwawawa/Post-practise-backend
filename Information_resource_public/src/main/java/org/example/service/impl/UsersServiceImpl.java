package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.Users;
import org.example.model.dto.UserGroupDto;
import org.example.model.vo.GroupCountVo;
import org.example.model.vo.UserGroupVo;
import org.example.model.vo.UserVo;
import org.example.mapper.UsersMapper;
import org.example.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 库里
* @description 针对表【users(用户表（用户与权限管理模块）)】的数据库操作Service实现
* @createDate 2024-12-19 14:25:15
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserGroupVo listPagesUser(UserGroupDto userGroupDto) {
        Integer page = userGroupDto.getPage() != null ? userGroupDto.getPage() : 1;
        Integer pageSize = userGroupDto.getPageSize() != null ? userGroupDto.getPageSize() : 10;
        PageHelper.startPage(page, pageSize);
        List<UserVo> sysUserSickList = usersMapper.listPagesUser(userGroupDto);
        PageInfo<UserVo> pageInfo = new PageInfo<>(sysUserSickList);
        long total = pageInfo.getTotal();
        List<UserVo> list = pageInfo.getList();
        Map<String, Integer> groupCounts = getUsersGroupCounts();
        for (UserVo user : list) {
            user.setMember_count(String.valueOf(groupCounts.getOrDefault(user.getGroupName(), 0)));
        }
        return new UserGroupVo(list, total);
    }

    private Map<String, Integer> getUsersGroupCounts() {
        // 查询每个小组的人数
        List<GroupCountVo> groupCountsList = usersMapper.getGroupCounts();
        return groupCountsList.stream()
                .collect(Collectors.toMap(GroupCountVo::getGroupName, GroupCountVo::getMemberCount));

    }


    @Override
    public UserGroupVo listGroup(String groupName) {
        List<UserVo> list=usersMapper.listGroup(groupName);
        return new UserGroupVo(list,0);
    }
}




