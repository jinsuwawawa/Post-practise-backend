package org.example.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.example.model.PresentationTimes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeekVo extends PresentationTimes {
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

}
