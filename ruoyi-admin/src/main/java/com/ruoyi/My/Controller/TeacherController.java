package com.ruoyi.My.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.My.service.TSServiceImpl;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;

import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.ExperimentWithPages;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.service.AnswersService;
import com.ruoyi.service.ExperimentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController {
    @Resource
    private ExperimentService experimentService;

    @Resource
    private AnswersService answersService;

    @Resource
    private TSServiceImpl tsService;

    /**
     * 教师端-学生成绩
     */
    @GetMapping("/getExperiment")
    public RequestResult<ExperimentWithPages> getExperiment(HttpServletResponse response){
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        startPage();
        List<SysUser> studentList2 = tsService.selectStudentList(new SysUser());
        List<Long> IdList = studentList2.stream().map(SysUser::getUserId).collect(Collectors.toList());
        startPage();

        List<Experiment> experimentList = experimentService.list(new QueryWrapper<Experiment>()
                .in("user_id", IdList)
                .orderByDesc("CASE WHEN end_time IS NOT NULL THEN end_time ELSE start_time END"));
        for (SysUser s:studentList2){
            Loop : for (Experiment experiment : experimentList){
                if (s.getUserId().equals(experiment.getUserId())){
                    experiment.setStudentName(s.getNickName());
                    experiment.setClassName(s.getDept().getDeptName());
                    continue Loop;
                }
            }
        }
        int total = experimentService.count(new QueryWrapper<Experiment>().in("user_id", IdList));
        ExperimentWithPages experimentWithPages = new ExperimentWithPages(experimentList, (int) Math.ceil(total / 10.0));

        return new RequestResult<>(experimentWithPages);
    }

    /**
     * 简答题形成报告所用
     * @param userId
     * @param expId
     */

    @GetMapping("/getSubjectAnswer/{userId}/{expId}")
    public RequestResult<List<Answers>> getSubjectAnswer(@PathVariable("userId") long userId,@PathVariable("expId") Integer expId){
        List<Answers> answersList = answersService.list(new QueryWrapper<Answers>()
                .eq("user_id", userId)
                .eq("exp_id", expId)
                .eq("type", "4"));
        answersList.sort((a1,a2)->{
            return Integer.compare(a1.getQuestionId(), a2.getQuestionId());
        });
        return new RequestResult<List<Answers>>(answersList);
    }

    /**
     * 批阅主观题后赋分
     * @param userId
     * @param expId
     * @param subjectiveScore
     */

    @GetMapping("/setSubjectiveScore/{userId}/{expId}")
    public RequestResult<Boolean> setSubjectiveScore(@PathVariable("userId") long userId,@PathVariable("expId") Integer expId
            ,@RequestParam @Size(min = 0,max = 100) BigDecimal subjectiveScore){
        Experiment experiment = experimentService.getOne(new QueryWrapper<Experiment>()
                .eq("user_id", userId).eq("exp_id", expId));
        experiment.setSubjectiveScore(subjectiveScore);
        boolean update = experimentService.update(new QueryWrapper<Experiment>()
                .eq("user_id", userId)
                .eq("exp_id", expId)
                .setEntity(experiment));
        return new RequestResult<>(update);
    }

    @GetMapping("/getAnswer/{user_id}/{exp_id}")
    public RequestResult<List<Answers>> getAnswer(@PathVariable("user_id") long userId,@PathVariable("exp_id")Integer expId){
        List<Answers> list = answersService
                .list(new QueryWrapper<Answers>()
                        .eq("user_id", userId)
                        .eq("exp_id", expId)
                        .orderByAsc("question_id"));
        list = list.stream().distinct().collect(Collectors.toList());
        return new RequestResult<>(list);
    }


}
