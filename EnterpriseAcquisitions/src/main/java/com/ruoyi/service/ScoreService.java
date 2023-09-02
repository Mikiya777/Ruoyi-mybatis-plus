package com.ruoyi.service;

import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.Score;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
* @author mac
* @description 针对表【score】的数据库操作Service
* @createDate 2023-08-30 19:45:06
*/
public interface ScoreService extends IService<Score> {
    BigDecimal getObjectiveScore(Long userId, Integer expId, List<Answers> list);
}
