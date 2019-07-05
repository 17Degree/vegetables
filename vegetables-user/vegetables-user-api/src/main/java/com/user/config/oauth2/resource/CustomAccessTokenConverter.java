package com.user.config.oauth2.resource;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

import java.util.Map;

//@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    public static String name = "自定义DefaultAccessTokenConverter";

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication authentication = super.extractAuthentication(claims);
        authentication.setDetails(claims);
        return authentication;
    }

}
