package com.user.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 *
 * 自定义认证管理器
 * @Author chenjiacheng
 * @Date 2019/6/1 11:26
 */
@Component
public class CustomAuthenticationManager implements AuthenticationManager, BeanPostProcessor {

    {
        System.out.println("构造块：CustomAuthenticationManager");
    }

    @Autowired
    private CustomDaoAuthenticationProvider authenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //将认证信息/对象 传给自定义的认证器认证
        Authentication authenticate = authenticationProvider.authenticate(authentication);

        if(Objects.nonNull(authenticate)){
            return authenticate;
        }

        throw new ProviderNotFoundException("Authentication failed!");
    }



}
