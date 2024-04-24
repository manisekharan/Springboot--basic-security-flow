package com.javatechie.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("user1")
                .roles("USER");
        auth.inMemoryAuthentication()
                .withUser("admin1")
                .password("admin1")
                .roles("ADMIN");
    }

    //Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //http.antMatcher("/secure/**").authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
        http.authorizeRequests()
                .antMatchers("/secure/rest/admin").hasRole("ADMIN")
                .antMatchers("/secure/rest/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/secure/rest/").permitAll()
                .and().formLogin();
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
