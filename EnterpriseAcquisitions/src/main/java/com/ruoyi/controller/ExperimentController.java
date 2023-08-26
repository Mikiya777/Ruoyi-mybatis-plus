package com.ruoyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.pojo.Schedule;
import com.ruoyi.service.ExperimentService;
import com.ruoyi.service.ScheduleService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 针对表【experiment(实验表)】的数据库操作Controller
 */
@RestController
@RequestMapping("/experiment")
public class ExperimentController {

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

        scheduleService.save(newSchedule);
        return new RequestResult<>(experiment);
    }

    /**
     * @description: 实验完成时要执行的操作
     * @param user_id 用户id
     * @param exp_id 实验id
     * @return 操作是否成功
     */

    @GetMapping("finishExp/{user_id}/{exp_id}")
    public RequestResult<Boolean> finishExp(@PathVariable("user_id") Long user_id, @PathVariable("exp_id") Integer exp_id) {
        Experiment experiment = experimentService.getOne(new QueryWrapper<Experiment>().eq("user_id", user_id).eq("exp_id", exp_id));
        experiment.setStatus(true);
        experiment.setEndTime(new Date());
        boolean update = experimentService.updateById(experiment);
        return new RequestResult<>(update);
    }
}
