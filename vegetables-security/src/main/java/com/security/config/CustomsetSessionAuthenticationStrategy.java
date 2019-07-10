package com.security.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * 自定义session管理器
 * @Author chenjiacheng
 * @Date 2019/6/4 11:26
 */
@Component
public class CustomsetSessionAuthenticationStrategy implements SessionAuthenticationStrategy, HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(CustomsetSessionAuthenticationStrategy.class);

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) throws SessionAuthenticationException {

        System.out.println(authentication);
        System.out.println(request);
        System.out.println(response);

        logger.info("+++++++++++++onAuthentication+++++++++++++ sessionId:" + request.getSession(false).getId());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("+++++++++++++sessionCreated+++++++++++++ sessionId:" + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("----------sessionDestroyed---------- sessionId:" + se.getSession().getId());
    }
}
