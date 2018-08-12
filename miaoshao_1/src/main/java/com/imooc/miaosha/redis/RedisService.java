package com.imooc.miaosha.redis;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public <T> T get(String key, Class<T> clazz) {
        String dataJson = (String) redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(dataJson)) {
            return null;
        }
        return jsonToBean(dataJson, clazz);
    }

    public <T> boolean set(String key, T value) {
        if (StringUtils.isBlank(key)) {
            return false;
        }
        String dataJson = beanToJson(value);
        redisTemplate.opsForValue().set(key, dataJson);
        return true;
    }

    public <T> String beanToJson(T value) {
        return new Gson().toJson(value);
    }

    public <T> T jsonToBean(String jsonString, Class<T> clazz) {
        return new Gson().fromJson(jsonString, clazz);
    }
}

