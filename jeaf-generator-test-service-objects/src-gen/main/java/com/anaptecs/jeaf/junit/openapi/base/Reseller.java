/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Reseller implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "channels".
   */
  public static final String CHANNELS = "channels";

  /**
   * Constant for the name of attribute "products".
   */
  public static final String PRODUCTS = "products";

  /**
   * Constant for the name of attribute "language".
   */
  public static final String LANGUAGE = "language";

  /**
   * 
   */
  private Set<Channel> channels = new HashSet<Channel>();

  /**
   * 
   */
  private Set<Product> products = new HashSet<Product>();

  /**
   * 
   */
  private Locale language;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Reseller( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.channels != null) {
      channels.addAll(pBuilder.channels);
    }
    if (pBuilder.products != null) {
      products.addAll(pBuilder.products);
    }
    language = pBuilder.language;
  }

  /**
   * Class implements builder to create a new instance of class Reseller. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<Channel> channels;

    /**
     * 
     */
    private Set<Product> products;

    /**
     * 
     */
    private Locale language;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Reseller)} instead of private constructor to create new builder.
     */
    protected Builder( Reseller pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        channels = pObject.channels;
        products = pObject.products;
        language = pObject.language;
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
     * @return {@link Builder} New builder that can be used to create new Reseller objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Reseller pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "channels".
     * 
     * @param pChannels Collection with objects to which the association should be set.
     */
    public Builder setChannels( Set<Channel> pChannels ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pChannels != null) {
        channels = new HashSet<Channel>(pChannels);
      }
      else {
        channels = null;
      }
      return this;
    }

    /**
     * Method sets the association "products".
     * 
     * @param pProducts Collection with objects to which the association should be set.
     */
    public Builder setProducts( Set<Product> pProducts ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pProducts != null) {
        products = new HashSet<Product>(pProducts);
      }
      else {
        products = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "language".
     * 
     * @param pLanguage Value to which the attribute "language" should be set.
     */
    public Builder setLanguage( Locale pLanguage ) {
      // Assign value to attribute
      language = pLanguage;
      return this;
    }

    /**
     * Method creates a new instance of class Reseller. The object will be initialized with the values of the builder.
     * 
     * @return Reseller Created object. The method never returns null.
     */
    public Reseller build( ) {
      return new Reseller(this);
    }

    /**
     * Method creates a new instance of class Reseller. The object will be initialized with the values of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return Reseller Created object. The method never returns null.
     */
    public Reseller build( boolean pValidate ) {
      Reseller lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the association "channels".
   * 
   *
   * @return Collection All Channel objects that belong to the association "channels". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Channel> getChannels( ) {
    // Return all Channel objects as unmodifiable collection.
    return Collections.unmodifiableSet(channels);
  }

  /**
   * Method sets the association "channels" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pChannels Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setChannels( Set<Channel> pChannels ) {
    // Check of parameter is not required.
    // Remove all objects from association "channels".
    this.clearChannels();
    // If the association is null, removing all entries is sufficient.
    if (pChannels != null) {
      channels = new HashSet<Channel>(pChannels);
    }
  }

  /**
   * Method adds the passed Channel object to the association "channels".
   * 
   * 
   * @param pChannels Object that should be added to the association "channels". The parameter must not be null.
   */
  public void addToChannels( Channel pChannels ) {
    // Check parameter "pChannels" for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
    // Add passed object to collection of associated Channel objects.
    channels.add(pChannels);
  }

  /**
   * Method adds all passed objects to the association "channels".
   * 
   * 
   * @param pChannels Collection with all objects that should be added to the association "channels". The parameter must
   * not be null.
   */
  public void addToChannels( Collection<Channel> pChannels ) {
    // Check parameter "pChannels" for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
    // Add all passed objects.
    for (Channel lNextObject : pChannels) {
      this.addToChannels(lNextObject);
    }
  }

  /**
   * Method removes the passed Channel object from the association "channels".
   * 
   * 
   * @param pChannels Object that should be removed from the association "channels". The parameter must not be null.
   */
  public void removeFromChannels( Channel pChannels ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pChannels, "pChannels");
    // Remove passed object from collection of associated Channel objects.
    channels.remove(pChannels);
  }

  /**
   * Method removes all objects from the association "channels".
   * 
   */
  public void clearChannels( ) {
    // Remove all objects from association "channels".
    Collection<Channel> lChannels = new HashSet<Channel>(channels);
    Iterator<Channel> lIterator = lChannels.iterator();
    while (lIterator.hasNext()) {
      this.removeFromChannels(lIterator.next());
    }
  }

  /**
   * Method returns the association "products".
   * 
   *
   * @return Collection All Product objects that belong to the association "products". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Product> getProducts( ) {
    // Return all Product objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method sets the association "products" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pProducts Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setProducts( Set<Product> pProducts ) {
    // Check of parameter is not required.
    // Remove all objects from association "products".
    this.clearProducts();
    // If the association is null, removing all entries is sufficient.
    if (pProducts != null) {
      products = new HashSet<Product>(pProducts);
    }
  }

  /**
   * Method adds the passed Product object to the association "products".
   * 
   * 
   * @param pProducts Object that should be added to the association "products". The parameter must not be null.
   */
  public void addToProducts( Product pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add passed object to collection of associated Product objects.
    products.add(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts != null && pProducts.getResellers().contains(this) == false) {
      pProducts.addToResellers((Reseller) this);
    }
  }

  /**
   * Method adds all passed objects to the association "products".
   * 
   * 
   * @param pProducts Collection with all objects that should be added to the association "products". The parameter must
   * not be null.
   */
  public void addToProducts( Collection<Product> pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add all passed objects.
    for (Product lNextObject : pProducts) {
      this.addToProducts(lNextObject);
    }
  }

  /**
   * Method removes the passed Product object from the association "products".
   * 
   * 
   * @param pProducts Object that should be removed from the association "products". The parameter must not be null.
   */
  public void removeFromProducts( Product pProducts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Remove passed object from collection of associated Product objects.
    products.remove(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts.getResellers().contains(this) == true) {
      pProducts.removeFromResellers((Reseller) this);
    }
  }

  /**
   * Method removes all objects from the association "products".
   * 
   */
  public void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<Product> lProducts = new HashSet<Product>(products);
    Iterator<Product> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      this.removeFromProducts(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "language".
   * 
   * 
   * @return Locale Value to which the attribute "language" is set.
   */
  public Locale getLanguage( ) {
    return language;
  }

  /**
   * Method sets the attribute "language".
   * 
   * 
   * @param pLanguage Value to which the attribute "language" should be set.
   */
  public void setLanguage( Locale pLanguage ) {
    // Assign value to attribute
    language = pLanguage;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "language", "" + language));
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