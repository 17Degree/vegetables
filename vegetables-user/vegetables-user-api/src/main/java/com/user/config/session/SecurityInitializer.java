package com.user.config.session;

import com.user.config.security.CustomSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(CustomSecurityConfig.class, HttpSessionConfig.class);
    }
}