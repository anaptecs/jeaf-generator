/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.datatypeusage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.openapi.datatypes.MyDataType;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@Valid
public class DataTypeUsage implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private MyDataType code;

  @JsonSetter(nulls = Nulls.SKIP)
  private List<MyDataType> codes;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DataTypeUsage( ) {
    codes = new ArrayList<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypeUsage( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    code = pBuilder.code;
    if (pBuilder.codes != null) {
      codes = pBuilder.codes;
    }
    else {
      codes = new ArrayList<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DataTypeUsage objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DataTypeUsage.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.datatypeusage.DataTypeUsage}
   */
  public static DataTypeUsage of( MyDataType pCode ) {
    DataTypeUsage.Builder lBuilder = DataTypeUsage.builder();
    lBuilder.setCode(pCode);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DataTypeUsage</code>.
   */
  public static class Builder {
    private MyDataType code;

    private List<MyDataType> codes;

    /**
     * Use {@link DataTypeUsage#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypeUsage#builder(DataTypeUsage)} instead of private constructor to create new builder.
     */
    protected Builder( DataTypeUsage pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
        this.setCodes(pObject.codes);
      }
    }

    /**
     * Method sets association {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( @MyNotNullProperty MyDataType pCode ) {
      code = pCode;
      return this;
    }

    /**
     * Method sets association {@link #codes}.<br/>
     *
     * @param pCodes Collection to which {@link #codes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCodes( List<MyDataType> pCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pCodes != null) {
        codes = new ArrayList<MyDataType>(pCodes);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #codes}.<br/>
     *
     * @param pCodes Array of objects that should be added to {@link #codes}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToCodes( MyDataType... pCodes ) {
      if (pCodes != null) {
        if (codes == null) {
          codes = new ArrayList<MyDataType>();
        }
        codes.addAll(Arrays.asList(pCodes));
      }
      return this;
    }

    /**
     * Method creates a new instance of class DataTypeUsage. The object will be initialized with the values of the
     * builder.
     *
     * @return DataTypeUsage Created object. The method never returns null.
     */
    public DataTypeUsage build( ) {
      return new DataTypeUsage(this);
    }

    /**
     * Method creates a new validated instance of class DataTypeUsage. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return DataTypeUsage Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DataTypeUsage buildValidated( ) throws ConstraintViolationException {
      DataTypeUsage lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #code}.<br/>
   *
   * @return {@link MyDataType} Value to which {@link #code} is set.
   */
  @MyNotNullProperty
  public MyDataType getCode( ) {
    return code;
  }

  /**
   * Method sets association {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( @MyNotNullProperty MyDataType pCode ) {
    code = pCode;
  }

  /**
   * Method unsets {@link #code}.
   */
  public final void unsetCode( ) {
    code = null;
  }

  /**
   * Method returns association {@link #codes}.<br/>
   *
   * @return {@link List<MyDataType>} Value to which {@link #codes} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  public List<MyDataType> getCodes( ) {
    // Return all MyDataType objects directly without any protection against modification.
    return codes;
  }

  /**
   * Method adds the passed object to {@link #codes}.
   *
   * @param pCodes Object that should be added to {@link #codes}. The parameter must not be null.
   */
  public void addToCodes( MyDataType pCodes ) {
    // Check parameter "pCodes" for invalid value null.
    Check.checkInvalidParameterNull(pCodes, "pCodes");
    // Add passed object to collection of associated MyDataType objects.
    codes.add(pCodes);
  }

  /**
   * Method adds all passed objects to {@link #codes}.
   *
   * @param pCodes Collection with all objects that should be added to {@link #codes}. The parameter must not be null.
   */
  public void addToCodes( Collection<MyDataType> pCodes ) {
    // Check parameter "pCodes" for invalid value null.
    Check.checkInvalidParameterNull(pCodes, "pCodes");
    // Add all passed objects.
    for (MyDataType lNextObject : pCodes) {
      this.addToCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #codes}.<br/>
   *
   * @param pCodes Object that should be removed from {@link #codes}. The parameter must not be null.
   */
  public void removeFromCodes( MyDataType pCodes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pCodes, "pCodes");
    // Remove passed object from collection of associated MyDataType objects.
    codes.remove(pCodes);
  }

  /**
   * Method removes all objects from {@link #codes}.
   */
  public void clearCodes( ) {
    // Remove all objects from association "codes".
    codes.clear();
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
    lBuilder.append("code: ");
    if (code != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(code.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("codes: ");
    if (codes != null) {
      lBuilder.append(codes.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (codes != null) {
      for (MyDataType lNext : codes) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
   * @return {@link Builder} New builder that can be used to create new DataTypeUsage objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}