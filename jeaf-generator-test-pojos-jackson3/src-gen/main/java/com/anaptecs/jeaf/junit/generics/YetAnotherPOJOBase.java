/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.generics;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = YetAnotherPOJO.Builder.class)
public abstract class YetAnotherPOJOBase {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected YetAnotherPOJOBase( BuilderBase pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
  }

  /**
   * Class implements builder to create a new instance of class YetAnotherPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BuilderBase {
    /**
     * Use {@link YetAnotherPOJO.builder()} instead of protected constructor to create new builder.
     */
    protected BuilderBase( ) {
    }

    /**
     * Use {@link YetAnotherPOJO.builder(YetAnotherPOJO)} instead of protected constructor to create new builder.
     */
    protected BuilderBase( YetAnotherPOJOBase pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
      }
    }

    /**
     * Method creates a new instance of class YetAnotherPOJO. The object will be initialized with the values of the
     * builder.
     *
     * @return YetAnotherPOJO Created object. The method never returns null.
     */
    public YetAnotherPOJO build( ) {
      return new YetAnotherPOJO(this);
    }

    /**
     * Method creates a new validated instance of class YetAnotherPOJO. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return YetAnotherPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public YetAnotherPOJO buildValidated( ) throws ConstraintViolationException {
      YetAnotherPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Convenience method to create new instance of class YetAnotherPOJO.
   *
   *
   * @return {@link YetAnotherPOJO}
   */
  public static YetAnotherPOJO of( ) {
    var lBuilder = YetAnotherPOJO.builder();
    return lBuilder.build();
  }

  /**
   * @return {@link GenericResponsePOJO<MyBusinessObject>}
   */
  public abstract GenericResponsePOJO<MyBusinessObject> getResponse( );

  @Override
  public int hashCode( ) {
    return 1;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      lEquals = true;
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new YetAnotherPOJO objects. The method never returns
   * null.
   */
  public YetAnotherPOJO.Builder toBuilder( ) {
    return new YetAnotherPOJO.Builder((YetAnotherPOJO) this);
  }
}