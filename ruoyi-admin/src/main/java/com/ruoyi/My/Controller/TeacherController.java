package com.ruoyi.My.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.My.service.TSServiceImpl;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.Experiment;
import com.ruoyi.pojo.RequestResult;
import com.ruoyi.service.AnswersService;
import com.ruoyi.service.ExperimentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
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
    public RequestResult<List<Experiment>> getExperiment(){
        List<SysUser> studentList2 = tsService.selectStudentList(new SysUser());
        List<Long> IdList = studentList2.stream().map(SysUser::getUserId).collect(Collectors.toList());
        List<Experiment> experimentList = experimentService.list(new QueryWrapper<Experiment>().in("user_id", IdList));
        Comparator<Experiment> comparator = (e1,e2)-> {
            Date currentTime = new Date();

            // 处理endTime为null的情况
            if (e1.getEndTime() == null && e2.getEndTime() != null) {
                return Long.compare(e1.getStartTime().getTime(), e2.getEndTime().getTime());
            } else if (e1.getEndTime() != null && e2.getEndTime() == null) {
                return Long.compare(e1.getEndTime().getTime(), e2.getStartTime().getTime());
            } else if (e1.getEndTime() == null && e2.getEndTime() == null) {
                return Long.compare(Math.abs(e1.getStartTime().getTime() - currentTime.getTime())
                        , Math.abs(e2.getStartTime().getTime() - currentTime.getTime()));
            }

            // 首先按照endTime距离当前时间的远近排序
            long endTimeDiff1 = Math.abs(e1.getEndTime().getTime() - currentTime.getTime());
            long endTimeDiff2 = Math.abs(e2.getEndTime().getTime() - currentTime.getTime());
            int endTimeComparison = Long.compare(endTimeDiff1, endTimeDiff2);

            // 如果endTime相等，再按照startTime距离当前时间的远近排序
            if (endTimeComparison == 0) {
                long startTimeDiff1 = Math.abs(e1.getStartTime().getTime() - currentTime.getTime());
                long startTimeDiff2 = Math.abs(e2.getStartTime().getTime() - currentTime.getTime());
                return Long.compare(startTimeDiff1, startTimeDiff2);
            } else {
                return endTimeComparison;
            }
        };
        experimentList.sort(comparator);

        Loop :for (Experiment experiment : experimentList){
            for (SysUser s:studentList2){
                if (s.getUserId().equals(experiment.getUserId())){
                    experiment.setStudentName(s.getNickName());
                    continue Loop;
                }
            }
        }

        return new RequestResult<List<Experiment>>(experimentList);
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


}
