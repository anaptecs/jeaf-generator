/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Latitude from equator. -90 (South) to +90 (North). Decimal degrees. e.g. 56.356.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Latitude {
  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * Latitude from equator. -90 (South) to +90 (North). Decimal degrees. e.g. 56.356. <br/>
   * <b>Example:</b> <code>47.37818</code>
   */
  @Min(value = -90)
  @Max(value = 90)
  private float value;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Latitude( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Latitude( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    value = pBuilder.value;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new Latitude objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new Latitude objects. The method never returns null.
   */
  public static Builder builder( Latitude pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class Latitude. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Latitude from equator. -90 (South) to +90 (North). Decimal degrees. e.g. 56.356.
     */
    @Min(value = -90)
    @Max(value = 90)
    private float value;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Latitude)} instead of private constructor to create new builder.
     */
    protected Builder( Latitude pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        value = pObject.value;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new Latitude objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Latitude objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Latitude pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "value". Latitude from equator. -90 (South) to +90 (North). Decimal degrees. e.g.
     * 56.356.
     * 
     * @param pValue Value to which the attribute "value" should be set.
     */
    public Builder setValue( float pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class Latitude. The object will be initialized with the values of the builder.
     * 
     * @return Latitude Created object. The method never returns null.
     */
    public Latitude build( ) {
      return new Latitude(this);
    }

    /**
     * Method creates a new validated instance of class Latitude. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Latitude Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Latitude buildValidated( ) throws ConstraintViolationException {
      Latitude lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "value". Latitude from equator. -90 (South) to +90 (North). Decimal degrees. e.g.
   * 56.356.
   * 
   * @return float Value to which the attribute "value" is set.
   */
  public float getValue( ) {
    return value;
  }

  /**
   * Method sets the attribute "value". Latitude from equator. -90 (South) to +90 (North). Decimal degrees. e.g. 56.356.
   * 
   * @param pValue Value to which the attribute "value" should be set.
   */
  public void setValue( float pValue ) {
    // Assign value to attribute
    value = pValue;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "value", "" + value));
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
