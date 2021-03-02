package com.kalone.mylog.security.config;

import com.kalone.mylog.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security整合配置文件
 *
 * @author shelin 2021/02/25 10:12
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        //http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
        // 关闭CSRF跨域
        http.csrf().disable();
        // 配置登录功能
        http.formLogin().usernameParameter("userName").passwordParameter("passWord").loginPage("/login");
        // 注销成功跳转首页
        http.logout().logoutSuccessUrl("/login");
        // 开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }


    // 用户认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }

}
