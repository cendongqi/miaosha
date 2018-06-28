package com.imooc.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:tz
 * @date:Created in 下午1:58 2018/6/28
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World";
    }

    // rest json api输出

}
