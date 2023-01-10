/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateObject {
  /**
   * Constant for the name of attribute "localTime".
   */
  public static final String LOCALTIME = "localTime";

  /**
   * Constant for the name of attribute "localDate".
   */
  public static final String LOCALDATE = "localDate";

  /**
   * Constant for the name of attribute "localDateTime".
   */
  public static final String LOCALDATETIME = "localDateTime";

  /**
   * Constant for the name of attribute "calendar".
   */
  public static final String CALENDAR = "calendar";

  /**
   * Constant for the name of attribute "sqlDate".
   */
  public static final String SQLDATE = "sqlDate";

  /**
   * Constant for the name of attribute "utilDate".
   */
  public static final String UTILDATE = "utilDate";

  /**
   * <br/>
   * <b>Example:</b> <code>12:07</code>
   */
  private LocalTime localTime;

  /**
   * 
   */
  private LocalDate localDate;

  /**
   * 
   */
  private LocalDateTime localDateTime;

  /**
   * 
   */
  private Calendar calendar;

  /**
   * 
   */
  private Date sqlDate;

  /**
   * 
   */
  private java.util.Date utilDate;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DateObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DateObject( Builder pBuilder ) {
    // Read attribute values from builder.
    localTime = pBuilder.localTime;
    localDate = pBuilder.localDate;
    localDateTime = pBuilder.localDateTime;
    calendar = pBuilder.calendar;
    sqlDate = pBuilder.sqlDate;
    utilDate = pBuilder.utilDate;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DateObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DateObject objects. The method never returns
   * null.
   */
  public static Builder builder( DateObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class DateObject. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private LocalTime localTime;

    /**
     * 
     */
    private LocalDate localDate;

    /**
     * 
     */
    private LocalDateTime localDateTime;

    /**
     * 
     */
    private Calendar calendar;

    /**
     * 
     */
    private Date sqlDate;

    /**
     * 
     */
    private java.util.Date utilDate;

    /**
     * Use {@link DateObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DateObject#builder(DateObject)} instead of private constructor to create new builder.
     */
    protected Builder( DateObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        localTime = pObject.localTime;
        localDate = pObject.localDate;
        localDateTime = pObject.localDateTime;
        calendar = pObject.calendar;
        sqlDate = pObject.sqlDate;
        utilDate = pObject.utilDate;
      }
    }

    /**
     * Method sets the attribute "localTime".
     * 
     * @param pLocalTime Value to which the attribute "localTime" should be set.
     */
    public Builder setLocalTime( LocalTime pLocalTime ) {
      // Assign value to attribute
      localTime = pLocalTime;
      return this;
    }

    /**
     * Method sets the attribute "localDate".
     * 
     * @param pLocalDate Value to which the attribute "localDate" should be set.
     */
    public Builder setLocalDate( LocalDate pLocalDate ) {
      // Assign value to attribute
      localDate = pLocalDate;
      return this;
    }

    /**
     * Method sets the attribute "localDateTime".
     * 
     * @param pLocalDateTime Value to which the attribute "localDateTime" should be set.
     */
    public Builder setLocalDateTime( LocalDateTime pLocalDateTime ) {
      // Assign value to attribute
      localDateTime = pLocalDateTime;
      return this;
    }

    /**
     * Method sets the attribute "calendar".
     * 
     * @param pCalendar Value to which the attribute "calendar" should be set.
     */
    public Builder setCalendar( Calendar pCalendar ) {
      // Assign value to attribute
      calendar = pCalendar;
      return this;
    }

    /**
     * Method sets the attribute "sqlDate".
     * 
     * @param pSqlDate Value to which the attribute "sqlDate" should be set.
     */
    public Builder setSqlDate( Date pSqlDate ) {
      // Assign value to attribute
      sqlDate = pSqlDate;
      return this;
    }

    /**
     * Method sets the attribute "utilDate".
     * 
     * @param pUtilDate Value to which the attribute "utilDate" should be set.
     */
    public Builder setUtilDate( java.util.Date pUtilDate ) {
      // Assign value to attribute
      utilDate = pUtilDate;
      return this;
    }

    /**
     * Method creates a new instance of class DateObject. The object will be initialized with the values of the builder.
     * 
     * @return DateObject Created object. The method never returns null.
     */
    public DateObject build( ) {
      return new DateObject(this);
    }
  }

  /**
   * Method returns the attribute "localTime".
   * 
   * 
   * @return LocalTime Value to which the attribute "localTime" is set.
   */
  public LocalTime getLocalTime( ) {
    return localTime;
  }

  /**
   * Method sets the attribute "localTime".
   * 
   * 
   * @param pLocalTime Value to which the attribute "localTime" should be set.
   */
  public void setLocalTime( LocalTime pLocalTime ) {
    // Assign value to attribute
    localTime = pLocalTime;
  }

  /**
   * Method returns the attribute "localDate".
   * 
   * 
   * @return LocalDate Value to which the attribute "localDate" is set.
   */
  public LocalDate getLocalDate( ) {
    return localDate;
  }

  /**
   * Method sets the attribute "localDate".
   * 
   * 
   * @param pLocalDate Value to which the attribute "localDate" should be set.
   */
  public void setLocalDate( LocalDate pLocalDate ) {
    // Assign value to attribute
    localDate = pLocalDate;
  }

  /**
   * Method returns the attribute "localDateTime".
   * 
   * 
   * @return LocalDateTime Value to which the attribute "localDateTime" is set.
   */
  public LocalDateTime getLocalDateTime( ) {
    return localDateTime;
  }

  /**
   * Method sets the attribute "localDateTime".
   * 
   * 
   * @param pLocalDateTime Value to which the attribute "localDateTime" should be set.
   */
  public void setLocalDateTime( LocalDateTime pLocalDateTime ) {
    // Assign value to attribute
    localDateTime = pLocalDateTime;
  }

  /**
   * Method returns the attribute "calendar".
   * 
   * 
   * @return Calendar Value to which the attribute "calendar" is set.
   */
  public Calendar getCalendar( ) {
    return calendar;
  }

  /**
   * Method sets the attribute "calendar".
   * 
   * 
   * @param pCalendar Value to which the attribute "calendar" should be set.
   */
  public void setCalendar( Calendar pCalendar ) {
    // Assign value to attribute
    calendar = pCalendar;
  }

  /**
   * Method returns the attribute "sqlDate".
   * 
   * 
   * @return Date Value to which the attribute "sqlDate" is set.
   */
  public Date getSqlDate( ) {
    return sqlDate;
  }

  /**
   * Method sets the attribute "sqlDate".
   * 
   * 
   * @param pSqlDate Value to which the attribute "sqlDate" should be set.
   */
  public void setSqlDate( Date pSqlDate ) {
    // Assign value to attribute
    sqlDate = pSqlDate;
  }

  /**
   * Method returns the attribute "utilDate".
   * 
   * 
   * @return Date Value to which the attribute "utilDate" is set.
   */
  public java.util.Date getUtilDate( ) {
    return utilDate;
  }

  /**
   * Method sets the attribute "utilDate".
   * 
   * 
   * @param pUtilDate Value to which the attribute "utilDate" should be set.
   */
  public void setUtilDate( java.util.Date pUtilDate ) {
    // Assign value to attribute
    utilDate = pUtilDate;
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
    lBuilder.append("localTime: ");
    lBuilder.append(localTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localDate: ");
    lBuilder.append(localDate);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localDateTime: ");
    lBuilder.append(localDateTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("calendar: ");
    lBuilder.append(calendar);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sqlDate: ");
    lBuilder.append(sqlDate);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("utilDate: ");
    lBuilder.append(utilDate);
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
