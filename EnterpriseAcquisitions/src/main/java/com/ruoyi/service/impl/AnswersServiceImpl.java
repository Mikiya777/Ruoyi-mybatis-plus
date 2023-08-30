package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.pojo.Answers;
import com.ruoyi.service.AnswersService;
import com.ruoyi.mapper.AnswersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Boolean CheckAnswersIfValid(Answers answers) {
        if (answersMapper.selectAnswerByPageId(answers.getId()) >0)
            return false;
        return true;
    }

    @Override
    public List<Answers> getAnswer(Long userId, Integer expId) {
        List<Answers> list = list(new QueryWrapper<Answers>().eq("user_id", userId).eq("exp_id", expId));
        return list;
    }
}




