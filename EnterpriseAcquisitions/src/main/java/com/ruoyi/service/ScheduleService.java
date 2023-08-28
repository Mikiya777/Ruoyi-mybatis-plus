package com.ruoyi.service;

import com.ruoyi.pojo.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 25808
* @description 针对表【schedule(演练进度)】的数据库操作Service
* @createDate 2023-08-26 16:27:46
*/
public interface ScheduleService extends IService<Schedule> {

    List<Schedule> getScheduleList(Long user_id);
}
