package com.imooc.miaosha.service.impl;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.imooc.miaosha.redis.RedisConst.USER_PREFIX;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;

    @Override
    public User getUserById(Long id) {
        User user = redisService.get(USER_PREFIX + id, User.class);
        if (user == null) {
            user = userDao.getById(id);
            if (user != null) {
                redisService.set(USER_PREFIX + id, user);
            }
        }
        return user;
    }
}
