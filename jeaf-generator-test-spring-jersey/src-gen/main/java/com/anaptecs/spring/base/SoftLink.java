/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class SoftLink extends SoftLinkBase {
  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected SoftLink( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected SoftLink( SoftLink.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SoftLink objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SoftLink objects. The method never returns null.
   */
  public static Builder builder( SoftLink pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( long pObjectID, DataUnit pDataUnit, Entity pEntity, String pRefrenceID ) {
    Builder lBuilder = builder();
    lBuilder.setObjectID(pObjectID);
    lBuilder.setDataUnit(pDataUnit);
    lBuilder.setEntity(pEntity);
    lBuilder.setRefrenceID(pRefrenceID);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class SoftLink. As the class has readonly attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends SoftLink.BuilderBase {
    /**
     * Use {@link SoftLink#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SoftLink#builder(SoftLink)} instead of protected constructor to create new builder.
     */
    protected Builder( SoftLink pObject ) {
      super(pObject);
    }
  }

  /**
   * Method serializes this object into its custom string representation.
   * 
   * @return {@link String} Serialized String representation of this object. The method must not return null.
   */
  public String serialize( ) {
    // TODO Implementation required
    return null;
  }

  /**
   * Method deserialized the passed String representation of this object into a new instance of this class.
   * 
   * @param pSerialized Serialized representation that should be used to create a new instance. The parameter is never
   * null.
   * @return {@link SoftLink} Instance of this class as it was deserialized from the passed string. The method must not
   * return null.
   */
  public static SoftLink deserialize( String pSerialized ) {
    // TODO Implementation required
    return null;
  }
}