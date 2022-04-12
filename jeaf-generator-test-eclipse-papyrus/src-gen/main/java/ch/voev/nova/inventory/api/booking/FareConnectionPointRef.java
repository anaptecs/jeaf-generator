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

/**
 * Reference to a Fare Connection Point.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class FareConnectionPointRef extends PlaceRef {
  /**
   * Constant for the name of attribute "fareConnectionPoint".
   */
  public static final String FARECONNECTIONPOINT = "fareConnectionPoint";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * 
   */
  private FareConnectionPoint fareConnectionPoint;

  /**
   * 
   */
  private String name;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected FareConnectionPointRef( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected FareConnectionPointRef( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    fareConnectionPoint = pBuilder.fareConnectionPoint;
    name = pBuilder.name;
  }

  /**
   * Class implements builder to create a new instance of class FareConnectionPointRef. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends PlaceRef.Builder {
    /**
     * 
     */
    private FareConnectionPoint fareConnectionPoint;

    /**
     * 
     */
    private String name;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link #newBuilder(FareConnectionPointRef)} instead of private constructor to create new builder.
     */
    protected Builder( FareConnectionPointRef pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        fareConnectionPoint = pObject.fareConnectionPoint;
        name = pObject.name;
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
     * @return {@link Builder} New builder that can be used to create new FareConnectionPointRef objects. The method
     * never returns null.
     */
    public static Builder newBuilder( FareConnectionPointRef pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "fareConnectionPoint".
     * 
     * @param pFareConnectionPoint FareConnectionPoint to which the association "fareConnectionPoint" should be set.
     */
    public Builder setFareConnectionPoint( FareConnectionPoint pFareConnectionPoint ) {
      fareConnectionPoint = pFareConnectionPoint;
      return this;
    }

    /**
     * Method sets the attribute "name".
     * 
     * @param pName Value to which the attribute "name" should be set.
     */
    public Builder setName( String pName ) {
      // Assign value to attribute
      name = pName;
      return this;
    }

    /**
     * Method creates a new instance of class FareConnectionPointRef. The object will be initialized with the values of
     * the builder.
     * 
     * @return FareConnectionPointRef Created object. The method never returns null.
     */
    public FareConnectionPointRef build( ) {
      return new FareConnectionPointRef(this);
    }

    /**
     * Method creates a new validated instance of class FareConnectionPointRef. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return FareConnectionPointRef Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public FareConnectionPointRef buildValidated( ) throws ConstraintViolationException {
      FareConnectionPointRef lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "fareConnectionPoint".
   * 
   *
   * @return FareConnectionPoint FareConnectionPoint to which the association "fareConnectionPoint" is set.
   */
  public FareConnectionPoint getFareConnectionPoint( ) {
    return fareConnectionPoint;
  }

  /**
   * Method sets the association "fareConnectionPoint".
   * 
   * 
   * @param pFareConnectionPoint FareConnectionPoint to which the association "fareConnectionPoint" should be set.
   */
  public void setFareConnectionPoint( FareConnectionPoint pFareConnectionPoint ) {
    fareConnectionPoint = pFareConnectionPoint;
  }

  /**
   * Method unsets the association "fareConnectionPoint".
   * 
   */
  public final void unsetFareConnectionPoint( ) {
    fareConnectionPoint = null;
  }

  /**
   * Method returns the attribute "name".
   * 
   * 
   * @return String Value to which the attribute "name" is set.
   */
  public String getName( ) {
    return name;
  }

  /**
   * Method sets the attribute "name".
   * 
   * 
   * @param pName Value to which the attribute "name" should be set.
   */
  public void setName( String pName ) {
    // Assign value to attribute
    name = pName;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = super.toStringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "name", "" + name));
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
