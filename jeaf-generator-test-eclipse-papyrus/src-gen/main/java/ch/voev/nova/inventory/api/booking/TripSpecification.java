/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * A minimal trip specification from origin to destination.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TripSpecification {
  /**
   * Constant for the name of attribute "externalRef".
   */
  public static final String EXTERNALREF = "externalRef";

  /**
   * Constant for the name of attribute "legs".
   */
  public static final String LEGS = "legs";

  /**
   * External reference of this trip for referencing purposes. Unique within a trip specification.
   */
  @NotNull
  private String externalRef;

  /**
   * 
   */
  private List<TripLegSpecification> legs;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TripSpecification( ) {
    legs = new ArrayList<TripLegSpecification>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TripSpecification( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    externalRef = pBuilder.externalRef;
    if (pBuilder.legs != null) {
      legs = pBuilder.legs;
    }
    else {
      legs = new ArrayList<TripLegSpecification>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new TripSpecification objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TripSpecification objects. The method never
   * returns null.
   */
  public static Builder builder( TripSpecification pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class TripSpecification. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * External reference of this trip for referencing purposes. Unique within a trip specification.
     */
    @NotNull
    private String externalRef;

    /**
     * 
     */
    private List<TripLegSpecification> legs;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(TripSpecification)} instead of private constructor to create new builder.
     */
    protected Builder( TripSpecification pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        externalRef = pObject.externalRef;
        legs = pObject.legs;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new TripSpecification objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new TripSpecification objects. The method never
     * returns null.
     */
    public static Builder newBuilder( TripSpecification pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "externalRef". External reference of this trip for referencing purposes. Unique within
     * a trip specification.
     * 
     * @param pExternalRef Value to which the attribute "externalRef" should be set.
     */
    public Builder setExternalRef( String pExternalRef ) {
      // Assign value to attribute
      externalRef = pExternalRef;
      return this;
    }

    /**
     * Method sets the association "legs".
     * 
     * @param pLegs Collection with objects to which the association should be set.
     */
    public Builder setLegs( List<TripLegSpecification> pLegs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLegs != null) {
        legs = new ArrayList<TripLegSpecification>(pLegs);
      }
      else {
        legs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class TripSpecification. The object will be initialized with the values of the
     * builder.
     * 
     * @return TripSpecification Created object. The method never returns null.
     */
    public TripSpecification build( ) {
      return new TripSpecification(this);
    }

    /**
     * Method creates a new validated instance of class TripSpecification. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return TripSpecification Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TripSpecification buildValidated( ) throws ConstraintViolationException {
      TripSpecification lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "externalRef". External reference of this trip for referencing purposes. Unique within
   * a trip specification.
   * 
   * @return String Value to which the attribute "externalRef" is set.
   */
  public String getExternalRef( ) {
    return externalRef;
  }

  /**
   * Method sets the attribute "externalRef". External reference of this trip for referencing purposes. Unique within a
   * trip specification.
   * 
   * @param pExternalRef Value to which the attribute "externalRef" should be set.
   */
  public void setExternalRef( String pExternalRef ) {
    // Assign value to attribute
    externalRef = pExternalRef;
  }

  /**
   * Method returns the association "legs".
   * 
   *
   * @return Collection All TripLegSpecification objects that belong to the association "legs". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<TripLegSpecification> getLegs( ) {
    // Return all TripLegSpecification objects as unmodifiable collection.
    return Collections.unmodifiableList(legs);
  }

  /**
   * Method adds the passed TripLegSpecification object to the association "legs".
   * 
   * 
   * @param pLegs Object that should be added to the association "legs". The parameter must not be null.
   */
  public void addToLegs( TripLegSpecification pLegs ) {
    // Check parameter "pLegs" for invalid value null.
    Check.checkInvalidParameterNull(pLegs, "pLegs");
    // Add passed object to collection of associated TripLegSpecification objects.
    legs.add(pLegs);
  }

  /**
   * Method adds all passed objects to the association "legs".
   * 
   * 
   * @param pLegs Collection with all objects that should be added to the association "legs". The parameter must not be
   * null.
   */
  public void addToLegs( Collection<TripLegSpecification> pLegs ) {
    // Check parameter "pLegs" for invalid value null.
    Check.checkInvalidParameterNull(pLegs, "pLegs");
    // Add all passed objects.
    for (TripLegSpecification lNextObject : pLegs) {
      this.addToLegs(lNextObject);
    }
  }

  /**
   * Method removes the passed TripLegSpecification object from the association "legs".
   * 
   * 
   * @param pLegs Object that should be removed from the association "legs". The parameter must not be null.
   */
  public void removeFromLegs( TripLegSpecification pLegs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pLegs, "pLegs");
    // Remove passed object from collection of associated TripLegSpecification objects.
    legs.remove(pLegs);
  }

  /**
   * Method removes all objects from the association "legs".
   * 
   */
  public void clearLegs( ) {
    // Remove all objects from association "legs".
    legs.clear();
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
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "externalRef", "" + externalRef));
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
