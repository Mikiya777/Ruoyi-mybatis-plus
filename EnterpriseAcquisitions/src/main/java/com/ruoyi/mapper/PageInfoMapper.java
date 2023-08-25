package com.ruoyi.mapper;

import com.ruoyi.pojo.PageInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 25808
* @description 针对表【page_info(页面信息-用于完成继续实验的跳转功能)】的数据库操作Mapper
* @createDate 2023-08-25 08:43:39
* @Entity com.ruoyi.pojo.PageInfo
*/
public interface PageInfoMapper extends BaseMapper<PageInfo> {
    PageInfo selectByPageInfoId(Long pageInfoId);

    int insertSelective(PageInfo record);
}




