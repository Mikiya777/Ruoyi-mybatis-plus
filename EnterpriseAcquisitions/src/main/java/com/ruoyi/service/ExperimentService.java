package com.ruoyi.service;

import com.ruoyi.pojo.Experiment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.pojo.Experiment;

/**
* @author 25808
* @description 针对表【experiment(实验表)】的数据库操作Service
* @createDate 2023-08-26 16:27:46
*/
public interface ExperimentService extends IService<Experiment> {
    Integer getLatestExpId(Long user_id);
}
