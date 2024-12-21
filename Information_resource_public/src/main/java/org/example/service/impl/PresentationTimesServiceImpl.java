package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.PresentationTimes;
import org.example.model.dto.WeekPageDto;
import org.example.model.vo.WeekUserVo;
import org.example.model.vo.WeekVo;
import org.example.mapper.PresentationTimesMapper;
import org.example.service.PresentationTimesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.service.PresentationTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 库里
* @description 针对表【presentation_times(分享时间表)】的数据库操作Service实现
* @createDate 2024-12-19 16:30:06
*/
@Service
public class PresentationTimesServiceImpl extends ServiceImpl<PresentationTimesMapper, PresentationTimes>
    implements PresentationTimesService {

    @Autowired
    private  PresentationTimesMapper presentationTimesMapper;

    @Override
    public WeekUserVo listPagesUser(WeekPageDto weekPageDto) {
        //开启分页
        PageHelper.startPage(weekPageDto.getPage(),weekPageDto.getPageSize());
        List<WeekVo> sysUserSickList=presentationTimesMapper.listPagesUser(weekPageDto);
        PageInfo<WeekVo> pageInfo = new PageInfo<>(sysUserSickList);
        long total = pageInfo.getTotal();
        List<WeekVo> list = pageInfo.getList();
        return new WeekUserVo(list,total);
    }
}




