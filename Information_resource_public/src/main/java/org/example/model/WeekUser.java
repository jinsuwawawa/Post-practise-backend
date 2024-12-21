package org.example.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName week_user
 */
@TableName(value ="week_user")
public class WeekUser implements Serializable {
    /**
     * 
     */
    private Integer timeId;

    /**
     * 
     */
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getTimeId() {
        return timeId;
    }

    /**
     * 
     */
    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    /**
     * 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}