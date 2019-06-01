package com.user.config.security;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


/***
 * TODO 不认识的东西
 *
 * 说明：此处为了方便直接使用了 Spring Security 中的
 * org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint
 * 类定义了一个对象，最主要的目的是设置登录页的 URL，如果想了解更多
 * AuthenticationEntryPoint
 * 接口细节可以参考
 * LoginUrlAuthenticationEntryPoint
 * 源码。
 *
 * @Author chenjiacheng
 * @Date 2019/6/1 11:49 
 */
//@Configuration
public class CustomAuthenticationSecurityEntryPoint {

    /***
     * 自定义登录地址
     * @Author chenjiacheng
     * @Date 2019/6/1 14:15
     * @param
     * @return org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint
     */
    //@Bean
    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint("/unAuthentication");
    }
}
