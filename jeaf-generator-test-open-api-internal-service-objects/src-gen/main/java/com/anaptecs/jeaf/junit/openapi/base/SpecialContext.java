/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Locale;
import java.util.Objects;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;

@Valid
public class SpecialContext extends Context {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @HeaderParam("specificHeader")
  @NotNull
  private String specificHeader;

  @Deprecated
  @HeaderParam("deprecatedHeader")
  @Valid
  @NotNull
  private IntegerCode deprecatedHeader;

  @HeaderParam("deprecatedType")
  @Valid
  @NotNull
  private DeprecatedType deprecatedType;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SpecialContext( ) {
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
    deprecatedHeader = pBuilder.deprecatedHeader;
    deprecatedType = pBuilder.deprecatedType;
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
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects. The method never returns
   * null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( SpecialContext pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pAccessToken, Locale pLanguage, long pResellerID, long pPathParam,
      String pQueryParam, String pSpecificHeader, IntegerCode pDeprecatedHeader, DeprecatedType pDeprecatedType ) {
    Builder lBuilder = builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    lBuilder.setSpecificHeader(pSpecificHeader);
    lBuilder.setDeprecatedHeader(pDeprecatedHeader);
    lBuilder.setDeprecatedType(pDeprecatedType);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class SpecialContext.
   *
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   *
   * @param pLanguage Value to which {@link #language} should be set.
   *
   * @param pResellerID Value to which {@link #resellerID} should be set.
   *
   * @param pPathParam Value to which {@link #pathParam} should be set.
   *
   * @param pQueryParam Value to which {@link #queryParam} should be set.
   *
   * @param pSpecificHeader Value to which {@link #specificHeader} should be set.
   *
   * @param pDeprecatedHeader Value to which {@link #deprecatedHeader} should be set.
   *
   * @param pDeprecatedType Value to which {@link #deprecatedType} should be set.
   *
   * @return {@link SpecialContext}
   */
  public static SpecialContext of( String pAccessToken, Locale pLanguage, long pResellerID, long pPathParam,
      String pQueryParam, String pSpecificHeader, IntegerCode pDeprecatedHeader, DeprecatedType pDeprecatedType ) {
    SpecialContext.Builder lBuilder = SpecialContext.builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    lBuilder.setSpecificHeader(pSpecificHeader);
    lBuilder.setDeprecatedHeader(pDeprecatedHeader);
    lBuilder.setDeprecatedType(pDeprecatedType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SpecialContext</code>.
   */
  public static class Builder extends Context.Builder {
    private String specificHeader;

    @Deprecated
    @Valid
    private IntegerCode deprecatedHeader;

    @Valid
    private DeprecatedType deprecatedType;

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
        this.setSpecificHeader(pObject.specificHeader);
        this.setDeprecatedHeader(pObject.deprecatedHeader);
        this.setDeprecatedType(pObject.deprecatedType);
      }
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setAccessToken( String pAccessToken ) {
      // Call super class implementation.
      super.setAccessToken(pAccessToken);
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setLanguage( Locale pLanguage ) {
      // Call super class implementation.
      super.setLanguage(pLanguage);
      return this;
    }

    /**
     * Method sets attribute {@link #resellerID}.<br/>
     *
     * @param pResellerID Value to which {@link #resellerID} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setResellerID( long pResellerID ) {
      // Call super class implementation.
      super.setResellerID(pResellerID);
      return this;
    }

    /**
     * Method sets attribute {@link #pathParam}.<br/>
     *
     * @param pPathParam Value to which {@link #pathParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setPathParam( long pPathParam ) {
      // Call super class implementation.
      super.setPathParam(pPathParam);
      return this;
    }

    /**
     * Method sets attribute {@link #queryParam}.<br/>
     *
     * @param pQueryParam Value to which {@link #queryParam} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setQueryParam( String pQueryParam ) {
      // Call super class implementation.
      super.setQueryParam(pQueryParam);
      return this;
    }

    /**
     * Method sets attribute {@link #intCode}.<br/>
     *
     * @param pIntCode Value to which {@link #intCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setIntCode( IntegerCodeType pIntCode ) {
      // Call super class implementation.
      super.setIntCode(pIntCode);
      return this;
    }

    /**
     * Method sets attribute {@link #specificHeader}.<br/>
     *
     * @param pSpecificHeader Value to which {@link #specificHeader} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSpecificHeader( String pSpecificHeader ) {
      // Assign value to attribute
      specificHeader = pSpecificHeader;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedHeader}.<br/>
     *
     * @param pDeprecatedHeader Value to which {@link #deprecatedHeader} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setDeprecatedHeader( IntegerCode pDeprecatedHeader ) {
      // Assign value to attribute
      deprecatedHeader = pDeprecatedHeader;
      return this;
    }

    /**
     * Method sets attribute {@link #deprecatedType}.<br/>
     *
     * @param pDeprecatedType Value to which {@link #deprecatedType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDeprecatedType( DeprecatedType pDeprecatedType ) {
      // Assign value to attribute
      deprecatedType = pDeprecatedType;
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

    /**
     * Method creates a new validated instance of class SpecialContext. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return SpecialContext Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SpecialContext buildValidated( ) throws ConstraintViolationException {
      SpecialContext lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #specificHeader}.<br/>
   *
   * @return {@link String} Value to which {@link #specificHeader} is set.
   */
  public String getSpecificHeader( ) {
    return specificHeader;
  }

  /**
   * Method sets attribute {@link #specificHeader}.<br/>
   *
   * @param pSpecificHeader Value to which {@link #specificHeader} should be set.
   */
  public void setSpecificHeader( String pSpecificHeader ) {
    // Assign value to attribute
    specificHeader = pSpecificHeader;
  }

  /**
   * Method returns attribute {@link #deprecatedHeader}.<br/>
   *
   * @return {@link IntegerCode} Value to which {@link #deprecatedHeader} is set.
   */
  @Deprecated
  public IntegerCode getDeprecatedHeader( ) {
    return deprecatedHeader;
  }

  /**
   * Method sets attribute {@link #deprecatedHeader}.<br/>
   *
   * @param pDeprecatedHeader Value to which {@link #deprecatedHeader} should be set.
   */
  @Deprecated
  public void setDeprecatedHeader( IntegerCode pDeprecatedHeader ) {
    // Assign value to attribute
    deprecatedHeader = pDeprecatedHeader;
  }

  /**
   * Method returns attribute {@link #deprecatedType}.<br/>
   *
   * @return {@link DeprecatedType} Value to which {@link #deprecatedType} is set.
   */
  public DeprecatedType getDeprecatedType( ) {
    return deprecatedType;
  }

  /**
   * Method sets attribute {@link #deprecatedType}.<br/>
   *
   * @param pDeprecatedType Value to which {@link #deprecatedType} should be set.
   */
  public void setDeprecatedType( DeprecatedType pDeprecatedType ) {
    // Assign value to attribute
    deprecatedType = pDeprecatedType;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(specificHeader);
    lResult = lPrime * lResult + Objects.hashCode(deprecatedHeader);
    lResult = lPrime * lResult + Objects.hashCode(deprecatedType);
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      SpecialContext lOther = (SpecialContext) pObject;
      lEquals = Objects.equals(specificHeader, lOther.specificHeader)
          && Objects.equals(deprecatedHeader, lOther.deprecatedHeader)
          && Objects.equals(deprecatedType, lOther.deprecatedType);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("specificHeader: ");
    lBuilder.append(specificHeader);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedHeader: ");
    lBuilder.append(deprecatedHeader);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedType: ");
    lBuilder.append(deprecatedType);
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
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
