package com.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("callback")
public class OauthCallbackController {


    @RequestMapping("temp1")
    public String optList(){
        return "Authorization success";
    }

}
