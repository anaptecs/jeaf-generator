/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

import ch.voev.nova.inventory.api.booking.FulfillmentType;

/**
 * CIT paper implies printing on value paper which is stock controlled.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class FulfillmentOption {
  /**
   * Constant for the name of attribute "type".
   */
  public static final String TYPE = "type";

  /**
   * Constant for the name of attribute "media".
   */
  public static final String MEDIA = "media";

  /**
   * 
   */
  private FulfillmentType type;

  /**
   * 
   */
  private List<FulfillmentMediaType> media;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected FulfillmentOption( ) {
    media = new ArrayList<FulfillmentMediaType>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected FulfillmentOption( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    type = pBuilder.type;
    if (pBuilder.media != null) {
      media = pBuilder.media;
    }
    else {
      media = new ArrayList<FulfillmentMediaType>();
    }
  }

  /**
   * Class implements builder to create a new instance of class FulfillmentOption. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private FulfillmentType type;

    /**
     * 
     */
    private List<FulfillmentMediaType> media;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(FulfillmentOption)} instead of private constructor to create new builder.
     */
    protected Builder( FulfillmentOption pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        type = pObject.type;
        media = pObject.media;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new FulfillmentOption objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new FulfillmentOption objects. The method never
     * returns null.
     */
    public static Builder newBuilder( FulfillmentOption pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "type".
     * 
     * @param pType FulfillmentType to which the association "type" should be set.
     */
    public Builder setType( FulfillmentType pType ) {
      type = pType;
      return this;
    }

    /**
     * Method sets the association "media".
     * 
     * @param pMedia Collection with objects to which the association should be set.
     */
    public Builder setMedia( List<FulfillmentMediaType> pMedia ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMedia != null) {
        media = new ArrayList<FulfillmentMediaType>(pMedia);
      }
      else {
        media = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class FulfillmentOption. The object will be initialized with the values of the
     * builder.
     * 
     * @return FulfillmentOption Created object. The method never returns null.
     */
    public FulfillmentOption build( ) {
      return new FulfillmentOption(this);
    }

    /**
     * Method creates a new validated instance of class FulfillmentOption. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return FulfillmentOption Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public FulfillmentOption buildValidated( ) throws ConstraintViolationException {
      FulfillmentOption lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "type".
   * 
   *
   * @return FulfillmentType FulfillmentType to which the association "type" is set.
   */
  public FulfillmentType getType( ) {
    return type;
  }

  /**
   * Method sets the association "type".
   * 
   * 
   * @param pType FulfillmentType to which the association "type" should be set.
   */
  public void setType( FulfillmentType pType ) {
    type = pType;
  }

  /**
   * Method unsets the association "type".
   * 
   */
  public final void unsetType( ) {
    type = null;
  }

  /**
   * Method returns the association "media".
   * 
   *
   * @return Collection All FulfillmentMediaType objects that belong to the association "media". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public List<FulfillmentMediaType> getMedia( ) {
    // Return all FulfillmentMediaType objects as unmodifiable collection.
    return Collections.unmodifiableList(media);
  }

  /**
   * Method adds the passed FulfillmentMediaType object to the association "media".
   * 
   * 
   * @param pMedia Object that should be added to the association "media". The parameter must not be null.
   */
  public void addToMedia( FulfillmentMediaType pMedia ) {
    // Check parameter "pMedia" for invalid value null.
    Check.checkInvalidParameterNull(pMedia, "pMedia");
    // Add passed object to collection of associated FulfillmentMediaType objects.
    media.add(pMedia);
  }

  /**
   * Method adds all passed objects to the association "media".
   * 
   * 
   * @param pMedia Collection with all objects that should be added to the association "media". The parameter must not
   * be null.
   */
  public void addToMedia( Collection<FulfillmentMediaType> pMedia ) {
    // Check parameter "pMedia" for invalid value null.
    Check.checkInvalidParameterNull(pMedia, "pMedia");
    // Add all passed objects.
    for (FulfillmentMediaType lNextObject : pMedia) {
      this.addToMedia(lNextObject);
    }
  }

  /**
   * Method removes the passed FulfillmentMediaType object from the association "media".
   * 
   * 
   * @param pMedia Object that should be removed from the association "media". The parameter must not be null.
   */
  public void removeFromMedia( FulfillmentMediaType pMedia ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pMedia, "pMedia");
    // Remove passed object from collection of associated FulfillmentMediaType objects.
    media.remove(pMedia);
  }

  /**
   * Method removes all objects from the association "media".
   * 
   */
  public void clearMedia( ) {
    // Remove all objects from association "media".
    media.clear();
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
