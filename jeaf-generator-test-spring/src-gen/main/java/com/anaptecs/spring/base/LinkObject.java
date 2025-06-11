/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

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
@JsonDeserialize(builder = LinkObject.LinkObjectBuilderImpl.class)
public class LinkObject {
  /**
   * Constant for the name of attribute "href".
   */
  public static final String HREF = "href";

  private String href;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LinkObject( LinkObjectBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    href = pBuilder.href;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LinkObject objects.
   */
  public static LinkObjectBuilder<?, ?> builder( ) {
    return new LinkObjectBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class LinkObject.
   *
   *
   * @param pHref Value to which {@link #href} should be set.
   *
   * @return {@link LinkObject}
   */
  public static LinkObject of( String pHref ) {
    LinkObjectBuilder<?, ?> lBuilder = LinkObject.builder();
    lBuilder.setHref(pHref);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>LinkObject</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class LinkObjectBuilder<T extends LinkObject, B extends LinkObjectBuilder<T, B>> {
    private String href;

    /**
     * Use {@link LinkObjectBuilder#builder()} instead of private constructor to create new builder.
     */
    protected LinkObjectBuilder( ) {
    }

    /**
     * Use {@link LinkObjectBuilder#builder(LinkObject)} instead of private constructor to create new builder.
     */
    protected LinkObjectBuilder( LinkObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setHref(pObject.href);
      }
    }

    /**
     * Method sets attribute {@link #href}.<br/>
     *
     * @param pHref Value to which {@link #href} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setHref( @MyNotNullProperty String pHref ) {
      // Assign value to attribute
      href = pHref;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class LinkObject. The object will be initialized with the values of the builder.
     *
     * @return LinkObject Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class LinkObjectBuilderImpl extends LinkObjectBuilder<LinkObject, LinkObjectBuilderImpl> {
    protected LinkObjectBuilderImpl( ) {
    }

    protected LinkObjectBuilderImpl( LinkObject pObject ) {
      super(pObject);
    }

    @Override
    protected LinkObjectBuilderImpl self( ) {
      return this;
    }

    @Override
    public LinkObject build( ) {
      LinkObject lObject = new LinkObject(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #href}.<br/>
   *
   * @return {@link String} Value to which {@link #href} is set.
   */
  @MyNotNullProperty
  public String getHref( ) {
    return href;
  }

  /**
   * Method sets attribute {@link #href}.<br/>
   *
   * @param pHref Value to which {@link #href} should be set.
   */
  public void setHref( @MyNotNullProperty String pHref ) {
    // Assign value to attribute
    href = pHref;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(href);
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
      LinkObject lOther = (LinkObject) pObject;
      lEquals = Objects.equals(href, lOther.href);
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
    lBuilder.append("href: ");
    lBuilder.append(href);
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
   * @return {@link Builder} New builder that can be used to create new LinkObject objects. The method never returns
   * null.
   */
  public LinkObjectBuilder<?, ?> toBuilder( ) {
    return new LinkObjectBuilderImpl(this);
  }
}