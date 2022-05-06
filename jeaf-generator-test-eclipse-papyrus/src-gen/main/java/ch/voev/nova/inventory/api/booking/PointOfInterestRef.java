/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;

/**
 * Reference to a Point of Interest. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class PointOfInterestRef extends PlaceRef {
  /**
   * Constant for the name of attribute "pointOfInterestRef".
   */
  public static final String POINTOFINTERESTREF = "pointOfInterestRef";

  /**
   * Constant for the name of attribute "name".
   */
  public static final String NAME = "name";

  /**
   * 
   */
  @NotNull
  private String pointOfInterestRef;

  /**
   * 
   */
  private String name;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PointOfInterestRef( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PointOfInterestRef( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    pointOfInterestRef = pBuilder.pointOfInterestRef;
    name = pBuilder.name;
  }

  /**
   * Class implements builder to create a new instance of class PointOfInterestRef. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder extends PlaceRef.Builder {
    /**
     * 
     */
    @NotNull
    private String pointOfInterestRef;

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
     * Use {@link #newBuilder(PointOfInterestRef)} instead of private constructor to create new builder.
     */
    protected Builder( PointOfInterestRef pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        pointOfInterestRef = pObject.pointOfInterestRef;
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
     * @return {@link Builder} New builder that can be used to create new PointOfInterestRef objects. The method never
     * returns null.
     */
    public static Builder newBuilder( PointOfInterestRef pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "pointOfInterestRef".
     * 
     * @param pPointOfInterestRef Value to which the attribute "pointOfInterestRef" should be set.
     */
    public Builder setPointOfInterestRef( String pPointOfInterestRef ) {
      // Assign value to attribute
      pointOfInterestRef = pPointOfInterestRef;
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
     * Method creates a new instance of class PointOfInterestRef. The object will be initialized with the values of the
     * builder.
     * 
     * @return PointOfInterestRef Created object. The method never returns null.
     */
    public PointOfInterestRef build( ) {
      return new PointOfInterestRef(this);
    }

    /**
     * Method creates a new validated instance of class PointOfInterestRef. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return PointOfInterestRef Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PointOfInterestRef buildValidated( ) throws ConstraintViolationException {
      PointOfInterestRef lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "pointOfInterestRef".
   * 
   * 
   * @return String Value to which the attribute "pointOfInterestRef" is set.
   */
  public String getPointOfInterestRef( ) {
    return pointOfInterestRef;
  }

  /**
   * Method sets the attribute "pointOfInterestRef".
   * 
   * 
   * @param pPointOfInterestRef Value to which the attribute "pointOfInterestRef" should be set.
   */
  public void setPointOfInterestRef( String pPointOfInterestRef ) {
    // Assign value to attribute
    pointOfInterestRef = pPointOfInterestRef;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "pointOfInterestRef",
        "" + pointOfInterestRef));
    lBuilder.append('\n');
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
