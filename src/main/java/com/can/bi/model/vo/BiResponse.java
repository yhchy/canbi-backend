package com.can.bi.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Yang Hengcan
 * @Date: 2024/1/14 17:00
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiResponse {
    /**
     * 生成的图表数据
     */
    private String genChart;

    /**
     * 生成的分析结论
     */
    private String genResult;
}
