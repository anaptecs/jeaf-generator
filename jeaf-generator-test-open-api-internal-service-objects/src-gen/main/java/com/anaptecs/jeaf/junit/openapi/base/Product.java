/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.net.URL;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

/**
 * Data type represents a product definition
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
@JsonIdentityInfo(property = "objectID", generator = PropertyGenerator.class)
public class Product extends ProductBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected Product( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected Product( Product.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Product objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Product objects. The method never returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( Product pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pName, URL pLink, UUID pProductID, String pDescription, String pUri ) {
    Builder lBuilder = builder();
    lBuilder.setName(pName);
    lBuilder.setLink(pLink);
    lBuilder.setProductID(pProductID);
    lBuilder.setDescription(pDescription);
    lBuilder.setUri(pUri);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class Product. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends Product.BuilderBase {
    /**
     * Use {@link Product#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Product#builder(Product)} instead of protected constructor to create new builder.
     */
    protected Builder( Product pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns association {@link #theChannels}.<br/>
   *
   * @return {@link Set<Channel>} Value to which {@link #theChannels} is set. The method never returns null and the
   * returned collection is modifiable.
   */
  public Set<Channel> getTheChannels( ) {
    // TODO Implement method for derived property "theChannels".
    return null;
  }
}
