package com.taskmanager.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taskmanager.pojo.DTO.UserDTO;
import com.taskmanager.pojo.Entity.User;

public interface UserService extends IService<User> {
    void add(UserDTO user);

    boolean login(UserDTO userDTO);
}
