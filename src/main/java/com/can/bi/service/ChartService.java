package com.can.bi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.can.bi.model.dto.chart.ChartQueryRequest;
import com.can.bi.model.entity.Chart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author admin
 * @description 针对表【chart(图表信息表)】的数据库操作Service
 * @createDate 2024-01-13 14:59:15
 */
public interface ChartService extends IService<Chart> {

    /**
     * 获取查询包装类
     *
     * @param chartQueryRequest
     * @return
     */
    QueryWrapper<Chart> getQueryWrapper(ChartQueryRequest chartQueryRequest);
}
