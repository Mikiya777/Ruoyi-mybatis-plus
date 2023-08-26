package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.mapper.ExperimentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 25808
* @description 针对表【experiment(实验表)】的数据库操作Service实现
* @createDate 2023-08-26 16:27:46
*/
@Service
public class ExperimentServiceImpl extends ServiceImpl<ExperimentMapper, Experiment>
    implements ExperimentService{
    @Resource
    private ExperimentMapper experimentMapper;

    @Override
    public Integer getLatestExpId(Long user_id) {
        return experimentMapper.selectTheLatestExpId(user_id);
    }
}




