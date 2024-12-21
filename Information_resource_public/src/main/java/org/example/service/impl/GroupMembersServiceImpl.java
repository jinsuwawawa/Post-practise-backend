package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.GroupMembers;
import org.example.mapper.GroupMembersMapper;
import org.example.service.GroupMembersService;
import org.example.service.GroupMembersService;
import org.springframework.stereotype.Service;

/**
* @author 库里
* @description 针对表【group_members(分组成员关联表)】的数据库操作Service实现
* @createDate 2024-12-19 14:45:33
*/
@Service
public class GroupMembersServiceImpl extends ServiceImpl<GroupMembersMapper, GroupMembers>
    implements GroupMembersService {

}




