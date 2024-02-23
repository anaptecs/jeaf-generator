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

public class Partner {
  /**
   * Constant for the name of attribute "postalAddresses".
   */
  public static final String POSTALADDRESSES = "postalAddresses";

  private List<PostalAddress> postalAddresses;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Partner( ) {
    postalAddresses = new ArrayList<PostalAddress>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Partner( Builder pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.postalAddresses != null) {
      postalAddresses = pBuilder.postalAddresses;
    }
    else {
      postalAddresses = new ArrayList<PostalAddress>();
    }
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
   * Convenience method to create new instance of class Partner.
   *
   *
   * @return {@link com.anaptecs.spring.base.Partner}
   */
  public static Partner of( ) {
    Partner.Builder lBuilder = Partner.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Partner</code>.
   */
  public static class Builder {
    private List<PostalAddress> postalAddresses;

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
        this.setPostalAddresses(pObject.postalAddresses);
      }
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

    /**
     * Method creates a new instance of class Partner. The object will be initialized with the values of the builder.
     *
     * @return Partner Created object. The method never returns null.
     */
    public Partner build( ) {
      return new Partner(this);
    }
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(postalAddresses);
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
      Partner lOther = (Partner) pObject;
      lEquals = Objects.equals(postalAddresses, lOther.postalAddresses);
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
    lBuilder.append("postalAddresses: ");
    if (postalAddresses != null) {
      lBuilder.append(postalAddresses.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (postalAddresses != null) {
      for (PostalAddress lNext : postalAddresses) {
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
   * @return {@link Builder} New builder that can be used to create new Partner objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
