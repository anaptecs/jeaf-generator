
/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

public class MasterDataObject extends MasterDataObjectBase {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object. Nothing special to do.
   */
  protected MasterDataObject( MasterDataObject.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new MasterDataObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder(com.anaptecs.spring.base.Entity pEntity, java.lang.String pObjectID,
      String pInternalProperty) {
    Builder lBuilder = builder();
    lBuilder.setEntity(pEntity);
    lBuilder.setObjectID(pObjectID);
    lBuilder.setInternalProperty(pInternalProperty);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class MasterDataObject. As the class has readonly attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends MasterDataObject.BuilderBase {
    /**
     * Use {@link MasterDataObject#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MasterDataObject#builder(MasterDataObject)} instead of protected constructor to create new builder.
     */
    protected Builder( MasterDataObject pObject ) {
      super(pObject);
    }
  }

  /**
   * Method returns attribute {@link #derivedProperty}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedProperty} is set.
   */
  @Override
  public String getDerivedProperty( ) {
    // TODO Implement method for derived property "derivedProperty".
    return null;
  }

  /**
   * Method returns association {@link #derivedDataUnits}.<br/>
   *
   * @return {@link java.util.List<com.anaptecs.spring.base.DataUnit>} Value to which {@link #derivedDataUnits} is set.
   * The method never returns null and the returned collection is unmodifiable.
   */
  @Override
  public java.util.List<com.anaptecs.spring.base.DataUnit> getDerivedDataUnits( ) {
    // TODO Implement method for derived property "derivedDataUnits".
    return null;
  }

  /**
   * Method returns association {@link #derivedEntity}.<br/>
   *
   * @return {@link com.anaptecs.spring.base.Entity} Value to which {@link #derivedEntity} is set.
   */
  @Override
  public com.anaptecs.spring.base.Entity getDerivedEntity( ) {
    // TODO Implement method for derived property "derivedEntity".
    return null;
  }

  /**
   * Method returns attribute {@link #derivedArray}.<br/>
   *
   * @return int[] Value to which {@link #derivedArray} is set.
   */
  @Override
  public int[] getDerivedArray( ) {
    // TODO Implement method for derived property "derivedArray".
    return null;
  }

  /**
   * Method returns attribute {@link #derivedBoolean}.<br/>
   *
   * @return boolean Value to which {@link #derivedBoolean} is set.
   */
  @Override
  public boolean isDerivedBoolean( ) {
    // TODO Implement method for derived property "derivedBoolean".
    return false;
  }

  /**
   * Method returns attribute {@link #derivedInt}.<br/>
   *
   * @return int Value to which {@link #derivedInt} is set.
   */
  @Override
  public int getDerivedInt( ) {
    // TODO Implement method for derived property "derivedInt".
    return 0;
  }

  /**
   * Method returns attribute {@link #derivedString}.<br/>
   *
   * @return {@link String} Value to which {@link #derivedString} is set.
   */
  @Override
  public String getDerivedString( ) {
    // TODO Implement method for derived property "derivedString".
    return null;
  }
}
