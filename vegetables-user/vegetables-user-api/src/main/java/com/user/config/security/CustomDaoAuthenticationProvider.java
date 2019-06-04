package com.user.config.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Component;


@Component
public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

    public String flag = "真正处理认证请求的bean";

    public CustomDaoAuthenticationProvider(CustomUserDetailsService customUserDetailsService){
        this.setUserDetailsService(customUserDetailsService);
    }


}
