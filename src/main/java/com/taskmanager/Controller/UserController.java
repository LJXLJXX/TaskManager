package com.taskmanager.Controller;


import com.taskmanager.Service.UserService;
import com.taskmanager.pojo.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO user){
        userService.add(user);

        return "注册成功";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO) ?"登录成功":"登录失败";

    }
}


//     web层   过滤层  拦截层  控制层  服务层  映射层  数据库