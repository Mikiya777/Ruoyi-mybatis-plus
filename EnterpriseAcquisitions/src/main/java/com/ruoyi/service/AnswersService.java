package com.ruoyi.service;

import com.ruoyi.pojo.Answers;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 25808
* @description 针对表【answers(作答记录)】的数据库操作Service
* @createDate 2023-08-26 16:27:46
*/
public interface AnswersService extends IService<Answers> {
    Integer getTheLatestQuestionId(Long userId,Integer expId);

    Boolean CheckAnswersIfValid(Answers answers);

    List<Answers> getAnswer(Long userId,Integer expId);
}
