package org.example.model.vo;

import org.example.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




/**
 * 用于分组列表返回
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVo extends Users {

    private Integer groupId;

    /**
     * 分组名称，不为空
     */
    private String groupName;

    /**
     * 组别
     */
    private String groupBy;


    private String member_count;




}
