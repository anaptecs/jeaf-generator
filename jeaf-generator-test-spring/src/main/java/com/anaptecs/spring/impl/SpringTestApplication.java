/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com.anaptecs.spring")
@Component
public class SpringTestApplication {
  public static void main( String[] pArgs ) {
    SpringApplication.run(SpringTestApplication.class);
  }
}