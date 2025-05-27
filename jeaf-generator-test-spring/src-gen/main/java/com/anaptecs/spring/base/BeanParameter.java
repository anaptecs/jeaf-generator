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
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = BeanParameter.BeanParameterBuilderImpl.class)
public class BeanParameter {
  /**
   * Constant for the name of attribute "accessToken".
   */
  public static final String ACCESSTOKEN = "accessToken";

  /**
   * Constant for the name of attribute "language".
   */
  public static final String LANGUAGE = "language";

  /**
   * Constant for the name of attribute "oldStyle".
   */
  @Deprecated
  public static final String OLDSTYLE = "oldStyle";

  private String accessToken;

  private Locale language;

  @Deprecated
  private String oldStyle;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BeanParameter( BeanParameterBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    accessToken = pBuilder.accessToken;
    language = pBuilder.language;
    oldStyle = pBuilder.oldStyle;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new BeanParameter objects.
   */
  public static BeanParameterBuilder<?, ?> builder( ) {
    return new BeanParameterBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class BeanParameter.
   *
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   *
   * @param pLanguage Value to which {@link #language} should be set.
   *
   * @param pOldStyle Value to which {@link #oldStyle} should be set.
   *
   * @return {@link BeanParameter}
   */
  public static BeanParameter of( String pAccessToken, Locale pLanguage, String pOldStyle ) {
    BeanParameterBuilder<?, ?> lBuilder = BeanParameter.builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setOldStyle(pOldStyle);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BeanParameter</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class BeanParameterBuilder<T extends BeanParameter, B extends BeanParameterBuilder<T, B>> {
    private String accessToken;

    private Locale language;

    @Deprecated
    private String oldStyle;

    /**
     * Use {@link BeanParameterBuilder#builder()} instead of private constructor to create new builder.
     */
    protected BeanParameterBuilder( ) {
    }

    /**
     * Use {@link BeanParameterBuilder#builder(BeanParameter)} instead of private constructor to create new builder.
     */
    protected BeanParameterBuilder( BeanParameter pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAccessToken(pObject.accessToken);
        this.setLanguage(pObject.language);
        this.setOldStyle(pObject.oldStyle);
      }
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setAccessToken( @MyNotNullProperty String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this.self();
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setLanguage( @MyNotNullProperty Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this.self();
    }

    /**
     * Method sets attribute {@link #oldStyle}.<br/>
     *
     * @param pOldStyle Value to which {@link #oldStyle} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public B setOldStyle( @MyNotNullProperty String pOldStyle ) {
      // Assign value to attribute
      oldStyle = pOldStyle;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of genric builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class BeanParameter. The object will be initialized with the values of the
     * builder.
     *
     * @return BeanParameter Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class BeanParameterBuilderImpl extends BeanParameterBuilder<BeanParameter, BeanParameterBuilderImpl> {
    protected BeanParameterBuilderImpl( ) {
    }

    protected BeanParameterBuilderImpl( BeanParameter pObject ) {
      super(pObject);
    }

    @Override
    protected BeanParameterBuilderImpl self( ) {
      return this;
    }

    @Override
    public BeanParameter build( ) {
      BeanParameter lObject = new BeanParameter(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #accessToken}.<br/>
   *
   * @return {@link String} Value to which {@link #accessToken} is set.
   */
  @MyNotNullProperty
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets attribute {@link #accessToken}.<br/>
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   */
  public void setAccessToken( @MyNotNullProperty String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  @MyNotNullProperty
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  public void setLanguage( @MyNotNullProperty Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Method returns attribute {@link #oldStyle}.<br/>
   *
   * @return {@link String} Value to which {@link #oldStyle} is set.
   */
  @Deprecated
  @MyNotNullProperty
  public String getOldStyle( ) {
    return oldStyle;
  }

  /**
   * Method sets attribute {@link #oldStyle}.<br/>
   *
   * @param pOldStyle Value to which {@link #oldStyle} should be set.
   */
  @Deprecated
  public void setOldStyle( @MyNotNullProperty String pOldStyle ) {
    // Assign value to attribute
    oldStyle = pOldStyle;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(accessToken);
    lResult = lPrime * lResult + Objects.hashCode(language);
    lResult = lPrime * lResult + Objects.hashCode(oldStyle);
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
      BeanParameter lOther = (BeanParameter) pObject;
      lEquals = Objects.equals(accessToken, lOther.accessToken) && Objects.equals(language, lOther.language)
          && Objects.equals(oldStyle, lOther.oldStyle);
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
    lBuilder.append("accessToken: ");
    lBuilder.append(accessToken);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("language: ");
    lBuilder.append(language);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("oldStyle: ");
    lBuilder.append(oldStyle);
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
   * @return {@link Builder} New builder that can be used to create new BeanParameter objects. The method never returns
   * null.
   */
  public BeanParameterBuilder<?, ?> toBuilder( ) {
    return new BeanParameterBuilderImpl(this);
  }
}