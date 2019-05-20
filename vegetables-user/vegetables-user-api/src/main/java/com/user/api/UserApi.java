package com.user.api;


import com.user.core.entity.User;
import com.user.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("info")
    public User info(@PathVariable Long userId){
        return userServicep.findById(userId);
    }


    @GetMapping("all")
    public List<User> all(){
        return userServicep.findAll();
    }


}
