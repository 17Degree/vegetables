package com.user.api;


import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserApi {

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
    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("info")
    public User info(@PathVariable Long userId){
        return userServicep.findById(userId);
    }


    @GetMapping("all")
    public List<User> all(){
        return userServicep.findAll();
    }


}