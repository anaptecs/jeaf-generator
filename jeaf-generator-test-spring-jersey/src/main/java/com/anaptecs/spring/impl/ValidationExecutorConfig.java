package com.anaptecs.spring.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.anaptecs.jeaf.rest.resource.api.ValidationExecutor;

@Configuration
public class ValidationExecutorConfig {
  @Bean
  @Primary
  ValidationExecutor createValidationExecutor( ) {
    return new ValidationExecutor() {

      @Override
      public void validateResponse( Class<?> pService, Object pResponseObject ) {
      }

      @Override
      public void validateRequest( Class<?> pService, Object... pRequestParameters ) {
      }
    };
  }

}
