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

  /**
   * Constant for the name of attribute "inlineSortimentType".
   */
  public static final String INLINESORTIMENTTYPE = "inlineSortimentType";

  /**
   * Constant for the name of attribute "types".
   */
  @Deprecated
  public static final String TYPES = "types";

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

  private InlineSortimentType inlineSortimentType;

  @Deprecated
  private Set<InlineSortimentType> types;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Sortiment( ) {
    products = new HashSet<>();
    // Bidirectional back reference is not yet set up correctly
    productsBackReferenceInitialized = false;
    value = 4711;
    types = new HashSet<>();
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
    products = (pBuilder.products == null) ? new HashSet<>() : pBuilder.products;
    // As association is bidirectional we also have to set it in the other direction.
    for (Product lNext : products) {
      lNext.addToSortiments((Sortiment) this);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    productsBackReferenceInitialized = true;
    value = pBuilder.value;
    inlineSortimentType = pBuilder.inlineSortimentType;
    types = (pBuilder.types == null) ? new HashSet<>() : pBuilder.types;
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
    var lBuilder = Sortiment.builder();
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

    private InlineSortimentType inlineSortimentType;

    @Deprecated
    private Set<InlineSortimentType> types;

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
        this.setInlineSortimentType(pObject.inlineSortimentType);
        this.setTypes(pObject.types);
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
     * Method sets association {@link #inlineSortimentType}.<br/>
     *
     * @param pInlineSortimentType Value to which {@link #inlineSortimentType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInlineSortimentType( InlineSortimentType pInlineSortimentType ) {
      inlineSortimentType = pInlineSortimentType;
      return this;
    }

    /**
     * Method sets association {@link #types}.<br/>
     *
     * @param pTypes Collection to which {@link #types} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setTypes( Set<InlineSortimentType> pTypes ) {
      types = pTypes;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #types}.<br/>
     *
     * @param pTypes Array of objects that should be added to {@link #types}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @Deprecated
    public Builder addToTypes( InlineSortimentType... pTypes ) {
      if (pTypes != null) {
        if (types == null) {
          types = new HashSet<InlineSortimentType>();
        }
        types.addAll(Arrays.asList(pTypes));
      }
      return this;
    }

    /**
     * Method sets association {@link #types}.<br/>
     *
     * @param pTypes Array with objects to which {@link #types} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setTypes( InlineSortimentType... pTypes ) {
      // Copy the content of the passed array.
      if (pTypes != null) {
        types = new HashSet<InlineSortimentType>(Arrays.asList(pTypes));
      }
      else {
        types = null;
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
   * Method returns association {@link #inlineSortimentType}.<br/>
   *
   * @return {@link InlineSortimentType} Value to which {@link #inlineSortimentType} is set.
   */
  public InlineSortimentType getInlineSortimentType( ) {
    return inlineSortimentType;
  }

  /**
   * Method sets association {@link #inlineSortimentType}.<br/>
   *
   * @param pInlineSortimentType Value to which {@link #inlineSortimentType} should be set.
   */
  public void setInlineSortimentType( InlineSortimentType pInlineSortimentType ) {
    inlineSortimentType = pInlineSortimentType;
  }

  /**
   * Method unsets {@link #inlineSortimentType}.
   */
  public final void unsetInlineSortimentType( ) {
    inlineSortimentType = null;
  }

  /**
   * Method returns association {@link #types}.<br/>
   *
   * @return {@link Set<InlineSortimentType>} Value to which {@link #types} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  @Deprecated
  public Set<InlineSortimentType> getTypes( ) {
    // Return all InlineSortimentType objects as unmodifiable collection.
    return Collections.unmodifiableSet(types);
  }

  /**
   * Method adds the passed object to {@link #types}.
   *
   * @param pTypes Object that should be added to {@link #types}. The parameter must not be null.
   */
  @Deprecated
  public void addToTypes( InlineSortimentType pTypes ) {
    // Check parameter "pTypes" for invalid value null.
    Check.checkInvalidParameterNull(pTypes, "pTypes");
    // Add passed object to collection of associated InlineSortimentType objects.
    types.add(pTypes);
  }

  /**
   * Method adds all passed objects to {@link #types}.
   *
   * @param pTypes Collection with all objects that should be added to {@link #types}. The parameter must not be null.
   */
  @Deprecated
  public void addToTypes( Collection<InlineSortimentType> pTypes ) {
    // Check parameter "pTypes" for invalid value null.
    Check.checkInvalidParameterNull(pTypes, "pTypes");
    // Add all passed objects.
    for (InlineSortimentType lNextObject : pTypes) {
      this.addToTypes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #types}.<br/>
   *
   * @param pTypes Object that should be removed from {@link #types}. The parameter must not be null.
   */
  @Deprecated
  public void removeFromTypes( InlineSortimentType pTypes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTypes, "pTypes");
    // Remove passed object from collection of associated InlineSortimentType objects.
    types.remove(pTypes);
  }

  /**
   * Method removes all objects from {@link #types}.
   */
  @Deprecated
  public void clearTypes( ) {
    // Remove all objects from association "types".
    types.clear();
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