package com.anaptecs.spring.impl;

import com.anaptecs.jeaf.jersey.impl.time.JavaTimeConverterProvider;
import com.anaptecs.spring.service.resource.PathlessServiceResource;
import com.anaptecs.spring.service.resource.ProductServiceResource;
import com.anaptecs.spring.service.resource.RESTProductServiceResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig( ) {
    register(ProductServiceResource.class);
    register(RESTProductServiceResource.class);
    register(PathlessServiceResource.class);
    register(JavaTimeConverterProvider.class);
  }
}