/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class LocalBeanParamType {
  /**
   * Constant for the name of attribute "localKey".
   */
  public static final String LOCALKEY = "localKey";

  /**
   * Constant for the name of attribute "localID".
   */
  public static final String LOCALID = "localID";

  /**
   * 
   */
  private String localKey;

  /**
   * 
   */
  private String localID;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public LocalBeanParamType( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LocalBeanParamType( Builder pBuilder ) {
    // Read attribute values from builder.
    localKey = pBuilder.localKey;
    localID = pBuilder.localID;
  }

  /**
   * Class implements builder to create a new instance of class LocalBeanParamType. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String localKey;

    /**
     * 
     */
    private String localID;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(LocalBeanParamType)} instead of private constructor to create new builder.
     */
    protected Builder( LocalBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        localKey = pObject.localKey;
        localID = pObject.localID;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new LocalBeanParamType objects. The method never
     * returns null.
     */
    public static Builder newBuilder( LocalBeanParamType pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "localKey".
     * 
     * @param pLocalKey Value to which the attribute "localKey" should be set.
     */
    public Builder setLocalKey( String pLocalKey ) {
      // Assign value to attribute
      localKey = pLocalKey;
      return this;
    }

    /**
     * Method sets the attribute "localID".
     * 
     * @param pLocalID Value to which the attribute "localID" should be set.
     */
    public Builder setLocalID( String pLocalID ) {
      // Assign value to attribute
      localID = pLocalID;
      return this;
    }

    /**
     * Method creates a new instance of class LocalBeanParamType. The object will be initialized with the values of the
     * builder.
     * 
     * @return LocalBeanParamType Created object. The method never returns null.
     */
    public LocalBeanParamType build( ) {
      return new LocalBeanParamType(this);
    }
  }

  /**
   * Method returns the attribute "localKey".
   * 
   * 
   * @return String Value to which the attribute "localKey" is set.
   */
  public String getLocalKey( ) {
    return localKey;
  }

  /**
   * Method sets the attribute "localKey".
   * 
   * 
   * @param pLocalKey Value to which the attribute "localKey" should be set.
   */
  public void setLocalKey( String pLocalKey ) {
    // Assign value to attribute
    localKey = pLocalKey;
  }

  /**
   * Method returns the attribute "localID".
   * 
   * 
   * @return String Value to which the attribute "localID" is set.
   */
  public String getLocalID( ) {
    return localID;
  }

  /**
   * Method sets the attribute "localID".
   * 
   * 
   * @param pLocalID Value to which the attribute "localID" should be set.
   */
  public void setLocalID( String pLocalID ) {
    // Assign value to attribute
    localID = pLocalID;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(this.getClass().getName());
    lBuilder.append('\n');
    lBuilder.append("Attributes:");
    lBuilder.append('\n');
    lBuilder.append("localKey: ");
    lBuilder.append(localKey);
    lBuilder.append('\n');
    lBuilder.append("localID: ");
    lBuilder.append(localID);
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