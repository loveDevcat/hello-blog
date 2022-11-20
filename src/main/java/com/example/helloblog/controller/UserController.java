package com.example.helloblog.controller;

import com.example.helloblog.domain.User;
import com.example.helloblog.service.UserService;
import com.example.helloblog.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/login")
    public Result<User> login(@RequestParam String uname, @RequestParam String password) {

        User user = userService.loginService(uname, password);
        if (user != null) {
            return Result.success(user, "登录成功！");
            // return new ModelAndView("blogList");
        } else {
            return Result.error("123", "账号或密码错误！");
            // return new ModelAndView("blogDetai");
        }


    }

    @RequestMapping("/register")
    public Result<User> register(@RequestParam String uname, @RequestParam String password) {
        if (uname.isEmpty() && password.isEmpty()) {
            return Result.error("456", "用户名已存在！");
        } else {
            User user = userService.registService(uname, password);
            return Result.success(user, "注册成功！");
        }

    }
}


