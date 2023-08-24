package com.ruoyi.My.Controller;

import com.ruoyi.My.service.TSServiceImpl;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TS")
public class TSController extends BaseController {
    @Autowired
    @Qualifier("tsServiceImpl")
    private TSServiceImpl tsService;

    @GetMapping("/getTeacherList")
    public TableDataInfo getTeacherList(SysUser user){
        startPage();
        List<SysUser> teacherList = tsService.selectTeacherList(user);
        return getDataTable(teacherList);
    }

    @GetMapping("/getStudentList")
    public TableDataInfo getStudentList(SysUser user){
        startPage();
        List<SysUser> studentList = tsService.selectStudentList(user);
        return getDataTable(studentList);
    }
}
