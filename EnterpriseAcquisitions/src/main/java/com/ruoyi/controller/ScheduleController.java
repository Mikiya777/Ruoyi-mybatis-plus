package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.pojo.ScheduleListWithPages;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.ScheduleService;

import com.ruoyi.utils.MyPageUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 针对表【schedule(演练进度)】的数据库操作Controller层
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Resource
    private ScheduleService scheduleService;

    @Resource
    private ExperimentService experimentService;


    /**
     * @description: 根据用户id获取该用户的所有演练进度
     *
     * @return 演练进度列表
     */

    @GetMapping("/get")
    public RequestResult<ScheduleListWithPages> getScheduleList() {

        LoginUser loginUser = SecurityUtils.getLoginUser();

        ScheduleListWithPages scheduleListWithPages = new ScheduleListWithPages();
        int total = scheduleService.count(new QueryWrapper<Schedule>().eq("user_id", loginUser.getUserId()));
        scheduleListWithPages.setPages( (int)Math.ceil(total / 8.0) );
        MyPageUtils.startPage();
        List<Schedule> scheduleList = scheduleService.list(new QueryWrapper<Schedule>()
                .eq("user_id", loginUser.getUserId()).orderByDesc("exp_id"));

        scheduleListWithPages.setScheduleList(scheduleList);

        System.out.println(scheduleListWithPages);
        return new RequestResult<>(scheduleListWithPages);
    }
}
