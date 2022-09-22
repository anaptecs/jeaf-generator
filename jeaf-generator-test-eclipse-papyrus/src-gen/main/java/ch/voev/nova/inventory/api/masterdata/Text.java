/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Directly included text in case of online services. Text must be encoded in UTF-8 format.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Text {
  /**
   * Constant for the name of attribute "id".
   */
  public static final String ID = "id";

  /**
   * Constant for the name of attribute "translations".
   */
  public static final String TRANSLATIONS = "translations";

  /**
   * Constant for the name of attribute "text".
   */
  public static final String TEXT = "text";

  /**
   * Constant for the name of attribute "shortText".
   */
  public static final String SHORTTEXT = "shortText";

  /**
   * 
   */
  private String id;

  /**
   * 
   */
  private List<Translation> translations;

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
  protected Text( ) {
    translations = new ArrayList<Translation>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Text( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    id = pBuilder.id;
    if (pBuilder.translations != null) {
      translations = pBuilder.translations;
    }
    else {
      translations = new ArrayList<Translation>();
    }
    text = pBuilder.text;
    shortText = pBuilder.shortText;
  }

  /**
   * Class implements builder to create a new instance of class Text. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private List<Translation> translations;

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
     * Use {@link #newBuilder(Text)} instead of private constructor to create new builder.
     */
    protected Builder( Text pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        id = pObject.id;
        translations = pObject.translations;
        text = pObject.text;
        shortText = pObject.shortText;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Text objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Text objects. The method never returns null.
     */
    public static Builder newBuilder( Text pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "id".
     * 
     * @param pId Value to which the attribute "id" should be set.
     */
    public Builder setId( String pId ) {
      // Assign value to attribute
      id = pId;
      return this;
    }

    /**
     * Method sets the association "translations".
     * 
     * @param pTranslations Collection with objects to which the association should be set.
     */
    public Builder setTranslations( List<Translation> pTranslations ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTranslations != null) {
        translations = new ArrayList<Translation>(pTranslations);
      }
      else {
        translations = null;
      }
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
     * Method creates a new instance of class Text. The object will be initialized with the values of the builder.
     * 
     * @return Text Created object. The method never returns null.
     */
    public Text build( ) {
      return new Text(this);
    }

    /**
     * Method creates a new validated instance of class Text. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Text Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Text buildValidated( ) throws ConstraintViolationException {
      Text lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "id".
   * 
   * 
   * @return String Value to which the attribute "id" is set.
   */
  public String getId( ) {
    return id;
  }

  /**
   * Method sets the attribute "id".
   * 
   * 
   * @param pId Value to which the attribute "id" should be set.
   */
  public void setId( String pId ) {
    // Assign value to attribute
    id = pId;
  }

  /**
   * Method returns the association "translations".
   * 
   *
   * @return Collection All Translation objects that belong to the association "translations". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<Translation> getTranslations( ) {
    // Return all Translation objects as unmodifiable collection.
    return Collections.unmodifiableList(translations);
  }

  /**
   * Method adds the passed Translation object to the association "translations".
   * 
   * 
   * @param pTranslations Object that should be added to the association "translations". The parameter must not be null.
   */
  public void addToTranslations( Translation pTranslations ) {
    // Check parameter "pTranslations" for invalid value null.
    Check.checkInvalidParameterNull(pTranslations, "pTranslations");
    // Add passed object to collection of associated Translation objects.
    translations.add(pTranslations);
  }

  /**
   * Method adds all passed objects to the association "translations".
   * 
   * 
   * @param pTranslations Collection with all objects that should be added to the association "translations". The
   * parameter must not be null.
   */
  public void addToTranslations( Collection<Translation> pTranslations ) {
    // Check parameter "pTranslations" for invalid value null.
    Check.checkInvalidParameterNull(pTranslations, "pTranslations");
    // Add all passed objects.
    for (Translation lNextObject : pTranslations) {
      this.addToTranslations(lNextObject);
    }
  }

  /**
   * Method removes the passed Translation object from the association "translations".
   * 
   * 
   * @param pTranslations Object that should be removed from the association "translations". The parameter must not be
   * null.
   */
  public void removeFromTranslations( Translation pTranslations ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTranslations, "pTranslations");
    // Remove passed object from collection of associated Translation objects.
    translations.remove(pTranslations);
  }

  /**
   * Method removes all objects from the association "translations".
   * 
   */
  public void clearTranslations( ) {
    // Remove all objects from association "translations".
    Collection<Translation> lTranslations = new HashSet<Translation>(translations);
    Iterator<Translation> lIterator = lTranslations.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTranslations(lIterator.next());
    }
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "id", "" + id));
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
