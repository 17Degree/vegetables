package com.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class CustomWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.info("初始化容器");

        servletContext.setSessionTimeout(1);
    }
}
