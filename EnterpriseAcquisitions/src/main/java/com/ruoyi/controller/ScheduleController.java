package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.ScheduleService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
     * @param user_id
     * @return 演练进度列表
     */

    @GetMapping("/get/{user_id}")
    public RequestResult<List<Schedule>> getScheduleList(@PathVariable Long user_id) {
        List<Schedule> scheduleList = scheduleService.getScheduleList(user_id);
        return new RequestResult<>(scheduleList);
    }



}
