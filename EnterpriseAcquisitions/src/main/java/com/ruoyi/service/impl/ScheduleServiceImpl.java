package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.ScheduleService;
import com.ruoyi.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 25808
* @description 针对表【schedule(演练进度)】的数据库操作Service实现
* @createDate 2023-08-26 16:27:46
*/
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
    implements ScheduleService{
    @Resource
    private ExperimentService experimentService;

    @Override
    public List<Schedule> getScheduleList(Long user_id) {
        List<Schedule> scheduleList = new ArrayList<>();
        List<Experiment> experimentList = experimentService.list(new QueryWrapper<Experiment>().eq("user_id", user_id));
        for (Experiment experiment : experimentList) {
            Schedule schedule = getOne(new QueryWrapper<Schedule>().eq("user_id", user_id).eq("exp_id", experiment.getExpId()));
            if (schedule != null)
                scheduleList.add(schedule);
        }
        return scheduleList;
    }
}




