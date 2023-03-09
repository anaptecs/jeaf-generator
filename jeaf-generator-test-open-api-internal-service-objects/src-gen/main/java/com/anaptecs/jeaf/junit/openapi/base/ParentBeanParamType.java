/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Valid
public class ParentBeanParamType implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @HeaderParam("novaKey")
  @NotNull
  private String novaKey;

  @HeaderParam("tkID")
  @NotNull
  private String tkID;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ParentBeanParamType( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ParentBeanParamType( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
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
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ParentBeanParamType objects. The method never
   * returns null.
   */
  public static Builder builder( ParentBeanParamType pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pNovaKey, String pTkID ) {
    Builder lBuilder = builder();
    lBuilder.setNovaKey(pNovaKey);
    lBuilder.setTkID(pTkID);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class ParentBeanParamType. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String novaKey;

    /**
     * 
     */
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
        novaKey = pObject.novaKey;
        tkID = pObject.tkID;
      }
    }

    /**
     * Method sets the attribute "novaKey".
     * 
     * @param pNovaKey Value to which the attribute "novaKey" should be set.
     */
    public Builder setNovaKey( String pNovaKey ) {
      // Assign value to attribute
      novaKey = pNovaKey;
      return this;
    }

    /**
     * Method sets the attribute "tkID".
     * 
     * @param pTkID Value to which the attribute "tkID" should be set.
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

    /**
     * Method creates a new validated instance of class ParentBeanParamType. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return ParentBeanParamType Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ParentBeanParamType buildValidated( ) throws ConstraintViolationException {
      ParentBeanParamType lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
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
}
