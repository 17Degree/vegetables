package com.user.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/***
 *
 * web配置
 * @Author chenjiacheng
 * @Date 2019/5/23 17:27
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.user.api"})
public class WebConfig implements WebMvcConfigurer {

}
