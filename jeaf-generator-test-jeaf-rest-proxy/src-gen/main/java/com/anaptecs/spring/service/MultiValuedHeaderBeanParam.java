/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.spring.base.StringCode;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class MultiValuedHeaderBeanParam implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "names".
   */
  public static final String NAMES = "names";

  /**
   * Constant for the name of attribute "ints".
   */
  public static final String INTS = "ints";

  /**
   * Constant for the name of attribute "doubles".
   */
  public static final String DOUBLES = "doubles";

  /**
   * Constant for the name of attribute "codes".
   */
  public static final String CODES = "codes";

  /**
   * Constant for the name of attribute "stringCodeList".
   */
  public static final String STRINGCODELIST = "stringCodeList";

  /**
   * Constant for the name of attribute "startDate".
   */
  public static final String STARTDATE = "startDate";

  /**
   * Constant for the name of attribute "dates".
   */
  public static final String DATES = "dates";

  /**
   * Constant for the name of attribute "timestamps".
   */
  public static final String TIMESTAMPS = "timestamps";

  /**
   * Constant for the name of attribute "calendars".
   */
  public static final String CALENDARS = "calendars";

  /**
   * Constant for the name of attribute "utilDates".
   */
  public static final String UTILDATES = "utilDates";

  /**
   * Constant for the name of attribute "sqlTimestamps".
   */
  public static final String SQLTIMESTAMPS = "sqlTimestamps";

  /**
   * 
   */
  @HeaderParam("names")
  private String[] names;

  /**
   * 
   */
  @HeaderParam("ints")
  private int[] ints;

  /**
   * 
   */
  @HeaderParam("doubles")
  private Double[] doubles;

  /**
   * 
   */
  @HeaderParam("codes")
  private StringCode[] codes;

  /**
   * 
   */
  @HeaderParam("stringCodeList")
  private Set<StringCode> stringCodeList;

  /**
   * 
   */
  @HeaderParam("startDate")
  public LocalDate startDate;

  /**
   * 
   */
  @HeaderParam("dates")
  private LocalDate[] dates;

  /**
   * 
   */
  @HeaderParam("timestamps")
  private Set<LocalDateTime> timestamps;

  /**
   * 
   */
  @HeaderParam("calendars")
  private Calendar[] calendars;

  /**
   * 
   */
  @HeaderParam("utilDates")
  private Date[] utilDates;

  /**
   * 
   */
  @HeaderParam("sqlTimestamps")
  private Timestamp[] sqlTimestamps;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public MultiValuedHeaderBeanParam( ) {
    stringCodeList = new HashSet<StringCode>();
    timestamps = new HashSet<LocalDateTime>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected MultiValuedHeaderBeanParam( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    names = pBuilder.names;
    ints = pBuilder.ints;
    doubles = pBuilder.doubles;
    codes = pBuilder.codes;
    if (pBuilder.stringCodeList != null) {
      stringCodeList = pBuilder.stringCodeList;
    }
    else {
      stringCodeList = new HashSet<StringCode>();
    }
    startDate = pBuilder.startDate;
    dates = pBuilder.dates;
    if (pBuilder.timestamps != null) {
      timestamps = pBuilder.timestamps;
    }
    else {
      timestamps = new HashSet<LocalDateTime>();
    }
    calendars = pBuilder.calendars;
    utilDates = pBuilder.utilDates;
    sqlTimestamps = pBuilder.sqlTimestamps;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new MultiValuedHeaderBeanParam objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new MultiValuedHeaderBeanParam objects. The method
   * never returns null.
   */
  public static Builder builder( MultiValuedHeaderBeanParam pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class MultiValuedHeaderBeanParam. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String[] names;

    /**
     * 
     */
    private int[] ints;

    /**
     * 
     */
    private Double[] doubles;

    /**
     * 
     */
    private StringCode[] codes;

    /**
     * 
     */
    private Set<StringCode> stringCodeList;

    /**
     * 
     */
    private LocalDate startDate;

    /**
     * 
     */
    private LocalDate[] dates;

    /**
     * 
     */
    private Set<LocalDateTime> timestamps;

    /**
     * 
     */
    private Calendar[] calendars;

    /**
     * 
     */
    private Date[] utilDates;

    /**
     * 
     */
    private Timestamp[] sqlTimestamps;

    /**
     * Use {@link MultiValuedHeaderBeanParam#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link MultiValuedHeaderBeanParam#builder(MultiValuedHeaderBeanParam)} instead of private constructor to
     * create new builder.
     */
    protected Builder( MultiValuedHeaderBeanParam pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        names = pObject.names;
        ints = pObject.ints;
        doubles = pObject.doubles;
        codes = pObject.codes;
        stringCodeList = pObject.stringCodeList;
        startDate = pObject.startDate;
        dates = pObject.dates;
        timestamps = pObject.timestamps;
        calendars = pObject.calendars;
        utilDates = pObject.utilDates;
        sqlTimestamps = pObject.sqlTimestamps;
      }
    }

    /**
     * Method sets the attribute "names".
     * 
     * @param pNames Value to which the attribute "names" should be set.
     */
    public Builder setNames( String[] pNames ) {
      // Assign value to attribute
      if (pNames != null) {
        names = new String[pNames.length];
        System.arraycopy(pNames, 0, names, 0, pNames.length);
      }
      else {
        names = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "ints".
     * 
     * @param pInts Value to which the attribute "ints" should be set.
     */
    public Builder setInts( int[] pInts ) {
      // Assign value to attribute
      if (pInts != null) {
        ints = new int[pInts.length];
        System.arraycopy(pInts, 0, ints, 0, pInts.length);
      }
      else {
        ints = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "doubles".
     * 
     * @param pDoubles Value to which the attribute "doubles" should be set.
     */
    public Builder setDoubles( Double[] pDoubles ) {
      // Assign value to attribute
      if (pDoubles != null) {
        doubles = new Double[pDoubles.length];
        System.arraycopy(pDoubles, 0, doubles, 0, pDoubles.length);
      }
      else {
        doubles = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "codes".
     * 
     * @param pCodes Value to which the attribute "codes" should be set.
     */
    public Builder setCodes( StringCode[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = new StringCode[pCodes.length];
        System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method sets the association "stringCodeList".
     * 
     * @param pStringCodeList Collection with objects to which the association should be set.
     */
    public Builder setStringCodeList( Set<StringCode> pStringCodeList ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pStringCodeList != null) {
        stringCodeList = new HashSet<StringCode>(pStringCodeList);
      }
      else {
        stringCodeList = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "startDate".
     * 
     * @param pStartDate Value to which the attribute "startDate" should be set.
     */
    public Builder setStartDate( LocalDate pStartDate ) {
      // Assign value to attribute
      startDate = pStartDate;
      return this;
    }

    /**
     * Method sets the attribute "dates".
     * 
     * @param pDates Value to which the attribute "dates" should be set.
     */
    public Builder setDates( LocalDate[] pDates ) {
      // Assign value to attribute
      if (pDates != null) {
        dates = new LocalDate[pDates.length];
        System.arraycopy(pDates, 0, dates, 0, pDates.length);
      }
      else {
        dates = null;
      }
      return this;
    }

    /**
     * Method sets the association "timestamps".
     * 
     * @param pTimestamps Collection with objects to which the association should be set.
     */
    public Builder setTimestamps( Set<LocalDateTime> pTimestamps ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTimestamps != null) {
        timestamps = new HashSet<LocalDateTime>(pTimestamps);
      }
      else {
        timestamps = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "calendars".
     * 
     * @param pCalendars Value to which the attribute "calendars" should be set.
     */
    public Builder setCalendars( Calendar[] pCalendars ) {
      // Assign value to attribute
      if (pCalendars != null) {
        calendars = new Calendar[pCalendars.length];
        System.arraycopy(pCalendars, 0, calendars, 0, pCalendars.length);
      }
      else {
        calendars = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "utilDates".
     * 
     * @param pUtilDates Value to which the attribute "utilDates" should be set.
     */
    public Builder setUtilDates( Date[] pUtilDates ) {
      // Assign value to attribute
      if (pUtilDates != null) {
        utilDates = new Date[pUtilDates.length];
        System.arraycopy(pUtilDates, 0, utilDates, 0, pUtilDates.length);
      }
      else {
        utilDates = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "sqlTimestamps".
     * 
     * @param pSqlTimestamps Value to which the attribute "sqlTimestamps" should be set.
     */
    public Builder setSqlTimestamps( Timestamp[] pSqlTimestamps ) {
      // Assign value to attribute
      if (pSqlTimestamps != null) {
        sqlTimestamps = new Timestamp[pSqlTimestamps.length];
        System.arraycopy(pSqlTimestamps, 0, sqlTimestamps, 0, pSqlTimestamps.length);
      }
      else {
        sqlTimestamps = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class MultiValuedHeaderBeanParam. The object will be initialized with the values
     * of the builder.
     * 
     * @return MultiValuedHeaderBeanParam Created object. The method never returns null.
     */
    public MultiValuedHeaderBeanParam build( ) {
      return new MultiValuedHeaderBeanParam(this);
    }

    /**
     * Method creates a new validated instance of class MultiValuedHeaderBeanParam. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return MultiValuedHeaderBeanParam Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public MultiValuedHeaderBeanParam buildValidated( ) throws ConstraintViolationException {
      MultiValuedHeaderBeanParam lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "names".
   * 
   * 
   * @return String Value to which the attribute "names" is set.
   */
  public String[] getNames( ) {
    String[] lReturnValue;
    if (names != null) {
      lReturnValue = new String[names.length];
      System.arraycopy(names, 0, lReturnValue, 0, names.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "names".
   * 
   * 
   * @param pNames Value to which the attribute "names" should be set.
   */
  public void setNames( String[] pNames ) {
    // Assign value to attribute
    if (pNames != null) {
      names = new String[pNames.length];
      System.arraycopy(pNames, 0, names, 0, pNames.length);
    }
    else {
      names = null;
    }
  }

  /**
   * Method returns the attribute "ints".
   * 
   * 
   * @return int Value to which the attribute "ints" is set.
   */
  public int[] getInts( ) {
    int[] lReturnValue;
    if (ints != null) {
      lReturnValue = new int[ints.length];
      System.arraycopy(ints, 0, lReturnValue, 0, ints.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "ints".
   * 
   * 
   * @param pInts Value to which the attribute "ints" should be set.
   */
  public void setInts( int[] pInts ) {
    // Assign value to attribute
    if (pInts != null) {
      ints = new int[pInts.length];
      System.arraycopy(pInts, 0, ints, 0, pInts.length);
    }
    else {
      ints = null;
    }
  }

  /**
   * Method returns the attribute "doubles".
   * 
   * 
   * @return Double Value to which the attribute "doubles" is set.
   */
  public Double[] getDoubles( ) {
    Double[] lReturnValue;
    if (doubles != null) {
      lReturnValue = new Double[doubles.length];
      System.arraycopy(doubles, 0, lReturnValue, 0, doubles.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "doubles".
   * 
   * 
   * @param pDoubles Value to which the attribute "doubles" should be set.
   */
  public void setDoubles( Double[] pDoubles ) {
    // Assign value to attribute
    if (pDoubles != null) {
      doubles = new Double[pDoubles.length];
      System.arraycopy(pDoubles, 0, doubles, 0, pDoubles.length);
    }
    else {
      doubles = null;
    }
  }

  /**
   * Method returns the attribute "codes".
   * 
   * 
   * @return StringCode Value to which the attribute "codes" is set.
   */
  public StringCode[] getCodes( ) {
    StringCode[] lReturnValue;
    if (codes != null) {
      lReturnValue = new StringCode[codes.length];
      System.arraycopy(codes, 0, lReturnValue, 0, codes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "codes".
   * 
   * 
   * @param pCodes Value to which the attribute "codes" should be set.
   */
  public void setCodes( StringCode[] pCodes ) {
    // Assign value to attribute
    if (pCodes != null) {
      codes = new StringCode[pCodes.length];
      System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
    }
    else {
      codes = null;
    }
  }

  /**
   * Method returns the association "stringCodeList".
   * 
   *
   * @return Collection All StringCode objects that belong to the association "stringCodeList". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<StringCode> getStringCodeList( ) {
    // Return all StringCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(stringCodeList);
  }

  /**
   * Method adds the passed StringCode object to the association "stringCodeList".
   * 
   * 
   * @param pStringCodeList Object that should be added to the association "stringCodeList". The parameter must not be
   * null.
   */
  public void addToStringCodeList( StringCode pStringCodeList ) {
    // Check parameter "pStringCodeList" for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeList, "pStringCodeList");
    // Add passed object to collection of associated StringCode objects.
    stringCodeList.add(pStringCodeList);
  }

  /**
   * Method adds all passed objects to the association "stringCodeList".
   * 
   * 
   * @param pStringCodeList Collection with all objects that should be added to the association "stringCodeList". The
   * parameter must not be null.
   */
  public void addToStringCodeList( Collection<StringCode> pStringCodeList ) {
    // Check parameter "pStringCodeList" for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeList, "pStringCodeList");
    // Add all passed objects.
    for (StringCode lNextObject : pStringCodeList) {
      this.addToStringCodeList(lNextObject);
    }
  }

  /**
   * Method removes the passed StringCode object from the association "stringCodeList".
   * 
   * 
   * @param pStringCodeList Object that should be removed from the association "stringCodeList". The parameter must not
   * be null.
   */
  public void removeFromStringCodeList( StringCode pStringCodeList ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pStringCodeList, "pStringCodeList");
    // Remove passed object from collection of associated StringCode objects.
    stringCodeList.remove(pStringCodeList);
  }

  /**
   * Method removes all objects from the association "stringCodeList".
   * 
   */
  public void clearStringCodeList( ) {
    // Remove all objects from association "stringCodeList".
    stringCodeList.clear();
  }

  /**
   * Method returns the attribute "startDate".
   * 
   * 
   * @return LocalDate Value to which the attribute "startDate" is set.
   */
  public LocalDate getStartDate( ) {
    return startDate;
  }

  /**
   * Method sets the attribute "startDate".
   * 
   * 
   * @param pStartDate Value to which the attribute "startDate" should be set.
   */
  public void setStartDate( LocalDate pStartDate ) {
    // Assign value to attribute
    startDate = pStartDate;
  }

  /**
   * Method returns the attribute "dates".
   * 
   * 
   * @return LocalDate Value to which the attribute "dates" is set.
   */
  public LocalDate[] getDates( ) {
    LocalDate[] lReturnValue;
    if (dates != null) {
      lReturnValue = new LocalDate[dates.length];
      System.arraycopy(dates, 0, lReturnValue, 0, dates.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "dates".
   * 
   * 
   * @param pDates Value to which the attribute "dates" should be set.
   */
  public void setDates( LocalDate[] pDates ) {
    // Assign value to attribute
    if (pDates != null) {
      dates = new LocalDate[pDates.length];
      System.arraycopy(pDates, 0, dates, 0, pDates.length);
    }
    else {
      dates = null;
    }
  }

  /**
   * Method returns the association "timestamps".
   * 
   *
   * @return Collection All LocalDateTime objects that belong to the association "timestamps". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<LocalDateTime> getTimestamps( ) {
    // Return all LocalDateTime objects as unmodifiable collection.
    return Collections.unmodifiableSet(timestamps);
  }

  /**
   * Method adds the passed LocalDateTime object to the association "timestamps".
   * 
   * 
   * @param pTimestamps Object that should be added to the association "timestamps". The parameter must not be null.
   */
  public void addToTimestamps( LocalDateTime pTimestamps ) {
    // Check parameter "pTimestamps" for invalid value null.
    Check.checkInvalidParameterNull(pTimestamps, "pTimestamps");
    // Add passed object to collection of associated LocalDateTime objects.
    timestamps.add(pTimestamps);
  }

  /**
   * Method adds all passed objects to the association "timestamps".
   * 
   * 
   * @param pTimestamps Collection with all objects that should be added to the association "timestamps". The parameter
   * must not be null.
   */
  public void addToTimestamps( Collection<LocalDateTime> pTimestamps ) {
    // Check parameter "pTimestamps" for invalid value null.
    Check.checkInvalidParameterNull(pTimestamps, "pTimestamps");
    // Add all passed objects.
    for (LocalDateTime lNextObject : pTimestamps) {
      this.addToTimestamps(lNextObject);
    }
  }

  /**
   * Method removes the passed LocalDateTime object from the association "timestamps".
   * 
   * 
   * @param pTimestamps Object that should be removed from the association "timestamps". The parameter must not be null.
   */
  public void removeFromTimestamps( LocalDateTime pTimestamps ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTimestamps, "pTimestamps");
    // Remove passed object from collection of associated LocalDateTime objects.
    timestamps.remove(pTimestamps);
  }

  /**
   * Method removes all objects from the association "timestamps".
   * 
   */
  public void clearTimestamps( ) {
    // Remove all objects from association "timestamps".
    timestamps.clear();
  }

  /**
   * Method returns the attribute "calendars".
   * 
   * 
   * @return Calendar Value to which the attribute "calendars" is set.
   */
  public Calendar[] getCalendars( ) {
    Calendar[] lReturnValue;
    if (calendars != null) {
      lReturnValue = new Calendar[calendars.length];
      System.arraycopy(calendars, 0, lReturnValue, 0, calendars.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "calendars".
   * 
   * 
   * @param pCalendars Value to which the attribute "calendars" should be set.
   */
  public void setCalendars( Calendar[] pCalendars ) {
    // Assign value to attribute
    if (pCalendars != null) {
      calendars = new Calendar[pCalendars.length];
      System.arraycopy(pCalendars, 0, calendars, 0, pCalendars.length);
    }
    else {
      calendars = null;
    }
  }

  /**
   * Method returns the attribute "utilDates".
   * 
   * 
   * @return Date Value to which the attribute "utilDates" is set.
   */
  public Date[] getUtilDates( ) {
    Date[] lReturnValue;
    if (utilDates != null) {
      lReturnValue = new Date[utilDates.length];
      System.arraycopy(utilDates, 0, lReturnValue, 0, utilDates.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "utilDates".
   * 
   * 
   * @param pUtilDates Value to which the attribute "utilDates" should be set.
   */
  public void setUtilDates( Date[] pUtilDates ) {
    // Assign value to attribute
    if (pUtilDates != null) {
      utilDates = new Date[pUtilDates.length];
      System.arraycopy(pUtilDates, 0, utilDates, 0, pUtilDates.length);
    }
    else {
      utilDates = null;
    }
  }

  /**
   * Method returns the attribute "sqlTimestamps".
   * 
   * 
   * @return Timestamp Value to which the attribute "sqlTimestamps" is set.
   */
  public Timestamp[] getSqlTimestamps( ) {
    Timestamp[] lReturnValue;
    if (sqlTimestamps != null) {
      lReturnValue = new Timestamp[sqlTimestamps.length];
      System.arraycopy(sqlTimestamps, 0, lReturnValue, 0, sqlTimestamps.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "sqlTimestamps".
   * 
   * 
   * @param pSqlTimestamps Value to which the attribute "sqlTimestamps" should be set.
   */
  public void setSqlTimestamps( Timestamp[] pSqlTimestamps ) {
    // Assign value to attribute
    if (pSqlTimestamps != null) {
      sqlTimestamps = new Timestamp[pSqlTimestamps.length];
      System.arraycopy(pSqlTimestamps, 0, sqlTimestamps, 0, pSqlTimestamps.length);
    }
    else {
      sqlTimestamps = null;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("startDate: ");
    lBuilder.append(startDate);
    lBuilder.append(System.lineSeparator());
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
    return this.toStringBuilder("").toString();
  }
}
