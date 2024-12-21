package org.example.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 分组成员关联表
 * @TableName group_members
 */

@TableName(value ="group_members")
public class GroupMembers implements Serializable {
    /**
     * 分组ID，外键关联至分组表 
     */
    @TableId
    private Integer groupId;

    /**
     * 分组ID，外键关联至分组表 
     */
    @TableId
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 分组ID，外键关联至分组表 
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 分组ID，外键关联至分组表 
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 分组ID，外键关联至分组表 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 分组ID，外键关联至分组表 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}