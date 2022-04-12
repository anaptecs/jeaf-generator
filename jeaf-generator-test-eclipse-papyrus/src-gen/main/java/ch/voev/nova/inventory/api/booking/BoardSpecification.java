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
 * Minimal leg board specification.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class BoardSpecification {
  /**
   * Constant for the name of attribute "stopPlaceRef".
   */
  public static final String STOPPLACEREF = "stopPlaceRef";

  /**
   * Constant for the name of attribute "serviceDeparture".
   */
  public static final String SERVICEDEPARTURE = "serviceDeparture";

  /**
   * 
   */
  private StopPlaceRef stopPlaceRef;

  /**
   * Describes the departure situation at this leg board stop point (group of attributes timetabled passing time,
   * estimated passing time, observed passing time).
   */
  private ServiceTime serviceDeparture;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BoardSpecification( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BoardSpecification( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    stopPlaceRef = pBuilder.stopPlaceRef;
    serviceDeparture = pBuilder.serviceDeparture;
  }

  /**
   * Class implements builder to create a new instance of class BoardSpecification. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private StopPlaceRef stopPlaceRef;

    /**
     * Describes the departure situation at this leg board stop point (group of attributes timetabled passing time,
     * estimated passing time, observed passing time).
     */
    private ServiceTime serviceDeparture;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BoardSpecification)} instead of private constructor to create new builder.
     */
    protected Builder( BoardSpecification pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        stopPlaceRef = pObject.stopPlaceRef;
        serviceDeparture = pObject.serviceDeparture;
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
     * @return {@link Builder} New builder that can be used to create new BoardSpecification objects. The method never
     * returns null.
     */
    public static Builder newBuilder( BoardSpecification pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "stopPlaceRef".
     * 
     * @param pStopPlaceRef StopPlaceRef to which the association "stopPlaceRef" should be set.
     */
    public Builder setStopPlaceRef( StopPlaceRef pStopPlaceRef ) {
      stopPlaceRef = pStopPlaceRef;
      return this;
    }

    /**
     * Method sets the association "serviceDeparture". Describes the departure situation at this leg board stop point
     * (group of attributes timetabled passing time, estimated passing time, observed passing time).
     * 
     * @param pServiceDeparture ServiceTime to which the association "serviceDeparture" should be set.
     */
    public Builder setServiceDeparture( ServiceTime pServiceDeparture ) {
      serviceDeparture = pServiceDeparture;
      return this;
    }

    /**
     * Method creates a new instance of class BoardSpecification. The object will be initialized with the values of the
     * builder.
     * 
     * @return BoardSpecification Created object. The method never returns null.
     */
    public BoardSpecification build( ) {
      return new BoardSpecification(this);
    }

    /**
     * Method creates a new validated instance of class BoardSpecification. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return BoardSpecification Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BoardSpecification buildValidated( ) throws ConstraintViolationException {
      BoardSpecification lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "stopPlaceRef".
   * 
   *
   * @return StopPlaceRef StopPlaceRef to which the association "stopPlaceRef" is set.
   */
  public StopPlaceRef getStopPlaceRef( ) {
    return stopPlaceRef;
  }

  /**
   * Method sets the association "stopPlaceRef".
   * 
   * 
   * @param pStopPlaceRef StopPlaceRef to which the association "stopPlaceRef" should be set.
   */
  public void setStopPlaceRef( StopPlaceRef pStopPlaceRef ) {
    stopPlaceRef = pStopPlaceRef;
  }

  /**
   * Method unsets the association "stopPlaceRef".
   * 
   */
  public final void unsetStopPlaceRef( ) {
    stopPlaceRef = null;
  }

  /**
   * Method returns the association "serviceDeparture". Describes the departure situation at this leg board stop point
   * (group of attributes timetabled passing time, estimated passing time, observed passing time).
   *
   * @return ServiceTime ServiceTime to which the association "serviceDeparture" is set.
   */
  public ServiceTime getServiceDeparture( ) {
    return serviceDeparture;
  }

  /**
   * Method sets the association "serviceDeparture". Describes the departure situation at this leg board stop point
   * (group of attributes timetabled passing time, estimated passing time, observed passing time).
   * 
   * @param pServiceDeparture ServiceTime to which the association "serviceDeparture" should be set.
   */
  public void setServiceDeparture( ServiceTime pServiceDeparture ) {
    serviceDeparture = pServiceDeparture;
  }

  /**
   * Method unsets the association "serviceDeparture". Describes the departure situation at this leg board stop point
   * (group of attributes timetabled passing time, estimated passing time, observed passing time).
   */
  public final void unsetServiceDeparture( ) {
    serviceDeparture = null;
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
