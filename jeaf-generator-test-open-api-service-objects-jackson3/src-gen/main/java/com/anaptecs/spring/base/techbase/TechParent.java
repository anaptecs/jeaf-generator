/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@Valid
@JsonDeserialize(builder = TechParent.Builder.class)
public class TechParent {
  @NotNull
  private String techAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechParent( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    techAttribute = pBuilder.techAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class TechParent.
   *
   *
   * @param pTechAttribute Value to which {@link #techAttribute} should be set.
   *
   * @return {@link TechParent}
   */
  public static TechParent of( String pTechAttribute ) {
    var lBuilder = TechParent.builder();
    lBuilder.setTechAttribute(pTechAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TechParent</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String techAttribute;

    /**
     * Use {@link TechParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechParent#builder(TechParent)} instead of private constructor to create new builder.
     */
    protected Builder( TechParent pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTechAttribute(pObject.techAttribute);
      }
    }

    /**
     * Method sets attribute {@link #techAttribute}.<br/>
     *
     * @param pTechAttribute Value to which {@link #techAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTechAttribute( @MyNotNullProperty String pTechAttribute ) {
      // Assign value to attribute
      techAttribute = pTechAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class TechParent. The object will be initialized with the values of the builder.
     *
     * @return TechParent Created object. The method never returns null.
     */
    public TechParent build( ) {
      return new TechParent(this);
    }

    /**
     * Method creates a new validated instance of class TechParent. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return TechParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TechParent buildValidated( ) throws ConstraintViolationException {
      TechParent lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #techAttribute}.<br/>
   *
   * @return {@link String} Value to which {@link #techAttribute} is set.
   */
  @MyNotNullProperty
  public String getTechAttribute( ) {
    return techAttribute;
  }

  /**
   * Method sets attribute {@link #techAttribute}.<br/>
   *
   * @param pTechAttribute Value to which {@link #techAttribute} should be set.
   */
  public void setTechAttribute( @MyNotNullProperty String pTechAttribute ) {
    // Assign value to attribute
    techAttribute = pTechAttribute;
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
    lBuilder.append(pIndent);
    lBuilder.append("techAttribute: ");
    lBuilder.append(techAttribute);
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
   * @return {@link Builder} New builder that can be used to create new TechParent objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}