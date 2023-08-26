package com.ruoyi.pojo;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class AnswersListWithPages {
    private List<Answers> answersList;
    private Page page;
}
