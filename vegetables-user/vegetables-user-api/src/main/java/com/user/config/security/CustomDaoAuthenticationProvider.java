package com.user.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomDaoAuthenticationProvider.class);

    public String flag = "真正处理认证请求的bean";

    {

        logger.info("实例化CustomDaoAuthenticationProvider");
    }

    public CustomDaoAuthenticationProvider(CustomUserDetailsService customUserDetailsService, CustomPasswordEncoder customPasswordEncoder){
        this.setUserDetailsService(customUserDetailsService);
        this.setPasswordEncoder(new BCryptPasswordEncoder());
    }




}
