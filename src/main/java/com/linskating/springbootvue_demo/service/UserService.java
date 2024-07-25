package com.linskating.springbootvue_demo.service;

import com.linskating.springbootvue_demo.entity.User;
import com.linskating.springbootvue_demo.exception.ServiceException;
import com.linskating.springbootvue_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Boolean insertUser(User user) {
        User findUser = userMapper.selectByName(user.getUsername());
        if(findUser == null) {
            userMapper.insertUser(user);
            return true;
        }
        throw new ServiceException("账号已存在");
    }

    public User login(User user) {
        User findUser = userMapper.selectByName(user.getUsername());
        if(findUser == null || !user.getPassword().equals(findUser.getPassword())) {
            throw new ServiceException("账号或密码不存在");
        }
        return findUser;
    }
}
