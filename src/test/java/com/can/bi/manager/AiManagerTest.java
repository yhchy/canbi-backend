package com.can.bi.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Yang Hengcan
 * @Date: 2024/1/14 16:44
 * @Description:
 */
@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;
    @Test
    void doChat() {
        String result = aiManager.doChat(1709156902984093697L,"推荐邓紫棋唱的10首最好听的歌");
        System.out.println("result = " + result);
    }
}