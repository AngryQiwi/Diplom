package com.oblom.DiplomServer.jwt;

import com.oblom.DiplomServer.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/selfemployeeds/register").permitAll()
                .antMatchers("/selfemployeeds/auth").permitAll()
                .antMatchers( "/customers/register").permitAll()
                .antMatchers("/customers/auth").permitAll()
                .antMatchers("/customers/**").hasAnyRole("CUSTOMER", "ADMIN")
                .antMatchers("/selfemployeeds/**").hasAnyRole("SELFEMPLOYEED", "ADMIN")
                .antMatchers(HttpMethod.GET, "/selfemployeeds/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/customers/**").hasRole("SELFEMPLOYEED")
                .antMatchers("/**").permitAll()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
