package com.zyl.sociality.service;

import com.zyl.sociality.domain.User;

import java.util.List;

public interface UserService {
    int save(User user);

    User findById(int id);

    List<User> findUserList();
}
