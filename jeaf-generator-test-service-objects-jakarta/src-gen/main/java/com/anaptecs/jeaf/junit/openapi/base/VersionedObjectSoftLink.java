/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

public class VersionedObjectSoftLink extends VersionedObjectSoftLinkBase {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected VersionedObjectSoftLink( ) {
  }

  /**
   * Initialize object. Nothing special to do.
   */
  protected VersionedObjectSoftLink( VersionedObjectSoftLink.BuilderBase pBuilder ) {
    super(pBuilder);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new VersionedObjectSoftLink objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initializes it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new VersionedObjectSoftLink objects. The method
   * never returns null.
   * @deprecated Please use {@link #toBuilder()} instead.
   */
  @Deprecated
  public static Builder builder( VersionedObjectSoftLink pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class VersionedObjectSoftLink. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends VersionedObjectSoftLink.BuilderBase {
    /**
     * Use {@link VersionedObjectSoftLink#builder()} instead of protected constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link VersionedObjectSoftLink#builder(VersionedObjectSoftLink)} instead of protected constructor to create
     * new builder.
     */
    protected Builder( VersionedObjectSoftLink pObject ) {
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
   * @return {@link VersionedObjectSoftLink} Instance of this class as it was deserialized from the passed string. The
   * method must not return null.
   */
  public static VersionedObjectSoftLink deserialize( String pSerialized ) {
    // TODO Implementation required
    return null;
  }
}