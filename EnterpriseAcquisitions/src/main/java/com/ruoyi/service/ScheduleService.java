package com.ruoyi.service;

import com.ruoyi.pojo.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 25808
* @description 针对表【schedule(演练进度)】的数据库操作Service
* @createDate 2023-08-25 08:56:03
*/
public interface ScheduleService extends IService<Schedule> {
    public Schedule getUserSchedule(Long userId, Integer expId);

    public Boolean saveSchedule(Schedule schedule);
}
