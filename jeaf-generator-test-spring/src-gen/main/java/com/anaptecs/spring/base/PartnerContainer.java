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

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
@JsonDeserialize(builder = PartnerContainer.PartnerContainerBuilderImpl.class)
public class PartnerContainer {
  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  private List<Partner> partners;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PartnerContainer( PartnerContainerBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.partners != null) {
      partners = pBuilder.partners;
    }
    else {
      partners = new ArrayList<>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects.
   */
  public static PartnerContainerBuilder<?, ?> builder( ) {
    return new PartnerContainerBuilderImpl();
  }

  /**
   * Convenience method to create new instance of class PartnerContainer.
   *
   *
   * @return {@link PartnerContainer}
   */
  public static PartnerContainer of( ) {
    PartnerContainerBuilder<?, ?> lBuilder = PartnerContainer.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>PartnerContainer</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class PartnerContainerBuilder<T extends PartnerContainer, B extends PartnerContainerBuilder<T, B>> {
    private List<Partner> partners;

    /**
     * Use {@link PartnerContainerBuilder#builder()} instead of private constructor to create new builder.
     */
    protected PartnerContainerBuilder( ) {
    }

    /**
     * Use {@link PartnerContainerBuilder#builder(PartnerContainer)} instead of private constructor to create new
     * builder.
     */
    protected PartnerContainerBuilder( PartnerContainer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setPartners(pObject.partners);
      }
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    public B setPartners( List<Partner> pPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPartners != null) {
        partners = new ArrayList<Partner>(pPartners);
      }
      else {
        partners = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #partners}.<br/>
     *
     * @param pPartners Array of objects that should be added to {@link #partners}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToPartners( Partner... pPartners ) {
      if (pPartners != null) {
        if (partners == null) {
          partners = new ArrayList<Partner>();
        }
        partners.addAll(Arrays.asList(pPartners));
      }
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );

    /**
     * Method creates a new instance of class PartnerContainer. The object will be initialized with the values of the
     * builder.
     *
     * @return PartnerContainer Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class PartnerContainerBuilderImpl
      extends PartnerContainerBuilder<PartnerContainer, PartnerContainerBuilderImpl> {
    protected PartnerContainerBuilderImpl( ) {
    }

    protected PartnerContainerBuilderImpl( PartnerContainer pObject ) {
      super(pObject);
    }

    @Override
    protected PartnerContainerBuilderImpl self( ) {
      return this;
    }

    @Override
    public PartnerContainer build( ) {
      PartnerContainer lObject = new PartnerContainer(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
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
  public PartnerContainerBuilder<?, ?> toBuilder( ) {
    return new PartnerContainerBuilderImpl(this);
  }
}