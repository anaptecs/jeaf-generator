/**
 * Copyright 2004 - 2023 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anaptecs.jeaf.rest.composite.api.CompositeTypeConverter;
import com.anaptecs.spring.base.BookingID;

@Component
public class InitComponent {
  @Autowired
  public void setSerializer( CompositeTypeConverter pSerializer ) {
    BookingID.setSerializer(pSerializer);
  }
}
