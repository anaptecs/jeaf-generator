/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Translation {
  /**
   * Constant for the name of attribute "language".
   */
  public static final String LANGUAGE = "language";

  /**
   * Constant for the name of attribute "text".
   */
  public static final String TEXT = "text";

  /**
   * Constant for the name of attribute "shortText".
   */
  public static final String SHORTTEXT = "shortText";

  /**
   * language code following RFC2616-sec14.4 <br/>
   * <b>Example:</b> <code>en</code>
   */
  private String language;

  /**
   * 
   */
  private String text;

  /**
   * 
   */
  private String shortText;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Translation( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Translation( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    language = pBuilder.language;
    text = pBuilder.text;
    shortText = pBuilder.shortText;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Translation objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Translation objects. The method never returns
   * null.
   */
  public static Builder builder( Translation pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Translation. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * language code following RFC2616-sec14.4
     */
    private String language;

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private String shortText;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Translation)} instead of private constructor to create new builder.
     */
    protected Builder( Translation pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        language = pObject.language;
        text = pObject.text;
        shortText = pObject.shortText;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Translation objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Translation objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Translation pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "language". language code following RFC2616-sec14.4
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
     */
    public Builder setLanguage( String pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method sets the attribute "text".
     * 
     * @param pText Value to which the attribute "text" should be set.
     */
    public Builder setText( String pText ) {
      // Assign value to attribute
      text = pText;
      return this;
    }

    /**
     * Method sets the attribute "shortText".
     * 
     * @param pShortText Value to which the attribute "shortText" should be set.
     */
    public Builder setShortText( String pShortText ) {
      // Assign value to attribute
      shortText = pShortText;
      return this;
    }

    /**
     * Method creates a new instance of class Translation. The object will be initialized with the values of the
     * builder.
     * 
     * @return Translation Created object. The method never returns null.
     */
    public Translation build( ) {
      return new Translation(this);
    }

    /**
     * Method creates a new validated instance of class Translation. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return Translation Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Translation buildValidated( ) throws ConstraintViolationException {
      Translation lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "language". language code following RFC2616-sec14.4
   * 
   * @return String Value to which the attribute "language" is set.
   */
  public String getLanguage( ) {
    return language;
  }

  /**
   * Method sets the attribute "language". language code following RFC2616-sec14.4
   * 
   * @param pLanguage Value to which the attribute "language" should be set.
   */
  public void setLanguage( String pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Method returns the attribute "text".
   * 
   * 
   * @return String Value to which the attribute "text" is set.
   */
  public String getText( ) {
    return text;
  }

  /**
   * Method sets the attribute "text".
   * 
   * 
   * @param pText Value to which the attribute "text" should be set.
   */
  public void setText( String pText ) {
    // Assign value to attribute
    text = pText;
  }

  /**
   * Method returns the attribute "shortText".
   * 
   * 
   * @return String Value to which the attribute "shortText" is set.
   */
  public String getShortText( ) {
    return shortText;
  }

  /**
   * Method sets the attribute "shortText".
   * 
   * 
   * @param pShortText Value to which the attribute "shortText" should be set.
   */
  public void setShortText( String pShortText ) {
    // Assign value to attribute
    shortText = pShortText;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "language", "" + language));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "text", "" + text));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "shortText", "" + shortText));
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
