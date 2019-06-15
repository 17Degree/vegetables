package com.user.config.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer {

    {

        System.out.println("+++++++++++Initializer++++++++++++++");

    }

}
