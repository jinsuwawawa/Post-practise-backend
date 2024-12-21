package org.example.controller;

import org.example.model.GroupMembers;
import org.example.model.Groups;
import org.example.model.ResponseResult;
import org.example.model.dto.UserGroupDto;
import org.example.model.vo.UserGroupVo;
import org.example.service.GroupMembersService;
import org.example.service.GroupsService;
import org.example.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.example.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@Slf4j
public class GroupController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private GroupsService groupsService;
    @Autowired
    private GroupMembersService groupMembersService;

    /**
     *  分组列表查询
     * @param userGroupDto
     * @return
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseResult listPage(@RequestParam(required = false) UserGroupDto userGroupDto){
        log.info("传递数据---{}", userGroupDto);
        if (userGroupDto == null){
            userGroupDto = new UserGroupDto(1, 10, "", "");
        }
        UserGroupVo userGroupVo = usersService.listPagesUser(userGroupDto);
        return new ResponseResult(200, "查询成功", userGroupVo);
    }




    /**
     * 根据小组名对小组进行分组查询
     * @param groupName
     * @return
     */
    @GetMapping("/listGroup")
    private ResponseResult listGroup(String groupName){
        log.info("传递数据---{}",groupName);
        UserGroupVo userGroupVo=usersService.listGroup(groupName);
        return new ResponseResult(200,"查询成功",userGroupVo);

    }

    /**
     * 新建分组
     * @param groups
     * @return
     */
    @GetMapping("/saveGroup")
    private ResponseResult saveGroup(Groups groups) {
        log.info("传递数据---{}", groups);

        if (groups == null || groups.getGroupName() == null || groups.getGroupBy() == null) {
            return new ResponseResult(400, "分组名称或组别不能为空");
        }

        // 执行保存操作
        groupsService.save(groups);

        return new ResponseResult(200, "新建成功");
    }


    /**
     * 新建分组
     * @param groupsId
     * @return
     */
    @DeleteMapping("/deleteGroup")
    private ResponseResult deleteGroup(Integer groupsId){
        log.info("传递数据---{}",groupsId);
        //这里有外键约束，先删除中间表
        groupMembersService.removeById(groupsId);
        //删除小组信息
        groupsService.removeById(groupsId);
         //还有一个问题是修改一下小组组长
        return new ResponseResult(200,"删除成功");

    }

}
