package com.user.api;


import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserApi {

    private static final Logger logger = LoggerFactory.getLogger(UserApi.class);


    @Autowired
    private UserService userServicep;

    /***
     *
     *
     *
     * @Author chenjiacheng
     * @Date 2019/5/23 17:18
     * @param userId
     * @return com.user.core.entity.User
     */
    @GetMapping("info")
    public User info(Long userId){
        return userServicep.findById(userId);
    }


    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("all")
    public List<User> all(){
        return userServicep.findAll();
    }

    @PreAuthorize("hasAnyRole('test1')")
    @GetMapping("test1")
    public void test1(){

        logger.error("++++++++++++无权限+++++++++++++++");
    }


}
