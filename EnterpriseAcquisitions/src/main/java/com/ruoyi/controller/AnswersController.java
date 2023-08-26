package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.AnswersListWithPages;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.service.AnswersService;

import com.ruoyi.utils.MyPageUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 针对表【answers(作答记录)】的数据库操作Controller
 */
@RestController
@RequestMapping("/answers")
public class AnswersController extends BaseController {
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
        Integer theLatestQuestionId = answersService.getTheLatestQuestionId(answers.getUserId(), answers.getExpId());
        answers.setQuestionId(theLatestQuestionId == null ? 1: theLatestQuestionId);
        if (answers.getNextId() == null){

        }

        if (answersService.CheckAnswersIfValid(answers)){
            answersService.save(answers);
            return new RequestResult<>(answers);
        }
        return new RequestResult<>(400, "落子无悔，无问得失，不可重复提交!",answers);
    }

    /**
     * @description: 根据用户id和实验id获取该用户的作答记录
     *
     * @param expId 实验id
     * @return 作答记录列表
     */
    @GetMapping("/get/{exp_id}")
    public RequestResult<AnswersListWithPages> get(@PathVariable("exp_id") Integer expId) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Page page = MyPageUtils.startPage();
        List<Answers> list = answersService
                .list(new QueryWrapper<Answers>()
                        .eq("user_id", loginUser.getUserId())
                        .eq("exp_id", expId)
                        .orderByAsc("question_id"));
        list = list.stream().distinct().collect(Collectors.toList());
        AnswersListWithPages answersListWithPages = new AnswersListWithPages(list, page);
        return new RequestResult<>(answersListWithPages);
    }
}
