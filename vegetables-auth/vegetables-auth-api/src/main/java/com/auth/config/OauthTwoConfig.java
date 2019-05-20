package com.auth.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;


@Configuration
@EnableAutoConfiguration
public class OauthTwoConfig {



    /***
     * 用来配置客户端详情服务（ClientDetailsService）
     * 客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
     * @Author chenjiacheng
     * @Date 2019/5/20 15:46
     * @param customClientDetailsService
     * @return org.springframework.security.oauth2.provider.ClientDetailsService
     */
    public ClientDetailsService clientDetailsService(CustomClientDetailsService customClientDetailsService){
        return customClientDetailsService;
    }




}
