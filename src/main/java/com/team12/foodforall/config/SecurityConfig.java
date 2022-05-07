package com.team12.foodforall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Heng Gao
 * @date: 27/03/2022 00:37
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/register").permitAll()  // allow any user to register
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").usernameParameter("email").permitAll().defaultSuccessUrl("/").failureUrl("/login?loginError=true")
                .and()
                    .logout().permitAll();

        http.csrf().disable();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
