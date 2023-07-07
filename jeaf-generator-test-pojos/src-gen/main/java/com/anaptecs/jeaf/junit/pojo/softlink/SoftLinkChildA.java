/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SoftLinkChildA extends SoftLinkParent {
  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SoftLinkChildA( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkChildA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildA objects. The method never returns
   * null.
   */
  public static Builder builder( SoftLinkChildA pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkChildA</code>.
   */
  public static class Builder extends SoftLinkParent.Builder {
    /**
     * Use {@link SoftLinkChildA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SoftLinkChildA#builder(SoftLinkChildA)} instead of private constructor to create new builder.
     */
    protected Builder( SoftLinkChildA pObject ) {
      super(pObject);
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setPartners( Set<SoftLinkID> pPartners ) {
      // Call super class implementation.
      super.setPartners(pPartners);
      return this;
    }

    /**
     * Method sets association {@link #thePartner}.<br/>
     *
     * @param pThePartner Value to which {@link #thePartner} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setThePartner( SoftLinkID pThePartner ) {
      // Call super class implementation.
      super.setThePartner(pThePartner);
      return this;
    }

    /**
     * Method sets association {@link #readonlyPartner}.<br/>
     *
     * @param pReadonlyPartner Value to which {@link #readonlyPartner} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setReadonlyPartner( SoftLinkID pReadonlyPartner ) {
      // Call super class implementation.
      super.setReadonlyPartner(pReadonlyPartner);
      return this;
    }

    /**
     * Method creates a new instance of class SoftLinkChildA. The object will be initialized with the values of the
     * builder.
     *
     * @return SoftLinkChildA Created object. The method never returns null.
     */
    public SoftLinkChildA build( ) {
      return new SoftLinkChildA(this);
    }

    /**
     * Method creates a new validated instance of class SoftLinkChildA. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SoftLinkChildA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLinkChildA buildValidated( ) throws ConstraintViolationException {
      SoftLinkChildA lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  @Override
  public int hashCode( ) {
    return super.hashCode();
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
    else if (!super.equals(pObject)) {
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
}
