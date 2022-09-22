/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Vehicle journey that runs at a specific date. Provided by OJP.
 * 
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class DatedJourney {
  /**
   * Constant for the name of attribute "mode".
   */
  public static final String MODE = "mode";

  /**
   * Constant for the name of attribute "productCategory".
   */
  public static final String PRODUCTCATEGORY = "productCategory";

  /**
   * Constant for the name of attribute "publishedServiceName".
   */
  public static final String PUBLISHEDSERVICENAME = "publishedServiceName";

  /**
   * Constant for the name of attribute "vehicleNumbers".
   */
  public static final String VEHICLENUMBERS = "vehicleNumbers";

  /**
   * Constant for the name of attribute "lineNumbers".
   */
  public static final String LINENUMBERS = "lineNumbers";

  /**
   * Constant for the name of attribute "operatorRefs".
   */
  public static final String OPERATORREFS = "operatorRefs";

  /**
   * Constant for the name of attribute "serviceStatus".
   */
  public static final String SERVICESTATUS = "serviceStatus";

  /**
   * Constant for the name of attribute "situationFullRefs".
   */
  public static final String SITUATIONFULLREFS = "situationFullRefs";

  /**
   * Constant for the name of attribute "operatingDayRef".
   */
  public static final String OPERATINGDAYREF = "operatingDayRef";

  /**
   * 
   */
  private Mode mode;

  /**
   * 
   */
  private ProductCategory productCategory;

  /**
   * Line name or service description as known to the public, f.e. "512", "S8" or "Circle Line" or "ICE 488". <br/>
   * <b>Example:</b> <code>S1</code>
   */
  private String publishedServiceName;

  /**
   * The vehicle number(s) of the vehicle(s) that runs this timed leg. On some legs a vehicle has multiple vehicles,
   * e.g. if it is split into two trains at a intermediate stop.
   * 
   * For backwards compatibility with Hermes/Hosa the length of the string must be restricted to 5 characters. If's
   * longer, it is not possible to use the H2O converter. <br/>
   * <b>Example:</b> <code>9218, 9340, 15</code>
   */
  private String[] vehicleNumbers;

  /**
   * List of line numbers that are part of this journey. Especially on regional traffic, a vehicle is defined by a line
   * number only. <br/>
   * <b>Example:</b> <code>52, 19</code>
   */
  private String[] lineNumbers;

  /**
   * Reference to transport operators. For UIC see:
   * https://unioninternationalcheminsdefer.github.io/OSDM/spec/catalog-of-code-lists/
   * 
   * As a leg can be operated by more than operator we model it as an array here. <br/>
   * <b>Example:</b> <code>urn:uic:rics:1185:000011</code>
   */
  private String[] operatorRefs;

  /**
   * 
   */
  private ServiceStatus serviceStatus;

  /**
   * 
   */
  private List<SituationFullRef> situationFullRefs;

  /**
   * 
   */
  private OperationDayRef operatingDayRef;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected DatedJourney( ) {
    situationFullRefs = new ArrayList<SituationFullRef>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DatedJourney( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    mode = pBuilder.mode;
    productCategory = pBuilder.productCategory;
    publishedServiceName = pBuilder.publishedServiceName;
    vehicleNumbers = pBuilder.vehicleNumbers;
    lineNumbers = pBuilder.lineNumbers;
    operatorRefs = pBuilder.operatorRefs;
    serviceStatus = pBuilder.serviceStatus;
    if (pBuilder.situationFullRefs != null) {
      situationFullRefs = pBuilder.situationFullRefs;
    }
    else {
      situationFullRefs = new ArrayList<SituationFullRef>();
    }
    operatingDayRef = pBuilder.operatingDayRef;
  }

  /**
   * Class implements builder to create a new instance of class DatedJourney. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Mode mode;

    /**
     * 
     */
    private ProductCategory productCategory;

    /**
     * Line name or service description as known to the public, f.e. "512", "S8" or "Circle Line" or "ICE 488".
     */
    private String publishedServiceName;

    /**
     * The vehicle number(s) of the vehicle(s) that runs this timed leg. On some legs a vehicle has multiple vehicles,
     * e.g. if it is split into two trains at a intermediate stop.
     * 
     * For backwards compatibility with Hermes/Hosa the length of the string must be restricted to 5 characters. If's
     * longer, it is not possible to use the H2O converter.
     */
    private String[] vehicleNumbers;

    /**
     * List of line numbers that are part of this journey. Especially on regional traffic, a vehicle is defined by a
     * line number only.
     */
    private String[] lineNumbers;

    /**
     * Reference to transport operators. For UIC see:
     * https://unioninternationalcheminsdefer.github.io/OSDM/spec/catalog-of-code-lists/
     * 
     * As a leg can be operated by more than operator we model it as an array here.
     */
    private String[] operatorRefs;

    /**
     * 
     */
    private ServiceStatus serviceStatus;

    /**
     * 
     */
    private List<SituationFullRef> situationFullRefs;

    /**
     * 
     */
    private OperationDayRef operatingDayRef;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(DatedJourney)} instead of private constructor to create new builder.
     */
    protected Builder( DatedJourney pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        mode = pObject.mode;
        productCategory = pObject.productCategory;
        publishedServiceName = pObject.publishedServiceName;
        vehicleNumbers = pObject.vehicleNumbers;
        lineNumbers = pObject.lineNumbers;
        operatorRefs = pObject.operatorRefs;
        serviceStatus = pObject.serviceStatus;
        situationFullRefs = pObject.situationFullRefs;
        operatingDayRef = pObject.operatingDayRef;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new DatedJourney objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new DatedJourney objects. The method never returns
     * null.
     */
    public static Builder newBuilder( DatedJourney pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "mode".
     * 
     * @param pMode Mode to which the association "mode" should be set.
     */
    public Builder setMode( Mode pMode ) {
      mode = pMode;
      return this;
    }

    /**
     * Method sets the association "productCategory".
     * 
     * @param pProductCategory ProductCategory to which the association "productCategory" should be set.
     */
    public Builder setProductCategory( ProductCategory pProductCategory ) {
      productCategory = pProductCategory;
      return this;
    }

    /**
     * Method sets the attribute "publishedServiceName". Line name or service description as known to the public, f.e.
     * "512", "S8" or "Circle Line" or "ICE 488".
     * 
     * @param pPublishedServiceName Value to which the attribute "publishedServiceName" should be set.
     */
    public Builder setPublishedServiceName( String pPublishedServiceName ) {
      // Assign value to attribute
      publishedServiceName = pPublishedServiceName;
      return this;
    }

    /**
     * Method sets the attribute "vehicleNumbers". The vehicle number(s) of the vehicle(s) that runs this timed leg. On
     * some legs a vehicle has multiple vehicles, e.g. if it is split into two trains at a intermediate stop.
     * 
     * For backwards compatibility with Hermes/Hosa the length of the string must be restricted to 5 characters. If's
     * longer, it is not possible to use the H2O converter.
     * 
     * @param pVehicleNumbers Value to which the attribute "vehicleNumbers" should be set.
     */
    public Builder setVehicleNumbers( String[] pVehicleNumbers ) {
      // Assign value to attribute
      if (pVehicleNumbers != null) {
        vehicleNumbers = new String[pVehicleNumbers.length];
        System.arraycopy(pVehicleNumbers, 0, vehicleNumbers, 0, pVehicleNumbers.length);
      }
      else {
        vehicleNumbers = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "lineNumbers". List of line numbers that are part of this journey. Especially on
     * regional traffic, a vehicle is defined by a line number only.
     * 
     * @param pLineNumbers Value to which the attribute "lineNumbers" should be set.
     */
    public Builder setLineNumbers( String[] pLineNumbers ) {
      // Assign value to attribute
      if (pLineNumbers != null) {
        lineNumbers = new String[pLineNumbers.length];
        System.arraycopy(pLineNumbers, 0, lineNumbers, 0, pLineNumbers.length);
      }
      else {
        lineNumbers = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "operatorRefs". Reference to transport operators. For UIC see:
     * https://unioninternationalcheminsdefer.github.io/OSDM/spec/catalog-of-code-lists/
     * 
     * As a leg can be operated by more than operator we model it as an array here.
     * 
     * @param pOperatorRefs Value to which the attribute "operatorRefs" should be set.
     */
    public Builder setOperatorRefs( String[] pOperatorRefs ) {
      // Assign value to attribute
      if (pOperatorRefs != null) {
        operatorRefs = new String[pOperatorRefs.length];
        System.arraycopy(pOperatorRefs, 0, operatorRefs, 0, pOperatorRefs.length);
      }
      else {
        operatorRefs = null;
      }
      return this;
    }

    /**
     * Method sets the association "serviceStatus".
     * 
     * @param pServiceStatus ServiceStatus to which the association "serviceStatus" should be set.
     */
    public Builder setServiceStatus( ServiceStatus pServiceStatus ) {
      serviceStatus = pServiceStatus;
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
     * Method sets the association "operatingDayRef".
     * 
     * @param pOperatingDayRef OperationDayRef to which the association "operatingDayRef" should be set.
     */
    public Builder setOperatingDayRef( OperationDayRef pOperatingDayRef ) {
      operatingDayRef = pOperatingDayRef;
      return this;
    }

    /**
     * Method creates a new instance of class DatedJourney. The object will be initialized with the values of the
     * builder.
     * 
     * @return DatedJourney Created object. The method never returns null.
     */
    public DatedJourney build( ) {
      return new DatedJourney(this);
    }

    /**
     * Method creates a new validated instance of class DatedJourney. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return DatedJourney Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DatedJourney buildValidated( ) throws ConstraintViolationException {
      DatedJourney lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "mode".
   * 
   *
   * @return Mode Mode to which the association "mode" is set.
   */
  public Mode getMode( ) {
    return mode;
  }

  /**
   * Method sets the association "mode".
   * 
   * 
   * @param pMode Mode to which the association "mode" should be set.
   */
  public void setMode( Mode pMode ) {
    mode = pMode;
  }

  /**
   * Method unsets the association "mode".
   * 
   */
  public final void unsetMode( ) {
    mode = null;
  }

  /**
   * Method returns the association "productCategory".
   * 
   *
   * @return ProductCategory ProductCategory to which the association "productCategory" is set.
   */
  public ProductCategory getProductCategory( ) {
    return productCategory;
  }

  /**
   * Method sets the association "productCategory".
   * 
   * 
   * @param pProductCategory ProductCategory to which the association "productCategory" should be set.
   */
  public void setProductCategory( ProductCategory pProductCategory ) {
    productCategory = pProductCategory;
  }

  /**
   * Method unsets the association "productCategory".
   * 
   */
  public final void unsetProductCategory( ) {
    productCategory = null;
  }

  /**
   * Method returns the attribute "publishedServiceName". Line name or service description as known to the public, f.e.
   * "512", "S8" or "Circle Line" or "ICE 488".
   * 
   * @return String Value to which the attribute "publishedServiceName" is set.
   */
  public String getPublishedServiceName( ) {
    return publishedServiceName;
  }

  /**
   * Method sets the attribute "publishedServiceName". Line name or service description as known to the public, f.e.
   * "512", "S8" or "Circle Line" or "ICE 488".
   * 
   * @param pPublishedServiceName Value to which the attribute "publishedServiceName" should be set.
   */
  public void setPublishedServiceName( String pPublishedServiceName ) {
    // Assign value to attribute
    publishedServiceName = pPublishedServiceName;
  }

  /**
   * Method returns the attribute "vehicleNumbers". The vehicle number(s) of the vehicle(s) that runs this timed leg. On
   * some legs a vehicle has multiple vehicles, e.g. if it is split into two trains at a intermediate stop.
   * 
   * For backwards compatibility with Hermes/Hosa the length of the string must be restricted to 5 characters. If's
   * longer, it is not possible to use the H2O converter.
   * 
   * @return String Value to which the attribute "vehicleNumbers" is set.
   */
  public String[] getVehicleNumbers( ) {
    String[] lReturnValue;
    if (vehicleNumbers != null) {
      lReturnValue = new String[vehicleNumbers.length];
      System.arraycopy(vehicleNumbers, 0, lReturnValue, 0, vehicleNumbers.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "vehicleNumbers". The vehicle number(s) of the vehicle(s) that runs this timed leg. On
   * some legs a vehicle has multiple vehicles, e.g. if it is split into two trains at a intermediate stop.
   * 
   * For backwards compatibility with Hermes/Hosa the length of the string must be restricted to 5 characters. If's
   * longer, it is not possible to use the H2O converter.
   * 
   * @param pVehicleNumbers Value to which the attribute "vehicleNumbers" should be set.
   */
  public void setVehicleNumbers( String[] pVehicleNumbers ) {
    // Assign value to attribute
    if (pVehicleNumbers != null) {
      vehicleNumbers = new String[pVehicleNumbers.length];
      System.arraycopy(pVehicleNumbers, 0, vehicleNumbers, 0, pVehicleNumbers.length);
    }
    else {
      vehicleNumbers = null;
    }
  }

  /**
   * Method returns the attribute "lineNumbers". List of line numbers that are part of this journey. Especially on
   * regional traffic, a vehicle is defined by a line number only.
   * 
   * @return String Value to which the attribute "lineNumbers" is set.
   */
  public String[] getLineNumbers( ) {
    String[] lReturnValue;
    if (lineNumbers != null) {
      lReturnValue = new String[lineNumbers.length];
      System.arraycopy(lineNumbers, 0, lReturnValue, 0, lineNumbers.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "lineNumbers". List of line numbers that are part of this journey. Especially on regional
   * traffic, a vehicle is defined by a line number only.
   * 
   * @param pLineNumbers Value to which the attribute "lineNumbers" should be set.
   */
  public void setLineNumbers( String[] pLineNumbers ) {
    // Assign value to attribute
    if (pLineNumbers != null) {
      lineNumbers = new String[pLineNumbers.length];
      System.arraycopy(pLineNumbers, 0, lineNumbers, 0, pLineNumbers.length);
    }
    else {
      lineNumbers = null;
    }
  }

  /**
   * Method returns the attribute "operatorRefs". Reference to transport operators. For UIC see:
   * https://unioninternationalcheminsdefer.github.io/OSDM/spec/catalog-of-code-lists/
   * 
   * As a leg can be operated by more than operator we model it as an array here.
   * 
   * @return String Value to which the attribute "operatorRefs" is set.
   */
  public String[] getOperatorRefs( ) {
    String[] lReturnValue;
    if (operatorRefs != null) {
      lReturnValue = new String[operatorRefs.length];
      System.arraycopy(operatorRefs, 0, lReturnValue, 0, operatorRefs.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "operatorRefs". Reference to transport operators. For UIC see:
   * https://unioninternationalcheminsdefer.github.io/OSDM/spec/catalog-of-code-lists/
   * 
   * As a leg can be operated by more than operator we model it as an array here.
   * 
   * @param pOperatorRefs Value to which the attribute "operatorRefs" should be set.
   */
  public void setOperatorRefs( String[] pOperatorRefs ) {
    // Assign value to attribute
    if (pOperatorRefs != null) {
      operatorRefs = new String[pOperatorRefs.length];
      System.arraycopy(pOperatorRefs, 0, operatorRefs, 0, pOperatorRefs.length);
    }
    else {
      operatorRefs = null;
    }
  }

  /**
   * Method returns the association "serviceStatus".
   * 
   *
   * @return ServiceStatus ServiceStatus to which the association "serviceStatus" is set.
   */
  public ServiceStatus getServiceStatus( ) {
    return serviceStatus;
  }

  /**
   * Method sets the association "serviceStatus".
   * 
   * 
   * @param pServiceStatus ServiceStatus to which the association "serviceStatus" should be set.
   */
  public void setServiceStatus( ServiceStatus pServiceStatus ) {
    serviceStatus = pServiceStatus;
  }

  /**
   * Method unsets the association "serviceStatus".
   * 
   */
  public final void unsetServiceStatus( ) {
    serviceStatus = null;
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
    Collection<SituationFullRef> lSituationFullRefs = new HashSet<SituationFullRef>(situationFullRefs);
    Iterator<SituationFullRef> lIterator = lSituationFullRefs.iterator();
    while (lIterator.hasNext()) {
      this.removeFromSituationFullRefs(lIterator.next());
    }
  }

  /**
   * Method returns the association "operatingDayRef".
   * 
   *
   * @return OperationDayRef OperationDayRef to which the association "operatingDayRef" is set.
   */
  public OperationDayRef getOperatingDayRef( ) {
    return operatingDayRef;
  }

  /**
   * Method sets the association "operatingDayRef".
   * 
   * 
   * @param pOperatingDayRef OperationDayRef to which the association "operatingDayRef" should be set.
   */
  public void setOperatingDayRef( OperationDayRef pOperatingDayRef ) {
    operatingDayRef = pOperatingDayRef;
  }

  /**
   * Method unsets the association "operatingDayRef".
   * 
   */
  public final void unsetOperatingDayRef( ) {
    operatingDayRef = null;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "publishedServiceName",
        "" + publishedServiceName));
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
