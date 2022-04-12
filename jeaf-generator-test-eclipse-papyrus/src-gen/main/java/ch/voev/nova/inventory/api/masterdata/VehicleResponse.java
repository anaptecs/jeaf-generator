/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

import ch.voev.nova.inventory.api.booking.Warning;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class VehicleResponse {
  /**
   * Constant for the name of attribute "warnings".
   */
  public static final String WARNINGS = "warnings";

  /**
   * Constant for the name of attribute "vehicles".
   */
  public static final String VEHICLES = "vehicles";

  /**
   * 
   */
  private List<Warning> warnings = new ArrayList<Warning>();

  /**
   * 
   */
  private List<Vehicle> vehicles = new ArrayList<Vehicle>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected VehicleResponse( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected VehicleResponse( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.warnings != null) {
      warnings.addAll(pBuilder.warnings);
    }
    if (pBuilder.vehicles != null) {
      vehicles.addAll(pBuilder.vehicles);
    }
  }

  /**
   * Class implements builder to create a new instance of class VehicleResponse. As the class has read only attributes
   * or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<Warning> warnings;

    /**
     * 
     */
    private List<Vehicle> vehicles;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(VehicleResponse)} instead of private constructor to create new builder.
     */
    protected Builder( VehicleResponse pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        warnings = pObject.warnings;
        vehicles = pObject.vehicles;
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
     * @return {@link Builder} New builder that can be used to create new VehicleResponse objects. The method never
     * returns null.
     */
    public static Builder newBuilder( VehicleResponse pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "warnings".
     * 
     * @param pWarnings Collection with objects to which the association should be set.
     */
    public Builder setWarnings( List<Warning> pWarnings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pWarnings != null) {
        warnings = new ArrayList<Warning>(pWarnings);
      }
      else {
        warnings = null;
      }
      return this;
    }

    /**
     * Method sets the association "vehicles".
     * 
     * @param pVehicles Collection with objects to which the association should be set.
     */
    public Builder setVehicles( List<Vehicle> pVehicles ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pVehicles != null) {
        vehicles = new ArrayList<Vehicle>(pVehicles);
      }
      else {
        vehicles = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class VehicleResponse. The object will be initialized with the values of the
     * builder.
     * 
     * @return VehicleResponse Created object. The method never returns null.
     */
    public VehicleResponse build( ) {
      return new VehicleResponse(this);
    }

    /**
     * Method creates a new validated instance of class VehicleResponse. The object will be initialized with the values
     * of the builder and validated afterwards.
     * 
     * @return VehicleResponse Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public VehicleResponse buildValidated( ) throws ConstraintViolationException {
      VehicleResponse lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "warnings".
   * 
   *
   * @return Collection All Warning objects that belong to the association "warnings". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<Warning> getWarnings( ) {
    // Return all Warning objects as unmodifiable collection.
    return Collections.unmodifiableList(warnings);
  }

  /**
   * Method sets the association "warnings" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pWarnings Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setWarnings( List<Warning> pWarnings ) {
    // Check of parameter is not required.
    // Remove all objects from association "warnings".
    this.clearWarnings();
    // If the association is null, removing all entries is sufficient.
    if (pWarnings != null) {
      warnings = new ArrayList<Warning>(pWarnings);
    }
  }

  /**
   * Method adds the passed Warning object to the association "warnings".
   * 
   * 
   * @param pWarnings Object that should be added to the association "warnings". The parameter must not be null.
   */
  public void addToWarnings( Warning pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add passed object to collection of associated Warning objects.
    warnings.add(pWarnings);
  }

  /**
   * Method adds all passed objects to the association "warnings".
   * 
   * 
   * @param pWarnings Collection with all objects that should be added to the association "warnings". The parameter must
   * not be null.
   */
  public void addToWarnings( Collection<Warning> pWarnings ) {
    // Check parameter "pWarnings" for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Add all passed objects.
    for (Warning lNextObject : pWarnings) {
      this.addToWarnings(lNextObject);
    }
  }

  /**
   * Method removes the passed Warning object from the association "warnings".
   * 
   * 
   * @param pWarnings Object that should be removed from the association "warnings". The parameter must not be null.
   */
  public void removeFromWarnings( Warning pWarnings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pWarnings, "pWarnings");
    // Remove passed object from collection of associated Warning objects.
    warnings.remove(pWarnings);
  }

  /**
   * Method removes all objects from the association "warnings".
   * 
   */
  public void clearWarnings( ) {
    // Remove all objects from association "warnings".
    Collection<Warning> lWarnings = new HashSet<Warning>(warnings);
    Iterator<Warning> lIterator = lWarnings.iterator();
    while (lIterator.hasNext()) {
      this.removeFromWarnings(lIterator.next());
    }
  }

  /**
   * Method returns the association "vehicles".
   * 
   *
   * @return Collection All Vehicle objects that belong to the association "vehicles". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<Vehicle> getVehicles( ) {
    // Return all Vehicle objects as unmodifiable collection.
    return Collections.unmodifiableList(vehicles);
  }

  /**
   * Method sets the association "vehicles" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pVehicles Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setVehicles( List<Vehicle> pVehicles ) {
    // Check of parameter is not required.
    // Remove all objects from association "vehicles".
    this.clearVehicles();
    // If the association is null, removing all entries is sufficient.
    if (pVehicles != null) {
      vehicles = new ArrayList<Vehicle>(pVehicles);
    }
  }

  /**
   * Method adds the passed Vehicle object to the association "vehicles".
   * 
   * 
   * @param pVehicles Object that should be added to the association "vehicles". The parameter must not be null.
   */
  public void addToVehicles( Vehicle pVehicles ) {
    // Check parameter "pVehicles" for invalid value null.
    Check.checkInvalidParameterNull(pVehicles, "pVehicles");
    // Add passed object to collection of associated Vehicle objects.
    vehicles.add(pVehicles);
  }

  /**
   * Method adds all passed objects to the association "vehicles".
   * 
   * 
   * @param pVehicles Collection with all objects that should be added to the association "vehicles". The parameter must
   * not be null.
   */
  public void addToVehicles( Collection<Vehicle> pVehicles ) {
    // Check parameter "pVehicles" for invalid value null.
    Check.checkInvalidParameterNull(pVehicles, "pVehicles");
    // Add all passed objects.
    for (Vehicle lNextObject : pVehicles) {
      this.addToVehicles(lNextObject);
    }
  }

  /**
   * Method removes the passed Vehicle object from the association "vehicles".
   * 
   * 
   * @param pVehicles Object that should be removed from the association "vehicles". The parameter must not be null.
   */
  public void removeFromVehicles( Vehicle pVehicles ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pVehicles, "pVehicles");
    // Remove passed object from collection of associated Vehicle objects.
    vehicles.remove(pVehicles);
  }

  /**
   * Method removes all objects from the association "vehicles".
   * 
   */
  public void clearVehicles( ) {
    // Remove all objects from association "vehicles".
    Collection<Vehicle> lVehicles = new HashSet<Vehicle>(vehicles);
    Iterator<Vehicle> lIterator = lVehicles.iterator();
    while (lIterator.hasNext()) {
      this.removeFromVehicles(lIterator.next());
    }
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
