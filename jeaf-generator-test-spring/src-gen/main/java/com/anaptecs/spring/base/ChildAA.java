/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Arrays;

import javax.validation.constraints.Size;

import com.anaptecs.jeaf.validation.api.spring.SpringValidationExecutor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Deprecated
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE)
public class ChildAA extends ChildA {
  /**
   * Constant for the name of attribute "childAAAttribute".
   */
  public static final String CHILDAAATTRIBUTE = "childAAAttribute";

  /**
   * Constant for the name of attribute "sizedArray".
   */
  public static final String SIZEDARRAY = "sizedArray";

  /**
   * Constant for the name of attribute "requiredArray".
   */
  public static final String REQUIREDARRAY = "requiredArray";

  /**
   * Multi<br/>
   * line<br/>
   * docs
   */
  private byte childAAAttribute;

  @Size(min = 10, max = 100)
  private int[] sizedArray;

  private String[] requiredArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildAA( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildAA( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childAAAttribute = pBuilder.childAAAttribute;
    sizedArray = pBuilder.sizedArray;
    requiredArray = pBuilder.requiredArray;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new ChildAA objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class ChildAA.
   *
   *
   * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
   *
   * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
   *
   * @param pChildAAAttribute Value to which {@link #childAAAttribute} should be set.
   *
   * @param pRequiredArray Value to which {@link #requiredArray} should be set.
   *
   * @return {@link com.anaptecs.spring.base.ChildAA}
   */
  public static ChildAA of( String pParentAttribute, int pChildAAttribute, byte pChildAAAttribute,
      String[] pRequiredArray ) {
    ChildAA.Builder lBuilder = ChildAA.builder();
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setChildAAttribute(pChildAAttribute);
    lBuilder.setChildAAAttribute(pChildAAAttribute);
    lBuilder.setRequiredArray(pRequiredArray);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>ChildAA</code>.
   */
  @Deprecated
  public static class Builder extends ChildA.Builder {
    /**
     * Multi<br/>
     * line<br/>
     * docs
     */
    private byte childAAAttribute;

    @Size(min = 10, max = 100)
    private int[] sizedArray;

    private String[] requiredArray;

    /**
     * Use {@link ChildAA#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildAA#builder(ChildAA)} instead of private constructor to create new builder.
     */
    protected Builder( ChildAA pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setChildAAAttribute(pObject.childAAAttribute);
        this.setSizedArray(pObject.sizedArray);
        this.setRequiredArray(pObject.requiredArray);
      }
    }

    /**
     * Method returns a new builder.
     *
     * @return {@link Builder} New builder that can be used to create new ChildAA objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     *
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ChildAA objects. The method never returns
     * null.
     */
    public static Builder newBuilder( ChildAA pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets attribute {@link #parentAttribute}.<br/>
     *
     * @param pParentAttribute Value to which {@link #parentAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setParentAttribute( String pParentAttribute ) {
      // Call super class implementation.
      super.setParentAttribute(pParentAttribute);
      return this;
    }

    /**
     * Method sets attribute {@link #childAAttribute}.<br/>
     *
     * @param pChildAAttribute Value to which {@link #childAAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setChildAAttribute( int pChildAAttribute ) {
      // Call super class implementation.
      super.setChildAAttribute(pChildAAttribute);
      return this;
    }

    /**
     * Method sets attribute {@link #childAAAttribute}.<br/>
     *
     * @param pChildAAAttribute Value to which {@link #childAAAttribute} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setChildAAAttribute( byte pChildAAAttribute ) {
      // Assign value to attribute
      childAAAttribute = pChildAAAttribute;
      return this;
    }

    /**
     * Method sets attribute {@link #sizedArray}.<br/>
     *
     * @param pSizedArray Value to which {@link #sizedArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSizedArray( int[] pSizedArray ) {
      // Assign value to attribute
      if (pSizedArray != null) {
        sizedArray = new int[pSizedArray.length];
        System.arraycopy(pSizedArray, 0, sizedArray, 0, pSizedArray.length);
      }
      else {
        sizedArray = null;
      }
      return this;
    }

    /**
     * Method sets attribute {@link #requiredArray}.<br/>
     *
     * @param pRequiredArray Collection to which {@link #requiredArray} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setRequiredArray( String[] pRequiredArray ) {
      // Assign value to attribute
      if (pRequiredArray != null) {
        requiredArray = new String[pRequiredArray.length];
        System.arraycopy(pRequiredArray, 0, requiredArray, 0, pRequiredArray.length);
      }
      else {
        requiredArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ChildAA. The object will be initialized with the values of the builder.
     *
     * @return ChildAA Created object. The method never returns null.
     */
    public ChildAA build( ) {
      ChildAA lObject = new ChildAA(this);
      SpringValidationExecutor.getValidationExecutor().validateObject(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #childAAAttribute}.<br/>
   * Multi<br/>
   * line<br/>
   * docs
   *
   * @return byte Value to which {@link #childAAAttribute} is set.
   */
  public byte getChildAAAttribute( ) {
    return childAAAttribute;
  }

  /**
   * Method sets attribute {@link #childAAAttribute}.<br/>
   * Multi<br/>
   * line<br/>
   * docs
   *
   * @param pChildAAAttribute Value to which {@link #childAAAttribute} should be set.
   */
  public void setChildAAAttribute( byte pChildAAAttribute ) {
    // Assign value to attribute
    childAAAttribute = pChildAAAttribute;
  }

  /**
   * Method returns attribute {@link #sizedArray}.<br/>
   *
   * @return int Value to which {@link #sizedArray} is set.
   */
  public int[] getSizedArray( ) {
    int[] lReturnValue;
    if (sizedArray != null) {
      lReturnValue = new int[sizedArray.length];
      System.arraycopy(sizedArray, 0, lReturnValue, 0, sizedArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #sizedArray}.<br/>
   *
   * @param pSizedArray Value to which {@link #sizedArray} should be set.
   */
  public void setSizedArray( int[] pSizedArray ) {
    // Assign value to attribute
    if (pSizedArray != null) {
      sizedArray = new int[pSizedArray.length];
      System.arraycopy(pSizedArray, 0, sizedArray, 0, pSizedArray.length);
    }
    else {
      sizedArray = null;
    }
  }

  /**
   * Method returns attribute {@link #requiredArray}.<br/>
   *
   * @return {@link String} Value to which {@link #requiredArray} is set.
   */
  public String[] getRequiredArray( ) {
    String[] lReturnValue;
    if (requiredArray != null) {
      lReturnValue = new String[requiredArray.length];
      System.arraycopy(requiredArray, 0, lReturnValue, 0, requiredArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #requiredArray}.<br/>
   *
   * @param pRequiredArray Value to which {@link #requiredArray} should be set.
   */
  public void setRequiredArray( String[] pRequiredArray ) {
    // Assign value to attribute
    if (pRequiredArray != null) {
      requiredArray = new String[pRequiredArray.length];
      System.arraycopy(pRequiredArray, 0, requiredArray, 0, pRequiredArray.length);
    }
    else {
      requiredArray = null;
    }
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + childAAAttribute;
    lResult = lPrime * lResult + Arrays.hashCode(sizedArray);
    lResult = lPrime * lResult + Arrays.hashCode(requiredArray);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      ChildAA lOther = (ChildAA) pObject;
      lEquals = childAAAttribute == lOther.childAAAttribute && Arrays.equals(sizedArray, lOther.sizedArray)
          && Arrays.equals(requiredArray, lOther.requiredArray);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("childAAAttribute: ");
    lBuilder.append(childAAAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sizedArray: ");
    if (sizedArray != null) {
      lBuilder.append(Arrays.toString(sizedArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("requiredArray: ");
    if (requiredArray != null) {
      lBuilder.append(Arrays.toString(requiredArray));
    }
    else {
      lBuilder.append(" null");
    }
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
   * @return {@link Builder} New builder that can be used to create new ChildAA objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
