/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base.techbase;

import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = TechParent.TechParentBuilderImpl.class)
public class TechParent {
  /**
   * Constant for the name of attribute "techAttribute".
   */
  public static final String TECHATTRIBUTE = "techAttribute";

  private String techAttribute;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechParent( TechParentBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    techAttribute = pBuilder.techAttribute;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechParent objects.
   */
  public static TechParentBuilder<?, ?> builder( ) {
    return new TechParentBuilderImpl();
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
    TechParentBuilder<?, ?> lBuilder = TechParent.builder();
    lBuilder.setTechAttribute(pTechAttribute);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>TechParent</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class TechParentBuilder<T extends TechParent, B extends TechParentBuilder<T, B>> {
    private String techAttribute;

    /**
     * Use {@link TechParentBuilder#builder()} instead of private constructor to create new builder.
     */
    protected TechParentBuilder( ) {
    }

    /**
     * Use {@link TechParentBuilder#builder(TechParent)} instead of private constructor to create new builder.
     */
    protected TechParentBuilder( TechParent pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTechAttribute(pObject.techAttribute);
      }
    }

    /**
     * Method sets attribute {@link #techAttribute}.<br/>
     *
     * @param pTechAttribute Value to which {@link #techAttribute} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setTechAttribute( @MyNotNullProperty String pTechAttribute ) {
      // Assign value to attribute
      techAttribute = pTechAttribute;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class TechParent. The object will be initialized with the values of the builder.
     *
     * @return TechParent Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class TechParentBuilderImpl extends TechParentBuilder<TechParent, TechParentBuilderImpl> {
    protected TechParentBuilderImpl( ) {
    }

    protected TechParentBuilderImpl( TechParent pObject ) {
      super(pObject);
    }

    @Override
    protected TechParentBuilderImpl self( ) {
      return this;
    }

    @Override
    public TechParent build( ) {
      TechParent lObject = new TechParent(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(techAttribute);
    return lResult;
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
      TechParent lOther = (TechParent) pObject;
      lEquals = Objects.equals(techAttribute, lOther.techAttribute);
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
  public TechParentBuilder<?, ?> toBuilder( ) {
    return new TechParentBuilderImpl(this);
  }
}