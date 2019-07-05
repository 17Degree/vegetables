package com.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PreAuthorize("hasAuthority('user')")
    @GetMapping(value = "users/list")
    public String listUser(HttpServletRequest request){
        logger.info("+++++++++++++listUser+++++++++++++ sessionId:" + request.getSession().getId());
        return "user";
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "opt/list")
    public String optList(){
        return "optList";
    }

}
