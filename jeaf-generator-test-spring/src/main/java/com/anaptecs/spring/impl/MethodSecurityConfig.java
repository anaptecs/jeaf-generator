package com.anaptecs.spring.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = false, jsr250Enabled = true, prePostEnabled = false)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}
