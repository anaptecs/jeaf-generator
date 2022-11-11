package com.anaptecs.spring.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.zalando.problem.ProblemModule;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.impl.kryo.KryoCompositeTypeConverter;
import com.anaptecs.spring.base.serializers.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Jackson Object Mapper configuration that is supposed to be used in context of OSDM.
 */
@Configuration
public class ObjectMapperConfig {
  @Bean
  @Primary
  public ObjectMapper objectMapper( ) {
    ObjectMapper lObjectMapper = ObjectMapperFactory.createObjectMapper(new KryoCompositeTypeConverter());
    lObjectMapper.registerModule(new ProblemModule());
    lObjectMapper.registerModule(new JavaTimeModule());
    lObjectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return lObjectMapper;
  }

  @Bean
  @Primary
  public CompositeTypeConverter compositeTypeConverter( ) {
    return new KryoCompositeTypeConverter();
  }
}
