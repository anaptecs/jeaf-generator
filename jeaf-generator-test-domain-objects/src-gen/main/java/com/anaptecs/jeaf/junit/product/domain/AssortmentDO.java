/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.product.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class AssortmentDO extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "products".
   */
  public static final String PRODUCTS = "products";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  private Set<ProductDO> products;

  private String name;

  /**
   * Initialize object. Nothing special to do.
   */
  public AssortmentDO( ) {
    products = new HashSet<ProductDO>();
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public AssortmentDO( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    products = new HashSet<ProductDO>();
  }

  /**
   * Method returns association {@link #products}.<br/>
   * 
   * @return {@link Set<ProductDO>} Value to which {@link #products} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public Set<ProductDO> getProducts( ) {
    // Return all ProductDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method adds the passed ProductDO object to the association "products".
   * 
   * 
   * @param pProducts Object that should be added to the association "products". The parameter must not be null.
   */
  public void addToProducts( ProductDO pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add passed object to collection of associated ProductDO objects.
    products.add(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts != null && pProducts.getAssortments().contains(this) == false) {
      pProducts.addToAssortments((AssortmentDO) this);
    }
  }

  /**
   * Method adds all passed objects to the association "products".
   * 
   * 
   * @param pProducts Collection with all objects that should be added to the association "products". The parameter must
   * not be null.
   */
  public void addToProducts( Collection<ProductDO> pProducts ) {
    // Check parameter "pProducts" for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Add all passed objects.
    for (ProductDO lNextObject : pProducts) {
      this.addToProducts(lNextObject);
    }
  }

  /**
   * Method removes the passed ProductDO object from the association "products".
   * 
   * 
   * @param pProducts Object that should be removed from the association "products". The parameter must not be null.
   */
  public void removeFromProducts( ProductDO pProducts ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pProducts, "pProducts");
    // Remove passed object from collection of associated ProductDO objects.
    products.remove(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts.getAssortments().contains(this) == true) {
      pProducts.removeFromAssortments((AssortmentDO) this);
    }
  }

  /**
   * Method removes all objects from the association "products".
   * 
   */
  public void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<ProductDO> lProducts = new HashSet<ProductDO>(products);
    Iterator<ProductDO> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromProducts(lIterator.next());
    }
  }

  /**
   * Method returns attribute {@link #name}.<br/>
   * 
   * @return {@link String} Value to which {@link #name} is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets attribute {@link #name}.<br/>
   * 
   * @param pName Value to which {@link #name} should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
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
    lBuilder.append("name: ");
    lBuilder.append(name);
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
