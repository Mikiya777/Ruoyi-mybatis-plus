package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
     * @param answers
     * @return 操作是否成功
     */
    @PostMapping("/submit")
    public RequestResult<Boolean> submit(@RequestBody Answers answers) {
        boolean save = answersService.save(answers);
        return new RequestResult<>(save);
    }

    /**
     * @description: 根据用户id和实验id获取该用户的作答记录
     * @param userId
     * @param expId
     * @return 作答记录列表
     */
    @GetMapping("/get/{user_id}/{exp_id}")
    public RequestResult<List<Answers>> get(@PathVariable("user_id") Long userId, @PathVariable("exp_id") Integer expId) {
        List<Answers> list = answersService.list(new QueryWrapper<Answers>().eq("user_id", userId).eq("exp_id", expId));
        return new RequestResult<>(list);
    }
}
