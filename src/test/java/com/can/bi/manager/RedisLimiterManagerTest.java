package com.can.bi.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: Yang Hengcan
 * @Date: 2024/2/22 23:37
 * @Description:
 */
@SpringBootTest
class RedisLimiterManagerTest {

    @Resource
    private RedisLimiterManager redisLimiterManager;

    @Test
    void doReteLimit() {
        for (int i = 0; i < 10; i++) {
            redisLimiterManager.doReteLimit("test");
            System.out.println("i = " + i);
        }
    }
}