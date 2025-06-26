/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.JEAFCustomAnnotationTest;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

@Generated("Before Class Declaration. Here an annontation cloud be added.")
/**
 * <p/>
 * <b>Alternate Name:</b> <code>Haltestelle</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@JEAFCustomAnnotationTest
public class UICStop extends Stop implements IStop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "uicCode".
   */
  @JEAFCustomAnnotationTest
  public static final String UICCODE = "uicCode";

  /**
   * Constant for the name of attribute "priority".
   */
  @JEAFCustomAnnotationTest
  public static final String PRIORITY = "priority";

  /**
   * Constant for the name of attribute "code".
   */
  @JEAFCustomAnnotationTest
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "index2".
   */
  @JEAFCustomAnnotationTest
  public static final String INDEX2 = "index2";

  /**
   * Constant for the name of attribute "inlineStopTypes".
   */
  @JEAFCustomAnnotationTest
  public static final String INLINESTOPTYPES = "inlineStopTypes";

  /**
   * Constant for the name of attribute "inlineStopType".
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public static final String INLINESTOPTYPE = "inlineStopType";

  // "String"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Size(min = 32, max = 255)
  private String uicCode;

  // "String"
  private int uicCodeXYZ = 0;

  // "int"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @DecimalMax(value = "32.777", inclusive = true)
  @DecimalMin(value = "1.025", inclusive = true)
  private int priority;

  // "int"
  private int priorityXYZ = 0;

  // "long"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Min(value = 1000)
  @Max(value = 9999)
  private long code;

  // "long"
  private int codeXYZ = 0;

  // "byte"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  @Positive
  private byte index2;

  // "byte"
  private int index2XYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
  @ClassPropertyDeclaration
  @JEAFCustomAnnotationTest
  private Set<InlineStopType> inlineStopTypes;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
  private int inlineStopTypesXYZ = 0;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
  @ClassPropertyDeclaration
  @Deprecated
  @JEAFCustomAnnotationTest
  private InlineStopType inlineStopType;

  // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
  private int inlineStopTypeXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected UICStop( ) {
    inlineStopTypes = new HashSet<>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected UICStop( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    uicCode = pBuilder.uicCode;
    // "String"
    uicCodeXYZ = pBuilder.uicCodeXYZ;
    priority = pBuilder.priority;
    // "int"
    priorityXYZ = pBuilder.priorityXYZ;
    code = pBuilder.code;
    // "long"
    codeXYZ = pBuilder.codeXYZ;
    index2 = pBuilder.index2;
    // "byte"
    index2XYZ = pBuilder.index2XYZ;
    if (pBuilder.inlineStopTypes != null) {
      inlineStopTypes = pBuilder.inlineStopTypes;
    }
    else {
      inlineStopTypes = new HashSet<>();
    }
    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    inlineStopTypesXYZ = pBuilder.inlineStopTypesXYZ;
    inlineStopType = pBuilder.inlineStopType;
    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    inlineStopTypeXYZ = pBuilder.inlineStopTypeXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new UICStop objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>UICStop</code>.
   */
  @JEAFCustomAnnotationTest
  public static class Builder extends Stop.Builder {
    // "String"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Size(min = 32, max = 255)
    private String uicCode;

    // "String"
    private int uicCodeXYZ = 0;

    // "int"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @DecimalMax(value = "32.777", inclusive = true)
    @DecimalMin(value = "1.025", inclusive = true)
    private int priority;

    // "int"
    private int priorityXYZ = 0;

    // "long"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Min(value = 1000)
    @Max(value = 9999)
    private long code;

    // "long"
    private int codeXYZ = 0;

    // "byte"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    @Positive
    private byte index2;

    // "byte"
    private int index2XYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    @BuilderPropertyDeclaration
    @JEAFCustomAnnotationTest
    private Set<InlineStopType> inlineStopTypes;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    private int inlineStopTypesXYZ = 0;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    @BuilderPropertyDeclaration
    @Deprecated
    @JEAFCustomAnnotationTest
    private InlineStopType inlineStopType;

    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    private int inlineStopTypeXYZ = 0;

    /**
     * Use {@link UICStop#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link UICStop#builder(UICStop)} instead of private constructor to create new builder.
     */
    protected Builder( UICStop pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setUicCode(pObject.uicCode);
        this.setPriority(pObject.priority);
        this.setCode(pObject.code);
        this.setIndex2(pObject.index2);
        this.setInlineStopTypes(pObject.inlineStopTypes);
        this.setInlineStopType(pObject.inlineStopType);
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets association {@link #links}.<br/>
     *
     * @param pLinks Collection to which {@link #links} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    @Override
    public Builder setLinks( List<LinkObject> pLinks ) {
      // Call super class implementation.
      super.setLinks(pLinks);
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #links}.<br/>
     *
     * @param pLinks Array of objects that should be added to {@link #links}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder addToLinks( LinkObject... pLinks ) {
      // Call super class implementation.
      super.addToLinks(pLinks);
      return this;
    }

    /**
     * Method sets attribute {@link #index}.<br/>
     *
     * @param pIndex Value to which {@link #index} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    @Override
    public Builder setIndex( byte pIndex ) {
      // Call super class implementation.
      super.setIndex(pIndex);
      return this;
    }

    /**
     * Method sets association {@link #theSoftLink}.<br/>
     *
     * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    @Override
    public Builder setTheSoftLink( SoftLink pTheSoftLink ) {
      // Call super class implementation.
      super.setTheSoftLink(pTheSoftLink);
      return this;
    }

    /**
     * Method sets attribute {@link #uicCode}.<br/>
     *
     * @param pUicCode Value to which {@link #uicCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setUicCode( String pUicCode ) {
      // Assign value to attribute
      uicCode = pUicCode;
      return this;
    }

    public Builder setUicCodeXYZ( int value ) {
      // "String"
      uicCodeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #priority}.<br/>
     *
     * @param pPriority Value to which {@link #priority} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setPriority( int pPriority ) {
      // Assign value to attribute
      priority = pPriority;
      return this;
    }

    public Builder setPriorityXYZ( int value ) {
      // "int"
      priorityXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setCode( long pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    public Builder setCodeXYZ( int value ) {
      // "long"
      codeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #index2}.<br/>
     *
     * @param pIndex2 Value to which {@link #index2} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setIndex2( byte pIndex2 ) {
      // Assign value to attribute
      index2 = pIndex2;
      return this;
    }

    public Builder setIndex2XYZ( int value ) {
      // "byte"
      index2XYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #inlineStopTypes}.<br/>
     *
     * @param pInlineStopTypes Collection to which {@link #inlineStopTypes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setInlineStopTypes( Set<InlineStopType> pInlineStopTypes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pInlineStopTypes != null) {
        inlineStopTypes = new HashSet<InlineStopType>(pInlineStopTypes);
      }
      else {
        inlineStopTypes = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #inlineStopTypes}.<br/>
     *
     * @param pInlineStopTypes Array of objects that should be added to {@link #inlineStopTypes}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder addToInlineStopTypes( InlineStopType... pInlineStopTypes ) {
      if (pInlineStopTypes != null) {
        if (inlineStopTypes == null) {
          inlineStopTypes = new HashSet<InlineStopType>();
        }
        inlineStopTypes.addAll(Arrays.asList(pInlineStopTypes));
      }
      return this;
    }

    /**
     * Method sets association {@link #inlineStopTypes}.<br/>
     *
     * @param pInlineStopTypes Array with objects to which {@link #inlineStopTypes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JEAFCustomAnnotationTest
    public Builder setInlineStopTypes( InlineStopType... pInlineStopTypes ) {
      // Copy the content of the passed array.
      if (pInlineStopTypes != null) {
        inlineStopTypes = new HashSet<InlineStopType>(Arrays.asList(pInlineStopTypes));
      }
      else {
        inlineStopTypes = null;
      }
      return this;
    }

    public Builder setInlineStopTypesXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
      inlineStopTypesXYZ = value;
      return this;
    }

    /**
     * Method sets association {@link #inlineStopType}.<br/>
     *
     * @param pInlineStopType Value to which {@link #inlineStopType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    @JEAFCustomAnnotationTest
    public Builder setInlineStopType( InlineStopType pInlineStopType ) {
      inlineStopType = pInlineStopType;
      return this;
    }

    public Builder setInlineStopTypeXYZ( int value ) {
      // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
      inlineStopTypeXYZ = value;
      return this;
    }
    // Ooops, I also forgot to implement that for our builders ;-(

    /**
     * Method creates a new instance of class UICStop. The object will be initialized with the values of the builder.
     *
     * @return UICStop Created object. The method never returns null.
     */
    public UICStop build( ) {
      return new UICStop(this);
    }

    /**
     * Method creates a new validated instance of class UICStop. The object will be initialized with the values of the
     * builder and validated afterwards.
     *
     * @return UICStop Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public UICStop buildValidated( ) throws ConstraintViolationException {
      UICStop lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #uicCode}.<br/>
   *
   * @return {@link String} Value to which {@link #uicCode} is set.
   */
  @JEAFCustomAnnotationTest
  public String getUicCode( ) {
    return uicCode;
  }

  /**
   * Method sets attribute {@link #uicCode}.<br/>
   *
   * @param pUicCode Value to which {@link #uicCode} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setUicCode( String pUicCode ) {
    // Assign value to attribute
    uicCode = pUicCode;
  }

  public int getUicCodeXYZ( ) {
    // "String"
    return uicCodeXYZ;
  }

  public void setUicCodeXYZ( int value ) {
    uicCodeXYZ = value;
  }

  /**
   * Method returns attribute {@link #priority}.<br/>
   *
   * @return int Value to which {@link #priority} is set.
   */
  @JEAFCustomAnnotationTest
  public int getPriority( ) {
    return priority;
  }

  /**
   * Method sets attribute {@link #priority}.<br/>
   *
   * @param pPriority Value to which {@link #priority} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setPriority( int pPriority ) {
    // Assign value to attribute
    priority = pPriority;
  }

  public int getPriorityXYZ( ) {
    // "int"
    return priorityXYZ;
  }

  public void setPriorityXYZ( int value ) {
    priorityXYZ = value;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return long Value to which {@link #code} is set.
   */
  @JEAFCustomAnnotationTest
  public long getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setCode( long pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  public int getCodeXYZ( ) {
    // "long"
    return codeXYZ;
  }

  public void setCodeXYZ( int value ) {
    codeXYZ = value;
  }

  /**
   * Method returns attribute {@link #index2}.<br/>
   *
   * @return byte Value to which {@link #index2} is set.
   */
  @JEAFCustomAnnotationTest
  public byte getIndex2( ) {
    return index2;
  }

  /**
   * Method sets attribute {@link #index2}.<br/>
   *
   * @param pIndex2 Value to which {@link #index2} should be set.
   */
  @JEAFCustomAnnotationTest
  public void setIndex2( byte pIndex2 ) {
    // Assign value to attribute
    index2 = pIndex2;
  }

  public int getIndex2XYZ( ) {
    // "byte"
    return index2XYZ;
  }

  public void setIndex2XYZ( int value ) {
    index2XYZ = value;
  }

  /**
   * Method returns association {@link #inlineStopTypes}.<br/>
   *
   * @return {@link Set<InlineStopType>} Value to which {@link #inlineStopTypes} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  @JEAFCustomAnnotationTest
  public Set<InlineStopType> getInlineStopTypes( ) {
    // Return all InlineStopType objects as unmodifiable collection.
    return Collections.unmodifiableSet(inlineStopTypes);
  }

  /**
   * Method adds the passed object to {@link #inlineStopTypes}.
   *
   * @param pInlineStopTypes Object that should be added to {@link #inlineStopTypes}. The parameter must not be null.
   */
  @JEAFCustomAnnotationTest
  public void addToInlineStopTypes( InlineStopType pInlineStopTypes ) {
    // Check parameter "pInlineStopTypes" for invalid value null.
    Check.checkInvalidParameterNull(pInlineStopTypes, "pInlineStopTypes");
    // Add passed object to collection of associated InlineStopType objects.
    inlineStopTypes.add(pInlineStopTypes);
  }

  /**
   * Method adds all passed objects to {@link #inlineStopTypes}.
   *
   * @param pInlineStopTypes Collection with all objects that should be added to {@link #inlineStopTypes}. The parameter
   * must not be null.
   */
  @JEAFCustomAnnotationTest
  public void addToInlineStopTypes( Collection<InlineStopType> pInlineStopTypes ) {
    // Check parameter "pInlineStopTypes" for invalid value null.
    Check.checkInvalidParameterNull(pInlineStopTypes, "pInlineStopTypes");
    // Add all passed objects.
    for (InlineStopType lNextObject : pInlineStopTypes) {
      this.addToInlineStopTypes(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #inlineStopTypes}.<br/>
   *
   * @param pInlineStopTypes Object that should be removed from {@link #inlineStopTypes}. The parameter must not be
   * null.
   */
  @JEAFCustomAnnotationTest
  public void removeFromInlineStopTypes( InlineStopType pInlineStopTypes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pInlineStopTypes, "pInlineStopTypes");
    // Remove passed object from collection of associated InlineStopType objects.
    inlineStopTypes.remove(pInlineStopTypes);
  }

  /**
   * Method removes all objects from {@link #inlineStopTypes}.
   */
  @JEAFCustomAnnotationTest
  public void clearInlineStopTypes( ) {
    // Remove all objects from association "inlineStopTypes".
    inlineStopTypes.clear();
  }

  public int getInlineStopTypesXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    return inlineStopTypesXYZ;
  }

  public void setInlineStopTypesXYZ( int value ) {
    inlineStopTypesXYZ = value;
  }

  /**
   * Method returns association {@link #inlineStopType}.<br/>
   *
   * @return {@link InlineStopType} Value to which {@link #inlineStopType} is set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public InlineStopType getInlineStopType( ) {
    return inlineStopType;
  }

  /**
   * Method sets association {@link #inlineStopType}.<br/>
   *
   * @param pInlineStopType Value to which {@link #inlineStopType} should be set.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public void setInlineStopType( InlineStopType pInlineStopType ) {
    inlineStopType = pInlineStopType;
  }

  /**
   * Method unsets {@link #inlineStopType}.
   */
  @Deprecated
  @JEAFCustomAnnotationTest
  public final void unsetInlineStopType( ) {
    inlineStopType = null;
  }

  public int getInlineStopTypeXYZ( ) {
    // "com.anaptecs.jeaf.junit.openapi.base.InlineStopType"
    return inlineStopTypeXYZ;
  }

  public void setInlineStopTypeXYZ( int value ) {
    inlineStopTypeXYZ = value;
  }

  public void doSomethingGenerated( ) {
    // Ooops, I forget to implement that ;-)
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
    lBuilder.append("uicCode: ");
    lBuilder.append(uicCode);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("priority: ");
    lBuilder.append(priority);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("code: ");
    lBuilder.append(code);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("index2: ");
    lBuilder.append(index2);
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
   * @return {@link Builder} New builder that can be used to create new UICStop objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}