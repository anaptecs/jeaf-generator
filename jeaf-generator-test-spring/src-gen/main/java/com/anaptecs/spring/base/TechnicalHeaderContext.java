/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TechnicalHeaderContext {
  /**
   * Constant for the name of attribute "reseller".
   */
  public static final String RESELLER = "reseller";

  /**
   * 
   */
  private String reseller;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public TechnicalHeaderContext( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechnicalHeaderContext( Builder pBuilder ) {
    // Read attribute values from builder.
    reseller = pBuilder.reseller;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects. The method never
   * returns null.
   */
  public static Builder builder( TechnicalHeaderContext pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class TechnicalHeaderContext. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String reseller;

    /**
     * Use {@link TechnicalHeaderContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechnicalHeaderContext#builder(TechnicalHeaderContext)} instead of private constructor to create new
     * builder.
     */
    protected Builder( TechnicalHeaderContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        reseller = pObject.reseller;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects. The method
     * never returns null.
     */
    public static Builder newBuilder( TechnicalHeaderContext pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "reseller".
     * 
     * @param pReseller Value to which the attribute "reseller" should be set.
     */
    public Builder setReseller( String pReseller ) {
      // Assign value to attribute
      reseller = pReseller;
      return this;
    }

    /**
     * Method creates a new instance of class TechnicalHeaderContext. The object will be initialized with the values of
     * the builder.
     * 
     * @return TechnicalHeaderContext Created object. The method never returns null.
     */
    public TechnicalHeaderContext build( ) {
      return new TechnicalHeaderContext(this);
    }
  }

  /**
   * Method returns the attribute "reseller".
   * 
   * 
   * @return String Value to which the attribute "reseller" is set.
   */
  public String getReseller( ) {
    return reseller;
  }

  /**
   * Method sets the attribute "reseller".
   * 
   * 
   * @param pReseller Value to which the attribute "reseller" should be set.
   */
  public void setReseller( String pReseller ) {
    // Assign value to attribute
    reseller = pReseller;
  }

  /**
   * Method returns map with all custom headers that were added
   * 
   * @return {@link Map} Map with all custom headers. The method never returns null. The returned map is unmodifiable.
   */
  public Map<String, String> getCustomHeaders( ) {
    return Collections.unmodifiableMap(customHeaders);
  }

  /**
   * Method adds the passed values as custom headers. The passed name and value of the http header must be compliant
   * with guidelines about http headers.
   * 
   * @param pHeaderName Name of the HTTP header. The parameter must not be null,
   * @param pHeaderValue Value of the http header the parameter may be null.
   */
  public void addCustomHeader( String pHeaderName, String pHeaderValue ) {
    if (pHeaderName != null) {
      customHeaders.put(pHeaderName, pHeaderValue);
    }
    else {
      throw new IllegalArgumentException("Parameter 'pHeaderName' must not be null.");
    }
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
    lBuilder.append("reseller: ");
    lBuilder.append(reseller);
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
