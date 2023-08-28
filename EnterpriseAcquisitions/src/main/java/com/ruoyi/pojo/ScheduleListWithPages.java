package com.ruoyi.pojo;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleListWithPages {
    private List<Schedule> scheduleList;
    private Integer pages;
}
