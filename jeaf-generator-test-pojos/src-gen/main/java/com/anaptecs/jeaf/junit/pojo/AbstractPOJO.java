/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ImmutablePOJOParent.class, name = "ImmutablePOJOParent"),
  @JsonSubTypes.Type(value = ImmutableChildPOJO.class, name = "ImmutableChildPOJO"),
  @JsonSubTypes.Type(value = MutableChildPOJO.class, name = "MutableChildPOJO") })
public abstract class AbstractPOJO {
  /**
   * Constant for the name of attribute "abtractAttr".
   */
  public static final String ABTRACTATTR = "abtractAttr";

  /**
   * 
   */
  private String abtractAttr;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected AbstractPOJO( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbstractPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    abtractAttr = pBuilder.abtractAttr;
  }

  /**
   * Class implements builder to create a new instance of class AbstractPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static abstract class Builder {
    /**
     * 
     */
    private String abtractAttr;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(AbstractPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( AbstractPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        abtractAttr = pObject.abtractAttr;
      }
    }

    /**
     * Method sets the attribute "abtractAttr".
     * 
     * @param pAbtractAttr Value to which the attribute "abtractAttr" should be set.
     */
    public Builder setAbtractAttr( String pAbtractAttr ) {
      // Assign value to attribute
      abtractAttr = pAbtractAttr;
      return this;
    }
  }

  /**
   * Method returns the attribute "abtractAttr".
   * 
   * 
   * @return String Value to which the attribute "abtractAttr" is set.
   */
  public String getAbtractAttr( ) {
    return abtractAttr;
  }

  /**
   * Method sets the attribute "abtractAttr".
   * 
   * 
   * @param pAbtractAttr Value to which the attribute "abtractAttr" should be set.
   */
  public void setAbtractAttr( String pAbtractAttr ) {
    // Assign value to attribute
    abtractAttr = pAbtractAttr;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "abtractAttr", "" + abtractAttr));
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