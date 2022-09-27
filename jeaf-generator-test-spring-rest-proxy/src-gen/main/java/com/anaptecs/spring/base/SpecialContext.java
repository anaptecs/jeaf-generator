/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Locale;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class SpecialContext extends Context {
  /**
   * Constant for the name of attribute "specificHeader".
   */
  public static final String SPECIFICHEADER = "specificHeader";

  /**
   * 
   */
  private String specificHeader;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public SpecialContext( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SpecialContext( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    specificHeader = pBuilder.specificHeader;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects. The method never returns
   * null.
   */
  public static Builder builder( SpecialContext pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SpecialContext. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Context.Builder {
    /**
     * 
     */
    private String specificHeader;

    /**
     * Use {@link SpecialContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link SpecialContext#builder(SpecialContext)} instead of private constructor to create new builder.
     */
    protected Builder( SpecialContext pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        specificHeader = pObject.specificHeader;
      }
    }

    /**
     * Method sets the attribute "accessToken".
     * 
     * @param pAccessToken Value to which the attribute "accessToken" should be set.
     */
    @Override
    public Builder setAccessToken( String pAccessToken ) {
      // Call super class implementation.
      super.setAccessToken(pAccessToken);
      return this;
    }

    /**
     * Method sets the attribute "language".
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
     */
    @Override
    public Builder setLanguage( Locale pLanguage ) {
      // Call super class implementation.
      super.setLanguage(pLanguage);
      return this;
    }

    /**
     * Method sets the attribute "resellerID".
     * 
     * @param pResellerID Value to which the attribute "resellerID" should be set.
     */
    @Override
    public Builder setResellerID( long pResellerID ) {
      // Call super class implementation.
      super.setResellerID(pResellerID);
      return this;
    }

    /**
     * Method sets the attribute "pathParam".
     * 
     * @param pPathParam Value to which the attribute "pathParam" should be set.
     */
    @Override
    public Builder setPathParam( long pPathParam ) {
      // Call super class implementation.
      super.setPathParam(pPathParam);
      return this;
    }

    /**
     * Method sets the attribute "queryParam".
     * 
     * @param pQueryParam Value to which the attribute "queryParam" should be set.
     */
    @Override
    public Builder setQueryParam( String pQueryParam ) {
      // Call super class implementation.
      super.setQueryParam(pQueryParam);
      return this;
    }

    /**
     * Method sets the attribute "specificHeader".
     * 
     * @param pSpecificHeader Value to which the attribute "specificHeader" should be set.
     */
    public Builder setSpecificHeader( String pSpecificHeader ) {
      // Assign value to attribute
      specificHeader = pSpecificHeader;
      return this;
    }

    /**
     * Method creates a new instance of class SpecialContext. The object will be initialized with the values of the
     * builder.
     * 
     * @return SpecialContext Created object. The method never returns null.
     */
    public SpecialContext build( ) {
      return new SpecialContext(this);
    }
  }

  /**
   * Method returns the attribute "specificHeader".
   * 
   * 
   * @return String Value to which the attribute "specificHeader" is set.
   */
  public String getSpecificHeader( ) {
    return specificHeader;
  }

  /**
   * Method sets the attribute "specificHeader".
   * 
   * 
   * @param pSpecificHeader Value to which the attribute "specificHeader" should be set.
   */
  public void setSpecificHeader( String pSpecificHeader ) {
    // Assign value to attribute
    specificHeader = pSpecificHeader;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append("specificHeader: ");
    lBuilder.append(specificHeader);
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}
