package com.user.core.service.impl;

import com.user.base.BaseServiceImpl;
import com.user.core.dao.UserRepository;
import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表
 * @author automatic
 * @version 1.0
 * @data 2019-05-16 11:39
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public void aaa() {

    }
}
