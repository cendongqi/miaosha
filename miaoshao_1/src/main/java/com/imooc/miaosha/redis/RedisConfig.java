package com.imooc.miaosha.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    private String host;

    private Integer port;

    private Integer timeout;

    private Integer maxTotal;

    private Integer maxIdle;

    private Integer maxWaitMillis;

    private Integer minEvictableIdleTimeMillis;

    private Integer numTestsPerEvictionRun;

    private Integer timeBetweenEvictionRunsMillis;

    private Boolean testOnBorrow;

    private Boolean testWhileIdle;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory fac = new JedisConnectionFactory();
        fac.setHostName(host);
        fac.setPort(port);
        fac.setTimeout(timeout);
        fac.getPoolConfig().setMaxIdle(maxIdle);
        fac.getPoolConfig().setMaxTotal(maxTotal);
        fac.getPoolConfig().setMaxWaitMillis(maxWaitMillis);
        fac.getPoolConfig().setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        fac.getPoolConfig()
                .setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        fac.getPoolConfig().setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        fac.getPoolConfig().setTestOnBorrow(testOnBorrow);
        fac.getPoolConfig().setTestWhileIdle(testWhileIdle);
        return fac;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory);
        redis.afterPropertiesSet();
        redis.setKeySerializer(new StringRedisSerializer());

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        redis.setValueSerializer(jackson2JsonRedisSerializer);
        return redis;
    }
}
