/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
    creatorVisibility = JsonAutoDetect.Visibility.ANY)
public class Sortiment {
  /**
   * Constant for the name of attribute "products".
   */
  public static final String PRODUCTS = "products";

  @JsonSetter(nulls = Nulls.SKIP)
  private Set<Product> products;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean productsBackReferenceInitialized;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
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
    // Read attribute values from builder.
    if (pBuilder.products != null) {
      products = pBuilder.products;
      // As association is bidirectional we also have to set it in the other direction.
      for (Product lNext : products) {
        lNext.addToSortiments((Sortiment) this);
      }
    }
    else {
      products = new HashSet<Product>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    productsBackReferenceInitialized = true;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Sortiment objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class Sortiment.
   *
   *
   * @return {@link Sortiment}
   */
  public static Sortiment of( ) {
    Sortiment.Builder lBuilder = Sortiment.builder();
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Sortiment</code>.
   */
  public static class Builder {
    private Set<Product> products;

    /**
     * Use {@link Sortiment#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Sortiment#builder(Sortiment)} instead of private constructor to create new builder.
     */
    protected Builder( Sortiment pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setProducts(pObject.products);
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
     * Method sets association {@link #products}.<br/>
     *
     * @param pProducts Collection to which {@link #products} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
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
     * Method adds the passed objects to association {@link #products}.<br/>
     *
     * @param pProducts Array of objects that should be added to {@link #products}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToProducts( Product... pProducts ) {
      if (pProducts != null) {
        if (products == null) {
          products = new HashSet<Product>();
        }
        products.addAll(Arrays.asList(pProducts));
      }
      return this;
    }

    /**
     * Method creates a new instance of class Sortiment. The object will be initialized with the values of the builder.
     *
     * @return Sortiment Created object. The method never returns null.
     */
    public Sortiment build( ) {
      Sortiment lObject = new Sortiment(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #products}.<br/>
   *
   * @return {@link Set<Product>} Value to which {@link #products} is set. The method never returns null and the
   * returned collection is unmodifiable.
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
    // Return all Product objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method adds the passed object to {@link #products}.
   *
   * @param pProducts Object that should be added to {@link #products}. The parameter must not be null.
   */
  public void addToProducts( Product pProducts ) {
    // Add passed object to collection of associated Product objects.
    products.add(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts != null && pProducts.getSortiments().contains(this) == false) {
      pProducts.addToSortiments((Sortiment) this);
    }
  }

  /**
   * Method adds all passed objects to {@link #products}.
   *
   * @param pProducts Collection with all objects that should be added to {@link #products}. The parameter must not be
   * null.
   */
  public void addToProducts( Collection<Product> pProducts ) {
    // Add all passed objects.
    for (Product lNextObject : pProducts) {
      this.addToProducts(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #products}.<br/>
   *
   * @param pProducts Object that should be removed from {@link #products}. The parameter must not be null.
   */
  public void removeFromProducts( Product pProducts ) {
    // Remove passed object from collection of associated Product objects.
    products.remove(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts.getSortiments().contains(this) == true) {
      pProducts.removeFromSortiments((Sortiment) this);
    }
  }

  /**
   * Method removes all objects from {@link #products}.
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

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(products);
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
      Sortiment lOther = (Sortiment) pObject;
      lEquals = Objects.equals(products, lOther.products);
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
    lBuilder.append("products: ");
    if (products != null) {
      lBuilder.append(products.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (products != null) {
      for (Product lNext : products) {
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
   * @return {@link Builder} New builder that can be used to create new Sortiment objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}