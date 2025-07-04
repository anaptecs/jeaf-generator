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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
@JEAFCustomAnnotationTest
public class Sortiment extends Object implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "products".
   */
  @JEAFCustomAnnotationTest
  public static final String PRODUCTS = "products";

  /**
   * Constant for the name of attribute "value".
   */
  @JEAFCustomAnnotationTest
  public static final String VALUE = "value";

  /**
   * Constant for the name of attribute "inlineSortimentType".
   */
  @JEAFCustomAnnotationTest
  public static final String INLINESORTIMENTTYPE = "inlineSortimentType";

  /**
   * Constant for the name of attribute "types".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String TYPES = "types";

  // "com.anaptecs.jeaf.junit.openapi.base.Product"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Set<Product> products;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean productsBackReferenceInitialized;

  // "com.anaptecs.jeaf.junit.openapi.base.Product"
  private int productsXYZ = 0;

  /**
   * <br/>
   * <b>Default Value:</b> <code>4711</code>
   */
  // "java.lang.Integer"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private final Integer value;

  // "java.lang.Integer"
  private int valueXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private InlineSortimentType inlineSortimentType;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
  private int inlineSortimentTypeXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private List<InlineSortimentType> types;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
  private int typesXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Sortiment( ) {
    products = new HashSet<>();
    // Bidirectional back reference is not yet set up correctly
    productsBackReferenceInitialized = false;
    value = 4711;
    types = new ArrayList<>();
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
      products = new HashSet<>();
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    productsBackReferenceInitialized = true;
    // "com.anaptecs.jeaf.junit.openapi.base.Product"
    productsXYZ = pBuilder.productsXYZ;
    value = pBuilder.value;
    // "java.lang.Integer"
    valueXYZ = pBuilder.valueXYZ;
    inlineSortimentType = pBuilder.inlineSortimentType;
    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    inlineSortimentTypeXYZ = pBuilder.inlineSortimentTypeXYZ;
    if (pBuilder.types != null) {
      types = pBuilder.types;
    }
    else {
      types = new ArrayList<>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    typesXYZ = pBuilder.typesXYZ;
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
   * Class implements builder to create a new instance of class <code>Sortiment</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder {
    // "com.anaptecs.jeaf.junit.openapi.base.Product"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Set<Product> products;

    // "com.anaptecs.jeaf.junit.openapi.base.Product"
    private int productsXYZ = 0;

    /**
     * <br/>
     * <b>Default Value:</b> <code>4711</code>
     */
    // "java.lang.Integer"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Integer value = 4711;

    // "java.lang.Integer"
    private int valueXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private InlineSortimentType inlineSortimentType;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    private int inlineSortimentTypeXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private List<InlineSortimentType> types;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    private int typesXYZ = 0;

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
    @JEAFCustomAnnotationTest
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
    @JEAFCustomAnnotationTest
    public Builder addToProducts( Product... pProducts ) {
      if (pProducts != null) {
        if (products == null) {
          products = new HashSet<Product>();
        }
        products.addAll(Arrays.asList(pProducts));
      }
      return this;
    }

    public Builder setProductsXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.Product"
      productsXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #value}.<br/>
     *
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setValue( Integer pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    public Builder setValueXYZ( int value ) {
      // "java.lang.Integer"
      valueXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #inlineSortimentType}.<br/>
     *
     * @param pInlineSortimentType Value to which {@link #inlineSortimentType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setInlineSortimentType( InlineSortimentType pInlineSortimentType ) {
      inlineSortimentType = pInlineSortimentType;
      return this;
    }

    public Builder setInlineSortimentTypeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
      inlineSortimentTypeXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #types}.<br/>
     *
     * @param pTypes Collection to which {@link #types} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public Builder setTypes( List<InlineSortimentType> pTypes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTypes != null) {
        types = new ArrayList<InlineSortimentType>(pTypes);
      }
      else {
        types = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #types}.<br/>
     *
     * @param pTypes Array of objects that should be added to {@link #types}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public Builder addToTypes( InlineSortimentType... pTypes ) {
      if (pTypes != null) {
        if (types == null) {
          types = new ArrayList<InlineSortimentType>();
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
    @JEAFCustomAnnotationTest
    public Builder setTypes( InlineSortimentType... pTypes ) {
      // Copy the content of the passed array.
      if (pTypes != null) {
        types = new ArrayList<InlineSortimentType>(Arrays.asList(pTypes));
      }
      else {
        types = null;
      }
      return this;
    }

    public Builder setTypesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
      typesXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
  public void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<Product> lProducts = new HashSet<Product>(products);
    Iterator<Product> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromProducts(lIterator.next());
    }
  }

  public int getProductsXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.Product"
    return productsXYZ;
  }

  public void setProductsXYZ( int value ) {
    productsXYZ = value;
  }

  /**
   * Method returns attribute {@link #value}.<br/>
   *
   * @return {@link Integer} Value to which {@link #value} is set.
   */
  @JEAFCustomAnnotationTest
  public Integer getValue( ) {
    return value;
  }

  public int getValueXYZ( ) {
    // "java.lang.Integer"
    return valueXYZ;
  }

  public void setValueXYZ( int value ) {
    valueXYZ = value;
  }

  /**
   * Method returns association {@link #inlineSortimentType}.<br/>
   *
   * @return {@link InlineSortimentType} Value to which {@link #inlineSortimentType} is set.
   */
  @JEAFCustomAnnotationTest
  public InlineSortimentType getInlineSortimentType( ) {
    return inlineSortimentType;
  }

  /**
   * Method sets association {@link #inlineSortimentType}.<br/>
   *
   * @param pInlineSortimentType Value to which {@link #inlineSortimentType} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setInlineSortimentType( InlineSortimentType pInlineSortimentType ) {
    inlineSortimentType = pInlineSortimentType;
  }

  /**
   * Method unsets {@link #inlineSortimentType}.
   */
  @JEAFCustomAnnotationTest
  public final void unsetInlineSortimentType( ) {
    inlineSortimentType = null;
  }

  public int getInlineSortimentTypeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    return inlineSortimentTypeXYZ;
  }

  public void setInlineSortimentTypeXYZ( int value ) {
    inlineSortimentTypeXYZ = value;
  }

  /**
   * Method returns association {@link #types}.<br/>
   *
   * @return {@link List<InlineSortimentType>} Value to which {@link #types} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public List<InlineSortimentType> getTypes( ) {
    // Return all InlineSortimentType objects as unmodifiable collection.
    return Collections.unmodifiableList(types);
  }

  /**
   * Method adds the passed object to {@link #types}.
   *
   * @param pTypes Object that should be added to {@link #types}. The parameter must not be null.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
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
  @JEAFCustomAnnotationTest
  public void clearTypes( ) {
    // Remove all objects from association "types".
    types.clear();
  }

  public int getTypesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.InlineSortimentType"
    return typesXYZ;
  }

  public void setTypesXYZ( int value ) {
    typesXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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