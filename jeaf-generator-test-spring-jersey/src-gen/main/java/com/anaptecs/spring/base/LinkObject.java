/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LinkObject.Builder.class)
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
  protected LinkObject( Builder pBuilder ) {
    // Read attribute values from builder.
    href = pBuilder.href;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LinkObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
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
    var lBuilder = LinkObject.builder();
    lBuilder.setHref(pHref);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>LinkObject</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String href;

    /**
     * Use {@link LinkObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link LinkObject#builder(LinkObject)} instead of private constructor to create new builder.
     */
    protected Builder( LinkObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setHref(pObject.href);
      }
    }

    /**
     * Method sets attribute {@link #href}.<br/>
     *
     * @param pHref Value to which {@link #href} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setHref( String pHref ) {
      // Assign value to attribute
      href = pHref;
      return this;
    }

    /**
     * Method creates a new instance of class LinkObject. The object will be initialized with the values of the builder.
     *
     * @return LinkObject Created object. The method never returns null.
     */
    public LinkObject build( ) {
      return new LinkObject(this);
    }
  }

  /**
   * Method returns attribute {@link #href}.<br/>
   *
   * @return {@link String} Value to which {@link #href} is set.
   */
  public String getHref( ) {
    return href;
  }

  /**
   * Method sets attribute {@link #href}.<br/>
   *
   * @param pHref Value to which {@link #href} should be set.
   */
  public void setHref( String pHref ) {
    // Assign value to attribute
    href = pHref;
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}