/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerContainer implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  /**
   * 
   */
  private List<Partner> partners;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PartnerContainer( ) {
    partners = new ArrayList<Partner>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PartnerContainer( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.partners != null) {
      partners = pBuilder.partners;
    }
    else {
      partners = new ArrayList<Partner>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects. The method never
   * returns null.
   */
  public static Builder builder( PartnerContainer pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PartnerContainer. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<Partner> partners;

    /**
     * Use {@link PartnerContainer#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PartnerContainer#builder(PartnerContainer)} instead of private constructor to create new builder.
     */
    protected Builder( PartnerContainer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        partners = pObject.partners;
      }
    }

    /**
     * Method sets the association "partners".
     * 
     * @param pPartners Collection with objects to which the association should be set.
     */
    public Builder setPartners( List<Partner> pPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPartners != null) {
        partners = new ArrayList<Partner>(pPartners);
      }
      else {
        partners = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PartnerContainer. The object will be initialized with the values of the
     * builder.
     * 
     * @return PartnerContainer Created object. The method never returns null.
     */
    public PartnerContainer build( ) {
      return new PartnerContainer(this);
    }

    /**
     * Method creates a new validated instance of class PartnerContainer. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return PartnerContainer Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PartnerContainer buildValidated( ) throws ConstraintViolationException {
      PartnerContainer lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "partners".
   * 
   *
   * @return Collection All Partner objects that belong to the association "partners". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<Partner> getPartners( ) {
    // Return all Partner objects as unmodifiable collection.
    return Collections.unmodifiableList(partners);
  }

  /**
   * Method adds the passed Partner object to the association "partners".
   * 
   * 
   * @param pPartners Object that should be added to the association "partners". The parameter must not be null.
   */
  public void addToPartners( Partner pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add passed object to collection of associated Partner objects.
    partners.add(pPartners);
  }

  /**
   * Method adds all passed objects to the association "partners".
   * 
   * 
   * @param pPartners Collection with all objects that should be added to the association "partners". The parameter must
   * not be null.
   */
  public void addToPartners( Collection<Partner> pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add all passed objects.
    for (Partner lNextObject : pPartners) {
      this.addToPartners(lNextObject);
    }
  }

  /**
   * Method removes the passed Partner object from the association "partners".
   * 
   * 
   * @param pPartners Object that should be removed from the association "partners". The parameter must not be null.
   */
  public void removeFromPartners( Partner pPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Remove passed object from collection of associated Partner objects.
    partners.remove(pPartners);
  }

  /**
   * Method removes all objects from the association "partners".
   * 
   */
  public void clearPartners( ) {
    // Remove all objects from association "partners".
    partners.clear();
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
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
