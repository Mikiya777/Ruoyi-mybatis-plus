package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.service.AnswersService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 针对表【answers(作答记录)】的数据库操作Controller
 */
@RestController
@RequestMapping("/answers")
public class AnswersController {
    @Resource
    private AnswersService answersService;

    /**
     * @description: 提交作答记录
     * @param answers 作答
     * @return 操作是否成功
     */

    @PostMapping("/submit")
    public RequestResult<Answers> submit(@RequestBody Answers answers) {
        answers.setUserId(SecurityUtils.getLoginUser().getUserId());
        answers.setQuestionId(answersService.getTheLatestQuestionId(answers.getUserId(),answers.getExpId())+1);
        boolean save = answersService.save(answers);
        if (answers.getNextId() == null){

        }
        return new RequestResult<>(answers);
    }

    /**
     * @description: 根据用户id和实验id获取该用户的作答记录
     *
     * @param expId 实验id
     * @return 作答记录列表
     */
    @GetMapping("/get/{exp_id}")
    public RequestResult<List<Answers>> get( @PathVariable("exp_id") Integer expId) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<Answers> list = answersService
                .list(new QueryWrapper<Answers>()
                        .eq("user_id", loginUser.getUserId())
                        .eq("exp_id", expId)
                        .orderByAsc("question_id"));
        return new RequestResult<>(list);
    }
}
