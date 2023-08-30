package com.ruoyi.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.pojo.Experiment;

/**
* @author 25808
* @description 针对表【experiment(实验表)】的数据库操作Mapper
* @createDate 2023-08-26 16:27:46
* @Entity .pojo.Experiment
*/
public interface ExperimentMapper extends BaseMapper<Experiment> {
    int selectTheLatestExpId(long user_id);
}




