package com.user.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;


@EnableWebSecurity
@Configuration
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;

//    @Autowired
//    private AbstractAuthenticationProcessingFilter authenticationProcessingFilter;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.eraseCredentials(false);

        auth.parentAuthenticationManager(customAuthenticationManager);

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
        web.ignoring().antMatchers("/css/**", "/js/**", "/lib/**", "/index.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .exceptionHandling()//.authenticationEntryPoint(authenticationEntryPoint)
//                .and()
                // 允许所有人访问 /login/page
                .authorizeRequests().antMatchers("/callback/**","/login/**","/test/**").permitAll()
                // 任意访问请求都必须先通过认证
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .and()
                //配置request缓存方式
                .requestCache().requestCache(new HttpSessionRequestCache())
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
