package com.imooc.miaosha.controller;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.imooc.miaosha.redis.RedisConst.USER_PREFIX;

@RestController
@RequestMapping("/miaosha")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Result getUser(Long userId) {
        User user = userService.getUserById(userId);
        return new Result().success().setData(user);
    }

    @RequestMapping(value = "/redis/user/set", method = RequestMethod.GET)
    public Result redisSetUser(Long userId, String username) {
        User user = new User(userId, username);
        redisService.set(USER_PREFIX + userId, user);
        return new Result().success().setData(user);
    }

    @RequestMapping(value = "/redis/user/get", method = RequestMethod.GET)
    public Result redisGetUser(Long userId) {
        User user = redisService.get(USER_PREFIX + userId, User.class);
        return new Result().success().setData(user);
    }
}
