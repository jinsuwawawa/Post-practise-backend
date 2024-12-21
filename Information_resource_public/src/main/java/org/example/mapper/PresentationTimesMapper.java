package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.model.PresentationTimes;
import org.example.model.dto.WeekPageDto;
import org.example.model.vo.WeekVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 库里
* @description 针对表【presentation_times(分享时间表)】的数据库操作Mapper
* @createDate 2024-12-19 16:30:06
* @Entity com.course.entity.PresentationTimes
*/
public interface PresentationTimesMapper extends BaseMapper<PresentationTimes> {

    List<WeekVo> listPagesUser(@Param("userDto")WeekPageDto weekPageDto);

}




