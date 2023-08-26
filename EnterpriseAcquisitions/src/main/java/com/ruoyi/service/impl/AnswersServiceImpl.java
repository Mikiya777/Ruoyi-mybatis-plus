package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.pojo.Answers;
import com.ruoyi.service.AnswersService;
import com.ruoyi.mapper.AnswersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 25808
* @description 针对表【answers(作答记录)】的数据库操作Service实现
* @createDate 2023-08-26 16:27:46
*/
@Service
public class AnswersServiceImpl extends ServiceImpl<AnswersMapper, Answers>
    implements AnswersService{
    @Resource
    private AnswersMapper answersMapper;
    @Override
    public Integer getTheLatestQuestionId(Long userId, Integer expId) {
        return answersMapper.selectTheLatestQuestionId(userId,expId);
    }
}




