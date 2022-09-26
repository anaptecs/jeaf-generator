/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * A minimal trip leg specification.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class TripLegSpecification {
  /**
   * Constant for the name of attribute "externalRef".
   */
  public static final String EXTERNALREF = "externalRef";

  /**
   * Constant for the name of attribute "timedLeg".
   */
  public static final String TIMEDLEG = "timedLeg";

  /**
   * Constant for the name of attribute "transferLeg".
   */
  public static final String TRANSFERLEG = "transferLeg";

  /**
   * External reference of this trip leg. Unique within trip result.
   */
  @NotNull
  private String externalRef;

  /**
   * 
   */
  private TimedLegSpecification timedLeg;

  /**
   * 
   */
  private TransferLeg transferLeg;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected TripLegSpecification( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TripLegSpecification( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    externalRef = pBuilder.externalRef;
    timedLeg = pBuilder.timedLeg;
    transferLeg = pBuilder.transferLeg;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new TripLegSpecification objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TripLegSpecification objects. The method never
   * returns null.
   */
  public static Builder builder( TripLegSpecification pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class TripLegSpecification. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * External reference of this trip leg. Unique within trip result.
     */
    @NotNull
    private String externalRef;

    /**
     * 
     */
    private TimedLegSpecification timedLeg;

    /**
     * 
     */
    private TransferLeg transferLeg;

    /**
     * Use {@link TripLegSpecification#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TripLegSpecification#builder(TripLegSpecification)} instead of private constructor to create new
     * builder.
     */
    protected Builder( TripLegSpecification pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        externalRef = pObject.externalRef;
        timedLeg = pObject.timedLeg;
        transferLeg = pObject.transferLeg;
      }
    }

    /**
     * Method sets the attribute "externalRef". External reference of this trip leg. Unique within trip result.
     * 
     * @param pExternalRef Value to which the attribute "externalRef" should be set.
     */
    public Builder setExternalRef( String pExternalRef ) {
      // Assign value to attribute
      externalRef = pExternalRef;
      return this;
    }

    /**
     * Method sets the association "timedLeg".
     * 
     * @param pTimedLeg TimedLegSpecification to which the association "timedLeg" should be set.
     */
    public Builder setTimedLeg( TimedLegSpecification pTimedLeg ) {
      timedLeg = pTimedLeg;
      return this;
    }

    /**
     * Method sets the association "transferLeg".
     * 
     * @param pTransferLeg TransferLeg to which the association "transferLeg" should be set.
     */
    public Builder setTransferLeg( TransferLeg pTransferLeg ) {
      transferLeg = pTransferLeg;
      return this;
    }

    /**
     * Method creates a new instance of class TripLegSpecification. The object will be initialized with the values of
     * the builder.
     * 
     * @return TripLegSpecification Created object. The method never returns null.
     */
    public TripLegSpecification build( ) {
      return new TripLegSpecification(this);
    }

    /**
     * Method creates a new validated instance of class TripLegSpecification. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return TripLegSpecification Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TripLegSpecification buildValidated( ) throws ConstraintViolationException {
      TripLegSpecification lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "externalRef". External reference of this trip leg. Unique within trip result.
   * 
   * @return String Value to which the attribute "externalRef" is set.
   */
  public String getExternalRef( ) {
    return externalRef;
  }

  /**
   * Method sets the attribute "externalRef". External reference of this trip leg. Unique within trip result.
   * 
   * @param pExternalRef Value to which the attribute "externalRef" should be set.
   */
  public void setExternalRef( String pExternalRef ) {
    // Assign value to attribute
    externalRef = pExternalRef;
  }

  /**
   * Method returns the association "timedLeg".
   * 
   *
   * @return TimedLegSpecification TimedLegSpecification to which the association "timedLeg" is set.
   */
  public TimedLegSpecification getTimedLeg( ) {
    return timedLeg;
  }

  /**
   * Method sets the association "timedLeg".
   * 
   * 
   * @param pTimedLeg TimedLegSpecification to which the association "timedLeg" should be set.
   */
  public void setTimedLeg( TimedLegSpecification pTimedLeg ) {
    timedLeg = pTimedLeg;
  }

  /**
   * Method unsets the association "timedLeg".
   * 
   */
  public final void unsetTimedLeg( ) {
    timedLeg = null;
  }

  /**
   * Method returns the association "transferLeg".
   * 
   *
   * @return TransferLeg TransferLeg to which the association "transferLeg" is set.
   */
  public TransferLeg getTransferLeg( ) {
    return transferLeg;
  }

  /**
   * Method sets the association "transferLeg".
   * 
   * 
   * @param pTransferLeg TransferLeg to which the association "transferLeg" should be set.
   */
  public void setTransferLeg( TransferLeg pTransferLeg ) {
    transferLeg = pTransferLeg;
  }

  /**
   * Method unsets the association "transferLeg".
   * 
   */
  public final void unsetTransferLeg( ) {
    transferLeg = null;
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
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "externalRef", "" + externalRef));
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
