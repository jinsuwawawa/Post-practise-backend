package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.Groups;
import org.example.mapper.GroupsMapper;
import org.example.service.GroupsService;
import org.springframework.stereotype.Service;

/**
* @author 库里
* @description 针对表【groups(分组表)】的数据库操作Service实现
* @createDate 2024-12-19 14:45:30
*/
@Service
public class GroupsServiceImpl extends ServiceImpl<GroupsMapper, Groups> implements GroupsService{

}




