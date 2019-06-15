package com.user.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * 登录成功后的操作代替默认的处理器 {@link SimpleUrlAuthenticationSuccessHandler}
 * @Author chenjiacheng
 * @Date 2019/6/11 11:35
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {

        logger.info("--------------------登录成功++++++++++++++++++++++");

        httpServletResponse.getWriter().append("OK");
        httpServletResponse.setStatus(200);

        //httpServletResponse.sendRedirect("/login/success");
        // 可以自定义登录成功后的其它动作，如记录用户登录日志、发送上线消息等
    }

}
