package com.user.config.security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


/***
 * 自定义认证过滤器
 * @Author chenjiacheng
 * @Date 2019/6/1 11:36
 */
@Component
public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     *
     * @Author chenjiacheng
     * @Date 2019/6/1 11:41
     * @param authenticationManager	认证管理器
     * @param authenticationFailureHandler 认证失败处理器
     * @param authenticationSuccessHandler 认证成功处理器
     */
    public CustomAuthenticationFilter(
            AuthenticationManager authenticationManager, AuthenticationFailureHandler authenticationFailureHandler,
            AuthenticationSuccessHandler authenticationSuccessHandler) {

        super(new AntPathRequestMatcher("/login", "POST"));
        this.setAuthenticationManager(authenticationManager);


        this.setAuthenticationFailureHandler(authenticationFailureHandler);
        this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    }


    /**
     *
     * attemptAuthentication 方法同 org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
     * 十分类似，唯一多出的注释掉的代码用于实现验证码校验功能，当然此处可以根据实际业务需求定制任意验证功能，
     * 有时间可以参考一下 UsernamePasswordAuthenticationFilter 的源码。自定义 AbstractAuthenticationProcessingFilter
     * 也可以直接继承 UsernamePasswordAuthenticationFilter。
     * @Author chenjiacheng
     * @Date 2019/6/1 11:47
     * @param request
     * @param response
     * @return org.springframework.security.core.Authentication
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        /*
        // 添加验证码校验功能
        String captcha = request.getParameter("captcha");
        if (!checkCaptcha(captcha)) {
            throw new AuthenticationException("Invalid captcha!");
        }
        */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        username = Objects.isNull(username) ? "" : username.trim();
        password = Objects.isNull(password) ? "" : password;

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
