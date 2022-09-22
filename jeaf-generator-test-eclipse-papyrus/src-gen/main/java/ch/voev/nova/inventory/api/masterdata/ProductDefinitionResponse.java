/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

import ch.voev.nova.inventory.api.booking.Warning;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ProductDefinitionResponse {
  /**
   * Constant for the name of attribute "warnings".
   */
  public static final String WARNINGS = "warnings";

  /**
   * Constant for the name of attribute "productDefinitions".
   */
  public static final String PRODUCTDEFINITIONS = "productDefinitions";

  /**
   * 
   */
  private List<Warning> warnings;

  /**
   * 
   */
  private Set<ProductDefinition> productDefinitions;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ProductDefinitionResponse( ) {
    warnings = new ArrayList<Warning>();
    productDefinitions = new HashSet<ProductDefinition>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ProductDefinitionResponse( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.warnings != null) {
      warnings = pBuilder.warnings;
    }
    else {
      warnings = new ArrayList<Warning>();
    }
    if (pBuilder.productDefinitions != null) {
      productDefinitions = pBuilder.productDefinitions;
    }
    else {
      productDefinitions = new HashSet<ProductDefinition>();
    }
  }

  /**
   * Class implements builder to create a new instance of class ProductDefinitionResponse. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<Warning> warnings;

    /**
     * 
     */
    private Set<ProductDefinition> productDefinitions;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ProductDefinitionResponse)} instead of private constructor to create new builder.
     */
    protected Builder( ProductDefinitionResponse pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        warnings = pObject.warnings;
        productDefinitions = pObject.productDefinitions;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ProductDefinitionResponse objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ProductDefinitionResponse objects. The method
     * never returns null.
     */
    public static Builder newBuilder( ProductDefinitionResponse pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "warnings".
     * 
     * @param pWarnings Collection with objects to which the association should be set.
     */
    public Builder setWarnings( List<Warning> pWarnings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pWarnings != null) {
        warnings = new ArrayList<Warning>(pWarnings);
      }
      else {
        warnings = null;
      }
      return this;
    }

    /**
     * Method sets the association "productDefinitions".
     * 
     * @param pProductDefinitions Collection with objects to which the association should be set.
     */
    public Builder setProductDefinitions( Set<ProductDefinition> pProductDefinitions ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pProductDefinitions != null) {
        productDefinitions = new HashSet<ProductDefinition>(pProductDefinitions);
      }
      else {
        productDefinitions = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ProductDefinitionResponse. The object will be initialized with the values
     * of the builder.
     * 
     * @return ProductDefinitionResponse Created object. The method never returns null.
     */
    public ProductDefinitionResponse build( ) {
      return new ProductDefinitionResponse(this);
    }

    /**
     * Method creates a new validated instance of class ProductDefinitionResponse. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return ProductDefinitionResponse Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ProductDefinitionResponse buildValidated( ) throws ConstraintViolationException {
      ProductDefinitionResponse lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "warnings".
   * 
   *
   * @return Collection All Warning objects that belong to the association "warnings". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<Warning> getWarnings( ) {
    // Return all Warning objects as unmodifiable collection.
    return Collections.unmodifiableList(warnings);
  }

  /**
   * Method adds the passed Warning object to the association "warnings".
   * 
   * 
   * @param pWarnings Object that should be added to the association "warnings". The parameter must not be null.
   */
  public void addToWarnings( Warning pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add passed object to collection of associated Warning objects.
    warnings.add(pWarnings);
  }

  /**
   * Method adds all passed objects to the association "warnings".
   * 
   * 
   * @param pWarnings Collection with all objects that should be added to the association "warnings". The parameter must
   * not be null.
   */
  public void addToWarnings( Collection<Warning> pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add all passed objects.
    for (Warning lNextObject : pWarnings) {
      this.addToWarnings(lNextObject);
    }
  }

  /**
   * Method removes the passed Warning object from the association "warnings".
   * 
   * 
   * @param pWarnings Object that should be removed from the association "warnings". The parameter must not be null.
   */
  public void removeFromWarnings( Warning pWarnings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Remove passed object from collection of associated Warning objects.
    warnings.remove(pWarnings);
  }

  /**
   * Method removes all objects from the association "warnings".
   * 
   */
  public void clearWarnings( ) {
    // Remove all objects from association "warnings".
    Collection<Warning> lWarnings = new HashSet<Warning>(warnings);
    Iterator<Warning> lIterator = lWarnings.iterator();
    while (lIterator.hasNext()) {
      this.removeFromWarnings(lIterator.next());
    }
  }

  /**
   * Method returns the association "productDefinitions".
   * 
   *
   * @return Collection All ProductDefinition objects that belong to the association "productDefinitions". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public Set<ProductDefinition> getProductDefinitions( ) {
    // Return all ProductDefinition objects as unmodifiable collection.
    return Collections.unmodifiableSet(productDefinitions);
  }

  /**
   * Method adds the passed ProductDefinition object to the association "productDefinitions".
   * 
   * 
   * @param pProductDefinitions Object that should be added to the association "productDefinitions". The parameter must
   * not be null.
   */
  public void addToProductDefinitions( ProductDefinition pProductDefinitions ) {
    // Check parameter "pProductDefinitions" for invalid value null.
    Check.checkInvalidParameterNull(pProductDefinitions, "pProductDefinitions");
    // Add passed object to collection of associated ProductDefinition objects.
    productDefinitions.add(pProductDefinitions);
  }

  /**
   * Method adds all passed objects to the association "productDefinitions".
   * 
   * 
   * @param pProductDefinitions Collection with all objects that should be added to the association
   * "productDefinitions". The parameter must not be null.
   */
  public void addToProductDefinitions( Collection<ProductDefinition> pProductDefinitions ) {
    // Check parameter "pProductDefinitions" for invalid value null.
    Check.checkInvalidParameterNull(pProductDefinitions, "pProductDefinitions");
    // Add all passed objects.
    for (ProductDefinition lNextObject : pProductDefinitions) {
      this.addToProductDefinitions(lNextObject);
    }
  }

  /**
   * Method removes the passed ProductDefinition object from the association "productDefinitions".
   * 
   * 
   * @param pProductDefinitions Object that should be removed from the association "productDefinitions". The parameter
   * must not be null.
   */
  public void removeFromProductDefinitions( ProductDefinition pProductDefinitions ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pProductDefinitions, "pProductDefinitions");
    // Remove passed object from collection of associated ProductDefinition objects.
    productDefinitions.remove(pProductDefinitions);
  }

  /**
   * Method removes all objects from the association "productDefinitions".
   * 
   */
  public void clearProductDefinitions( ) {
    // Remove all objects from association "productDefinitions".
    Collection<ProductDefinition> lProductDefinitions = new HashSet<ProductDefinition>(productDefinitions);
    Iterator<ProductDefinition> lIterator = lProductDefinitions.iterator();
    while (lIterator.hasNext()) {
      this.removeFromProductDefinitions(lIterator.next());
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
