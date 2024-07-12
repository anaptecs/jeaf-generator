/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Objects;

public class ParentBeanParamType {
  /**
   * Constant for the name of attribute "novaKey".
   */
  public static final String NOVAKEY = "novaKey";

  /**
   * Constant for the name of attribute "tkID".
   */
  public static final String TKID = "tkID";

  private String novaKey;

  private String tkID;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public ParentBeanParamType( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentBeanParamType( Builder pBuilder ) {
    // Read attribute values from builder.
    novaKey = pBuilder.novaKey;
    tkID = pBuilder.tkID;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ParentBeanParamType.
   *
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   *
   * @return {@link com.anaptecs.spring.base.ParentBeanParamType}
   */
  public static ParentBeanParamType of( String pNovaKey, String pTkID ) {
    ParentBeanParamType.Builder lBuilder = ParentBeanParamType.builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ParentBeanParamType</code>.
   */
  public static class Builder {
    private String novaKey;

    private String tkID;

    /**
     * Use {@link ParentBeanParamType#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ParentBeanParamType#builder(ParentBeanParamType)} instead of private constructor to create new
     * builder.
     */
    protected Builder( ParentBeanParamType pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setNovaKey(pObject.novaKey);
        this.setTkID(pObject.tkID);
      }
    }

    /**
     * Method sets attribute {@link #novaKey}.<br/>
     *
     * @param pNovaKey Value to which {@link #novaKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setNovaKey( String pNovaKey ) {
      // Assign value to attribute
      novaKey = pNovaKey;
      return this;
    }

    /**
     * Method sets attribute {@link #tkID}.<br/>
     *
     * @param pTkID Value to which {@link #tkID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setTkID( String pTkID ) {
      // Assign value to attribute
      tkID = pTkID;
      return this;
    }

    /**
     * Method creates a new instance of class ParentBeanParamType. The object will be initialized with the values of the
     * builder.
     *
     * @return ParentBeanParamType Created object. The method never returns null.
     */
    public ParentBeanParamType build( ) {
      return new ParentBeanParamType(this);
    }
  }

  /**
   * Method returns attribute {@link #novaKey}.<br/>
   *
   * @return {@link String} Value to which {@link #novaKey} is set.
   */
  public String getNovaKey( ) {
    return novaKey;
  }

  /**
   * Method sets attribute {@link #novaKey}.<br/>
   *
   * @param pNovaKey Value to which {@link #novaKey} should be set.
   */
  public void setNovaKey( String pNovaKey ) {
    // Assign value to attribute
    novaKey = pNovaKey;
  }

  /**
   * Method returns attribute {@link #tkID}.<br/>
   *
   * @return {@link String} Value to which {@link #tkID} is set.
   */
  public String getTkID( ) {
    return tkID;
  }

  /**
   * Method sets attribute {@link #tkID}.<br/>
   *
   * @param pTkID Value to which {@link #tkID} should be set.
   */
  public void setTkID( String pTkID ) {
    // Assign value to attribute
    tkID = pTkID;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(novaKey);
    lResult = lPrime * lResult + Objects.hashCode(tkID);
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
      ParentBeanParamType lOther = (ParentBeanParamType) pObject;
      lEquals = Objects.equals(novaKey, lOther.novaKey) && Objects.equals(tkID, lOther.tkID);
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
    lBuilder.append("novaKey: ");
    lBuilder.append(novaKey);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("tkID: ");
    lBuilder.append(tkID);
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
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}