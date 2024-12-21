package org.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 分组表
 * @TableName groups
 */
@TableName(value ="`groups`")
public class Groups implements Serializable {
    /**
     * 分组ID，自增主键 
     */
    @TableId(type = IdType.AUTO)
    private Integer groupId;

    /**
     * 分组名称，不为空 
     */
    private String groupName;

    /**
     * 组别
     */
    private String groupBy;

    /**
     * 分组描述信息
     */
    private String description;

    /**
     * 分组描述信息
     */
    private Date createdAt;

    /**
     * 最大人数
     */
    private Integer maxPeople;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 分组ID，自增主键 
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 分组ID，自增主键 
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 分组名称，不为空 
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 分组名称，不为空 
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 组别
     */
    public String getGroupBy() {
        return groupBy;
    }

    /**
     * 组别
     */
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    /**
     * 分组描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 分组描述信息
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 分组描述信息
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 分组描述信息
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 最大人数
     */
    public Integer getMaxPeople() {
        return maxPeople;
    }

    /**
     * 最大人数
     */
    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }
}