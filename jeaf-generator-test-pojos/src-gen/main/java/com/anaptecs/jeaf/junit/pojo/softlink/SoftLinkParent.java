/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo.softlink;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Generated("com.anaptecs.jeaf.generator.JEAFGenerator")
@SuppressWarnings("JEAF_SUPPRESS_WARNINGS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = SoftLinkChildA.class, name = "SoftLinkChildA"),
  @JsonSubTypes.Type(value = SoftLinkChildB.class, name = "SoftLinkChildB") })
public class SoftLinkParent {
  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  /**
   * Constant for the name of attribute "thePartner".
   */
  public static final String THEPARTNER = "thePartner";

  /**
   * Constant for the name of attribute "readonlyPartner".
   */
  public static final String READONLYPARTNER = "readonlyPartner";

  private Set<SoftLinkID> partners;

  private SoftLinkID thePartner;

  private final SoftLinkID readonlyPartner;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SoftLinkParent( ) {
    partners = new HashSet<SoftLinkID>();
    readonlyPartner = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SoftLinkParent( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.partners != null) {
      partners = pBuilder.partners;
    }
    else {
      partners = new HashSet<SoftLinkID>();
    }
    thePartner = pBuilder.thePartner;
    readonlyPartner = pBuilder.readonlyPartner;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SoftLinkParent objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SoftLinkParent objects. The method never returns
   * null.
   */
  public static Builder builder( SoftLinkParent pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class SoftLinkParent. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<SoftLinkID> partners;

    /**
     * 
     */
    private SoftLinkID thePartner;

    /**
     * 
     */
    private SoftLinkID readonlyPartner;

    /**
     * Use {@link SoftLinkParent#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SoftLinkParent#builder(SoftLinkParent)} instead of private constructor to create new builder.
     */
    protected Builder( SoftLinkParent pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        partners = pObject.partners;
        thePartner = pObject.thePartner;
        readonlyPartner = pObject.readonlyPartner;
      }
    }

    /**
     * Method sets the association "partners".
     * 
     * @param pPartners Collection with objects to which the association should be set.
     */
    public Builder setPartners( Set<SoftLinkID> pPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPartners != null) {
        partners = new HashSet<SoftLinkID>(pPartners);
      }
      else {
        partners = null;
      }
      return this;
    }

    /**
     * Method sets the association "thePartner".
     * 
     * @param pThePartner SoftLinkPartner to which the association "thePartner" should be set.
     */
    public Builder setThePartner( SoftLinkID pThePartner ) {
      thePartner = pThePartner;
      return this;
    }

    /**
     * Method sets the association "readonlyPartner".
     * 
     * @param pReadonlyPartner SoftLinkPartner to which the association "readonlyPartner" should be set.
     */
    public Builder setReadonlyPartner( SoftLinkID pReadonlyPartner ) {
      readonlyPartner = pReadonlyPartner;
      return this;
    }

    /**
     * Method creates a new instance of class SoftLinkParent. The object will be initialized with the values of the
     * builder.
     * 
     * @return SoftLinkParent Created object. The method never returns null.
     */
    public SoftLinkParent build( ) {
      return new SoftLinkParent(this);
    }

    /**
     * Method creates a new validated instance of class SoftLinkParent. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return SoftLinkParent Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SoftLinkParent buildValidated( ) throws ConstraintViolationException {
      SoftLinkParent lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "partners".
   * 
   *
   * @return Collection All SoftLinkPartner objects that belong to the association "partners". The method never returns
   * null and the returned collection is unmodifiable.
   */
  /**
   * Method returns association {@link #partners}.<br/>
   * 
   * @return {@link Set<SoftLinkID>} Value to which {@link #partners} is set. Actual type:
   * com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner
   */
  public Set<SoftLinkID> getPartners( ) {
    // Return all SoftLinkPartner objects as unmodifiable collection.
    return Collections.unmodifiableSet(partners);
  }

  /**
   * Method adds the passed SoftLinkPartner object to the association "partners".
   * 
   * 
   * @param pPartners Object that should be added to the association "partners". The parameter must not be null.
   */
  public void addToPartners( SoftLinkID pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add passed object to collection of associated SoftLinkPartner objects.
    partners.add(pPartners);
  }

  /**
   * Method adds all passed objects to the association "partners".
   * 
   * 
   * @param pPartners Collection with all objects that should be added to the association "partners". The parameter must
   * not be null.
   */
  public void addToPartners( Collection<SoftLinkID> pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add all passed objects.
    for (SoftLinkID lNextObject : pPartners) {
      this.addToPartners(lNextObject);
    }
  }

  /**
   * Method removes the passed SoftLinkPartner object from the association "partners".
   * 
   * 
   * @param pPartners Object that should be removed from the association "partners". The parameter must not be null.
   */
  public void removeFromPartners( SoftLinkID pPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Remove passed object from collection of associated SoftLinkPartner objects.
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
   * Method returns association {@link #thePartner}.<br/>
   * 
   * @return {@link SoftLinkID} Value to which {@link #thePartner} is set. Actual type:
   * com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner
   */
  public SoftLinkID getThePartner( ) {
    return thePartner;
  }

  /**
   * Method sets association {@link #thePartner}.<br/>
   * 
   * @param pThePartner Value to which {@link #thePartner} should be set.
   */
  public void setThePartner( SoftLinkID pThePartner ) {
    thePartner = pThePartner;
  }

  /**
   * Method unsets the association "thePartner".
   * 
   */
  public final void unsetThePartner( ) {
    thePartner = null;
  }

  /**
   * Method returns association {@link #readonlyPartner}.<br/>
   * 
   * @return {@link SoftLinkID} Value to which {@link #readonlyPartner} is set. Actual type:
   * com.anaptecs.jeaf.junit.pojo.softlink.SoftLinkPartner
   */
  public SoftLinkID getReadonlyPartner( ) {
    return readonlyPartner;
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
}
