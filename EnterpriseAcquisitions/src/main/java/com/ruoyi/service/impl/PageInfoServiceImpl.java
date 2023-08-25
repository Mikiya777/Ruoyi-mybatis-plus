package com.ruoyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.pojo.PageInfo;
import com.ruoyi.service.PageInfoService;
import com.ruoyi.mapper.PageInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 25808
 * @description 针对表【page_info(页面信息-用于完成继续实验的跳转功能)】的数据库操作Service实现
 * @createDate 2023-08-25 08:43:39
 */
@Service
public class PageInfoServiceImpl extends ServiceImpl<PageInfoMapper, PageInfo>
        implements PageInfoService {
    @Resource
    private PageInfoMapper pageInfoMapper;

    @Override
    public Boolean savePageInfo(PageInfo pageInfo) {
        if (pageInfoMapper.insertSelective(pageInfo) > 0)
            return true;
        return false;
    }
}




