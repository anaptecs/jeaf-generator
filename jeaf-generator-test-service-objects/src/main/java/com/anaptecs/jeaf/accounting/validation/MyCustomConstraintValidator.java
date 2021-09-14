/**
 * Copyright 2004 - 2018 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.accounting.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustomConstraintValidator implements ConstraintValidator<MyGeneratedCustomConstraint, String> {

  @Override
  public void initialize( MyGeneratedCustomConstraint pConstraintAnnotation ) {
    ConstraintValidator.super.initialize(pConstraintAnnotation);
  }

  @Override
  public boolean isValid( String pValue, ConstraintValidatorContext pContext ) {
    return false;
  }

}
