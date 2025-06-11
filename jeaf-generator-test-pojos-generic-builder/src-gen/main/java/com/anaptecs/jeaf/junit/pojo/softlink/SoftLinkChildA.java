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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonDeserialize(builder = SoftLinkChildA.SoftLinkChildABuilderImpl.class)
public class SoftLinkChildA extends SoftLinkParent {
  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkChildA( SoftLinkChildABuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildA objects.
   */
  public static SoftLinkChildABuilder<?, ?> builder( ) {
    return new SoftLinkChildABuilderImpl();
  }

  /**
   * Convenience method to create new instance of class SoftLinkChildA.
   *
   *
   * @param pPartners Value to which {@link #partners} should be set.
   *
   * @param pThePartner Value to which {@link #thePartner} should be set.
   *
   * @return {@link SoftLinkChildA}
   */
  public static SoftLinkChildA of( Set<SoftLinkID> pPartnerIDs, SoftLinkID pThePartnerID ) {
    SoftLinkChildABuilder<?, ?> lBuilder = SoftLinkChildA.builder();
    lBuilder.setPartnerIDs(pPartnerIDs);
    lBuilder.setThePartnerID(pThePartnerID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SoftLinkChildA</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class SoftLinkChildABuilder<T extends SoftLinkChildA, B extends SoftLinkChildABuilder<T, B>>
      extends SoftLinkParentBuilder<T, B> {
    /**
     * Use {@link SoftLinkChildABuilder#builder()} instead of private constructor to create new builder.
     */
    protected SoftLinkChildABuilder( ) {
      super();
    }

    /**
     * Use {@link SoftLinkChildABuilder#builder(SoftLinkChildA)} instead of private constructor to create new builder.
     */
    protected SoftLinkChildABuilder( SoftLinkChildA pObject ) {
      super(pObject);
    }

    /**
     * Method creates a new instance of class SoftLinkChildA. The object will be initialized with the values of the
     * builder.
     *
     * @return SoftLinkChildA Created object. The method never returns null.
     */
    public abstract T build( );

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

  static final class SoftLinkChildABuilderImpl
      extends SoftLinkChildABuilder<SoftLinkChildA, SoftLinkChildABuilderImpl> {
    protected SoftLinkChildABuilderImpl( ) {
    }

    protected SoftLinkChildABuilderImpl( SoftLinkChildA pObject ) {
      super(pObject);
    }

    @Override
    protected SoftLinkChildABuilderImpl self( ) {
      return this;
    }

    @Override
    public SoftLinkChildA build( ) {
      return new SoftLinkChildA(this);
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new SoftLinkChildA objects. The method never returns
   * null.
   */
  public SoftLinkChildABuilder<?, ?> toBuilder( ) {
    return new SoftLinkChildABuilderImpl(this);
  }
}