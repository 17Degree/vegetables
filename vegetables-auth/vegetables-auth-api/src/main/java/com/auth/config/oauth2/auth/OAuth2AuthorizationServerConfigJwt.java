package com.auth.config.oauth2.auth;


import com.auth.config.oauth2.common.CustomDefaultTokenServices;
import com.auth.config.oauth2.common.CustomJwtAccessTokenConverter;
import com.auth.config.oauth2.common.CustomJwtTokenStore;
import com.security.config.CustomAuthenticationManager;
import com.security.config.CustomPasswordEncoder;
import com.security.config.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigJwt extends AuthorizationServerConfigurerAdapter{

    /**
     * 认证方式
     */
    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private CustomDefaultTokenServices customDefaultTokenServices;
    @Autowired
    private CustomJwtAccessTokenConverter customJwtAccessTokenConverter;
    @Autowired
    private CustomJwtTokenStore customJwtTokenStore;

    public OAuth2AuthorizationServerConfigJwt(){

        System.out.println("");
    }


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

        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(new CustomPasswordEncoder());
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
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception { // @formatter:off

        clients.inMemory()
                .withClient("sampleClientId")
                .authorizedGrantTypes("implicit", "refresh_token")
                .scopes("read", "write", "foo", "bar")
                .autoApprove(true)
                .accessTokenValiditySeconds(3600)
                .redirectUris("http://127.0.0.1:8061/callback/temp1","http://127.0.0.1:8061/callback/temp2")

                .and()
                .withClient("fooClientIdPassword")
                .secret("secret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
                .scopes("foo", "read", "write")
                .autoApprove(true)
                .accessTokenValiditySeconds(3600)       // 1 hour
                .refreshTokenValiditySeconds(2592000)  // 30 days
                .redirectUris("http://127.0.0.1:8061/callback/temp1")

                .and()
                .withClient("barClientIdPassword")
                .secret("secret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .scopes("bar", "read", "write")
                .accessTokenValiditySeconds(3600)       // 1 hour
                .refreshTokenValiditySeconds(2592000)  // 30 days

                .and()
                .withClient("testImplicitClientId")
                .authorizedGrantTypes("implicit")
                .scopes("read", "write", "foo", "bar")
                .autoApprove(true)
                .redirectUris("http://127.0.0.1:8061/callback/temp1");
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
        //tokenEnhancer()设置令牌
        //自定义TOKEN生成策略
        final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), customJwtAccessTokenConverter));

        endpoints
                .tokenStore(customJwtTokenStore)
                .tokenEnhancer(tokenEnhancerChain)
                .authenticationManager(customAuthenticationManager)
                .userDetailsService(customUserDetailsService);
    }



    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }




    /**
     * spring 默认 encodingId = bcrypt
     * @author farmer
     * @date 2019/7/1 22:32
     * @param
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        String encodingId = "noop";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
        encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
        encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());

        return new DelegatingPasswordEncoder(encodingId, encoders);
    }



}
