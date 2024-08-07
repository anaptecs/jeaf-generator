/**
 * Copyright 2004 - 2019 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.fwk.tools.message.generator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.anaptecs.jeaf.tools.annotations.ToolsImplementation;
import com.anaptecs.jeaf.tools.api.validation.ValidationResult;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

@ToolsImplementation(toolsInterface = ValidationTools.class)
public class NoValidationToolsImpl implements ValidationTools {

  @Override
  public boolean requiresRequestValidation( Method pMethod ) {
    return false;
  }

  @Override
  public boolean requiresResponseValidation( Method pMethod ) {
    return false;
  }

  @Override
  public boolean requiresValidation( Field pField ) {
    return false;
  }

  @Override
  public boolean isValidationAnnotation( Annotation pAnnotation ) {
    return false;
  }

  @Override
  public boolean containsValidationAnnotation( List<Annotation> pAnnotations ) {
    return false;
  }

  @Override
  public boolean containsValidationAnnotation( Annotation[] pAnnotations ) {
    return false;
  }

  @Override
  public <T> ValidationResult<T> validate( T pObject ) {
    return null;
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validateObject( T pObject ) {
    return null;
  }

  @Override
  public void enforceObjectValidation( Object pObject ) throws ConstraintViolationException {
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<ConstraintViolation<?>> validateObjects( Object[] pObjects ) {
    return null;
  }

  @Override
  public Validator getValidator( ) {
    return null;
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validateObjects( Collection<T> pObjects ) {
    return null;
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validateParameters( T pObject, Method pMethod, Object[] pParameterValues,
      Class<?>... pGroups ) {
    return null;
  }

  @Override
  public <T> void enforceParameterValidation( T pObject, Method pMethod, Object[] pParameterValues,
      Class<?>... pGroups )
    throws ConstraintViolationException {
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validateReturnValue( T pObject, Method pMethod, Object pReturnValue,
      Class<?>... pGroups ) {
    return null;
  }

  @Override
  public <T> void enforceReturnValueValidation( T pObject, Method pMethod, Object pReturnValue, Class<?>... pGroups ) {
  }

}
