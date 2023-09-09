package com.ruoyi.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.service.AnswersService;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.ScoreService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 针对表【answers(作答记录)】的数据库操作Controller
 */
@RestController
@RequestMapping("/answers")
public class AnswersController extends BaseController {
    @Resource
    private AnswersService answersService;

    @Resource
    private ExperimentService experimentService;

    @Resource
    private ScoreService scoreService;

    /**
     * @param answers 作答
     * @return 操作是否成功
     * @description: 提交作答记录
     */

    @PostMapping("/submit")
    public RequestResult<Answers> submit(@RequestBody Answers answers) {
        System.out.println("************\t"+answers+"\"A\"");

        answers.setUserId(SecurityUtils.getLoginUser().getUserId());
        Integer theLatestQuestionId = answersService.getTheLatestQuestionId(answers.getUserId(), answers.getExpId());
        answers.setQuestionId(theLatestQuestionId == null ? 1 : theLatestQuestionId);
        if (answers.getNextId() == null || answers.getNextId().equals("")||answers.getNextId().equals("''")){
            switch (answers.getId()) {
                case "p33":
                    if (new Random().nextBoolean())
                        answers.setNextId("dgood");
                    else
                        answers.setNextId("dbad");
                    break;
                case "dquestion":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("h1");
                        System.out.println("我在dquestion分支选择了A答案\t"+answers);
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("dwork");
                        System.out.println("我在dquestion分支选择了B答案"+answers);
                    }
                    break;
                case "dprice":
                    Map<String,String> answerMap = JSON.parseObject(answers.getAnswer(), new TypeReference<Map<String, String>>() {
                    });
                    if (Double.parseDouble(answerMap.get("1")) >= 25) {
                        answers.setNextId("f1");
                    } else
                        answers.setNextId("h1");
                    break;
                case "f34简答":
                    Answers f32Answer = answersService.getOne(new QueryWrapper<Answers>()
                            .eq("id", "f32单选")
                            .eq("exp_id", answers.getExpId())
                            .eq("user_id", SecurityUtils.getLoginUser().getUserId()));
                    if (f32Answer.getAnswer().equals("\"A\"")) {
                        answers.setNextId("f35MM");
                    } else if (f32Answer.getAnswer().equals("\"B\"")) {
                        answers.setNextId("f35Son");
                    } else if (f32Answer.getAnswer().equals("\"C\"")) {
                        answers.setNextId("f35Gold");
                    }
                    break;
                case "f38单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("f39现金");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("f39混合");
                    }
                    break;
                case "f60":
                    Answers Son = answersService.getOne(new QueryWrapper<Answers>()
                            .eq("id", "f35Son")
                            .eq("exp_id", answers.getExpId())
                            .eq("user_id", SecurityUtils.getLoginUser().getUserId()));

                    Answers Gold = answersService.getOne(new QueryWrapper<Answers>()
                            .eq("id", "f35Gold")
                            .eq("exp_id", answers.getExpId())
                            .eq("user_id", SecurityUtils.getLoginUser().getUserId()));
                    if (Son != null || Gold != null) {
                        answers.setNextId("f回归母公司");
                    } else {
                        Answers f38 = answersService.getOne(new QueryWrapper<Answers>()
                                .eq("id", "f38单选")
                                .eq("exp_id", answers.getExpId())
                                .eq("user_id", SecurityUtils.getLoginUser().getUserId()));
                        if (f38.getAnswer().equals("\"A\"")) {
                            answers.setNextId("fMM现金");

                        } else if (f38.getAnswer().equals("\"B\"")) {
                            answers.setNextId("fMM混合");
                        }
                    }
                    break;
                case "f回归母公司":
                    Answers Son2 = answersService.getOne(new QueryWrapper<Answers>()
                            .eq("id", "f35Son")
                            .eq("exp_id", answers.getExpId())
                            .eq("user_id", SecurityUtils.getLoginUser().getUserId()));
                    Answers f38 = answersService.getOne(new QueryWrapper<Answers>()
                            .eq("id", "f38单选")
                            .eq("exp_id", answers.getExpId())
                            .eq("user_id", SecurityUtils.getLoginUser().getUserId()));
                    if (Son2 != null) {
                        if (f38.getAnswer().equals("\"A\"")) {
                            answers.setNextId("fSon现金");

                        } else if (f38.getAnswer().equals("\"B\"")) {
                            answers.setNextId("fSon混合");
                        }
                    }
                    break;
                case "h18单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("M&A1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("FD1");
                    }
                    break;
                case "FD1":
                    if (new Random().nextBoolean()){
                        answers.setNextId("FDS");
                    }else {
                        answers.setNextId("FDD1");
                    }
                    break;
                case "FDD2单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("TA1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("M&A1");
                    }
                    break;
                case "M&A5单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("TA1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("MAA1");
                    }
                    break;
                case "MAA4单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("TA1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("CC1");
                    }
                    break;
                case "CC5":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("TA1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("AB1");
                    }
                    break;
                case "AB5单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        if (new Random().nextBoolean()) {
                            answers.setNextId("SC1");
                        }else {
                            answers.setNextId("BNA1");
                        }
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("NF1");
                    }
                    break;
                case "BMA5单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("SS1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("CA1");
                    }
                    break;
                case "NF2单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("TA1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("DS1");
                    }
                    break;
                case "DS4单选":
                    if (answers.getAnswer().equals("\"A\"")) {
                        answers.setNextId("DSSS1");
                    } else if (answers.getAnswer().equals("\"B\"")) {
                        answers.setNextId("DSCA1");
                    }
                    break;

            }
        }

        if (answersService.CheckAnswersIfValid(answers)) {
            boolean save = answersService.save(answers);
            System.out.println("Answer保存结果：\t:"+save);
            if (answers.getEnd() != null && answers.getEnd()){
                Boolean aBoolean = finishExp(answers.getUserId(), answers.getExpId());
                if (!aBoolean){
                    throw new RuntimeException("Error!");
                }
            }
            return new RequestResult<>(answers);
        }
        return new RequestResult<>(400, "落子无悔，无问得失，不可重复提交!", answers);
    }

    /**
     * @param expId 实验id
     * @return 作答记录列表
     * @description: 根据用户id和实验id获取该用户的作答记录
     */
    @GetMapping("/get/{exp_id}")
    public RequestResult<List<Answers>> get(@PathVariable("exp_id") Integer expId) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<Answers> list = answersService
                .list(new QueryWrapper<Answers>()
                        .eq("user_id", loginUser.getUserId())
                        .eq("exp_id", expId)
                        .orderByAsc("question_id"));
        list = list.stream().distinct().collect(Collectors.toList());
        return new RequestResult<>(list);
    }

    public Boolean finishExp(Long userId ,Integer exp_id) {


        BigDecimal objectiveScore = scoreService.getObjectiveScore(userId, exp_id, answersService.getAnswer(userId, exp_id));

        boolean update = experimentService.update(new UpdateWrapper<Experiment>()
                .set("Objective_Score",objectiveScore)
                .set("end_time",new Date())
                .set("status",true)
                .eq("user_id",userId)
                .eq("exp_id",exp_id));
        return update;
    }



}
