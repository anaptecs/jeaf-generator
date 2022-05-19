package com.anaptecs.spring.impl;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.anaptecs.spring.service.ProductServiceResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig( ) {
    register(ProductServiceResource.class);
  }
}