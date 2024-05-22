package com.taskmanager.Service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taskmanager.Mapper.UserMapper;
import com.taskmanager.Service.UserService;
import com.taskmanager.pojo.DTO.UserDTO;
import com.taskmanager.pojo.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        userMapper.insert(user);
    }

    @Override
    public boolean login(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        User return_user =  userMapper.selectOne(
                new QueryWrapper<User>().eq("username", user.getUsername())
                .eq("password", user.getPassword()));
        if(return_user != null)
            return true;
        log.info("{}",return_user);
        return false;
    }
}
