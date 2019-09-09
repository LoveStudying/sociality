package com.zyl.sociality.service.impl;

import com.zyl.sociality.common.BizException;
import com.zyl.sociality.common.CodeMsg;
import com.zyl.sociality.domain.User;
import com.zyl.sociality.mapper.UserMapper;
import com.zyl.sociality.service.UserService;
import com.zyl.sociality.utils.JwtHelper;
import com.zyl.sociality.utils.MD5Util;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
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

    @Override
    public User login(String userName, String passWord) {
        User user =userMapper.login(userName, MD5Util.encodeMd5(passWord));
        if(user !=null){
            return user;
        }else{
            throw new BizException(CodeMsg.PASSWORD_WRONG);
        }
    }
}
