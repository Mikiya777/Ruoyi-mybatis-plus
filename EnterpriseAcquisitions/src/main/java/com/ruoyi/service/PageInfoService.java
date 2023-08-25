package com.ruoyi.service;

import com.ruoyi.pojo.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25808
* @description 针对表【page_info(页面信息-用于完成继续实验的跳转功能)】的数据库操作Service
* @createDate 2023-08-25 08:43:39
*/
public interface PageInfoService extends IService<PageInfo> {
    public Boolean savePageInfo(PageInfo pageInfo);
}
