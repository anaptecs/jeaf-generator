/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Locale;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class BeanParameter extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "accessToken".
   */
  @JEAFCustomAnnotationTest
  public static final String ACCESSTOKEN = "accessToken";

  /**
   * Constant for the name of attribute "language".
   */
  @JEAFCustomAnnotationTest
  public static final String LANGUAGE = "language";

  /**
   * Constant for the name of attribute "oldStyle".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String OLDSTYLE = "oldStyle";

  // "java.lang.String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private String accessToken;

  // "java.lang.String"
  private int accessTokenXYZ = 0;

  // "java.util.Locale"
  @ClassPropertyDeclaration
  /**
   * <br/>
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>DE-de<br/>
   * 2nd line</code></li>
   * <li><code>en</code></li>
   * </ul>
   */
  @JEAFCustomAnnotationTest
  private Locale language;

  // "java.util.Locale"
  private int languageXYZ = 0;

  // "java.lang.String"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private String oldStyle;

  // "java.lang.String"
  private int oldStyleXYZ = 0;

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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    accessToken = pBuilder.accessToken;
    // "java.lang.String"
    accessTokenXYZ = pBuilder.accessTokenXYZ;
    language = pBuilder.language;
    // "java.util.Locale"
    languageXYZ = pBuilder.languageXYZ;
    oldStyle = pBuilder.oldStyle;
    // "java.lang.String"
    oldStyleXYZ = pBuilder.oldStyleXYZ;
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
   * Class implements builder to create a new instance of class <code>BeanParameter</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "java.lang.String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private String accessToken;

    // "java.lang.String"
    private int accessTokenXYZ = 0;

    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>DE-de<br/>
     * 2nd line</code></li>
     * <li><code>en</code></li>
     * </ul>
     */
    // "java.util.Locale"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Locale language;

    // "java.util.Locale"
    private int languageXYZ = 0;

    // "java.lang.String"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private String oldStyle;

    // "java.lang.String"
    private int oldStyleXYZ = 0;

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
     * Method sets attribute {@link #accessToken}.<br/>
     *
     * @param pAccessToken Value to which {@link #accessToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setAccessToken( String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this;
    }

    public Builder setAccessTokenXYZ( int value ) {
      // "java.lang.String"
      accessTokenXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #language}.<br/>
     *
     * @param pLanguage Value to which {@link #language} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    public Builder setLanguageXYZ( int value ) {
      // "java.util.Locale"
      languageXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #oldStyle}.<br/>
     *
     * @param pOldStyle Value to which {@link #oldStyle} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public Builder setOldStyle( String pOldStyle ) {
      // Assign value to attribute
      oldStyle = pOldStyle;
      return this;
    }

    public Builder setOldStyleXYZ( int value ) {
      // "java.lang.String"
      oldStyleXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class BeanParameter. The object will be initialized with the values of the
     * builder.
     *
     * @return BeanParameter Created object. The method never returns null.
     */
    public BeanParameter build( ) {
      return new BeanParameter(this);
    }

    /**
     * Method creates a new validated instance of class BeanParameter. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return BeanParameter Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BeanParameter buildValidated( ) throws ConstraintViolationException {
      BeanParameter lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #accessToken}.<br/>
   *
   * @return {@link String} Value to which {@link #accessToken} is set.
   */
  @JEAFCustomAnnotationTest
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets attribute {@link #accessToken}.<br/>
   *
   * @param pAccessToken Value to which {@link #accessToken} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setAccessToken( String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  public int getAccessTokenXYZ( ) {
    // "java.lang.String"
    return accessTokenXYZ;
  }

  public void setAccessTokenXYZ( int value ) {
    accessTokenXYZ = value;
  }

  /**
   * Method returns attribute {@link #language}.<br/>
   *
   * @return {@link Locale} Value to which {@link #language} is set.
   */
  @JEAFCustomAnnotationTest
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets attribute {@link #language}.<br/>
   *
   * @param pLanguage Value to which {@link #language} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  public int getLanguageXYZ( ) {
    // "java.util.Locale"
    return languageXYZ;
  }

  public void setLanguageXYZ( int value ) {
    languageXYZ = value;
  }

  /**
   * Method returns attribute {@link #oldStyle}.<br/>
   *
   * @return {@link String} Value to which {@link #oldStyle} is set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public String getOldStyle( ) {
    return oldStyle;
  }

  /**
   * Method sets attribute {@link #oldStyle}.<br/>
   *
   * @param pOldStyle Value to which {@link #oldStyle} should be set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void setOldStyle( String pOldStyle ) {
    // Assign value to attribute
    oldStyle = pOldStyle;
  }

  public int getOldStyleXYZ( ) {
    // "java.lang.String"
    return oldStyleXYZ;
  }

  public void setOldStyleXYZ( int value ) {
    oldStyleXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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