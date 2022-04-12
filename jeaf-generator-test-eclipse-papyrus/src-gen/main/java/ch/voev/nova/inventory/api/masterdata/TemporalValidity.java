/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.time.LocalDate;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Defines a validity range for a given item.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TemporalValidity {
  /**
   * Constant for the name of attribute "validFrom".
   */
  public static final String VALIDFROM = "validFrom";

  /**
   * Constant for the name of attribute "validUntil".
   */
  public static final String VALIDUNTIL = "validUntil";

  /**
   * 
   */
  private LocalDate validFrom;

  /**
   * 
   */
  private LocalDate validUntil;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TemporalValidity( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TemporalValidity( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    validFrom = pBuilder.validFrom;
    validUntil = pBuilder.validUntil;
  }

  /**
   * Class implements builder to create a new instance of class TemporalValidity. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private LocalDate validFrom;

    /**
     * 
     */
    private LocalDate validUntil;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(TemporalValidity)} instead of private constructor to create new builder.
     */
    protected Builder( TemporalValidity pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        validFrom = pObject.validFrom;
        validUntil = pObject.validUntil;
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
     * @return {@link Builder} New builder that can be used to create new TemporalValidity objects. The method never
     * returns null.
     */
    public static Builder newBuilder( TemporalValidity pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "validFrom".
     * 
     * @param pValidFrom Value to which the attribute "validFrom" should be set.
     */
    public Builder setValidFrom( LocalDate pValidFrom ) {
      // Assign value to attribute
      validFrom = pValidFrom;
      return this;
    }

    /**
     * Method sets the attribute "validUntil".
     * 
     * @param pValidUntil Value to which the attribute "validUntil" should be set.
     */
    public Builder setValidUntil( LocalDate pValidUntil ) {
      // Assign value to attribute
      validUntil = pValidUntil;
      return this;
    }

    /**
     * Method creates a new instance of class TemporalValidity. The object will be initialized with the values of the
     * builder.
     * 
     * @return TemporalValidity Created object. The method never returns null.
     */
    public TemporalValidity build( ) {
      return new TemporalValidity(this);
    }

    /**
     * Method creates a new validated instance of class TemporalValidity. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return TemporalValidity Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TemporalValidity buildValidated( ) throws ConstraintViolationException {
      TemporalValidity lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "validFrom".
   * 
   * 
   * @return LocalDate Value to which the attribute "validFrom" is set.
   */
  public LocalDate getValidFrom( ) {
    return validFrom;
  }

  /**
   * Method sets the attribute "validFrom".
   * 
   * 
   * @param pValidFrom Value to which the attribute "validFrom" should be set.
   */
  public void setValidFrom( LocalDate pValidFrom ) {
    // Assign value to attribute
    validFrom = pValidFrom;
  }

  /**
   * Method returns the attribute "validUntil".
   * 
   * 
   * @return LocalDate Value to which the attribute "validUntil" is set.
   */
  public LocalDate getValidUntil( ) {
    return validUntil;
  }

  /**
   * Method sets the attribute "validUntil".
   * 
   * 
   * @param pValidUntil Value to which the attribute "validUntil" should be set.
   */
  public void setValidUntil( LocalDate pValidUntil ) {
    // Assign value to attribute
    validUntil = pValidUntil;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "validFrom", "" + validFrom));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "validUntil", "" + validUntil));
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
