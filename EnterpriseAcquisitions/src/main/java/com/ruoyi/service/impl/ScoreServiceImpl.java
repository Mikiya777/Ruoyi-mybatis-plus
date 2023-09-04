package com.ruoyi.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.mapper.ScoreMapper;
import com.ruoyi.pojo.Answers;
import com.ruoyi.pojo.Score;
import com.ruoyi.service.ScoreService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
* @author 25808
* @description 针对表【score】的数据库操作Service实现
* @createDate 2023-08-30 21:34:38
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{


    /**
     * 计算客观题总分
     * @param userId
     * @param expId
     * @param answersList
     * @return
     */
    @Override
    public BigDecimal getObjectiveScore(Long userId, Integer expId, List<Answers> answersList) {
        List <Answers> answersListConveted = answersList.stream().map(answers -> {
            switch (answers.getType()){
                //单选答案转换
                case 2:
                    answers.setAnswer(parseString(answers.getAnswer()));
                    break;
                //多选答案转换
                case 3:
                    answers.setAnswer(parseStringArray(answers.getAnswer()));
                    break;
                //单填空答案转
                case 1:
                    answers.setAnswer(parseStringFromSingleBlank(answers.getAnswer()));
                    break;
                //简答题答案
                case 4:
                    answers.setAnswer(parseString(answers.getAnswer()));
                    break;
                //多填空答案转换
                case 5:
                    answers.setAnswer(parseStringFromMutilBlank(answers.getAnswer()));
                    break;
            }
            return answers;
        }).collect(Collectors.toList());

        List<Score> list = list();

        list = list.stream().filter(score -> {
            for (Answers answers:answersList){
                if (score.getId().equals(answers.getId()))
                    return true;
            }
            return false;
        }).collect(Collectors.toList());

        BigDecimal objectiveScoreFromPath = new BigDecimal(0);
        List<Score> filterScoreList = filterScoreList(list);
        for (Score score: filterScoreList){
            objectiveScoreFromPath = objectiveScoreFromPath.add(score.getScore());
        }

        BigDecimal objectiveScore = new BigDecimal(0);

        A: for (Answers answers:answersListConveted){
            for (Score score : list){
                if (answers.getId().equals(score.getId()) && answers.getAnswer()!=null && answers.getAnswer().equals(score.getAnswer())){
                    objectiveScore = objectiveScore.add(score.getScore());
                    continue A;
                }
            }
        }

        objectiveScore = objectiveScore
                .divide(objectiveScoreFromPath,1, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
        return objectiveScore;
    }

    public List<Score> filterScoreList(List<Score> scoreList){
        HashMap<String, Score> map = new HashMap<>();
        for (Score score : scoreList) {
            if (!map.containsKey(score.getId()) || score.getScore().compareTo(map.get(score.getId()).getScore()) > 0) {
                map.put(score.getId(), score);
            }
        }
        scoreList = map.values().stream().collect(Collectors.toList());
        return scoreList;
    }


    /**
     * 转换单选答案
     * @param answer
     * @return
     */
    public String parseString(String answer){
        return JSON.parseObject(answer,String.class);
    }

    /**
     * 转换多选答案
     * @param answer
     * @return
     */
    public String parseStringArray(String answer){
        return String.join(",",JSON.parseObject(answer,String[].class));
    }

    /**
     * 转换多个填空题答案
     * @param answer
     * @return
     */

    public String parseStringFromMutilBlank(String answer){
        Map<String,String> answerMap = JSON.parseObject(answer, new TypeReference<Map<String, String>>() {
        });
        List<String> collect = answerMap.values().stream().collect(Collectors.toList());
        answer = String.join(",", collect);
        System.out.println("parseStringFromMutilBlank处理结果\t"+answer);
        return answer;
    }

    /**
     * 转换简答题答案
     */
    public String parseStringFromSingleBlank(String answer){
        Map<String,String> answerMap = JSON.parseObject(answer, new TypeReference<Map<String, String>>() {
        });
        answer = answerMap.get("1");
        return answer;
    }

    /**
     * 结束演练的方法
     * @param userId
     * @param exp_id
     * @return
     */

}




