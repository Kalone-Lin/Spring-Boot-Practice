package com.kalone.mylog.security.config;

import com.kalone.mylog.security.util.MyPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

/**
 * spring security整合配置文件
 *
 * @author shelin 2021/02/25 10:12
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.authorizeRequests().antMatchers("/login").permitAll()
        .antMatchers("/").hasRole("ADMIN");
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
        // 内存里面放着
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                // 添加用户，密码，角色
                .withUser("admin").password("123456").roles("ADMIN")
                // 链式编程
                .and()
                .withUser("zl").password("123456").roles("primary");
    }

}
