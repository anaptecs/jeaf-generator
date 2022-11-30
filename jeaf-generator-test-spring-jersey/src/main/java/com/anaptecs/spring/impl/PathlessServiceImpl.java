/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import org.springframework.stereotype.Service;

import com.anaptecs.spring.service.PathlessService;

@Service
public class PathlessServiceImpl implements PathlessService {

  @Override
  public String getSomething( ) {
    return "Something";
  }
}
