package com.ruoyi.My.mapper;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomUserMapper {
    List<SysUser> selectUserList(SysUser user);
}
