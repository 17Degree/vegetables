package com.user.config.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);


    public CustomAuthenticationFailureHandler() {
    }

    /**
     * 通过检查异常类型实现页面跳转控制
     */
    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException {

        logger.info("--------------------登录失败++++++++++++++++++++++");

        httpServletResponse.getWriter().append(e.getMessage());
        httpServletResponse.setStatus(401);
//        if (e instanceof UsernameNotFoundException) {
//            httpServletResponse.sendRedirect("/login/error?inexistent");
//        } else if (e instanceof DisabledException) {
//            httpServletResponse.sendRedirect("/login/error?disabled");
//        } else if (e instanceof AccountExpiredException) {
//            httpServletResponse.sendRedirect("/login/error?expired");
//        } else if (e instanceof LockedException) {
//            httpServletResponse.sendRedirect("/login/error?locked");
//        } else {
//            httpServletResponse.sendRedirect("/login/error?error");
//        }


    }
}
