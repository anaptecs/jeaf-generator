/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.time.OffsetDateTime;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Contains at least scheduled time, but can contain real time and estimated times. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ServiceTime {
  /**
   * Constant for the name of attribute "timetabledTime".
   */
  public static final String TIMETABLEDTIME = "timetabledTime";

  /**
   * Constant for the name of attribute "estimatedTime".
   */
  public static final String ESTIMATEDTIME = "estimatedTime";

  /**
   * Constant for the name of attribute "observedTime".
   */
  public static final String OBSERVEDTIME = "observedTime";

  /**
   * 
   */
  @NotNull
  private OffsetDateTime timetabledTime;

  /**
   * 
   */
  private OffsetDateTime estimatedTime;

  /**
   * 
   */
  private OffsetDateTime observedTime;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ServiceTime( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ServiceTime( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    timetabledTime = pBuilder.timetabledTime;
    estimatedTime = pBuilder.estimatedTime;
    observedTime = pBuilder.observedTime;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ServiceTime objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ServiceTime objects. The method never returns
   * null.
   */
  public static Builder builder( ServiceTime pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ServiceTime. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    @NotNull
    private OffsetDateTime timetabledTime;

    /**
     * 
     */
    private OffsetDateTime estimatedTime;

    /**
     * 
     */
    private OffsetDateTime observedTime;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(ServiceTime)} instead of private constructor to create new builder.
     */
    protected Builder( ServiceTime pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        timetabledTime = pObject.timetabledTime;
        estimatedTime = pObject.estimatedTime;
        observedTime = pObject.observedTime;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ServiceTime objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new ServiceTime objects. The method never returns
     * null.
     */
    public static Builder newBuilder( ServiceTime pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "timetabledTime".
     * 
     * @param pTimetabledTime Value to which the attribute "timetabledTime" should be set.
     */
    public Builder setTimetabledTime( OffsetDateTime pTimetabledTime ) {
      // Assign value to attribute
      timetabledTime = pTimetabledTime;
      return this;
    }

    /**
     * Method sets the attribute "estimatedTime".
     * 
     * @param pEstimatedTime Value to which the attribute "estimatedTime" should be set.
     */
    public Builder setEstimatedTime( OffsetDateTime pEstimatedTime ) {
      // Assign value to attribute
      estimatedTime = pEstimatedTime;
      return this;
    }

    /**
     * Method sets the attribute "observedTime".
     * 
     * @param pObservedTime Value to which the attribute "observedTime" should be set.
     */
    public Builder setObservedTime( OffsetDateTime pObservedTime ) {
      // Assign value to attribute
      observedTime = pObservedTime;
      return this;
    }

    /**
     * Method creates a new instance of class ServiceTime. The object will be initialized with the values of the
     * builder.
     * 
     * @return ServiceTime Created object. The method never returns null.
     */
    public ServiceTime build( ) {
      return new ServiceTime(this);
    }

    /**
     * Method creates a new validated instance of class ServiceTime. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return ServiceTime Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ServiceTime buildValidated( ) throws ConstraintViolationException {
      ServiceTime lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "timetabledTime".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "timetabledTime" is set.
   */
  public OffsetDateTime getTimetabledTime( ) {
    return timetabledTime;
  }

  /**
   * Method sets the attribute "timetabledTime".
   * 
   * 
   * @param pTimetabledTime Value to which the attribute "timetabledTime" should be set.
   */
  public void setTimetabledTime( OffsetDateTime pTimetabledTime ) {
    // Assign value to attribute
    timetabledTime = pTimetabledTime;
  }

  /**
   * Method returns the attribute "estimatedTime".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "estimatedTime" is set.
   */
  public OffsetDateTime getEstimatedTime( ) {
    return estimatedTime;
  }

  /**
   * Method sets the attribute "estimatedTime".
   * 
   * 
   * @param pEstimatedTime Value to which the attribute "estimatedTime" should be set.
   */
  public void setEstimatedTime( OffsetDateTime pEstimatedTime ) {
    // Assign value to attribute
    estimatedTime = pEstimatedTime;
  }

  /**
   * Method returns the attribute "observedTime".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "observedTime" is set.
   */
  public OffsetDateTime getObservedTime( ) {
    return observedTime;
  }

  /**
   * Method sets the attribute "observedTime".
   * 
   * 
   * @param pObservedTime Value to which the attribute "observedTime" should be set.
   */
  public void setObservedTime( OffsetDateTime pObservedTime ) {
    // Assign value to attribute
    observedTime = pObservedTime;
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
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "timetabledTime", "" + timetabledTime));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "estimatedTime", "" + estimatedTime));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "observedTime", "" + observedTime));
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
