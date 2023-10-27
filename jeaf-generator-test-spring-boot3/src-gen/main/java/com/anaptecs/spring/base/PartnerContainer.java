/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PartnerContainer {
  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  private List<Partner> partners;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects. The method never
   * returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( PartnerContainer pObject ) {
    return new Builder(pObject);
  }

  /**
   * Convenience method to create new instance of class PartnerContainer.
   *
   *
   * @return {@link PartnerContainer}
   */
  public static PartnerContainer of( ) {
    PartnerContainer.Builder lBuilder = PartnerContainer.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PartnerContainer</code>.
   */
  public static class Builder {
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
        this.setPartners(pObject.partners);
      }
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #partners}.<br/>
     *
     * @param pPartners Array of objects that should be added to {@link #partners}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToPartners( Partner... pPartners ) {
      if (pPartners != null) {
        if (partners == null) {
          partners = new ArrayList<Partner>();
        }
        partners.addAll(Arrays.asList(pPartners));
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
  }

  /**
   * Method returns association {@link #partners}.<br/>
   *
   * @return {@link List<Partner>} Value to which {@link #partners} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<Partner> getPartners( ) {
    // Return all Partner objects as unmodifiable collection.
    return Collections.unmodifiableList(partners);
  }

  /**
   * Method adds the passed object to {@link #partners}.
   *
   * @param pPartners Object that should be added to {@link #partners}. The parameter must not be null.
   */
  public void addToPartners( Partner pPartners ) {
    // Add passed object to collection of associated Partner objects.
    partners.add(pPartners);
  }

  /**
   * Method adds all passed objects to {@link #partners}.
   *
   * @param pPartners Collection with all objects that should be added to {@link #partners}. The parameter must not be
   * null.
   */
  public void addToPartners( Collection<Partner> pPartners ) {
    // Add all passed objects.
    for (Partner lNextObject : pPartners) {
      this.addToPartners(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #partners}.<br/>
   *
   * @param pPartners Object that should be removed from {@link #partners}. The parameter must not be null.
   */
  public void removeFromPartners( Partner pPartners ) {
    // Remove passed object from collection of associated Partner objects.
    partners.remove(pPartners);
  }

  /**
   * Method removes all objects from {@link #partners}.
   */
  public void clearPartners( ) {
    // Remove all objects from association "partners".
    partners.clear();
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(partners);
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
      PartnerContainer lOther = (PartnerContainer) pObject;
      lEquals = Objects.equals(partners, lOther.partners);
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
    lBuilder.append("partners: ");
    if (partners != null) {
      lBuilder.append(partners.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (partners != null) {
      for (Partner lNext : partners) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
