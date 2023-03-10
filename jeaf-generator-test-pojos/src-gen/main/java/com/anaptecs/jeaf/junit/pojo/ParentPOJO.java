/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = ChildPOJO.class, name = "ChildPOJO") })
public class ParentPOJO {
  /**
   * Constant for the name of attribute "parentAttribute".
   */
  public static final String PARENTATTRIBUTE = "parentAttribute";

  /**
   * Constant for the name of attribute "weirdAttribute".
   */
  @Deprecated
  public static final String WEIRDATTRIBUTE = "weirdAttribute";

  /**
   * Constant for the name of attribute "hello".
   */
  public static final String HELLO = "hello";

  private String parentAttribute;

  @Deprecated
  private byte weirdAttribute;

  private String hello;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ParentPOJO( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    parentAttribute = pBuilder.parentAttribute;
    weirdAttribute = pBuilder.weirdAttribute;
    hello = pBuilder.hello;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ParentPOJO objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ParentPOJO objects. The method never returns
   * null.
   */
  public static Builder builder( ParentPOJO pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ParentPOJO. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    private String parentAttribute;

    @Deprecated
    private byte weirdAttribute;

    private String hello;

    /**
     * Use {@link ParentPOJO#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ParentPOJO#builder(ParentPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ParentPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        parentAttribute = pObject.parentAttribute;
        weirdAttribute = pObject.weirdAttribute;
        hello = pObject.hello;
      }
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    public Builder setParentAttribute( String pParentAttribute ) {
      // Assign value to attribute
      parentAttribute = pParentAttribute;
      return this;
    }

    /**
     * Method sets the attribute "weirdAttribute".
     * 
     * @param pWeirdAttribute Value to which the attribute "weirdAttribute" should be set.
     */
    @Deprecated
    public Builder setWeirdAttribute( byte pWeirdAttribute ) {
      // Assign value to attribute
      weirdAttribute = pWeirdAttribute;
      return this;
    }

    /**
     * Method sets the attribute "hello".
     * 
     * @param pHello Value to which the attribute "hello" should be set.
     */
    public Builder setHello( String pHello ) {
      // Assign value to attribute
      hello = pHello;
      return this;
    }

    /**
     * Method creates a new instance of class ParentPOJO. The object will be initialized with the values of the builder.
     * 
     * @return ParentPOJO Created object. The method never returns null.
     */
    public ParentPOJO build( ) {
      return new ParentPOJO(this);
    }

    /**
     * Method creates a new validated instance of class ParentPOJO. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return ParentPOJO Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ParentPOJO buildValidated( ) throws ConstraintViolationException {
      ParentPOJO lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #parentAttribute}.<br/>
   * 
   * @return {@link String} Value to which {@link #parentAttribute} is set.
   */
  public String getParentAttribute( ) {
    return parentAttribute;
  }

  /**
   * Method sets attribute {@link #parentAttribute}.<br/>
   * 
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   */
  public void setParentAttribute( String pParentAttribute ) {
    // Assign value to attribute
    parentAttribute = pParentAttribute;
  }

  /**
   * Method returns attribute {@link #weirdAttribute}.<br/>
   * 
   * @return byte Value to which {@link #weirdAttribute} is set.
   */
  @Deprecated
  public byte getWeirdAttribute( ) {
    return weirdAttribute;
  }

  /**
   * Method sets attribute {@link #weirdAttribute}.<br/>
   * 
   * @param pWeirdAttribute Value to which {@link #weirdAttribute} should be set.
   */
  @Deprecated
  public void setWeirdAttribute( byte pWeirdAttribute ) {
    // Assign value to attribute
    weirdAttribute = pWeirdAttribute;
  }

  /**
   * Method returns attribute {@link #hello}.<br/>
   * 
   * @return {@link String} Value to which {@link #hello} is set.
   */
  public String getHello( ) {
    return hello;
  }

  /**
   * Method sets attribute {@link #hello}.<br/>
   * 
   * @param pHello Value to which {@link #hello} should be set.
   */
  public void setHello( String pHello ) {
    // Assign value to attribute
    hello = pHello;
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
    lBuilder.append("parentAttribute: ");
    lBuilder.append(parentAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("weirdAttribute: ");
    lBuilder.append(weirdAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("hello: ");
    lBuilder.append(hello);
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
