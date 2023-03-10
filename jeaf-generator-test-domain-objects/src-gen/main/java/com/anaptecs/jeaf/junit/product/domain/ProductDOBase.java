/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.product.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.anaptecs.jeaf.core.api.DomainObject;
import com.anaptecs.jeaf.core.api.DomainObjectID;
import com.anaptecs.jeaf.junit.product.ProductCategory;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public abstract class ProductDOBase extends DomainObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  /**
   * Constant for the name of attribute "vat".
   */
  public static final String VAT = "vat";

  /**
   * Constant for the name of attribute "productCategory".
   */
  public static final String PRODUCTCATEGORY = "productCategory";

  private Set<AssortmentDO> assortments;

  private Set<PriceDO> pricesPerCurrency;

  private String name;

  private String description;

  private VatDO vat;

  private ProductCategory productCategory;

  /**
   * Initialize object. Nothing special to do.
   */
  public ProductDOBase( ) {
    assortments = new HashSet<AssortmentDO>();
    pricesPerCurrency = new HashSet<PriceDO>();
  }

  /**
   * Initialize object. Therefore its domain object id has to be passed.
   * 
   * @param pDomainObjectID Id of this domain object. The parameter must not be null.
   */
  public ProductDOBase( DomainObjectID pDomainObjectID ) {
    super(pDomainObjectID);
    assortments = new HashSet<AssortmentDO>();
    pricesPerCurrency = new HashSet<PriceDO>();
  }

  /**
   * Method returns the association "assortments".
   * 
   *
   * @return Collection All AssortmentDO objects that belong to the association "assortments". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<AssortmentDO> getAssortments( ) {
    // Return all AssortmentDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(assortments);
  }

  /**
   * Method adds the passed AssortmentDO object to the association "assortments".
   * 
   * 
   * @param pAssortments Object that should be added to the association "assortments". The parameter must not be null.
   */
  public void addToAssortments( AssortmentDO pAssortments ) {
    // Check parameter "pAssortments" for invalid value null.
    Check.checkInvalidParameterNull(pAssortments, "pAssortments");
    // Add passed object to collection of associated AssortmentDO objects.
    assortments.add(pAssortments);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAssortments != null && pAssortments.getProducts().contains(this) == false) {
      pAssortments.addToProducts((ProductDO) this);
    }
  }

  /**
   * Method adds all passed objects to the association "assortments".
   * 
   * 
   * @param pAssortments Collection with all objects that should be added to the association "assortments". The
   * parameter must not be null.
   */
  public void addToAssortments( Collection<AssortmentDO> pAssortments ) {
    // Check parameter "pAssortments" for invalid value null.
    Check.checkInvalidParameterNull(pAssortments, "pAssortments");
    // Add all passed objects.
    for (AssortmentDO lNextObject : pAssortments) {
      this.addToAssortments(lNextObject);
    }
  }

  /**
   * Method removes the passed AssortmentDO object from the association "assortments".
   * 
   * 
   * @param pAssortments Object that should be removed from the association "assortments". The parameter must not be
   * null.
   */
  public void removeFromAssortments( AssortmentDO pAssortments ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAssortments, "pAssortments");
    // Remove passed object from collection of associated AssortmentDO objects.
    assortments.remove(pAssortments);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pAssortments.getProducts().contains(this) == true) {
      pAssortments.removeFromProducts((ProductDO) this);
    }
  }

  /**
   * Method removes all objects from the association "assortments".
   * 
   */
  public void clearAssortments( ) {
    // Remove all objects from association "assortments".
    Collection<AssortmentDO> lAssortments = new HashSet<AssortmentDO>(assortments);
    Iterator<AssortmentDO> lIterator = lAssortments.iterator();
    while (lIterator.hasNext()) {
      // As association is bidirectional we have to clear it in both directions.
      this.removeFromAssortments(lIterator.next());
    }
  }

  /**
   * Method returns the association "pricesPerCurrency".
   * 
   *
   * @return Collection All PriceDO objects that belong to the association "pricesPerCurrency". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<PriceDO> getPricesPerCurrency( ) {
    // Return all PriceDO objects as unmodifiable collection.
    return Collections.unmodifiableSet(pricesPerCurrency);
  }

  /**
   * Method adds the passed PriceDO object to the association "pricesPerCurrency".
   * 
   * 
   * @param pPricesPerCurrency Object that should be added to the association "pricesPerCurrency". The parameter must
   * not be null.
   */
  public void addToPricesPerCurrency( PriceDO pPricesPerCurrency ) {
    // Check parameter "pPricesPerCurrency" for invalid value null.
    Check.checkInvalidParameterNull(pPricesPerCurrency, "pPricesPerCurrency");
    // Add passed object to collection of associated PriceDO objects.
    pricesPerCurrency.add(pPricesPerCurrency);
  }

  /**
   * Method adds all passed objects to the association "pricesPerCurrency".
   * 
   * 
   * @param pPricesPerCurrency Collection with all objects that should be added to the association "pricesPerCurrency".
   * The parameter must not be null.
   */
  public void addToPricesPerCurrency( Collection<PriceDO> pPricesPerCurrency ) {
    // Check parameter "pPricesPerCurrency" for invalid value null.
    Check.checkInvalidParameterNull(pPricesPerCurrency, "pPricesPerCurrency");
    // Add all passed objects.
    for (PriceDO lNextObject : pPricesPerCurrency) {
      this.addToPricesPerCurrency(lNextObject);
    }
  }

  /**
   * Method removes the passed PriceDO object from the association "pricesPerCurrency".
   * 
   * 
   * @param pPricesPerCurrency Object that should be removed from the association "pricesPerCurrency". The parameter
   * must not be null.
   */
  public void removeFromPricesPerCurrency( PriceDO pPricesPerCurrency ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPricesPerCurrency, "pPricesPerCurrency");
    // Remove passed object from collection of associated PriceDO objects.
    pricesPerCurrency.remove(pPricesPerCurrency);
  }

  /**
   * Method removes all objects from the association "pricesPerCurrency".
   * 
   */
  public void clearPricesPerCurrency( ) {
    // Remove all objects from association "pricesPerCurrency".
    pricesPerCurrency.clear();
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
   * Method returns attribute {@link #description}.<br/>
   * 
   * @return {@link String} Value to which {@link #description} is set.
   */
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   * 
   * @param pDescription Value to which {@link #description} should be set.
   */
  public void setDescription( String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  /**
   * Method returns association {@link #vat}.<br/>
   * 
   * @return {@link VatDO} Value to which {@link #vat} is set.
   */
  public VatDO getVat( ) {
    return vat;
  }

  /**
   * Method sets association {@link #vat}.<br/>
   * 
   * @param pVat Value to which {@link #vat} should be set.
   */
  public void setVat( VatDO pVat ) {
    vat = pVat;
  }

  /**
   * Method unsets {@link #vat}.
   */
  public final void unsetVat( ) {
    vat = null;
  }

  /**
   * Method returns association {@link #productCategory}.<br/>
   * 
   * @return {@link ProductCategory} Value to which {@link #productCategory} is set.
   */
  public ProductCategory getProductCategory( ) {
    return productCategory;
  }

  /**
   * Method sets association {@link #productCategory}.<br/>
   * 
   * @param pProductCategory Value to which {@link #productCategory} should be set.
   */
  public void setProductCategory( ProductCategory pProductCategory ) {
    productCategory = pProductCategory;
  }

  /**
   * Method unsets {@link #productCategory}.
   */
  public final void unsetProductCategory( ) {
    productCategory = null;
  }

  /**
   * @param pCurrency
   * @return {@link PriceDO}
   */
  public abstract PriceDO getPrice( Currency pCurrency );

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
    lBuilder.append(pIndent);
    lBuilder.append("description: ");
    lBuilder.append(description);
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
