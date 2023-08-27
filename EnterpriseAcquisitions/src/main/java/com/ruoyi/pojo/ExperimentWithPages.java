package com.ruoyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.math3.analysis.function.Exp;

import java.util.List;
@Data
@AllArgsConstructor
public class ExperimentWithPages {
    private List<Experiment> experimentList;
    private Integer pages;
}
