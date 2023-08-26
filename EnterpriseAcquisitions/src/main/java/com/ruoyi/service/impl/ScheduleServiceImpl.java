package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.service.ScheduleService;
import com.ruoyi.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 25808
 * @description 针对表【schedule(演练进度)】的数据库操作Service实现
 * @createDate 2023-08-25 08:56:03
 */
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
        implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public Schedule getUserSchedule(Long userId, Integer expId) {
        return scheduleMapper.selectScheduleAndPageInfoByUserIdAndExpId(userId, expId);
    }

    @Override
    public Boolean saveSchedule(Schedule schedule) {
        if (scheduleMapper.insertSelective(schedule) > 0)
            return true;
        return false;
    }
}




