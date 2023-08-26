package com.ruoyi.mapper;

import com.ruoyi.pojo.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

/**
* @author 25808
* @description 针对表【schedule(演练进度)】的数据库操作Mapper
* @createDate 2023-08-25 08:56:03
* @Entity .pojo.Schedule
*/
public interface ScheduleMapper extends BaseMapper<Schedule> {
    Schedule selectScheduleAndPageInfoByUserIdAndExpId(@Param("userId") Long userId, @Param("expId") Integer expId);

    int insertSelective(Schedule record);
}




