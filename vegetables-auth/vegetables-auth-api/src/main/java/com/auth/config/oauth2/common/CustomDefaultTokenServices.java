package com.auth.config.oauth2.common;


import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Component;

@Component
public class CustomDefaultTokenServices extends DefaultTokenServices {

    public static String name = "自定义DefaultTokenServices";

    public CustomDefaultTokenServices(CustomJwtTokenStore tokenStore){

        super.setTokenStore(tokenStore);
        super.setSupportRefreshToken(true);
    }


}
