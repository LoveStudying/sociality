package com.zyl.sociality.service.impl;

import com.zyl.sociality.domain.User;
import com.zyl.sociality.mapper.UserMapper;
import com.zyl.sociality.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public User findById(int id) {
        User user= userMapper.findById(id);
        return user;
    }

    @Override
    public List<User> findUserList() {
        List<User> list = userMapper.findUserList();
        return list;
    }
}
