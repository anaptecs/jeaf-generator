/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.core.api.ServiceObjectID;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.common.Identifiable;
import com.anaptecs.jeaf.xfun.api.common.ObjectIdentity;

public class Partner implements ServiceObject, Identifiable<ServiceObjectID> {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "postalAddresses".
   */
  public static final String POSTALADDRESSES = "postalAddresses";

  /**
   * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
   */
  private final ServiceObjectID objectID;

  // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
  @ClassPropertyDeclaration
  private List<PostalAddress> postalAddresses;

  // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
  private int postalAddressesXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Partner( ) {
    objectID = null;
    postalAddresses = new ArrayList<PostalAddress>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Partner( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read object ID.
    ObjectIdentity<?> lObjectID = pBuilder.objectID;
    if (lObjectID != null) {
      objectID = new ServiceObjectID(pBuilder.objectID);
    }
    else {
      objectID = null;
    }
    // Read attribute values from builder.
    if (pBuilder.postalAddresses != null) {
      postalAddresses = pBuilder.postalAddresses;
    }
    else {
      postalAddresses = new ArrayList<PostalAddress>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
    postalAddressesXYZ = pBuilder.postalAddressesXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Partner objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>Partner</code>.
   */
  public static class Builder {
    /**
     * Reference to the identifier of this object. The reference may be null since an id is not mandatory.
     */
    private ObjectIdentity<?> objectID;

    // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
    @BuilderPropertyDeclaration
    private List<PostalAddress> postalAddresses;

    // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
    private int postalAddressesXYZ = 0;

    /**
     * Use {@link Partner#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Partner#builder(Partner)} instead of private constructor to create new builder.
     */
    protected Builder( Partner pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        objectID = pObject.objectID;
        this.setPostalAddresses(pObject.postalAddresses);
      }
    }

    /**
     * Method sets the identifier for the object created using the builder. The reference may be null since an id is not
     * mandatory.
     */
    public Builder setID( ObjectIdentity<?> pObjectID ) {
      objectID = pObjectID;
      return this;
    }

    /**
     * Method sets association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Collection to which {@link #postalAddresses} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPostalAddresses != null) {
        postalAddresses = new ArrayList<PostalAddress>(pPostalAddresses);
      }
      else {
        postalAddresses = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #postalAddresses}.<br/>
     *
     * @param pPostalAddresses Array of objects that should be added to {@link #postalAddresses}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToPostalAddresses( PostalAddress... pPostalAddresses ) {
      if (pPostalAddresses != null) {
        if (postalAddresses == null) {
          postalAddresses = new ArrayList<PostalAddress>();
        }
        postalAddresses.addAll(Arrays.asList(pPostalAddresses));
      }
      return this;
    }

    public Builder setPostalAddressesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
      postalAddressesXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class Partner. The object will be initialized with the values of the builder.
     *
     * @return Partner Created object. The method never returns null.
     */
    public Partner build( ) {
      return new Partner(this);
    }

    /**
     * Method creates a new validated instance of class Partner. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Partner Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Partner buildValidated( ) throws ConstraintViolationException {
      Partner lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns the id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getID( ) {
    return objectID;
  }

  /**
   * Method returns the unversioned object id of this object.
   *
   * @return {@link ServiceObjectID} ID of this object. Since an object must not have an id the method may also return
   * null.
   */
  @Override
  public final ServiceObjectID getUnversionedID( ) {
    ServiceObjectID lUnversionedID;
    if (objectID != null) {
      lUnversionedID = objectID.getUnversionedObjectID();
    }
    else {
      lUnversionedID = null;
    }
    return lUnversionedID;
  }

  /**
   * Method returns association {@link #postalAddresses}.<br/>
   *
   * @return {@link List<PostalAddress>} Value to which {@link #postalAddresses} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public List<PostalAddress> getPostalAddresses( ) {
    // Return all PostalAddress objects as unmodifiable collection.
    return Collections.unmodifiableList(postalAddresses);
  }

  /**
   * Method adds the passed object to {@link #postalAddresses}.
   *
   * @param pPostalAddresses Object that should be added to {@link #postalAddresses}. The parameter must not be null.
   */
  public void addToPostalAddresses( PostalAddress pPostalAddresses ) {
    // Check parameter "pPostalAddresses" for invalid value null.
    Check.checkInvalidParameterNull(pPostalAddresses, "pPostalAddresses");
    // Add passed object to collection of associated PostalAddress objects.
    postalAddresses.add(pPostalAddresses);
  }

  /**
   * Method adds all passed objects to {@link #postalAddresses}.
   *
   * @param pPostalAddresses Collection with all objects that should be added to {@link #postalAddresses}. The parameter
   * must not be null.
   */
  public void addToPostalAddresses( Collection<PostalAddress> pPostalAddresses ) {
    // Check parameter "pPostalAddresses" for invalid value null.
    Check.checkInvalidParameterNull(pPostalAddresses, "pPostalAddresses");
    // Add all passed objects.
    for (PostalAddress lNextObject : pPostalAddresses) {
      this.addToPostalAddresses(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #postalAddresses}.<br/>
   *
   * @param pPostalAddresses Object that should be removed from {@link #postalAddresses}. The parameter must not be
   * null.
   */
  public void removeFromPostalAddresses( PostalAddress pPostalAddresses ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPostalAddresses, "pPostalAddresses");
    // Remove passed object from collection of associated PostalAddress objects.
    postalAddresses.remove(pPostalAddresses);
  }

  /**
   * Method removes all objects from {@link #postalAddresses}.
   */
  public void clearPostalAddresses( ) {
    // Remove all objects from association "postalAddresses".
    postalAddresses.clear();
  }

  public int getPostalAddressesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.PostalAddress"
    return postalAddressesXYZ;
  }

  public void setPostalAddressesXYZ( int value ) {
    postalAddressesXYZ = value;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new Partner objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
