package com.user.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


@EnableWebSecurity
@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AbstractAuthenticationProcessingFilter authenticationProcessingFilter;

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.eraseCredentials(false);

        //
//        //设置密码不需要加密 bCryptPasswordEncoder()=>NoOpPasswordEncoder.getInstance()
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                // 允许所有人访问 /login/page
                .authorizeRequests().antMatchers("/oauth/**","/login/unAuthentication").permitAll()
                // 任意访问请求都必须先通过认证
                .anyRequest().authenticated()
                .and()
                //禁用CSRF
                .csrf().disable()
                // 启用 iframe 功能
                .headers().frameOptions().disable()
//                .and()
                // 将自定义的 AbstractAuthenticationProcessingFilter 加在 Spring 过滤器链中
                .addFilterBefore(authenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
