package com.user.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

import java.util.concurrent.ConcurrentHashMap;

/***
 * 基于spring-session-core-2.1.6.RELEASE
 *
 * 如果需要使用header头获取sessionId的方式请打开该配置
 * 如果需要session共享请将EnableSpringHttpSession改为EnableRedisHttpSession并引用spring-session-data-redis
 *
 * @Author chenjiacheng
 * @Date 2019/6/15 17:51
 */
//@Configuration
//@EnableSpringHttpSession
public class HttpSessionConfig {


    /**-----------------HTTP session ----------------------*/

    @Bean
    public MapSessionRepository mapSessionRepository() {
        MapSessionRepository mapSessionRepository = new MapSessionRepository(new ConcurrentHashMap<>());
        return mapSessionRepository;
    }

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        return new HeaderHttpSessionIdResolver("X-SESSION-ID-HEADER-HTTP");
    }

   /**-----------------web session 管理----------------------*/

//    @Bean
//    public ReactiveMapSessionRepository reactiveMapSessionRepository() {
//        ReactiveMapSessionRepository reactiveMapSessionRepository = new ReactiveMapSessionRepository(new ConcurrentHashMap<>());
//        return reactiveMapSessionRepository;
//    }

//    @Bean
//    public HeaderWebSessionIdResolver headerWebSessionIdResolver() {
//        HeaderWebSessionIdResolver resolver = new HeaderWebSessionIdResolver();
//        resolver.setHeaderName("X-SESSION-ID-HEADER-WEB");
//        return resolver;
//    }

//    @Bean
//    public CookieWebSessionIdResolver cookieWebSessionIdResolver() {
//        CookieWebSessionIdResolver resolver = new CookieWebSessionIdResolver();
//        resolver.setCookieName("X-SESSION-ID-COOKIE-WEB");
//        return resolver;
//    }

}