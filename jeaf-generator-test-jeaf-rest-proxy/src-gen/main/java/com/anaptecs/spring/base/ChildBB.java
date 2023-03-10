/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildBB extends ChildB {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "childBBAttribute".
   */
  public static final String CHILDBBATTRIBUTE = "childBBAttribute";

  /**
   * Constant for the name of attribute "deprecatedAttribute".
   */
  @Deprecated
  public static final String DEPRECATEDATTRIBUTE = "deprecatedAttribute";

  /**
   * Constant for the name of attribute "deprecatedBs".
   */
  @Deprecated
  public static final String DEPRECATEDBS = "deprecatedBs";

  /**
   * Constant for the name of attribute "deprecatedParent".
   */
  @Deprecated
  public static final String DEPRECATEDPARENT = "deprecatedParent";

  /**
   * Constant for the name of attribute "deprecatedArray".
   */
  @Deprecated
  public static final String DEPRECATEDARRAY = "deprecatedArray";

  private Long childBBAttribute;

  @Deprecated
  private int deprecatedAttribute;

  @Deprecated
  private Set<ChildB> deprecatedBs;

  @Deprecated
  private ParentClass deprecatedParent;

  @Deprecated
  @Size(min = 0, max = 4711)
  private byte[] deprecatedArray;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected ChildBB( ) {
    deprecatedBs = new HashSet<ChildB>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ChildBB( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    childBBAttribute = pBuilder.childBBAttribute;
    deprecatedAttribute = pBuilder.deprecatedAttribute;
    if (pBuilder.deprecatedBs != null) {
      deprecatedBs = pBuilder.deprecatedBs;
    }
    else {
      deprecatedBs = new HashSet<ChildB>();
    }
    deprecatedParent = pBuilder.deprecatedParent;
    deprecatedArray = pBuilder.deprecatedArray;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ChildBB objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ChildBB objects. The method never returns null.
   */
  public static Builder builder( ChildBB pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( String pParentAttribute, Long pChildBBAttribute, int pDeprecatedAttribute ) {
    Builder lBuilder = builder();
    lBuilder.setParentAttribute(pParentAttribute);
    lBuilder.setChildBBAttribute(pChildBBAttribute);
    lBuilder.setDeprecatedAttribute(pDeprecatedAttribute);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class ChildBB. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends ChildB.Builder {
    /**
     * 
     */
    private Long childBBAttribute;

    /**
     * 
     */
    @Deprecated
    private int deprecatedAttribute;

    /**
     * 
     */
    @Deprecated
    private Set<ChildB> deprecatedBs;

    /**
     * 
     */
    @Deprecated
    private ParentClass deprecatedParent;

    /**
     * 
     */
    @Deprecated
    @Size(min = 0, max = 4711)
    private byte[] deprecatedArray;

    /**
     * Use {@link ChildBB#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link ChildBB#builder(ChildBB)} instead of private constructor to create new builder.
     */
    protected Builder( ChildBB pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        childBBAttribute = pObject.childBBAttribute;
        deprecatedAttribute = pObject.deprecatedAttribute;
        deprecatedBs = pObject.deprecatedBs;
        deprecatedParent = pObject.deprecatedParent;
        deprecatedArray = pObject.deprecatedArray;
      }
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
     * Method sets the attribute "childBAttribute". A child attribute
     * 
     * @param pChildBAttribute Value to which the attribute "childBAttribute" should be set.
     */
    @Override
    public Builder setChildBAttribute( boolean[] pChildBAttribute ) {
      // Call super class implementation.
      super.setChildBAttribute(pChildBAttribute);
      return this;
    }

    /**
     * Method sets the association "composition". the composition
     * 
     * @param pComposition Collection with objects to which the association should be set.
     */
    @Override
    public Builder setComposition( Set<ParentClass> pComposition ) {
      // Call super class implementation.
      super.setComposition(pComposition);
      return this;
    }

    /**
     * Method sets the attribute "childBBAttribute".
     * 
     * @param pChildBBAttribute Value to which the attribute "childBBAttribute" should be set.
     */
    public Builder setChildBBAttribute( Long pChildBBAttribute ) {
      // Assign value to attribute
      childBBAttribute = pChildBBAttribute;
      return this;
    }

    /**
     * Method sets the attribute "deprecatedAttribute".
     * 
     * @param pDeprecatedAttribute Value to which the attribute "deprecatedAttribute" should be set.
     */
    @Deprecated
    public Builder setDeprecatedAttribute( int pDeprecatedAttribute ) {
      // Assign value to attribute
      deprecatedAttribute = pDeprecatedAttribute;
      return this;
    }

    /**
     * Method sets the association "deprecatedBs".
     * 
     * @param pDeprecatedBs Collection with objects to which the association should be set.
     */
    @Deprecated
    public Builder setDeprecatedBs( Set<ChildB> pDeprecatedBs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDeprecatedBs != null) {
        deprecatedBs = new HashSet<ChildB>(pDeprecatedBs);
      }
      else {
        deprecatedBs = null;
      }
      return this;
    }

    /**
     * Method sets the association "deprecatedParent".
     * 
     * @param pDeprecatedParent ParentClass to which the association "deprecatedParent" should be set.
     */
    @Deprecated
    public Builder setDeprecatedParent( ParentClass pDeprecatedParent ) {
      deprecatedParent = pDeprecatedParent;
      return this;
    }

    /**
     * Method sets the attribute "deprecatedArray".
     * 
     * @param pDeprecatedArray Value to which the attribute "deprecatedArray" should be set.
     */
    @Deprecated
    public Builder setDeprecatedArray( byte[] pDeprecatedArray ) {
      // Assign value to attribute
      if (pDeprecatedArray != null) {
        deprecatedArray = new byte[pDeprecatedArray.length];
        System.arraycopy(pDeprecatedArray, 0, deprecatedArray, 0, pDeprecatedArray.length);
      }
      else {
        deprecatedArray = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ChildBB. The object will be initialized with the values of the builder.
     * 
     * @return ChildBB Created object. The method never returns null.
     */
    public ChildBB build( ) {
      return new ChildBB(this);
    }

    /**
     * Method creates a new validated instance of class ChildBB. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return ChildBB Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ChildBB buildValidated( ) throws ConstraintViolationException {
      ChildBB lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #childBBAttribute}.<br/>
   * 
   * @return {@link Long} Value to which {@link #childBBAttribute} is set.
   */
  public Long getChildBBAttribute( ) {
    return childBBAttribute;
  }

  /**
   * Method sets attribute {@link #childBBAttribute}.<br/>
   * 
   * @param pChildBBAttribute Value to which {@link #childBBAttribute} should be set.
   */
  public void setChildBBAttribute( Long pChildBBAttribute ) {
    // Assign value to attribute
    childBBAttribute = pChildBBAttribute;
  }

  /**
   * Method returns attribute {@link #deprecatedAttribute}.<br/>
   * 
   * @return int Value to which {@link #deprecatedAttribute} is set.
   */
  @Deprecated
  public int getDeprecatedAttribute( ) {
    return deprecatedAttribute;
  }

  /**
   * Method sets attribute {@link #deprecatedAttribute}.<br/>
   * 
   * @param pDeprecatedAttribute Value to which {@link #deprecatedAttribute} should be set.
   */
  @Deprecated
  public void setDeprecatedAttribute( int pDeprecatedAttribute ) {
    // Assign value to attribute
    deprecatedAttribute = pDeprecatedAttribute;
  }

  /**
   * Method returns association {@link #deprecatedBs}.<br/>
   * 
   * @return {@link Set<ChildB>} Value to which {@link #deprecatedBs} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  @Deprecated
  public Set<ChildB> getDeprecatedBs( ) {
    // Return all ChildB objects as unmodifiable collection.
    return Collections.unmodifiableSet(deprecatedBs);
  }

  /**
   * Method adds the passed object to {@link #deprecatedBs}.
   * 
   * @param pDeprecatedBs Object that should be added to {@link #deprecatedBs}. The parameter must not be null.
   */
  @Deprecated
  public void addToDeprecatedBs( ChildB pDeprecatedBs ) {
    // Check parameter "pDeprecatedBs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedBs, "pDeprecatedBs");
    // Add passed object to collection of associated ChildB objects.
    deprecatedBs.add(pDeprecatedBs);
  }

  /**
   * Method adds all passed objects to {@link #deprecatedBs}.
   * 
   * @param pDeprecatedBs Collection with all objects that should be added to {@link #deprecatedBs}. The parameter must
   * not be null.
   */
  @Deprecated
  public void addToDeprecatedBs( Collection<ChildB> pDeprecatedBs ) {
    // Check parameter "pDeprecatedBs" for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedBs, "pDeprecatedBs");
    // Add all passed objects.
    for (ChildB lNextObject : pDeprecatedBs) {
      this.addToDeprecatedBs(lNextObject);
    }
  }

  /**
   * Method removes the passed ChildB object from the association "deprecatedBs".
   * 
   * 
   * @param pDeprecatedBs Object that should be removed from the association "deprecatedBs". The parameter must not be
   * null.
   */
  @Deprecated
  public void removeFromDeprecatedBs( ChildB pDeprecatedBs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pDeprecatedBs, "pDeprecatedBs");
    // Remove passed object from collection of associated ChildB objects.
    deprecatedBs.remove(pDeprecatedBs);
  }

  /**
   * Method removes all objects from the association "deprecatedBs".
   * 
   */
  @Deprecated
  public void clearDeprecatedBs( ) {
    // Remove all objects from association "deprecatedBs".
    deprecatedBs.clear();
  }

  /**
   * Method returns association {@link #deprecatedParent}.<br/>
   * 
   * @return {@link ParentClass} Value to which {@link #deprecatedParent} is set.
   */
  @Deprecated
  public ParentClass getDeprecatedParent( ) {
    return deprecatedParent;
  }

  /**
   * Method sets association {@link #deprecatedParent}.<br/>
   * 
   * @param pDeprecatedParent Value to which {@link #deprecatedParent} should be set.
   */
  @Deprecated
  public void setDeprecatedParent( ParentClass pDeprecatedParent ) {
    deprecatedParent = pDeprecatedParent;
  }

  /**
   * Method unsets {@link #deprecatedParent}.
   */
  @Deprecated
  public final void unsetDeprecatedParent( ) {
    deprecatedParent = null;
  }

  /**
   * Method returns attribute {@link #deprecatedArray}.<br/>
   * 
   * @return byte Value to which {@link #deprecatedArray} is set.
   */
  @Deprecated
  public byte[] getDeprecatedArray( ) {
    byte[] lReturnValue;
    if (deprecatedArray != null) {
      lReturnValue = new byte[deprecatedArray.length];
      System.arraycopy(deprecatedArray, 0, lReturnValue, 0, deprecatedArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets attribute {@link #deprecatedArray}.<br/>
   * 
   * @param pDeprecatedArray Value to which {@link #deprecatedArray} should be set.
   */
  @Deprecated
  public void setDeprecatedArray( byte[] pDeprecatedArray ) {
    // Assign value to attribute
    if (pDeprecatedArray != null) {
      deprecatedArray = new byte[pDeprecatedArray.length];
      System.arraycopy(pDeprecatedArray, 0, deprecatedArray, 0, pDeprecatedArray.length);
    }
    else {
      deprecatedArray = null;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("childBBAttribute: ");
    lBuilder.append(childBBAttribute);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("deprecatedAttribute: ");
    lBuilder.append(deprecatedAttribute);
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
