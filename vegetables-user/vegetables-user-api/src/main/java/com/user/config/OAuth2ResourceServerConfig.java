package com.user.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


/**
 *
 * OAuth2资源服务器配置
 *
 * 资源服务器能够检查授权服务器发出的访问令牌的有效性
 * prePostEnabled 表示启用全局方法安全性配置
 * @Author chenjiacheng
 * @Date 2019/5/23 17:02
 */
@EnableResourceServer
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServerConfig extends GlobalMethodSecurityConfiguration {


    @Autowired
    private DataSource dataSource;



    /***
     * 令牌存储配置
     *
     * @Author chenjiacheng
     * @Date 2019/5/23 17:03
     * @param
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     */
    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }



    /***
     *
     * 此服务将使用授权服务器上的checkTokenEndPoint来验证AccessToken并从中获取Authentication对象
     *
     * @Author chenjiacheng
     * @Date 2019/5/23 17:13
     * @param
     * @return org.springframework.security.oauth2.provider.token.RemoteTokenServices
     */
    @Bean
    @Primary
    public RemoteTokenServices tokenServices(){

        RemoteTokenServices tokenServices = new RemoteTokenServices();

        tokenServices.setCheckTokenEndpointUrl(
                "http://localhost:8080/spring-security-oauth-server/oauth/check_token");
        tokenServices.setCheckTokenEndpointUrl("fooClientIdPassword");
        tokenServices.setClientSecret("secret");

        return tokenServices;
    }



        
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler(){
        return new OAuth2MethodSecurityExpressionHandler();
    }



}
