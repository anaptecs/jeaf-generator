/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class Sortiment implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  private Set<Product> products;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean productsBackReferenceInitialized;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Sortiment( ) {
    products = new HashSet<Product>();
    // Bidirectional back reference is not yet set up correctly
    productsBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Sortiment( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.products != null) {
      products = pBuilder.products;
    }
    else {
      products = new HashSet<Product>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    productsBackReferenceInitialized = true;
  }

  /**
   * Class implements builder to create a new instance of class Sortiment. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<Product> products;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Sortiment)} instead of private constructor to create new builder.
     */
    protected Builder( Sortiment pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        products = pObject.products;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Sortiment objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Sortiment objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Sortiment pObject ) {
      return new Builder(pObject);
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
     * Method creates a new instance of class Sortiment. The object will be initialized with the values of the builder.
     * 
     * @return Sortiment Created object. The method never returns null.
     */
    public Sortiment build( ) {
      return new Sortiment(this);
    }

    /**
     * Method creates a new validated instance of class Sortiment. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Sortiment Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Sortiment buildValidated( ) throws ConstraintViolationException {
      Sortiment lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "products".
   * 
   *
   * @return Collection All Product objects that belong to the association "products". The method never returns null and
   * the returned collection is modifiable.
   */
  public Set<Product> getProducts( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (productsBackReferenceInitialized == false) {
      productsBackReferenceInitialized = true;
      for (Product lNext : products) {
        lNext.addToSortiments((Sortiment) this);
      }
    }
    // Return all Product objects directly without any protection against modification.
    return products;
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
    if (pProducts != null && pProducts.getSortiments().contains(this) == false) {
      pProducts.addToSortiments((Sortiment) this);
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
    if (pProducts.getSortiments().contains(this) == true) {
      pProducts.removeFromSortiments((Sortiment) this);
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
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromProducts(lIterator.next());
    }
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
