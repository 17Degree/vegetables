package com.user.api;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginApi {

    @GetMapping("unAuthentication")
    public JSONObject unAuthenticationApi(){
        return new JSONObject().fluentPut("msg","未登录");
    }

    @GetMapping("error")
    public JSONObject error(){
        return new JSONObject().fluentPut("msg","登陆失败");
    }

    @GetMapping("success")
    public JSONObject success(){
        return new JSONObject().fluentPut("msg","登陆成功");
    }

    @GetMapping("invalid")
    public JSONObject invalid(){
        return new JSONObject().fluentPut("msg","登录无效");
    }



}
