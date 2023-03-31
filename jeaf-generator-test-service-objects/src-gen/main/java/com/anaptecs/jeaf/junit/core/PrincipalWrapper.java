/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import java.security.Principal;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PrincipalWrapper implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "lPrincipal".
   */
  public static final String LPRINCIPAL = "lPrincipal";

  private Principal lPrincipal;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PrincipalWrapper( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PrincipalWrapper( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    lPrincipal = pBuilder.lPrincipal;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PrincipalWrapper objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PrincipalWrapper objects. The method never
   * returns null.
   */
  public static Builder builder( PrincipalWrapper pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>PrincipalWrapper</code>.
   */
  public static class Builder {
    private Principal lPrincipal;

    /**
     * Use {@link PrincipalWrapper#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PrincipalWrapper#builder(PrincipalWrapper)} instead of private constructor to create new builder.
     */
    protected Builder( PrincipalWrapper pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        lPrincipal = pObject.lPrincipal;
      }
    }

    /**
     * Method sets attribute {@link #lPrincipal}.<br/>
     *
     * @param pLPrincipal Value to which {@link #lPrincipal} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLPrincipal( Principal pLPrincipal ) {
      // Assign value to attribute
      lPrincipal = pLPrincipal;
      return this;
    }

    /**
     * Method creates a new instance of class PrincipalWrapper. The object will be initialized with the values of the
     * builder.
     *
     * @return PrincipalWrapper Created object. The method never returns null.
     */
    public PrincipalWrapper build( ) {
      return new PrincipalWrapper(this);
    }

    /**
     * Method creates a new validated instance of class PrincipalWrapper. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return PrincipalWrapper Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PrincipalWrapper buildValidated( ) throws ConstraintViolationException {
      PrincipalWrapper lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #lPrincipal}.<br/>
   *
   * @return {@link Principal} Value to which {@link #lPrincipal} is set.
   */
  public Principal getLPrincipal( ) {
    return lPrincipal;
  }

  /**
   * Method sets attribute {@link #lPrincipal}.<br/>
   *
   * @param pLPrincipal Value to which {@link #lPrincipal} should be set.
   */
  public void setLPrincipal( Principal pLPrincipal ) {
    // Assign value to attribute
    lPrincipal = pLPrincipal;
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
    lBuilder.append("lPrincipal: ");
    lBuilder.append(lPrincipal);
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
}
