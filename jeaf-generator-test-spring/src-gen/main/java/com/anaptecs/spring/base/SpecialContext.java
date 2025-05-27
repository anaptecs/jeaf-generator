/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Locale;
import java.util.Objects;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class SpecialContext extends Context {
  /**
   * Constant for the name of attribute "specificHeader".
   */
  public static final String SPECIFICHEADER = "specificHeader";

  /**
   * Constant for the name of attribute "channelType".
   */
  public static final String CHANNELTYPE = "channelType";

  private String specificHeader;

  private ChannelType channelType;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SpecialContext( SpecialContextBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    specificHeader = pBuilder.specificHeader;
    channelType = pBuilder.channelType;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new SpecialContext objects.
   */
  public static SpecialContextBuilder<?, ?> builder( ) {
    return new SpecialContextBuilderImpl();
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
   * @param pLang Value to which {@link #lang} should be set.
   *
   * @param pIntCode Value to which {@link #intCode} should be set.
   *
   * @param pSpecificHeader Value to which {@link #specificHeader} should be set.
   *
   * @param pChannelType Value to which {@link #channelType} should be set.
   *
   * @return {@link com.anaptecs.spring.base.SpecialContext}
   */
  public static SpecialContext of( String pAccessToken, Locale pLanguage, long pResellerID, long pPathParam,
      String pQueryParam, String pLang, IntegerCodeType pIntCode, String pSpecificHeader, ChannelType pChannelType ) {
    SpecialContextBuilder<?, ?> lBuilder = SpecialContext.builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    lBuilder.setLang(pLang);
    lBuilder.setIntCode(pIntCode);
    lBuilder.setSpecificHeader(pSpecificHeader);
    lBuilder.setChannelType(pChannelType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>SpecialContext</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class SpecialContextBuilder<T extends SpecialContext, B extends SpecialContextBuilder<T, B>>
      extends ContextBuilder<T, B> {
    private String specificHeader;

    private ChannelType channelType;

    /**
     * Use {@link SpecialContextBuilder#builder()} instead of private constructor to create new builder.
     */
    protected SpecialContextBuilder( ) {
      super();
    }

    /**
     * Use {@link SpecialContextBuilder#builder(SpecialContext)} instead of private constructor to create new builder.
     */
    protected SpecialContextBuilder( SpecialContext pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setSpecificHeader(pObject.specificHeader);
        this.setChannelType(pObject.channelType);
      }
    }

    /**
     * Method sets attribute {@link #specificHeader}.<br/>
     *
     * @param pSpecificHeader Value to which {@link #specificHeader} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setSpecificHeader( @MyNotNullProperty String pSpecificHeader ) {
      // Assign value to attribute
      specificHeader = pSpecificHeader;
      return this.self();
    }

    /**
     * Method sets attribute {@link #channelType}.<br/>
     *
     * @param pChannelType Value to which {@link #channelType} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setChannelType( @MyNotNullProperty ChannelType pChannelType ) {
      // Assign value to attribute
      channelType = pChannelType;
      return this.self();
    }

    @Override
    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class SpecialContext. The object will be initialized with the values of the
     * builder.
     *
     * @return SpecialContext Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class SpecialContextBuilderImpl
      extends SpecialContextBuilder<SpecialContext, SpecialContextBuilderImpl> {
    protected SpecialContextBuilderImpl( ) {
    }

    protected SpecialContextBuilderImpl( SpecialContext pObject ) {
      super(pObject);
    }

    @Override
    protected SpecialContextBuilderImpl self( ) {
      return this;
    }

    @Override
    public SpecialContext build( ) {
      SpecialContext lObject = new SpecialContext(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #specificHeader}.<br/>
   *
   * @return {@link String} Value to which {@link #specificHeader} is set.
   */
  @MyNotNullProperty
  public String getSpecificHeader( ) {
    return specificHeader;
  }

  /**
   * Method sets attribute {@link #specificHeader}.<br/>
   *
   * @param pSpecificHeader Value to which {@link #specificHeader} should be set.
   */
  public void setSpecificHeader( @MyNotNullProperty String pSpecificHeader ) {
    // Assign value to attribute
    specificHeader = pSpecificHeader;
  }

  /**
   * Method returns attribute {@link #channelType}.<br/>
   *
   * @return {@link ChannelType} Value to which {@link #channelType} is set.
   */
  @MyNotNullProperty
  public ChannelType getChannelType( ) {
    return channelType;
  }

  /**
   * Method sets attribute {@link #channelType}.<br/>
   *
   * @param pChannelType Value to which {@link #channelType} should be set.
   */
  public void setChannelType( @MyNotNullProperty ChannelType pChannelType ) {
    // Assign value to attribute
    channelType = pChannelType;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(specificHeader);
    lResult = lPrime * lResult + Objects.hashCode(channelType);
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
      lEquals =
          Objects.equals(specificHeader, lOther.specificHeader) && Objects.equals(channelType, lOther.channelType);
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
    lBuilder.append("channelType: ");
    lBuilder.append(channelType);
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
  public SpecialContextBuilder<?, ?> toBuilder( ) {
    return new SpecialContextBuilderImpl(this);
  }
}