package com.user.config.oauth2.common;


import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

@Component
public class CustomJwtTokenStore extends JwtTokenStore{

    /**
     * Create a JwtTokenStore with this token enhancer (should be shared with the DefaultTokenServices if used).
     *
     * @param jwtTokenEnhancer
     */
    public CustomJwtTokenStore(CustomJwtAccessTokenConverter jwtTokenEnhancer) {

        super(jwtTokenEnhancer);
    }
}
