/**
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2023. All rights reserved.
 */
package com.anaptecs.spring.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.anaptecs.jeaf.rest.resource.api.CustomHeaderFilter;

@Configuration
public class CustomHeaderFilterConfig {

  @Bean
  @Primary
  CustomHeaderFilter createCustomHeaderFilter( ) {
    return CustomHeaderFilter.from("Reseller", "Custom-Header");
  }
}
