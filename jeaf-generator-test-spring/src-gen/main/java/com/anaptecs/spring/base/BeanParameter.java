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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
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
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected BeanParameter( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BeanParameter( Builder pBuilder ) {
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
  public static Builder builder( ) {
    return new Builder();
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
   * @return {@link com.anaptecs.spring.base.BeanParameter}
   */
  public static BeanParameter of( String pAccessToken, Locale pLanguage, String pOldStyle ) {
    BeanParameter.Builder lBuilder = BeanParameter.builder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setOldStyle(pOldStyle);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>BeanParameter</code>.
   */
  public static class Builder {
    private String accessToken;

    private Locale language;

    @Deprecated
    private String oldStyle;

    /**
     * Use {@link BeanParameter#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link BeanParameter#builder(BeanParameter)} instead of private constructor to create new builder.
     */
    protected Builder( BeanParameter pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setAccessToken(pObject.accessToken);
        this.setLanguage(pObject.language);
        this.setOldStyle(pObject.oldStyle);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new BeanParameter objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new BeanParameter objects. The method never
     * returns null.
     */
    public static Builder newBuilder( BeanParameter pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAccessToken( @MyNotNullProperty String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLanguage( @MyNotNullProperty Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method sets attribute {@link #oldStyle}.<br/>
     *
     * @param pOldStyle Value to which {@link #oldStyle} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setOldStyle( @MyNotNullProperty String pOldStyle ) {
      // Assign value to attribute
      oldStyle = pOldStyle;
      return this;
    }

    /**
     * Method creates a new instance of class BeanParameter. The object will be initialized with the values of the
     * builder.
     *
     * @return BeanParameter Created object. The method never returns null.
     */
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
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
