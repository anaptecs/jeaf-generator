/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.pojo;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ImmutableChildPOJO extends ImmutablePOJOParent {
  /**
   * Constant for the name of attribute "childAttribute".
   */
  public static final String CHILDATTRIBUTE = "childAttribute";

  /**
   * Constant for the name of attribute "anotherChildAttribute".
   */
  public static final String ANOTHERCHILDATTRIBUTE = "anotherChildAttribute";

  /**
   * 
   */
  private String childAttribute;

  /**
   * 
   */
  private final Double anotherChildAttribute;

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ImmutableChildPOJO( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAttribute = pBuilder.childAttribute;
    anotherChildAttribute = pBuilder.anotherChildAttribute;
  }

  /**
   * Class implements builder to create a new instance of class ImmutableChildPOJO. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ImmutablePOJOParent.Builder {
    /**
     * 
     */
    private String childAttribute;

    /**
     * 
     */
    private Double anotherChildAttribute;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(ImmutableChildPOJO)} instead of private constructor to create new builder.
     */
    protected Builder( ImmutableChildPOJO pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        childAttribute = pObject.childAttribute;
        anotherChildAttribute = pObject.anotherChildAttribute;
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
     * @return {@link Builder} New builder that can be used to create new ImmutableChildPOJO objects. The method never
     * returns null.
     */
    public static Builder newBuilder( ImmutableChildPOJO pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "parentAttribute".
     * 
     * @param pParentAttribute Value to which the attribute "parentAttribute" should be set.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "anotherParentAttribute".
     * 
     * @param pAnotherParentAttribute Value to which the attribute "anotherParentAttribute" should be set.
     */
    @Override
    public Builder setAnotherParentAttribute( Integer pAnotherParentAttribute ) {
      // Call super class implementation.
      super.setAnotherParentAttribute(pAnotherParentAttribute);
      return this;
    }

    /**
     * Method sets the attribute "childAttribute".
     * 
     * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
     */
    public Builder setChildAttribute( String pChildAttribute ) {
      // Assign value to attribute
      childAttribute = pChildAttribute;
      return this;
    }

    /**
     * Method sets the attribute "anotherChildAttribute".
     * 
     * @param pAnotherChildAttribute Value to which the attribute "anotherChildAttribute" should be set.
     */
    public Builder setAnotherChildAttribute( Double pAnotherChildAttribute ) {
      // Assign value to attribute
      anotherChildAttribute = pAnotherChildAttribute;
      return this;
    }

    /**
     * Method creates a new instance of class ImmutableChildPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @return ImmutableChildPOJO Created object. The method never returns null.
     */
    public ImmutableChildPOJO build( ) {
      return new ImmutableChildPOJO(this);
    }

    /**
     * Method creates a new instance of class ImmutableChildPOJO. The object will be initialized with the values of the
     * builder.
     * 
     * @param pValidate Parameter defines if the created POJO should be validated using Java Validation.
     * @return ImmutableChildPOJO Created object. The method never returns null.
     */
    public ImmutableChildPOJO build( boolean pValidate ) {
      ImmutableChildPOJO lPOJO = this.build();
      if (pValidate == true) {
        Tools.getValidationTools().validateObject(lPOJO);
      }
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "childAttribute".
   * 
   * 
   * @return String Value to which the attribute "childAttribute" is set.
   */
  public String getChildAttribute( ) {
    return childAttribute;
  }

  /**
   * Method sets the attribute "childAttribute".
   * 
   * 
   * @param pChildAttribute Value to which the attribute "childAttribute" should be set.
   */
  public void setChildAttribute( String pChildAttribute ) {
    // Assign value to attribute
    childAttribute = pChildAttribute;
  }

  /**
   * Method returns the attribute "anotherChildAttribute".
   * 
   * 
   * @return Double Value to which the attribute "anotherChildAttribute" is set.
   */
  public Double getAnotherChildAttribute( ) {
    return anotherChildAttribute;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "childAttribute",
        "" + childAttribute));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(MessageConstants.OBJECT_ATTRIBUTE, "anotherChildAttribute",
        "" + anotherChildAttribute));
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