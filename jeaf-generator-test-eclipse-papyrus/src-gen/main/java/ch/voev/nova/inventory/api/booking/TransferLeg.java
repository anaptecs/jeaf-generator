/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * A leg which links other legs of a trip where a transfer between different places is required. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TransferLeg {
  /**
   * Constant for the name of attribute "continuousMode".
   */
  public static final String CONTINUOUSMODE = "continuousMode";

  /**
   * Constant for the name of attribute "transferMode".
   */
  public static final String TRANSFERMODE = "transferMode";

  /**
   * Constant for the name of attribute "start".
   */
  public static final String START = "start";

  /**
   * Constant for the name of attribute "end".
   */
  public static final String END = "end";

  /**
   * Constant for the name of attribute "timeWindowStart".
   */
  public static final String TIMEWINDOWSTART = "timeWindowStart";

  /**
   * Constant for the name of attribute "timeWindowEnd".
   */
  public static final String TIMEWINDOWEND = "timeWindowEnd";

  /**
   * Constant for the name of attribute "duration".
   */
  public static final String DURATION = "duration";

  /**
   * Constant for the name of attribute "situationFullRefs".
   */
  public static final String SITUATIONFULLREFS = "situationFullRefs";

  /**
   * 
   */
  private ContinuousMode continuousMode;

  /**
   * 
   */
  private TransferMode transferMode;

  /**
   * Stop/Station to board.
   */
  private PlaceRef start;

  /**
   * Stop/Station to alight
   */
  private PlaceRef end;

  /**
   * Time at which window begins.
   */
  private OffsetDateTime timeWindowStart;

  /**
   * Time at which window ends.
   */
  private OffsetDateTime timeWindowEnd;

  /**
   * Overall duration of this interchange. <br/>
   * <b>Example:</b> <code>PT20M</code>
   */
  private Duration duration;

  /**
   * 
   */
  private List<SituationFullRef> situationFullRefs;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TransferLeg( ) {
    situationFullRefs = new ArrayList<SituationFullRef>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TransferLeg( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    continuousMode = pBuilder.continuousMode;
    transferMode = pBuilder.transferMode;
    start = pBuilder.start;
    end = pBuilder.end;
    timeWindowStart = pBuilder.timeWindowStart;
    timeWindowEnd = pBuilder.timeWindowEnd;
    duration = pBuilder.duration;
    if (pBuilder.situationFullRefs != null) {
      situationFullRefs = pBuilder.situationFullRefs;
    }
    else {
      situationFullRefs = new ArrayList<SituationFullRef>();
    }
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new TransferLeg objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TransferLeg objects. The method never returns
   * null.
   */
  public static Builder builder( TransferLeg pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class TransferLeg. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ContinuousMode continuousMode;

    /**
     * 
     */
    private TransferMode transferMode;

    /**
     * Stop/Station to board.
     */
    private PlaceRef start;

    /**
     * Stop/Station to alight
     */
    private PlaceRef end;

    /**
     * Time at which window begins.
     */
    private OffsetDateTime timeWindowStart;

    /**
     * Time at which window ends.
     */
    private OffsetDateTime timeWindowEnd;

    /**
     * Overall duration of this interchange.
     */
    private Duration duration;

    /**
     * 
     */
    private List<SituationFullRef> situationFullRefs;

    /**
     * Use {@link TransferLeg#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TransferLeg#builder(TransferLeg)} instead of private constructor to create new builder.
     */
    protected Builder( TransferLeg pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        continuousMode = pObject.continuousMode;
        transferMode = pObject.transferMode;
        start = pObject.start;
        end = pObject.end;
        timeWindowStart = pObject.timeWindowStart;
        timeWindowEnd = pObject.timeWindowEnd;
        duration = pObject.duration;
        situationFullRefs = pObject.situationFullRefs;
      }
    }

    /**
     * Method sets the attribute "continuousMode".
     * 
     * @param pContinuousMode Value to which the attribute "continuousMode" should be set.
     */
    public Builder setContinuousMode( ContinuousMode pContinuousMode ) {
      // Assign value to attribute
      continuousMode = pContinuousMode;
      return this;
    }

    /**
     * Method sets the attribute "transferMode".
     * 
     * @param pTransferMode Value to which the attribute "transferMode" should be set.
     */
    public Builder setTransferMode( TransferMode pTransferMode ) {
      // Assign value to attribute
      transferMode = pTransferMode;
      return this;
    }

    /**
     * Method sets the association "start". Stop/Station to board.
     * 
     * @param pStart PlaceRef to which the association "start" should be set.
     */
    public Builder setStart( PlaceRef pStart ) {
      start = pStart;
      return this;
    }

    /**
     * Method sets the association "end". Stop/Station to alight
     * 
     * @param pEnd PlaceRef to which the association "end" should be set.
     */
    public Builder setEnd( PlaceRef pEnd ) {
      end = pEnd;
      return this;
    }

    /**
     * Method sets the attribute "timeWindowStart". Time at which window begins.
     * 
     * @param pTimeWindowStart Value to which the attribute "timeWindowStart" should be set.
     */
    public Builder setTimeWindowStart( OffsetDateTime pTimeWindowStart ) {
      // Assign value to attribute
      timeWindowStart = pTimeWindowStart;
      return this;
    }

    /**
     * Method sets the attribute "timeWindowEnd". Time at which window ends.
     * 
     * @param pTimeWindowEnd Value to which the attribute "timeWindowEnd" should be set.
     */
    public Builder setTimeWindowEnd( OffsetDateTime pTimeWindowEnd ) {
      // Assign value to attribute
      timeWindowEnd = pTimeWindowEnd;
      return this;
    }

    /**
     * Method sets the attribute "duration". Overall duration of this interchange.
     * 
     * @param pDuration Value to which the attribute "duration" should be set.
     */
    public Builder setDuration( Duration pDuration ) {
      // Assign value to attribute
      duration = pDuration;
      return this;
    }

    /**
     * Method sets the association "situationFullRefs".
     * 
     * @param pSituationFullRefs Collection with objects to which the association should be set.
     */
    public Builder setSituationFullRefs( List<SituationFullRef> pSituationFullRefs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pSituationFullRefs != null) {
        situationFullRefs = new ArrayList<SituationFullRef>(pSituationFullRefs);
      }
      else {
        situationFullRefs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class TransferLeg. The object will be initialized with the values of the
     * builder.
     * 
     * @return TransferLeg Created object. The method never returns null.
     */
    public TransferLeg build( ) {
      return new TransferLeg(this);
    }

    /**
     * Method creates a new validated instance of class TransferLeg. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return TransferLeg Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TransferLeg buildValidated( ) throws ConstraintViolationException {
      TransferLeg lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "continuousMode".
   * 
   * 
   * @return ContinuousMode Value to which the attribute "continuousMode" is set.
   */
  public ContinuousMode getContinuousMode( ) {
    return continuousMode;
  }

  /**
   * Method sets the attribute "continuousMode".
   * 
   * 
   * @param pContinuousMode Value to which the attribute "continuousMode" should be set.
   */
  public void setContinuousMode( ContinuousMode pContinuousMode ) {
    // Assign value to attribute
    continuousMode = pContinuousMode;
  }

  /**
   * Method returns the attribute "transferMode".
   * 
   * 
   * @return TransferMode Value to which the attribute "transferMode" is set.
   */
  public TransferMode getTransferMode( ) {
    return transferMode;
  }

  /**
   * Method sets the attribute "transferMode".
   * 
   * 
   * @param pTransferMode Value to which the attribute "transferMode" should be set.
   */
  public void setTransferMode( TransferMode pTransferMode ) {
    // Assign value to attribute
    transferMode = pTransferMode;
  }

  /**
   * Method returns the association "start". Stop/Station to board.
   *
   * @return PlaceRef PlaceRef to which the association "start" is set.
   */
  public PlaceRef getStart( ) {
    return start;
  }

  /**
   * Method sets the association "start". Stop/Station to board.
   * 
   * @param pStart PlaceRef to which the association "start" should be set.
   */
  public void setStart( PlaceRef pStart ) {
    start = pStart;
  }

  /**
   * Method unsets the association "start". Stop/Station to board.
   */
  public final void unsetStart( ) {
    start = null;
  }

  /**
   * Method returns the association "end". Stop/Station to alight
   *
   * @return PlaceRef PlaceRef to which the association "end" is set.
   */
  public PlaceRef getEnd( ) {
    return end;
  }

  /**
   * Method sets the association "end". Stop/Station to alight
   * 
   * @param pEnd PlaceRef to which the association "end" should be set.
   */
  public void setEnd( PlaceRef pEnd ) {
    end = pEnd;
  }

  /**
   * Method unsets the association "end". Stop/Station to alight
   */
  public final void unsetEnd( ) {
    end = null;
  }

  /**
   * Method returns the attribute "timeWindowStart". Time at which window begins.
   * 
   * @return OffsetDateTime Value to which the attribute "timeWindowStart" is set.
   */
  public OffsetDateTime getTimeWindowStart( ) {
    return timeWindowStart;
  }

  /**
   * Method sets the attribute "timeWindowStart". Time at which window begins.
   * 
   * @param pTimeWindowStart Value to which the attribute "timeWindowStart" should be set.
   */
  public void setTimeWindowStart( OffsetDateTime pTimeWindowStart ) {
    // Assign value to attribute
    timeWindowStart = pTimeWindowStart;
  }

  /**
   * Method returns the attribute "timeWindowEnd". Time at which window ends.
   * 
   * @return OffsetDateTime Value to which the attribute "timeWindowEnd" is set.
   */
  public OffsetDateTime getTimeWindowEnd( ) {
    return timeWindowEnd;
  }

  /**
   * Method sets the attribute "timeWindowEnd". Time at which window ends.
   * 
   * @param pTimeWindowEnd Value to which the attribute "timeWindowEnd" should be set.
   */
  public void setTimeWindowEnd( OffsetDateTime pTimeWindowEnd ) {
    // Assign value to attribute
    timeWindowEnd = pTimeWindowEnd;
  }

  /**
   * Method returns the attribute "duration". Overall duration of this interchange.
   * 
   * @return Duration Value to which the attribute "duration" is set.
   */
  public Duration getDuration( ) {
    return duration;
  }

  /**
   * Method sets the attribute "duration". Overall duration of this interchange.
   * 
   * @param pDuration Value to which the attribute "duration" should be set.
   */
  public void setDuration( Duration pDuration ) {
    // Assign value to attribute
    duration = pDuration;
  }

  /**
   * Method returns the association "situationFullRefs".
   * 
   *
   * @return Collection All SituationFullRef objects that belong to the association "situationFullRefs". The method
   * never returns null and the returned collection is unmodifiable.
   */
  public List<SituationFullRef> getSituationFullRefs( ) {
    // Return all SituationFullRef objects as unmodifiable collection.
    return Collections.unmodifiableList(situationFullRefs);
  }

  /**
   * Method adds the passed SituationFullRef object to the association "situationFullRefs".
   * 
   * 
   * @param pSituationFullRefs Object that should be added to the association "situationFullRefs". The parameter must
   * not be null.
   */
  public void addToSituationFullRefs( SituationFullRef pSituationFullRefs ) {
    // Check parameter "pSituationFullRefs" for invalid value null.
    Check.checkInvalidParameterNull(pSituationFullRefs, "pSituationFullRefs");
    // Add passed object to collection of associated SituationFullRef objects.
    situationFullRefs.add(pSituationFullRefs);
  }

  /**
   * Method adds all passed objects to the association "situationFullRefs".
   * 
   * 
   * @param pSituationFullRefs Collection with all objects that should be added to the association "situationFullRefs".
   * The parameter must not be null.
   */
  public void addToSituationFullRefs( Collection<SituationFullRef> pSituationFullRefs ) {
    // Check parameter "pSituationFullRefs" for invalid value null.
    Check.checkInvalidParameterNull(pSituationFullRefs, "pSituationFullRefs");
    // Add all passed objects.
    for (SituationFullRef lNextObject : pSituationFullRefs) {
      this.addToSituationFullRefs(lNextObject);
    }
  }

  /**
   * Method removes the passed SituationFullRef object from the association "situationFullRefs".
   * 
   * 
   * @param pSituationFullRefs Object that should be removed from the association "situationFullRefs". The parameter
   * must not be null.
   */
  public void removeFromSituationFullRefs( SituationFullRef pSituationFullRefs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pSituationFullRefs, "pSituationFullRefs");
    // Remove passed object from collection of associated SituationFullRef objects.
    situationFullRefs.remove(pSituationFullRefs);
  }

  /**
   * Method removes all objects from the association "situationFullRefs".
   * 
   */
  public void clearSituationFullRefs( ) {
    // Remove all objects from association "situationFullRefs".
    situationFullRefs.clear();
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
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "continuousMode", "" + continuousMode));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "transferMode", "" + transferMode));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "timeWindowStart", "" + timeWindowStart));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "timeWindowEnd", "" + timeWindowEnd));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "duration", "" + duration));
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
