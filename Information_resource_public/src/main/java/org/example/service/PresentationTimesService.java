package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.PresentationTimes;
import org.example.model.dto.WeekPageDto;
import org.example.model.vo.WeekUserVo;

/**
* @author 库里
* @description 针对表【presentation_times(分享时间表)】的数据库操作Service
* @createDate 2024-12-19 16:30:06
*/
public interface PresentationTimesService extends IService<PresentationTimes> {

    WeekUserVo listPagesUser(WeekPageDto weekPageDto);
}
