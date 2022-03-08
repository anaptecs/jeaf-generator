/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Locale;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class BeanParameter implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

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

  /**
   * 
   */
  private String accessToken;

  /**
   * 
   */
  private Locale language;

  /**
   * 
   */
  @Deprecated
  private String oldStyle;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BeanParameter( ) {
    // Nothing to do.
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
    language = pBuilder.language;
    oldStyle = pBuilder.oldStyle;
  }

  /**
   * Class implements builder to create a new instance of class BeanParameter. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String accessToken;

    /**
     * 
     */
    private Locale language;

    /**
     * 
     */
    @Deprecated
    private String oldStyle;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BeanParameter)} instead of private constructor to create new builder.
     */
    protected Builder( BeanParameter pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        accessToken = pObject.accessToken;
        language = pObject.language;
        oldStyle = pObject.oldStyle;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
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
     * Method sets the attribute "accessToken".
     * 
     * @param pAccessToken Value to which the attribute "accessToken" should be set.
     */
    public Builder setAccessToken( String pAccessToken ) {
      // Assign value to attribute
      accessToken = pAccessToken;
      return this;
    }

    /**
     * Method sets the attribute "language".
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
     */
    public Builder setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method sets the attribute "oldStyle".
     * 
     * @param pOldStyle Value to which the attribute "oldStyle" should be set.
     */
    @Deprecated
    public Builder setOldStyle( String pOldStyle ) {
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
      return new BeanParameter(this);
    }

    /**
     * Method creates a new instance of class BeanParameter. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return BeanParameter Created object. The method never returns null.
     */
    public BeanParameter build( boolean pValidate ) {
      BeanParameter lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "accessToken".
   * 
   * 
   * @return String Value to which the attribute "accessToken" is set.
   */
  public String getAccessToken( ) {
    return accessToken;
  }

  /**
   * Method sets the attribute "accessToken".
   * 
   * 
   * @param pAccessToken Value to which the attribute "accessToken" should be set.
   */
  public void setAccessToken( String pAccessToken ) {
    // Assign value to attribute
    accessToken = pAccessToken;
  }

  /**
   * Method returns the attribute "language".
   * 
   * 
   * @return Locale Value to which the attribute "language" is set.
   */
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets the attribute "language".
   * 
   * 
   * @param pLanguage Value to which the attribute "language" should be set.
   */
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Method returns the attribute "oldStyle".
   * 
   * 
   * @return String Value to which the attribute "oldStyle" is set.
   */
  @Deprecated
  public String getOldStyle( ) {
    return oldStyle;
  }

  /**
   * Method sets the attribute "oldStyle".
   * 
   * 
   * @param pOldStyle Value to which the attribute "oldStyle" should be set.
   */
  @Deprecated
  public void setOldStyle( String pOldStyle ) {
    // Assign value to attribute
    oldStyle = pOldStyle;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "accessToken", "" + accessToken));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "language", "" + language));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "oldStyle", "" + oldStyle));
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
