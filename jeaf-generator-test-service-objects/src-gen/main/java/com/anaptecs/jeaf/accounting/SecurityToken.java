/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.accounting;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class SecurityToken implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "sessionKey".
   */
  public static final String SESSIONKEY = "sessionKey";

  /**
   * Constant for the name of attribute "booking".
   */
  public static final String BOOKING = "booking";

  /**
   * Constant for the name of attribute "value".
   */
  public static final String VALUE = "value";

  /**
   * The attribute contains the session key of the security token that was used when the booking was executed.
   */
  private final byte[] sessionKey;

  private Booking booking;

  private transient Integer value;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected SecurityToken( ) {
    sessionKey = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected SecurityToken( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    sessionKey = pBuilder.sessionKey;
    booking = pBuilder.booking;
    value = pBuilder.value;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new SecurityToken objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new SecurityToken objects. The method never returns
   * null.
   */
  public static Builder builder( SecurityToken pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>SecurityToken</code>.
   */
  public static class Builder {
    /**
     * The attribute contains the session key of the security token that was used when the booking was executed.
     */
    private byte[] sessionKey;

    private Booking booking;

    private Integer value;

    /**
     * Use {@link SecurityToken#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link SecurityToken#builder(SecurityToken)} instead of private constructor to create new builder.
     */
    protected Builder( SecurityToken pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        sessionKey = pObject.sessionKey;
        booking = pObject.booking;
        value = pObject.value;
      }
    }

    /**
     * Method sets attribute {@link #sessionKey}.<br/>
     * 
     * @param pSessionKey Value to which {@link #sessionKey} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSessionKey( byte[] pSessionKey ) {
      // Assign value to attribute
      if (pSessionKey != null) {
        sessionKey = new byte[pSessionKey.length];
        System.arraycopy(pSessionKey, 0, sessionKey, 0, pSessionKey.length);
      }
      else {
        sessionKey = null;
      }
      return this;
    }

    /**
     * Method sets association {@link #booking}.<br/>
     * 
     * @param pBooking Value to which {@link #booking} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setBooking( Booking pBooking ) {
      booking = pBooking;
      return this;
    }

    /**
     * Method sets attribute {@link #value}.<br/>
     * 
     * @param pValue Value to which {@link #value} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setValue( Integer pValue ) {
      // Assign value to attribute
      value = pValue;
      return this;
    }

    /**
     * Method creates a new instance of class SecurityToken. The object will be initialized with the values of the
     * builder.
     * 
     * @return SecurityToken Created object. The method never returns null.
     */
    public SecurityToken build( ) {
      return new SecurityToken(this);
    }

    /**
     * Method creates a new validated instance of class SecurityToken. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return SecurityToken Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public SecurityToken buildValidated( ) throws ConstraintViolationException {
      SecurityToken lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #sessionKey}.<br/>
   * The attribute contains the session key of the security token that was used when the booking was executed.
   * 
   * @return byte Value to which {@link #sessionKey} is set.
   */
  public byte[] getSessionKey( ) {
    byte[] lReturnValue;
    if (sessionKey != null) {
      lReturnValue = new byte[sessionKey.length];
      System.arraycopy(sessionKey, 0, lReturnValue, 0, sessionKey.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method returns association {@link #booking}.<br/>
   * 
   * @return {@link Booking} Value to which {@link #booking} is set.
   */
  public Booking getBooking( ) {
    return booking;
  }

  /**
   * Method sets association {@link #booking}.<br/>
   * 
   * @param pBooking Value to which {@link #booking} should be set.
   */
  public void setBooking( Booking pBooking ) {
    // Release already referenced object before setting a new association.
    if (booking != null) {
      booking.unsetToken();
    }
    booking = pBooking;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pBooking != null && this.equals(pBooking.getToken()) == false) {
      pBooking.setToken((SecurityToken) this);
    }
  }

  /**
   * Method unsets {@link #booking}.
   */
  public final void unsetBooking( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    Booking lBooking = booking;
    booking = null;
    if (lBooking != null && this.equals(lBooking.getToken()) == true) {
      lBooking.unsetToken();
    }
  }

  /**
   * Method returns attribute {@link #value}.<br/>
   * 
   * @return {@link Integer} Value to which {@link #value} is set.
   */
  public Integer getValue( ) {
    return value;
  }

  /**
   * Method sets attribute {@link #value}.<br/>
   * 
   * @param pValue Value to which {@link #value} should be set.
   */
  public void setValue( Integer pValue ) {
    // Assign value to attribute
    value = pValue;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("value: ");
    lBuilder.append(value);
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
