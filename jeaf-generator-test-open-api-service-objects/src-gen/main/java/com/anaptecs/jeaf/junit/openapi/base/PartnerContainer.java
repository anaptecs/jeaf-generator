/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
public class PartnerContainer implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  /**
   * 
   */
  private List<Partner> partners = new ArrayList<Partner>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PartnerContainer( ) {
    // Nothing to do.
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
      partners.addAll(pBuilder.partners);
    }
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(PartnerContainer)} instead of private constructor to create new builder.
     */
    protected Builder( PartnerContainer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        partners = pObject.partners;
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
     * @return {@link Builder} New builder that can be used to create new PartnerContainer objects. The method never
     * returns null.
     */
    public static Builder newBuilder( PartnerContainer pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class PartnerContainer. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return PartnerContainer Created object. The method never returns null.
     */
    public PartnerContainer build( boolean pValidate ) {
      PartnerContainer lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
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
   * Method sets the association "partners" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pPartners Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setPartners( List<Partner> pPartners ) {
    // Check of parameter is not required.
    // Remove all objects from association "partners".
    this.clearPartners();
    // If the association is null, removing all entries is sufficient.
    if (pPartners != null) {
      partners = new ArrayList<Partner>(pPartners);
    }
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
    Collection<Partner> lPartners = new HashSet<Partner>(partners);
    Iterator<Partner> lIterator = lPartners.iterator();
    while (lIterator.hasNext()) {
      this.removeFromPartners(lIterator.next());
    }
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
