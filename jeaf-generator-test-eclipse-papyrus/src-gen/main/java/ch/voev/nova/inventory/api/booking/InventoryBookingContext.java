/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class InventoryBookingContext {
  /**
   * Constant for the name of attribute "acceptLanguage".
   */
  public static final String ACCEPTLANGUAGE = "acceptLanguage";

  /**
   * Constant for the name of attribute "traceParent".
   */
  public static final String TRACEPARENT = "traceParent";

  /**
   * Constant for the name of attribute "traceState".
   */
  public static final String TRACESTATE = "traceState";

  /**
   * Describes the set of natural languages that are preferred for localized text in the response to the request (see
   * RFC2616-sec14.4). Supporting English (en) is a must.
   */
  private String acceptLanguage;

  /**
   * The traceparent header describes the position of the incoming request in its trace graph in a portable,
   * fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST properly set traceparent even when
   * it only relies on vendor-specific information in tracestate (see W3C Trace Context).
   */
  private String traceParent;

  /**
   * The tracestate extends traceparent with vendor-specific data represented by a set of name/value pairs. Storing
   * information in tracestate is optional (see W3C Trace Context).
   */
  private String traceState;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  public InventoryBookingContext( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected InventoryBookingContext( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    acceptLanguage = pBuilder.acceptLanguage;
    traceParent = pBuilder.traceParent;
    traceState = pBuilder.traceState;
  }

  /**
   * Class implements builder to create a new instance of class InventoryBookingContext. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Describes the set of natural languages that are preferred for localized text in the response to the request (see
     * RFC2616-sec14.4). Supporting English (en) is a must.
     */
    private String acceptLanguage;

    /**
     * The traceparent header describes the position of the incoming request in its trace graph in a portable,
     * fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST properly set traceparent even
     * when it only relies on vendor-specific information in tracestate (see W3C Trace Context).
     */
    private String traceParent;

    /**
     * The tracestate extends traceparent with vendor-specific data represented by a set of name/value pairs. Storing
     * information in tracestate is optional (see W3C Trace Context).
     */
    private String traceState;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(InventoryBookingContext)} instead of private constructor to create new builder.
     */
    protected Builder( InventoryBookingContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        acceptLanguage = pObject.acceptLanguage;
        traceParent = pObject.traceParent;
        traceState = pObject.traceState;
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
     * @return {@link Builder} New builder that can be used to create new InventoryBookingContext objects. The method
     * never returns null.
     */
    public static Builder newBuilder( InventoryBookingContext pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "acceptLanguage". Describes the set of natural languages that are preferred for
     * localized text in the response to the request (see RFC2616-sec14.4). Supporting English (en) is a must.
     * 
     * @param pAcceptLanguage Value to which the attribute "acceptLanguage" should be set.
     */
    public Builder setAcceptLanguage( String pAcceptLanguage ) {
      // Assign value to attribute
      acceptLanguage = pAcceptLanguage;
      return this;
    }

    /**
     * Method sets the attribute "traceParent". The traceparent header describes the position of the incoming request in
     * its trace graph in a portable, fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST
     * properly set traceparent even when it only relies on vendor-specific information in tracestate (see W3C Trace
     * Context).
     * 
     * @param pTraceParent Value to which the attribute "traceParent" should be set.
     */
    public Builder setTraceParent( String pTraceParent ) {
      // Assign value to attribute
      traceParent = pTraceParent;
      return this;
    }

    /**
     * Method sets the attribute "traceState". The tracestate extends traceparent with vendor-specific data represented
     * by a set of name/value pairs. Storing information in tracestate is optional (see W3C Trace Context).
     * 
     * @param pTraceState Value to which the attribute "traceState" should be set.
     */
    public Builder setTraceState( String pTraceState ) {
      // Assign value to attribute
      traceState = pTraceState;
      return this;
    }

    /**
     * Method creates a new instance of class InventoryBookingContext. The object will be initialized with the values of
     * the builder.
     * 
     * @return InventoryBookingContext Created object. The method never returns null.
     */
    public InventoryBookingContext build( ) {
      return new InventoryBookingContext(this);
    }

    /**
     * Method creates a new validated instance of class InventoryBookingContext. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return InventoryBookingContext Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public InventoryBookingContext buildValidated( ) throws ConstraintViolationException {
      InventoryBookingContext lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "acceptLanguage". Describes the set of natural languages that are preferred for
   * localized text in the response to the request (see RFC2616-sec14.4). Supporting English (en) is a must.
   * 
   * @return String Value to which the attribute "acceptLanguage" is set.
   */
  public String getAcceptLanguage( ) {
    return acceptLanguage;
  }

  /**
   * Method sets the attribute "acceptLanguage". Describes the set of natural languages that are preferred for localized
   * text in the response to the request (see RFC2616-sec14.4). Supporting English (en) is a must.
   * 
   * @param pAcceptLanguage Value to which the attribute "acceptLanguage" should be set.
   */
  public void setAcceptLanguage( String pAcceptLanguage ) {
    // Assign value to attribute
    acceptLanguage = pAcceptLanguage;
  }

  /**
   * Method returns the attribute "traceParent". The traceparent header describes the position of the incoming request
   * in its trace graph in a portable, fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST
   * properly set traceparent even when it only relies on vendor-specific information in tracestate (see W3C Trace
   * Context).
   * 
   * @return String Value to which the attribute "traceParent" is set.
   */
  public String getTraceParent( ) {
    return traceParent;
  }

  /**
   * Method sets the attribute "traceParent". The traceparent header describes the position of the incoming request in
   * its trace graph in a portable, fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST
   * properly set traceparent even when it only relies on vendor-specific information in tracestate (see W3C Trace
   * Context).
   * 
   * @param pTraceParent Value to which the attribute "traceParent" should be set.
   */
  public void setTraceParent( String pTraceParent ) {
    // Assign value to attribute
    traceParent = pTraceParent;
  }

  /**
   * Method returns the attribute "traceState". The tracestate extends traceparent with vendor-specific data represented
   * by a set of name/value pairs. Storing information in tracestate is optional (see W3C Trace Context).
   * 
   * @return String Value to which the attribute "traceState" is set.
   */
  public String getTraceState( ) {
    return traceState;
  }

  /**
   * Method sets the attribute "traceState". The tracestate extends traceparent with vendor-specific data represented by
   * a set of name/value pairs. Storing information in tracestate is optional (see W3C Trace Context).
   * 
   * @param pTraceState Value to which the attribute "traceState" should be set.
   */
  public void setTraceState( String pTraceState ) {
    // Assign value to attribute
    traceState = pTraceState;
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
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "acceptLanguage", "" + acceptLanguage));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "traceParent", "" + traceParent));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "traceState", "" + traceState));
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
