package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGroupDto {
    private Integer page;
    private Integer pageSize;
    //组名
    private String  groupName;
    //组长姓名
    private String username;


}
