/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.QueryParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class DataTypesQueryBean implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "longCodes".
   */
  public static final String LONGCODES = "longCodes";

  /**
   * Constant for the name of attribute "codes".
   */
  public static final String CODES = "codes";

  /**
   * Constant for the name of attribute "doubleCodes".
   */
  public static final String DOUBLECODES = "doubleCodes";

  /**
   * 
   */
  @QueryParam("longCodes")
  private LongCode[] longCodes;

  /**
   * 
   */
  @QueryParam("codes")
  private IntegerCodeType[] codes;

  /**
   * 
   */
  private Set<DoubleCode> doubleCodes;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public DataTypesQueryBean( ) {
    doubleCodes = new HashSet<DoubleCode>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypesQueryBean( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    longCodes = pBuilder.longCodes;
    codes = pBuilder.codes;
    if (pBuilder.doubleCodes != null) {
      doubleCodes = pBuilder.doubleCodes;
    }
    else {
      doubleCodes = new HashSet<DoubleCode>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects. The method never
   * returns null.
   */
  public static Builder builder( DataTypesQueryBean pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class DataTypesQueryBean. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private LongCode[] longCodes;

    /**
     * 
     */
    private IntegerCodeType[] codes;

    /**
     * 
     */
    private Set<DoubleCode> doubleCodes;

    /**
     * Use {@link DataTypesQueryBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypesQueryBean#builder(DataTypesQueryBean)} instead of private constructor to create new builder.
     */
    protected Builder( DataTypesQueryBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        longCodes = pObject.longCodes;
        codes = pObject.codes;
        doubleCodes = pObject.doubleCodes;
      }
    }

    /**
     * Method sets the attribute "longCodes".
     * 
     * @param pLongCodes Value to which the attribute "longCodes" should be set.
     */
    public Builder setLongCodes( LongCode[] pLongCodes ) {
      // Assign value to attribute
      if (pLongCodes != null) {
        longCodes = new LongCode[pLongCodes.length];
        System.arraycopy(pLongCodes, 0, longCodes, 0, pLongCodes.length);
      }
      else {
        longCodes = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "codes".
     * 
     * @param pCodes Value to which the attribute "codes" should be set.
     */
    public Builder setCodes( IntegerCodeType[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = new IntegerCodeType[pCodes.length];
        System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method sets the association "doubleCodes".
     * 
     * @param pDoubleCodes Collection with objects to which the association should be set.
     */
    public Builder setDoubleCodes( Set<DoubleCode> pDoubleCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDoubleCodes != null) {
        doubleCodes = new HashSet<DoubleCode>(pDoubleCodes);
      }
      else {
        doubleCodes = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class DataTypesQueryBean. The object will be initialized with the values of the
     * builder.
     * 
     * @return DataTypesQueryBean Created object. The method never returns null.
     */
    public DataTypesQueryBean build( ) {
      return new DataTypesQueryBean(this);
    }

    /**
     * Method creates a new validated instance of class DataTypesQueryBean. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return DataTypesQueryBean Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DataTypesQueryBean buildValidated( ) throws ConstraintViolationException {
      DataTypesQueryBean lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "longCodes".
   * 
   * 
   * @return LongCode Value to which the attribute "longCodes" is set.
   */
  public LongCode[] getLongCodes( ) {
    LongCode[] lReturnValue;
    if (longCodes != null) {
      lReturnValue = new LongCode[longCodes.length];
      System.arraycopy(longCodes, 0, lReturnValue, 0, longCodes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "longCodes".
   * 
   * 
   * @param pLongCodes Value to which the attribute "longCodes" should be set.
   */
  public void setLongCodes( LongCode[] pLongCodes ) {
    // Assign value to attribute
    if (pLongCodes != null) {
      longCodes = new LongCode[pLongCodes.length];
      System.arraycopy(pLongCodes, 0, longCodes, 0, pLongCodes.length);
    }
    else {
      longCodes = null;
    }
  }

  /**
   * Method returns the attribute "codes".
   * 
   * 
   * @return IntegerCodeType Value to which the attribute "codes" is set.
   */
  public IntegerCodeType[] getCodes( ) {
    IntegerCodeType[] lReturnValue;
    if (codes != null) {
      lReturnValue = new IntegerCodeType[codes.length];
      System.arraycopy(codes, 0, lReturnValue, 0, codes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "codes".
   * 
   * 
   * @param pCodes Value to which the attribute "codes" should be set.
   */
  public void setCodes( IntegerCodeType[] pCodes ) {
    // Assign value to attribute
    if (pCodes != null) {
      codes = new IntegerCodeType[pCodes.length];
      System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
    }
    else {
      codes = null;
    }
  }

  /**
   * Method returns the association "doubleCodes".
   * 
   *
   * @return Collection All DoubleCode objects that belong to the association "doubleCodes". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<DoubleCode> getDoubleCodes( ) {
    // Return all DoubleCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(doubleCodes);
  }

  /**
   * Method adds the passed DoubleCode object to the association "doubleCodes".
   * 
   * 
   * @param pDoubleCodes Object that should be added to the association "doubleCodes". The parameter must not be null.
   */
  public void addToDoubleCodes( DoubleCode pDoubleCodes ) {
    // Check parameter "pDoubleCodes" for invalid value null.
    Check.checkInvalidParameterNull(pDoubleCodes, "pDoubleCodes");
    // Add passed object to collection of associated DoubleCode objects.
    doubleCodes.add(pDoubleCodes);
  }

  /**
   * Method adds all passed objects to the association "doubleCodes".
   * 
   * 
   * @param pDoubleCodes Collection with all objects that should be added to the association "doubleCodes". The
   * parameter must not be null.
   */
  public void addToDoubleCodes( Collection<DoubleCode> pDoubleCodes ) {
    // Check parameter "pDoubleCodes" for invalid value null.
    Check.checkInvalidParameterNull(pDoubleCodes, "pDoubleCodes");
    // Add all passed objects.
    for (DoubleCode lNextObject : pDoubleCodes) {
      this.addToDoubleCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed DoubleCode object from the association "doubleCodes".
   * 
   * 
   * @param pDoubleCodes Object that should be removed from the association "doubleCodes". The parameter must not be
   * null.
   */
  public void removeFromDoubleCodes( DoubleCode pDoubleCodes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDoubleCodes, "pDoubleCodes");
    // Remove passed object from collection of associated DoubleCode objects.
    doubleCodes.remove(pDoubleCodes);
  }

  /**
   * Method removes all objects from the association "doubleCodes".
   * 
   */
  public void clearDoubleCodes( ) {
    // Remove all objects from association "doubleCodes".
    doubleCodes.clear();
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
