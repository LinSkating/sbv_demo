package com.linskating.springbootvue_demo.controller;

import com.linskating.springbootvue_demo.common.Result;
import com.linskating.springbootvue_demo.entity.User;
import com.linskating.springbootvue_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //登录操作
    @PostMapping("/Login")
    public Result login(@RequestBody User user) {
        if(user.getUsername() == null || user.getPassword() == null) {
            return Result.error("数据输入不合法");
        }
        user = userService.login(user);
        return Result.success(user);
    }

    //注册操作
    @PostMapping("/Register")
    public Result register(@RequestBody User user) {
        if(userService.insertUser(user)) {
            return Result.success();
        }
        return Result.error("账号已存在");
    }

    //忘记密码操作
    @PostMapping("/forgetPassword")
    public Result forgetPassword(@RequestBody User user) {
        if(userService.resetPassword(user.getUsername(), user.getPassword())) {
            return Result.success();
        }
        return Result.error("账号不存在");
    }
}
