package com.can.bi.constant;

import java.util.Set;

/**
 * 文件常量
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://can.icu">编程导航知识星球</a>
 */
public interface FileConstant {

    /**
     * COS 访问地址
     * todo 需替换配置
     */
    String COS_HOST = "https://can.icu";

    Long ONE_MB = 1024 * 1024L;

    Set<String> validFileSuffix = Set.of("png", "jpg", "svg", "xls", "xlsx", "doc", "docx", "pdf", "jpeg");
}
