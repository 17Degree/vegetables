package com.user.config.oauth2.auth;


import com.user.config.security.CustomAuthenticationManager;
import com.user.config.security.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

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

        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(passwordEncoder());
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
                .authorizedGrantTypes("implicit")
                .scopes("read", "write", "foo", "bar")
                .autoApprove(false)
                .accessTokenValiditySeconds(3600)
                .redirectUris("http://localhost:8083/","http://localhost:8086/")

                .and()
                .withClient("fooClientIdPassword")
                .secret("secret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
                .scopes("foo", "read", "write")
                .accessTokenValiditySeconds(3600)       // 1 hour
                .refreshTokenValiditySeconds(2592000)  // 30 days
                .redirectUris("http://www.example.com","http://localhost:8089/","http://localhost:8080/login/oauth2/code/custom","http://localhost:8080/ui-thymeleaf/login/oauth2/code/custom", "http://localhost:8080/authorize/oauth2/code/bael", "http://localhost:8080/login/oauth2/code/bael")

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
                .redirectUris("http://www.example.com");
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
        endpoints.tokenStore(tokenStore()).tokenEnhancer(null).authenticationManager(customAuthenticationManager);
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();

        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);

        return defaultTokenServices;
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
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        // final KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"), "mypass".toCharArray());
        // converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
        return converter;
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
