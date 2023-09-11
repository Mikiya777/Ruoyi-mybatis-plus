package com.ruoyi.My.Controller;

import com.ruoyi.My.mapper.CustomUserMapper;
import com.ruoyi.My.service.TSServiceImpl;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/TS")
public class TSController extends BaseController {
    @Autowired
    @Qualifier("tsServiceImpl")
    private TSServiceImpl tsService;



    /**
     * 院校管理员查看老师
     * @param user
     * @return
     */
    @GetMapping("/getTeacherList")
    public TableDataInfo getTeacherList(SysUser user, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        startPage();
        List<SysUser> teacherList = tsService.selectTeacherList(user);
        return getDataTable(teacherList);
    }

    /**
     * 院校管理员查看学生
     * @param user
     * @return
     */

    @GetMapping("/getStudentList")
    public TableDataInfo getStudentList(SysUser user,HttpServletResponse response){
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        startPage();
        List<SysUser> studentList = tsService.selectStudentList(user);
        return getDataTable(studentList);
    }

    /**
     * 老师端查看学生
     * @param user
     * @return
     */
    @GetMapping("/teacher/getStudentList")
    public TableDataInfo getStudentList2(SysUser user){
        startPage();
        List<SysUser> studentList = tsService.selectStudentList2(user);
        return getDataTable(studentList);
    }
}
