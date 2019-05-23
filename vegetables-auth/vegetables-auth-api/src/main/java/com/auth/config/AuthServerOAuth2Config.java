package com.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


/***
 *
 * 继承AuthorizationServerConfigurerAdapter并重写config方法 自定义授权配置
 * @EnableAuthorizationServer 注解用来配置OAuth2.0 授权服务机制 表示其是授权服务器
 * @Author chenjiacheng
 * @Date 2019/5/22 14:19
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("")
    private AuthenticationManager authenticationManager;


    /***
     *
     * 用来配置令牌端点(Token Endpoint)的安全约束
     * @Author chenjiacheng
     * @Date 2019/5/22 14:20
     * @param security
     * @return void
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }


    /***
     * 配置客户端详情信息
     * 客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     * @Author chenjiacheng
     * @Date 2019/5/22 14:21
     * @param clients
     * @return void
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.jdbc(dataSource)

                //隐式授权客户端类型类型
                .withClient("sampleClientId")
                .authorizedGrantTypes("implicit")
                .scopes("read")
                .autoApprove("true")

                //设置了三种授权类型
                .and()
                .withClient("clientIdPassword")
                .secret("secret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .scopes("read");
    }


    /***
     *
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     * @Author chenjiacheng
     * @Date 2019/5/22 17:14
     * @param endpoints
     * @return void
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        //为了使用password授权类型，需要连接并使用authenticationManagerBean
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
    }

    /***
     *
     * 为了持久化令牌选择JDBC_TOKEN_STORE
     * @Author chenjiacheng
     * @Date 2019/5/22 17:29
     * @param
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     */
    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }

}
