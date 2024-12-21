package org.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 分享时间表
 * @TableName presentation_times
 */
@TableName(value ="presentation_times")
public class PresentationTimes implements Serializable {
    /**
     * 时间ID，自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer timeId;

    /**
     * 周数，不为空
     */
    private Integer weekNumber;

    /**
     * 每周分享最大人数限制，默认为8
     */
    private Integer maxCapacity;

    /**
     * 可用分享时间槽数量，默认为8
     */
    private Integer availableSlots;

    /**
     * 位次
     */
    private Integer weekPlace;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



    /**
     * 时间ID，自增主键
     */
    public Integer getTimeId() {
        return timeId;
    }

    /**
     * 时间ID，自增主键
     */
    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    /**
     * 周数，不为空
     */
    public Integer getWeekNumber() {
        return weekNumber;
    }

    /**
     * 周数，不为空
     */
    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * 每周分享最大人数限制，默认为8
     */
    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * 每周分享最大人数限制，默认为8
     */
    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * 可用分享时间槽数量，默认为8
     */
    public Integer getAvailableSlots() {
        return availableSlots;
    }

    /**
     * 可用分享时间槽数量，默认为8
     */
    public void setAvailableSlots(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }

    /**
     * 位次
     */
    public Integer getWeekPlace() {
        return weekPlace;
    }

    /**
     * 位次
     */
    public void setWeekPlace(Integer weekPlace) {
        this.weekPlace = weekPlace;
    }
}