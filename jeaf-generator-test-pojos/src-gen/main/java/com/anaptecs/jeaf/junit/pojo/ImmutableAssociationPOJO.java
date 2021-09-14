/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ImmutableAssociationPOJO {
  /**
   * Constant for the name of attribute "yetAnotherAttribute".
   */
  public static final String YETANOTHERATTRIBUTE = "yetAnotherAttribute";

  /**
   * Constant for the name of attribute "readonlyAssociation".
   */
  public static final String READONLYASSOCIATION = "readonlyAssociation";

  /**
   * Constant for the name of attribute "immutableChildPOJO".
   */
  public static final String IMMUTABLECHILDPOJO = "immutableChildPOJO";

  /**
   * 
   */
  private final boolean yetAnotherAttribute;

  /**
   * 
   */
  private final SortedSet<ImmutablePOJO> readonlyAssociation = new TreeSet<ImmutablePOJO>();

  /**
   * 
   */
  private final ImmutableChildPOJO immutableChildPOJO;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutableAssociationPOJO( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    yetAnotherAttribute = pBuilder.yetAnotherAttribute;
    if (pBuilder.readonlyAssociation != null) {
      readonlyAssociation.addAll(pBuilder.readonlyAssociation);
    }
    immutableChildPOJO = pBuilder.immutableChildPOJO;
  }

  /**
   * Class implements builder to create a new instance of class ImmutableAssociationPOJO. As the class has readonly
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private boolean yetAnotherAttribute;

    /**
     * 
     */
    private SortedSet<ImmutablePOJO> readonlyAssociation;

    /**
     * 
     */
    private ImmutableChildPOJO immutableChildPOJO;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ImmutableAssociationPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ImmutableAssociationPOJO pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        yetAnotherAttribute = pObject.yetAnotherAttribute;
        readonlyAssociation = pObject.readonlyAssociation;
        immutableChildPOJO = pObject.immutableChildPOJO;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ImmutableAssociationPOJO objects. The method
     * never returns null.
     */
    public static Builder newBuilder( ImmutableAssociationPOJO pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "yetAnotherAttribute".
     * 
     * @param pYetAnotherAttribute Value to which the attribute "yetAnotherAttribute" should be set.
     */
    public Builder setYetAnotherAttribute( boolean pYetAnotherAttribute ) {
      // Assign value to attribute
      yetAnotherAttribute = pYetAnotherAttribute;
      return this;
    }

    /**
     * Method sets the association "readonlyAssociation".
     * 
     * @param pReadonlyAssociation Collection with objects to which the association should be set.
     */
    public Builder setReadonlyAssociation( SortedSet<ImmutablePOJO> pReadonlyAssociation ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pReadonlyAssociation != null) {
        readonlyAssociation = new TreeSet<ImmutablePOJO>(pReadonlyAssociation);
      }
      else {
        readonlyAssociation = null;
      }
      return this;
    }

    /**
     * Method sets the association "immutableChildPOJO".
     * 
     * @param pImmutableChildPOJO ImmutableChildPOJO to which the association "immutableChildPOJO" should be set.
     */
    public Builder setImmutableChildPOJO( ImmutableChildPOJO pImmutableChildPOJO ) {
      immutableChildPOJO = pImmutableChildPOJO;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutableAssociationPOJO. The object will be initialized with the values
     * of the builder.
     * 
     * @return ImmutableAssociationPOJO Created object. The method never returns null.
     */
    public ImmutableAssociationPOJO build( ) {
      return new ImmutableAssociationPOJO(this);
    }

    /**
     * Method creates a new instance of class ImmutableAssociationPOJO. The object will be initialized with the values
     * of the builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ImmutableAssociationPOJO Created object. The method never returns null.
     */
    public ImmutableAssociationPOJO build( boolean pValidate ) {
      ImmutableAssociationPOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "yetAnotherAttribute".
   * 
   * 
   * @return Boolean Value to which the attribute "yetAnotherAttribute" is set.
   */
  public boolean getYetAnotherAttribute( ) {
    return yetAnotherAttribute;
  }

  /**
   * Method returns the association "readonlyAssociation".
   * 
   *
   * @return Collection All ImmutablePOJO objects that belong to the association "readonlyAssociation". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public SortedSet<ImmutablePOJO> getReadonlyAssociation( ) {
    // Return all ImmutablePOJO objects as unmodifiable collection.
    return Collections.unmodifiableSortedSet(readonlyAssociation);
  }

  /**
   * Method returns the association "immutableChildPOJO".
   * 
   *
   * @return ImmutableChildPOJO ImmutableChildPOJO to which the association "immutableChildPOJO" is set.
   */
  public ImmutableChildPOJO getImmutableChildPOJO( ) {
    return immutableChildPOJO;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "yetAnotherAttribute",
        "" + yetAnotherAttribute));
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
