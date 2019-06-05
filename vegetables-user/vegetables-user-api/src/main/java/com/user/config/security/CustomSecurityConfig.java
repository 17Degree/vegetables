package com.user.config.security;

import com.user.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;

//    @Autowired
//    private AbstractAuthenticationProcessingFilter authenticationProcessingFilter;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.eraseCredentials(false);
    }



    /**
     * 配置静态文件路由 表示不处理权限认证
     * @Author chenjiacheng
     * @Date 2019/6/4 14:44
     * @param web
     * @return void
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()//.authenticationEntryPoint(authenticationEntryPoint)
                .and()
                // 允许所有人访问 /login/page
                .authorizeRequests().antMatchers("/oauth/**","/login/**").permitAll()
                // 任意访问请求都必须先通过认证
                .anyRequest().authenticated()
                .and()
                //禁用CSRF
                .csrf().disable()
                // 启用 iframe 功能
                .headers().frameOptions().disable();
//                .and()
                // 将自定义的 AbstractAuthenticationProcessingFilter 加在 Spring 过滤器链中
                //.addFilterBefore(authenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
    }

//    @Bean
//    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
//        return new LoginUrlAuthenticationEntryPoint("/login/unAuthentication");
//    }
//









}
