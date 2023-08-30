package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.ExperimentWithPages;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.service.AnswersService;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.ScheduleService;

import com.ruoyi.service.ScoreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.ruoyi.common.utils.PageUtils.startPage;

/**
 * @description: 针对表【experiment(实验表)】的数据库操作Controller
 */
@RestController
@RequestMapping("/experiment")
public class ExperimentController {

    @Resource
    private AnswersService answersService;

    @Resource
    private ScoreService scoreService;

    @Resource
    private ExperimentService experimentService;

    @Resource
    private ScheduleService scheduleService;

    /**
     * @description: 根据用户id创建一个新的实验
     *
     * @return 实验id
     */
    @GetMapping("/createExp")
    @PreAuthorize("@ss.hasPermi('ExerciseStart')")
    public RequestResult<Experiment> createExp() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long user_id = loginUser.getUserId();

        Experiment experiment = new Experiment();
        experiment.setUserId(user_id);
        experiment.setStatus(false);
        experiment.setStartTime(new Date());
        experimentService.save(experiment);
        Integer expId = experimentService.getLatestExpId(user_id);
        experiment.setExpId(expId);

        Schedule newSchedule = new Schedule();
        newSchedule.setExpId(expId);
        newSchedule.setUserId(user_id);
        newSchedule.setStatus(false);
        newSchedule.setStartTime(experiment.getStartTime());
        newSchedule.setNextId("p1");

        scheduleService.save(newSchedule);
        return new RequestResult<>(experiment);
    }

    /**
     * 获取当前用户所有实验
     * @return 实验列表
     */
    @GetMapping("/get")
    public RequestResult<ExperimentWithPages> getExprimentList(){
        LoginUser loginUser = SecurityUtils.getLoginUser();
        startPage();
        List<Experiment> experimentList = experimentService
                .list(new QueryWrapper<Experiment>()
                        .eq("user_id", loginUser.getUserId())
                        .orderByDesc("exp_id"));
        int total = experimentService.count(new QueryWrapper<Experiment>().eq("user_id", loginUser.getUserId()));
        return new RequestResult<>(new ExperimentWithPages(experimentList,(int)Math.ceil(total/10.0)));
    }

    /**
     * @description: 实验完成时要执行的操作
     *
     * @param exp_id 实验id
     * @return 操作是否成功
     */

    @GetMapping("finishExp/{exp_id}")
    public RequestResult<Boolean> finishExp(@PathVariable("exp_id") Integer exp_id) {
        Long userId = SecurityUtils.getLoginUser().getUserId();

        Experiment experiment = experimentService.getOne(new QueryWrapper<Experiment>().eq("user_id", userId).eq("exp_id", exp_id));
        experiment.setStatus(true);
        experiment.setEndTime(new Date());

        BigDecimal objectiveScore = scoreService.getObjectiveScore(userId, exp_id, answersService.getAnswer(userId, exp_id));
        experiment.setObjectiveScore(objectiveScore);

        boolean update = experimentService.updateById(experiment);
        return new RequestResult<>(update);
    }
}
