package com.anaptecs.spring.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.anaptecs.spring.base.serializers.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson Object Mapper configuration that is supposed to be used in context of OSDM.
 */
@Configuration
public class ObjectMapperConfig {
  @Bean
  @Primary
  public ObjectMapper objectMapper( ) {
    return ObjectMapperFactory.createObjectMapper();
  }
}
