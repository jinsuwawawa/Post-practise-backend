package org.example.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeekUserVo {
    private List<WeekVo> userGroupDtoList;
    private long total;
}
