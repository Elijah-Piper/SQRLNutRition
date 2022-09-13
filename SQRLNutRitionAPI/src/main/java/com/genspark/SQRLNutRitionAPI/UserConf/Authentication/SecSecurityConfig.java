package com.genspark.SQRLNutRitionAPI.UserConf.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    DaoAuthenticationProvider authProvider;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authProvider);
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception  {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler);
    }
    private class CustomLogoutSuccessHandler extends
            SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(
                HttpServletRequest request,
                HttpServletResponse response,
                Authentication authentication)
                throws IOException, ServletException {

            String refererUrl = request.getHeader("Referer");

            super.onLogoutSuccess(request, response, authentication);
        }
    }
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
}
