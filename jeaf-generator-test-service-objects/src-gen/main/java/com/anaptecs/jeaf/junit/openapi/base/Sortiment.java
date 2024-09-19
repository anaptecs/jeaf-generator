/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class Sortiment implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "products".
   */
  public static final String PRODUCTS = "products";

  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  private Set<Product> products;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean productsBackReferenceInitialized;

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  private final Integer value;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Sortiment( ) {
    products = new HashSet<Product>();
    // Bidirectional back reference is not yet set up correctly
    productsBackReferenceInitialized = false;
    value = 4711;
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
    value = pBuilder.value;
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
   * @param pValue Value to which {@link #value} should be set.
   *
   * @return {@link Sortiment}
   */
  public static Sortiment of( Integer pValue ) {
    Sortiment.Builder lBuilder = Sortiment.builder();
    lBuilder.setValue(pValue);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>Sortiment</code>.
   */
  public static class Builder {
    private Set<Product> products;

    /**
     * <br/>
     * <b>Default Value:</b> <code>4711</code>
     */
    private Integer value = 4711;

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
        this.setValue(pObject.value);
      }
    }

    /**
     * Method sets association {@link #products}.<br/>
     *
     * @param pProducts Collection to which {@link #products} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setProducts( Set<Product> pProducts ) {
      products = pProducts;
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
     * Method sets attribute {@link #value}.<br/>
     *
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setValue( Integer pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class Sortiment. The object will be initialized with the values of the builder.
     *
     * @return Sortiment Created object. The method never returns null.
     */
    public Sortiment build( ) {
      Sortiment lObject = new Sortiment(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class Sortiment. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return Sortiment Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Sortiment buildValidated( ) throws ConstraintViolationException {
      Sortiment lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
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
   * Method adds all passed objects to {@link #products}.
   *
   * @param pProducts Collection with all objects that should be added to {@link #products}. The parameter must not be
   * null.
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
   * Method removes the passed object from {@link #products}.<br/>
   *
   * @param pProducts Object that should be removed from {@link #products}. The parameter must not be null.
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

  /**
   * Method returns attribute {@link #value}.<br/>
   *
   * @return {@link Integer} Value to which {@link #value} is set.
   */
  public Integer getValue( ) {
    return value;
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
    lBuilder.append("value: ");
    lBuilder.append(value);
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
   * @return {@link Builder} New builder that can be used to create new Sortiment objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}