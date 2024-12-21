package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeekPageDto {
    private Integer page;
    private Integer pageSize;
    //
    private String  weekNumber;
    //组
    private String weekPlace ;
}
