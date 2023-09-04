package com.ruoyi.My.service;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.My.mapper.CustomUserMapper;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("tsServiceImpl")
public class TSServiceImpl extends SysUserServiceImpl {
    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private CustomUserMapper customUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;


    /**
     * 系管理员查询所有教师
     *
     * @return 所有教师
     */
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectTeacherList(SysUser user) {
        List<SysUser> teacherList = null;
//        List<SysUser> sysUsers = selectUserList(user);
        List<SysUser> sysUsers = customUserMapper.selectUserList(user);
        teacherList = filterRoles(sysUsers,"Teacher");
        for (SysUser teacher : teacherList){
            String gid;
            if ((gid = teacher.getGroupId())!=null){
                SysDept sysDept = new SysDept();
                sysDept.setGroupId(gid);
                List<SysDept> sysDepts = sysDeptMapper.selectDeptList(sysDept);
                List<String> collect = sysDepts.stream().map(dept ->dept.getDeptName())
                        .collect(Collectors.toList());
                SysDept dept = teacher.getDept();
                dept.setDeptName(String.join(",", collect));
                teacher.setDept(dept);
            }
        }
        return teacherList;
    }

    /**
     * 根据当前用户的数据权限查询所有学生
     *
     * @return 所有学生
     */

    public List<SysUser> selectStudentList(SysUser user) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<SysUser> studentList = null;
        List<SysUser> sysUsers = selectUserList(user);
        studentList = filterRoles(sysUsers,"Student");
        return studentList;
    }

    /**
     * 根据Group_id查看学生
     *
     * @return 所有学生
     */

    public List<SysUser> selectStudentList2(SysUser user) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<SysUser> studentList = null;
        List<SysUser> sysUsers = selectUserList(user);
        studentList = filterRoles(sysUsers,"Student");

        studentList = studentList.stream().map(student->{
            student.setGroupId(String.join(",", JSON.parseObject(student.getGroupId(),String[].class)));
            return student;
        }).collect(Collectors.toList());

        studentList = studentList.stream().filter((student)->{
            if (student.getGroupId().contains(loginUser.getGroup_id())){
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        return studentList;
    }

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */

    public List<SysRole> selectRolesByUserId(Long userId) {
        List<SysRole> userRoles = roleMapper.selectRolePermissionByUserId(userId);
        List<SysRole> roles = selectRoleAll();
        for (SysRole role : roles) {
            for (SysRole userRole : userRoles) {
                if (role.getRoleId().longValue() == userRole.getRoleId().longValue()) {
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    /**
     * 过滤特定角色的用户
     * @param userList 待过滤的用户列表
     * @param roleKey 角色
     * @return
     *
     */
    public List<SysUser> filterRoles(List<SysUser> userList , String roleKey){
        List<SysUser> tempList = new ArrayList<>();
        userList = userList.stream().map(sysUser -> {
                    List<SysRole> sysRoles = selectRolesByUserId(sysUser.getUserId());
                    sysUser.setRoles(sysRoles);
                    return sysUser;
                }).collect(Collectors.toList());
        for (SysUser sysUser : userList) {
            List<SysRole> roles = sysUser.getRoles();
            for (SysRole role : roles) {
                if (role.isFlag() && role.getRoleKey().equals(roleKey)) {
                    tempList.add(sysUser);
                    continue;
                }
            }
        }
        return tempList;
    }

    public List<SysRole> selectRoleAll() {
        return SpringUtils.getAopProxy(this).selectRoleList(new SysRole());
    }

    @DataScope(deptAlias = "d")
    public List<SysRole> selectRoleList(SysRole role) {
        return roleMapper.selectRoleList(role);
    }
}
