package org.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表（用户与权限管理模块）
 * @TableName users
 */
@TableName(value ="users")
public class Users implements Serializable {
    /**
     * 用户ID，自增主键 
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名，唯一且不为空
     */
    private String username;

    /**
     * 密码哈希值，不为空
     */
    private String password;

    /**
     * 用户邮箱，唯一且不为空
     */
    private String email;

    /**
     * TOTP密钥，用于双因素身份验证
     */
    private String totpSecret;

    /**
     * 用户账号是否激活，默认为真
     */
    private Integer isActive;

    /**
     * 角色字面量，0组员1组长2管理员
     */
    private Integer role;

    /**
     * 记录创建时间
     */
    private Date createdAt;

    /**
     * 记录更新时间
     */
    private Date updatedAt;

    /**
     * 是否是组长（1是组长 默认为0）
     */
    private Integer isLeader;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，自增主键 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID，自增主键 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户名，唯一且不为空
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名，唯一且不为空
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码哈希值，不为空
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码哈希值，不为空
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户邮箱，唯一且不为空
     */
    public String getEmail() {
        return email;
    }

    /**
     * 用户邮箱，唯一且不为空
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * TOTP密钥，用于双因素身份验证
     */
    public String getTotpSecret() {
        return totpSecret;
    }

    /**
     * TOTP密钥，用于双因素身份验证
     */
    public void setTotpSecret(String totpSecret) {
        this.totpSecret = totpSecret;
    }

    /**
     * 用户账号是否激活，默认为真
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * 用户账号是否激活，默认为真
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * 角色字面量，0组员1组长2管理员
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 角色字面量，0组员1组长2管理员
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 记录创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 记录创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 记录更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 记录更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 是否是组长（1是组长 默认为0）
     */
    public Integer getIsLeader() {
        return isLeader;
    }

    /**
     * 是否是组长（1是组长 默认为0）
     */
    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }
}