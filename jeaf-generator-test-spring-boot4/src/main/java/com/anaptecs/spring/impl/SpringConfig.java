package com.anaptecs.spring.impl;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.jeaf.rest.composite.impl.kryo.KryoCompositeTypeConverter;
import com.anaptecs.spring.base.serializers.v3.ObjectMapperFactoryV3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tools.jackson.databind.ObjectMapper;

/**
 * Jackson Object Mapper configuration that is supposed to be used in context of OSDM.
 */
@Configuration
public class SpringConfig {
  @Bean
  @Primary
  public ObjectMapper objectMapper( ) {
    return ObjectMapperFactoryV3.createObjectMapper(new KryoCompositeTypeConverter());
  }

  @Bean
  @Primary
  public CompositeTypeConverter compositeTypeConverter( ) {
    return new KryoCompositeTypeConverter();
  }
}
