package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.PageInfoService;
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

    @Resource
    private PageInfoService pageInfoService;

    /**
     * @description: 根据用户id获取该用户的所有演练进度
     * @param user_id
     * @return 演练进度列表
     */
    @GetMapping("/get/{user_id}")
    public RequestResult<List<Schedule>> getScheduleList(@PathVariable Long user_id) {
        List<Schedule> scheduleList = new ArrayList<>();
        List<Experiment> experimentList = experimentService.list(new QueryWrapper<Experiment>().eq("user_id", user_id));
        for (Experiment experiment : experimentList) {
            Schedule schedule = scheduleService.getUserSchedule(user_id, experiment.getExpId());
            if (schedule != null)
                scheduleList.add(schedule);
        }
        return new RequestResult<>(scheduleList);
    }

    @PostMapping("/submit")
    public RequestResult<Boolean> submitSchedule(@RequestBody Schedule schedule) {
        if (pageInfoService.savePageInfo(schedule.getPageInfo())){
            schedule.setPageInfoId(schedule.getPageInfo().getPageInfoId());
            return new RequestResult<>(scheduleService.saveSchedule(schedule));
        }
        return new RequestResult<>(false);
    }


}
