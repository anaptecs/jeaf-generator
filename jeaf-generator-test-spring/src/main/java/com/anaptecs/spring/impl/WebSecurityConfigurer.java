package com.anaptecs.spring.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfigurer {
  @Bean
  public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
    http.authorizeRequests().antMatchers("**").permitAll().and().anonymous();
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}