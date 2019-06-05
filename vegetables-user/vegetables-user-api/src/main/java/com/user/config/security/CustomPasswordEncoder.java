package com.user.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

    {
        System.out.println("初始化密码鉴定器");
    }


    @Override
    public String encode(CharSequence rawPassword) {
        System.out.println("明文密码加密规则");
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.out.println("密码鉴定");
        return false;
    }
}
