package com.genspark.SQRLNutRitionAPI.UserConf.Authentication;

import com.genspark.SQRLNutRitionAPI.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
    LogoutSuccessHandler logoutSuccessHandler = new CustomLogoutSuccessHandler();
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    @Autowired
    UserDao userDao;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authProvider);
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception  {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/anonymous*").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/squirrel/**").permitAll()
                .antMatchers("/meal/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler);
    }
    @Bean
    public PasswordEncoder passwordEncoder()    {
        return new BCryptPasswordEncoder();
    }
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService((UserDetailsService) userDao);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
