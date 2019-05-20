package com.auth.config;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;


/***
 * 该AuthorizationServerTokenServices接口定义了管理OAuth 2.0令牌所需的操作
 *  1.创建访问令牌时，必须存储身份验证，以便接受访问令牌的资源可以在以后引用它。
 *  2.访问令牌用于加载用于授权其创建的身份验证。
 *
 * @Author chenjiacheng
 * @Date 2019/5/20 16:03
 */
@Component
public class CustomAuthorizationServerTokenServices implements AuthorizationServerTokenServices {

    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {


        return null;
    }

    @Override
    public OAuth2AccessToken refreshAccessToken(String refreshToken, TokenRequest tokenRequest) throws AuthenticationException {

        return null;
    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {

        return null;
    }
}
