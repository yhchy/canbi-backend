package com.can.bi.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Yang Hengcan
 * @Date: 2024/2/22 23:26
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissionConfig {
    private Integer database;
    private String host;
    private Integer port;
    private Integer timeout;
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setDatabase(database);
        return Redisson.create(config);
    }
}
