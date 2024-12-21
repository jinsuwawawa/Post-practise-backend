package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.model.PresentationTimes;
import org.example.model.ResponseResult;
import org.example.model.Users;
import org.example.model.WeekUser;
import org.example.model.dto.WeekPageDto;
import org.example.mapper.UsersMapper;
import org.example.mapper.WeekUserMapper;
import org.example.service.PresentationTimesService;
import org.example.service.WeekUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/week")
@Slf4j
public class WeekController {

    @Autowired
    private PresentationTimesService presentationTimesService;

    @Autowired
    private WeekUserService weekUserService;

    @Autowired
    private WeekUserMapper weekUserMapper;
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 分享报告列表
     */
    @PostMapping("/list")
    public ResponseResult listPage(@RequestBody WeekPageDto weekPageDto) {
        if (weekPageDto.getPage() == null) {
            weekPageDto.setPage(1);
        }
        if (weekPageDto.getPageSize() == null) {
            weekPageDto.setPageSize(10);
        }

        log.info("传递数据---{}", weekPageDto);
        Page<PresentationTimes> page = new Page<>(weekPageDto.getPage(), weekPageDto.getPageSize());
        QueryWrapper<PresentationTimes> queryWrapper = new QueryWrapper<>();

        if (weekPageDto.getWeekNumber() != null) {
            queryWrapper.eq("week_number", weekPageDto.getWeekNumber());
        }

        if (weekPageDto.getWeekPlace() != null) {
            queryWrapper.eq("week_place", weekPageDto.getWeekPlace());
        }

        queryWrapper.orderByAsc("week_number", "week_place");

        Page<PresentationTimes> resultPage = presentationTimesService.page(page, queryWrapper);

        return new ResponseResult(200, "查询成功", resultPage);
    }

    /**
     * 删除分组
     */
    @DeleteMapping("/deleteWeek")
    private ResponseResult deleteGroup(@RequestParam("id") Integer id) {
        log.info("传递数据---{}", id);

        presentationTimesService.removeById(id);
        weekUserService.removeById(id);

        return new ResponseResult(200, "删除成功");
    }

    /**
     * 根据周数id查看用户信息
     * @param time_id
     * @return
     */
    @GetMapping("/listUser")
    private ResponseResult listUser(@RequestParam("time_id") Integer time_id) {
        log.info("listUser 接受数据 --> {}", time_id);

        WeekUser weekUser = weekUserMapper.selectById(time_id);
        log.info("weekUser --> {}", weekUser);

        if (weekUser == null) {
            return new ResponseResult(500, "没有找到对应的周次数据", null);
        }

        Integer userId = weekUser.getUserId();
        log.info("userId --> {}", userId);

        Users users = usersMapper.selectById(userId);
        log.info("users --> {}", users);

        return new ResponseResult(200, "查询成功", users);
    }

    @PostMapping("/updateReport")
    public ResponseResult saveReport(@RequestBody PresentationTimes presentationTimes) {
        try {
            // 检查是否有 timeId（即是否是更新）
            if (presentationTimes.getTimeId() != null) {
                // 如果有 timeId，更新该报告
                boolean updated = presentationTimesService.updateById(presentationTimes);
                if (updated) {
                    return new ResponseResult(200, "更新成功", null);
                } else {
                    return new ResponseResult(500, "更新失败", null);
                }
            } else {
                // 如果没有 timeId，新增报告
                boolean saved = presentationTimesService.save(presentationTimes);
                if (saved) {
                    return new ResponseResult(200, "保存成功", null);
                } else {
                    return new ResponseResult(500, "保存失败", null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(500, "服务器错误", null);
        }
    }
}
