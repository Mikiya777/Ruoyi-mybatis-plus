package com.ruoyi.mapper;

import com.ruoyi.pojo.Answers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 25808
* @description 针对表【answers(作答记录)】的数据库操作Mapper
* @createDate 2023-08-26 16:27:46
* @Entity .pojo.Answers
*/
public interface AnswersMapper extends BaseMapper<Answers> {
    Integer selectTheLatestQuestionId(Long userId,Integer expId);

    Integer selectAnswerByPageId(String id);

}




