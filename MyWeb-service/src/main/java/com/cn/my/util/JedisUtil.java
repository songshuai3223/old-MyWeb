package com.cn.my.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by gcb on 2018/1/15.
 */
@Configuration
public class JedisUtil {
    @Value("${spring.redis.cluster.nodes}")
    private String serverNodes;

    @Bean(name="jedis.pool")
    public JedisPool jedisPool(@Qualifier("jedis.pool.config")JedisPoolConfig config,
                               @Value("${jedis.pool.host}")String host,@Value("${jedis.pool.port}")int port){
        return new JedisPool(config,host,port);
    }
    @Bean(name="jedis.pool.config")
    public JedisPoolConfig jedisPoolConfig(@Value("${jedis.pool.config.maxTotal}")int  maxTotal,
                               @Value("${jedis.pool.config.maxIdle}")int maxIdle,
                               @Value("${jedis.pool.config.maxWaitMillis}")int maxWaitMillis){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return jedisPoolConfig;
    }
}
