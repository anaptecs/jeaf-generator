/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Parameters which describe the current status of a dated vehicle journey. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ServiceStatus {
  /**
   * Constant for the name of attribute "unplanned".
   */
  public static final String UNPLANNED = "unplanned";

  /**
   * Constant for the name of attribute "cancelled".
   */
  public static final String CANCELLED = "cancelled";

  /**
   * Constant for the name of attribute "deviation".
   */
  public static final String DEVIATION = "deviation";

  /**
   * Constant for the name of attribute "occupancy".
   */
  public static final String OCCUPANCY = "occupancy";

  /**
   * Whether this trip is an additional one that has not been planned. <br/>
   * <b>Default Value:</b> <code>false</code>
   */
  private boolean unplanned;

  /**
   * Whether this trip is cancelled and will not be run. <br/>
   * <b>Default Value:</b> <code>false</code>
   */
  private boolean cancelled;

  /**
   * Whether this trip deviates from the planned service pattern. <br/>
   * <b>Default Value:</b> <code>false</code>
   */
  private boolean deviation;

  /**
   * Passenger load status on vehicle. If omitted, not known. Equivalent to siri:OccupancyEnumeration which describes
   * three values: "full", "seatingAvailable" and "standingAvailable".
   */
  private String occupancy;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ServiceStatus( ) {
    unplanned = false;
    cancelled = false;
    deviation = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ServiceStatus( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    unplanned = pBuilder.unplanned;
    cancelled = pBuilder.cancelled;
    deviation = pBuilder.deviation;
    occupancy = pBuilder.occupancy;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ServiceStatus objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ServiceStatus objects. The method never returns
   * null.
   */
  public static Builder builder( ServiceStatus pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ServiceStatus. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * Whether this trip is an additional one that has not been planned.
     */
    private boolean unplanned = false;

    /**
     * Whether this trip is cancelled and will not be run.
     */
    private boolean cancelled = false;

    /**
     * Whether this trip deviates from the planned service pattern.
     */
    private boolean deviation = false;

    /**
     * Passenger load status on vehicle. If omitted, not known. Equivalent to siri:OccupancyEnumeration which describes
     * three values: "full", "seatingAvailable" and "standingAvailable".
     */
    private String occupancy;

    /**
     * Use {@link ServiceStatus#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ServiceStatus#builder(ServiceStatus)} instead of private constructor to create new builder.
     */
    protected Builder( ServiceStatus pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        unplanned = pObject.unplanned;
        cancelled = pObject.cancelled;
        deviation = pObject.deviation;
        occupancy = pObject.occupancy;
      }
    }

    /**
     * Method sets the attribute "unplanned". Whether this trip is an additional one that has not been planned.
     * 
     * @param pUnplanned Value to which the attribute "unplanned" should be set.
     */
    public Builder setUnplanned( boolean pUnplanned ) {
      // Assign value to attribute
      unplanned = pUnplanned;
      return this;
    }

    /**
     * Method sets the attribute "cancelled". Whether this trip is cancelled and will not be run.
     * 
     * @param pCancelled Value to which the attribute "cancelled" should be set.
     */
    public Builder setCancelled( boolean pCancelled ) {
      // Assign value to attribute
      cancelled = pCancelled;
      return this;
    }

    /**
     * Method sets the attribute "deviation". Whether this trip deviates from the planned service pattern.
     * 
     * @param pDeviation Value to which the attribute "deviation" should be set.
     */
    public Builder setDeviation( boolean pDeviation ) {
      // Assign value to attribute
      deviation = pDeviation;
      return this;
    }

    /**
     * Method sets the attribute "occupancy". Passenger load status on vehicle. If omitted, not known. Equivalent to
     * siri:OccupancyEnumeration which describes three values: "full", "seatingAvailable" and "standingAvailable".
     * 
     * @param pOccupancy Value to which the attribute "occupancy" should be set.
     */
    public Builder setOccupancy( String pOccupancy ) {
      // Assign value to attribute
      occupancy = pOccupancy;
      return this;
    }

    /**
     * Method creates a new instance of class ServiceStatus. The object will be initialized with the values of the
     * builder.
     * 
     * @return ServiceStatus Created object. The method never returns null.
     */
    public ServiceStatus build( ) {
      return new ServiceStatus(this);
    }

    /**
     * Method creates a new validated instance of class ServiceStatus. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return ServiceStatus Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ServiceStatus buildValidated( ) throws ConstraintViolationException {
      ServiceStatus lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "unplanned". Whether this trip is an additional one that has not been planned.
   * 
   * @return Boolean Value to which the attribute "unplanned" is set.
   */
  public boolean getUnplanned( ) {
    return unplanned;
  }

  /**
   * Method sets the attribute "unplanned". Whether this trip is an additional one that has not been planned.
   * 
   * @param pUnplanned Value to which the attribute "unplanned" should be set.
   */
  public void setUnplanned( boolean pUnplanned ) {
    // Assign value to attribute
    unplanned = pUnplanned;
  }

  /**
   * Method returns the attribute "cancelled". Whether this trip is cancelled and will not be run.
   * 
   * @return Boolean Value to which the attribute "cancelled" is set.
   */
  public boolean getCancelled( ) {
    return cancelled;
  }

  /**
   * Method sets the attribute "cancelled". Whether this trip is cancelled and will not be run.
   * 
   * @param pCancelled Value to which the attribute "cancelled" should be set.
   */
  public void setCancelled( boolean pCancelled ) {
    // Assign value to attribute
    cancelled = pCancelled;
  }

  /**
   * Method returns the attribute "deviation". Whether this trip deviates from the planned service pattern.
   * 
   * @return Boolean Value to which the attribute "deviation" is set.
   */
  public boolean getDeviation( ) {
    return deviation;
  }

  /**
   * Method sets the attribute "deviation". Whether this trip deviates from the planned service pattern.
   * 
   * @param pDeviation Value to which the attribute "deviation" should be set.
   */
  public void setDeviation( boolean pDeviation ) {
    // Assign value to attribute
    deviation = pDeviation;
  }

  /**
   * Method returns the attribute "occupancy". Passenger load status on vehicle. If omitted, not known. Equivalent to
   * siri:OccupancyEnumeration which describes three values: "full", "seatingAvailable" and "standingAvailable".
   * 
   * @return String Value to which the attribute "occupancy" is set.
   */
  public String getOccupancy( ) {
    return occupancy;
  }

  /**
   * Method sets the attribute "occupancy". Passenger load status on vehicle. If omitted, not known. Equivalent to
   * siri:OccupancyEnumeration which describes three values: "full", "seatingAvailable" and "standingAvailable".
   * 
   * @param pOccupancy Value to which the attribute "occupancy" should be set.
   */
  public void setOccupancy( String pOccupancy ) {
    // Assign value to attribute
    occupancy = pOccupancy;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "unplanned", "" + unplanned));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "cancelled", "" + cancelled));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "deviation", "" + deviation));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "occupancy", "" + occupancy));
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
