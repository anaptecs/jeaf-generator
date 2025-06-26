/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * <p/>
 * <b>Alternate Name:</b> <code>Haltestelle</code>
 *
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class UICStop extends Stop implements IStop {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "uicCode".
   */
  public static final String UICCODE = "uicCode";

  /**
   * Constant for the name of attribute "priority".
   */
  public static final String PRIORITY = "priority";

  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  /**
   * Constant for the name of attribute "index2".
   */
  public static final String INDEX2 = "index2";

  /**
   * Constant for the name of attribute "inlineStopTypes".
   */
  public static final String INLINESTOPTYPES = "inlineStopTypes";

  /**
   * Constant for the name of attribute "inlineStopType".
   */
  @Deprecated
  public static final String INLINESTOPTYPE = "inlineStopType";

  @Size(min = 32, max = 255)
  private String uicCode;

  @DecimalMax(value = "32.777", inclusive = true)
  @DecimalMin(value = "1.025", inclusive = true)
  private int priority;

  @Min(value = 1000)
  @Max(value = 9999)
  private long code;

  @Positive
  private byte index2;

  private Set<InlineStopType> inlineStopTypes;

  @Deprecated
  private InlineStopType inlineStopType;

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
    priority = pBuilder.priority;
    code = pBuilder.code;
    index2 = pBuilder.index2;
    if (pBuilder.inlineStopTypes != null) {
      inlineStopTypes = pBuilder.inlineStopTypes;
    }
    else {
      inlineStopTypes = new HashSet<>();
    }
    inlineStopType = pBuilder.inlineStopType;
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
   * Convenience method to create new instance of class UICStop.
   *
   *
   * @param pName Value to which {@link #name} should be set.
   *
   * @param pIndex Value to which {@link #index} should be set.
   *
   * @param pTheSoftLink Value to which {@link #theSoftLink} should be set.
   *
   * @param pUicCode Value to which {@link #uicCode} should be set.
   *
   * @param pPriority Value to which {@link #priority} should be set.
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @param pIndex2 Value to which {@link #index2} should be set.
   *
   * @param pInlineStopTypes Value to which {@link #inlineStopTypes} should be set.
   *
   * @param pInlineStopType Value to which {@link #inlineStopType} should be set.
   *
   * @return {@link com.anaptecs.jeaf.junit.openapi.base.UICStop}
   */
  public static UICStop of( String pName, byte pIndex, SoftLink pTheSoftLinkLink, String pUicCode, int pPriority,
      long pCode, byte pIndex2, Set<InlineStopType> pInlineStopTypes, InlineStopType pInlineStopType ) {
    var lBuilder = UICStop.builder();
    lBuilder.setName(pName);
    lBuilder.setIndex(pIndex);
    lBuilder.setTheSoftLinkLink(pTheSoftLinkLink);
    lBuilder.setUicCode(pUicCode);
    lBuilder.setPriority(pPriority);
    lBuilder.setCode(pCode);
    lBuilder.setIndex2(pIndex2);
    lBuilder.setInlineStopTypes(pInlineStopTypes);
    lBuilder.setInlineStopType(pInlineStopType);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>UICStop</code>.
   */
  public static class Builder extends Stop.Builder {
    @Size(min = 32, max = 255)
    private String uicCode;

    @DecimalMax(value = "32.777", inclusive = true)
    @DecimalMin(value = "1.025", inclusive = true)
    private int priority;

    @Min(value = 1000)
    @Max(value = 9999)
    private long code;

    @Positive
    private byte index2;

    private Set<InlineStopType> inlineStopTypes;

    @Deprecated
    private InlineStopType inlineStopType;

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
    @Override
    public Builder setTheSoftLinkLink( SoftLink pTheSoftLink ) {
      // Call super class implementation.
      super.setTheSoftLinkLink(pTheSoftLink);
      return this;
    }

    /**
     * Method sets attribute {@link #uicCode}.<br/>
     *
     * @param pUicCode Value to which {@link #uicCode} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setUicCode( String pUicCode ) {
      // Assign value to attribute
      uicCode = pUicCode;
      return this;
    }

    /**
     * Method sets attribute {@link #priority}.<br/>
     *
     * @param pPriority Value to which {@link #priority} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPriority( int pPriority ) {
      // Assign value to attribute
      priority = pPriority;
      return this;
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCode( long pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method sets attribute {@link #index2}.<br/>
     *
     * @param pIndex2 Value to which {@link #index2} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setIndex2( byte pIndex2 ) {
      // Assign value to attribute
      index2 = pIndex2;
      return this;
    }

    /**
     * Method sets association {@link #inlineStopTypes}.<br/>
     *
     * @param pInlineStopTypes Collection to which {@link #inlineStopTypes} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setInlineStopTypes( Set<InlineStopType> pInlineStopTypes ) {
      inlineStopTypes = pInlineStopTypes;
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #inlineStopTypes}.<br/>
     *
     * @param pInlineStopTypes Array of objects that should be added to {@link #inlineStopTypes}. The parameter may be
     * null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
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

    /**
     * Method sets association {@link #inlineStopType}.<br/>
     *
     * @param pInlineStopType Value to which {@link #inlineStopType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Deprecated
    public Builder setInlineStopType( InlineStopType pInlineStopType ) {
      inlineStopType = pInlineStopType;
      return this;
    }

    /**
     * Method creates a new instance of class UICStop. The object will be initialized with the values of the builder.
     *
     * @return UICStop Created object. The method never returns null.
     */
    public UICStop build( ) {
      UICStop lObject = new UICStop(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
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
  public String getUicCode( ) {
    return uicCode;
  }

  /**
   * Method sets attribute {@link #uicCode}.<br/>
   *
   * @param pUicCode Value to which {@link #uicCode} should be set.
   */
  public void setUicCode( String pUicCode ) {
    // Assign value to attribute
    uicCode = pUicCode;
  }

  /**
   * Method returns attribute {@link #priority}.<br/>
   *
   * @return int Value to which {@link #priority} is set.
   */
  public int getPriority( ) {
    return priority;
  }

  /**
   * Method sets attribute {@link #priority}.<br/>
   *
   * @param pPriority Value to which {@link #priority} should be set.
   */
  public void setPriority( int pPriority ) {
    // Assign value to attribute
    priority = pPriority;
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return long Value to which {@link #code} is set.
   */
  public long getCode( ) {
    return code;
  }

  /**
   * Method sets attribute {@link #code}.<br/>
   *
   * @param pCode Value to which {@link #code} should be set.
   */
  public void setCode( long pCode ) {
    // Assign value to attribute
    code = pCode;
  }

  /**
   * Method returns attribute {@link #index2}.<br/>
   *
   * @return byte Value to which {@link #index2} is set.
   */
  public byte getIndex2( ) {
    return index2;
  }

  /**
   * Method sets attribute {@link #index2}.<br/>
   *
   * @param pIndex2 Value to which {@link #index2} should be set.
   */
  public void setIndex2( byte pIndex2 ) {
    // Assign value to attribute
    index2 = pIndex2;
  }

  /**
   * Method returns association {@link #inlineStopTypes}.<br/>
   *
   * @return {@link Set<InlineStopType>} Value to which {@link #inlineStopTypes} is set. The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<InlineStopType> getInlineStopTypes( ) {
    // Return all InlineStopType objects as unmodifiable collection.
    return Collections.unmodifiableSet(inlineStopTypes);
  }

  /**
   * Method adds the passed object to {@link #inlineStopTypes}.
   *
   * @param pInlineStopTypes Object that should be added to {@link #inlineStopTypes}. The parameter must not be null.
   */
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
  public void removeFromInlineStopTypes( InlineStopType pInlineStopTypes ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pInlineStopTypes, "pInlineStopTypes");
    // Remove passed object from collection of associated InlineStopType objects.
    inlineStopTypes.remove(pInlineStopTypes);
  }

  /**
   * Method removes all objects from {@link #inlineStopTypes}.
   */
  public void clearInlineStopTypes( ) {
    // Remove all objects from association "inlineStopTypes".
    inlineStopTypes.clear();
  }

  /**
   * Method returns association {@link #inlineStopType}.<br/>
   *
   * @return {@link InlineStopType} Value to which {@link #inlineStopType} is set.
   */
  @Deprecated
  public InlineStopType getInlineStopType( ) {
    return inlineStopType;
  }

  /**
   * Method sets association {@link #inlineStopType}.<br/>
   *
   * @param pInlineStopType Value to which {@link #inlineStopType} should be set.
   */
  @Deprecated
  public void setInlineStopType( InlineStopType pInlineStopType ) {
    inlineStopType = pInlineStopType;
  }

  /**
   * Method unsets {@link #inlineStopType}.
   */
  @Deprecated
  public final void unsetInlineStopType( ) {
    inlineStopType = null;
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