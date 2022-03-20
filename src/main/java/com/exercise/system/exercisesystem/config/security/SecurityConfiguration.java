package com.exercise.system.exercisesystem.config.security;

import com.exercise.system.exercisesystem.auth.provider.EnrichedDaoAuthenticationProvider;
import com.exercise.system.exercisesystem.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.beans.factory.support.SimpleSecurityContextProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthService authService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new EnrichedDaoAuthenticationProvider(authService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(authService);
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/room", true)
                .permitAll();
    }

    @Bean
    public SecurityContextProvider securityContextProvider() {
        return new SimpleSecurityContextProvider();
    }
}
