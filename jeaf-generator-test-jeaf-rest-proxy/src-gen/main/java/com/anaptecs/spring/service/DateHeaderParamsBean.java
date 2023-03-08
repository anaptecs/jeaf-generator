/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Calendar;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.HeaderParam;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class DateHeaderParamsBean implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "offsetDateTime".
   */
  public static final String OFFSETDATETIME = "offsetDateTime";

  /**
   * Constant for the name of attribute "offsetTime".
   */
  public static final String OFFSETTIME = "offsetTime";

  /**
   * Constant for the name of attribute "localDateTime".
   */
  public static final String LOCALDATETIME = "localDateTime";

  /**
   * Constant for the name of attribute "localTime".
   */
  public static final String LOCALTIME = "localTime";

  /**
   * Constant for the name of attribute "localDate".
   */
  public static final String LOCALDATE = "localDate";

  /**
   * Constant for the name of attribute "utilDate".
   */
  public static final String UTILDATE = "utilDate";

  /**
   * Constant for the name of attribute "calendar".
   */
  public static final String CALENDAR = "calendar";

  /**
   * Constant for the name of attribute "sqlTimestamp".
   */
  public static final String SQLTIMESTAMP = "sqlTimestamp";

  /**
   * Constant for the name of attribute "sqlTime".
   */
  public static final String SQLTIME = "sqlTime";

  /**
   * Constant for the name of attribute "sqlDate".
   */
  public static final String SQLDATE = "sqlDate";

  @HeaderParam("Offset-Date-Time")
  private OffsetDateTime offsetDateTime;

  @HeaderParam("Offset-Time")
  private OffsetTime offsetTime;

  @HeaderParam("Local-Date-Time")
  private LocalDateTime localDateTime;

  @HeaderParam("Local-Time")
  private LocalTime localTime;

  @HeaderParam("Local-Date")
  private LocalDate localDate;

  @HeaderParam("Util-Date")
  private java.util.Date utilDate;

  @HeaderParam("Calendar")
  private Calendar calendar;

  @HeaderParam("SQL-Timestamp")
  private Timestamp sqlTimestamp;

  @HeaderParam("SQL-Time")
  private Time sqlTime;

  @HeaderParam("SQL-Date")
  private Date sqlDate;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public DateHeaderParamsBean( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DateHeaderParamsBean( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    offsetDateTime = pBuilder.offsetDateTime;
    offsetTime = pBuilder.offsetTime;
    localDateTime = pBuilder.localDateTime;
    localTime = pBuilder.localTime;
    localDate = pBuilder.localDate;
    utilDate = pBuilder.utilDate;
    calendar = pBuilder.calendar;
    sqlTimestamp = pBuilder.sqlTimestamp;
    sqlTime = pBuilder.sqlTime;
    sqlDate = pBuilder.sqlDate;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DateHeaderParamsBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DateHeaderParamsBean objects. The method never
   * returns null.
   */
  public static Builder builder( DateHeaderParamsBean pObject ) {
    return new Builder(pObject);
  }

  /**
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime, LocalDateTime pLocalDateTime,
      LocalTime pLocalTime, LocalDate pLocalDate, java.util.Date pUtilDate, Calendar pCalendar, Timestamp pSqlTimestamp,
      Time pSqlTime, Date pSqlDate ) {
    Builder lBuilder = builder();
    lBuilder.setOffsetDateTime(pOffsetDateTime);
    lBuilder.setOffsetTime(pOffsetTime);
    lBuilder.setLocalDateTime(pLocalDateTime);
    lBuilder.setLocalTime(pLocalTime);
    lBuilder.setLocalDate(pLocalDate);
    lBuilder.setUtilDate(pUtilDate);
    lBuilder.setCalendar(pCalendar);
    lBuilder.setSqlTimestamp(pSqlTimestamp);
    lBuilder.setSqlTime(pSqlTime);
    lBuilder.setSqlDate(pSqlDate);
    return lBuilder;
  }

  /**
   * Class implements builder to create a new instance of class DateHeaderParamsBean. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private OffsetDateTime offsetDateTime;

    /**
     * 
     */
    private OffsetTime offsetTime;

    /**
     * 
     */
    private LocalDateTime localDateTime;

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
    private java.util.Date utilDate;

    /**
     * 
     */
    private Calendar calendar;

    /**
     * 
     */
    private Timestamp sqlTimestamp;

    /**
     * 
     */
    private Time sqlTime;

    /**
     * 
     */
    private Date sqlDate;

    /**
     * Use {@link DateHeaderParamsBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DateHeaderParamsBean#builder(DateHeaderParamsBean)} instead of private constructor to create new
     * builder.
     */
    protected Builder( DateHeaderParamsBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        offsetDateTime = pObject.offsetDateTime;
        offsetTime = pObject.offsetTime;
        localDateTime = pObject.localDateTime;
        localTime = pObject.localTime;
        localDate = pObject.localDate;
        utilDate = pObject.utilDate;
        calendar = pObject.calendar;
        sqlTimestamp = pObject.sqlTimestamp;
        sqlTime = pObject.sqlTime;
        sqlDate = pObject.sqlDate;
      }
    }

    /**
     * Method sets the attribute "offsetDateTime".
     * 
     * @param pOffsetDateTime Value to which the attribute "offsetDateTime" should be set.
     */
    public Builder setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
      // Assign value to attribute
      offsetDateTime = pOffsetDateTime;
      return this;
    }

    /**
     * Method sets the attribute "offsetTime".
     * 
     * @param pOffsetTime Value to which the attribute "offsetTime" should be set.
     */
    public Builder setOffsetTime( OffsetTime pOffsetTime ) {
      // Assign value to attribute
      offsetTime = pOffsetTime;
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
     * Method sets the attribute "sqlTimestamp".
     * 
     * @param pSqlTimestamp Value to which the attribute "sqlTimestamp" should be set.
     */
    public Builder setSqlTimestamp( Timestamp pSqlTimestamp ) {
      // Assign value to attribute
      sqlTimestamp = pSqlTimestamp;
      return this;
    }

    /**
     * Method sets the attribute "sqlTime".
     * 
     * @param pSqlTime Value to which the attribute "sqlTime" should be set.
     */
    public Builder setSqlTime( Time pSqlTime ) {
      // Assign value to attribute
      sqlTime = pSqlTime;
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
     * Method creates a new instance of class DateHeaderParamsBean. The object will be initialized with the values of
     * the builder.
     * 
     * @return DateHeaderParamsBean Created object. The method never returns null.
     */
    public DateHeaderParamsBean build( ) {
      return new DateHeaderParamsBean(this);
    }

    /**
     * Method creates a new validated instance of class DateHeaderParamsBean. The object will be initialized with the
     * values of the builder and validated afterwards.
     * 
     * @return DateHeaderParamsBean Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DateHeaderParamsBean buildValidated( ) throws ConstraintViolationException {
      DateHeaderParamsBean lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns attribute {@link #offsetDateTime}.<br/>
   * 
   * @return OffsetDateTime Value to which the attribute "offsetDateTime" is set.
   */
  public OffsetDateTime getOffsetDateTime( ) {
    return offsetDateTime;
  }

  /**
   * Method sets the attribute "offsetDateTime".
   * 
   * 
   * @param pOffsetDateTime Value to which the attribute "offsetDateTime" should be set.
   */
  public void setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
    // Assign value to attribute
    offsetDateTime = pOffsetDateTime;
  }

  /**
   * Method returns attribute {@link #offsetTime}.<br/>
   * 
   * @return OffsetTime Value to which the attribute "offsetTime" is set.
   */
  public OffsetTime getOffsetTime( ) {
    return offsetTime;
  }

  /**
   * Method sets the attribute "offsetTime".
   * 
   * 
   * @param pOffsetTime Value to which the attribute "offsetTime" should be set.
   */
  public void setOffsetTime( OffsetTime pOffsetTime ) {
    // Assign value to attribute
    offsetTime = pOffsetTime;
  }

  /**
   * Method returns attribute {@link #localDateTime}.<br/>
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
   * Method returns attribute {@link #localTime}.<br/>
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
   * Method returns attribute {@link #localDate}.<br/>
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
   * Method returns attribute {@link #utilDate}.<br/>
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
   * Method returns attribute {@link #calendar}.<br/>
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
   * Method returns attribute {@link #sqlTimestamp}.<br/>
   * 
   * @return Timestamp Value to which the attribute "sqlTimestamp" is set.
   */
  public Timestamp getSqlTimestamp( ) {
    return sqlTimestamp;
  }

  /**
   * Method sets the attribute "sqlTimestamp".
   * 
   * 
   * @param pSqlTimestamp Value to which the attribute "sqlTimestamp" should be set.
   */
  public void setSqlTimestamp( Timestamp pSqlTimestamp ) {
    // Assign value to attribute
    sqlTimestamp = pSqlTimestamp;
  }

  /**
   * Method returns attribute {@link #sqlTime}.<br/>
   * 
   * @return Time Value to which the attribute "sqlTime" is set.
   */
  public Time getSqlTime( ) {
    return sqlTime;
  }

  /**
   * Method sets the attribute "sqlTime".
   * 
   * 
   * @param pSqlTime Value to which the attribute "sqlTime" should be set.
   */
  public void setSqlTime( Time pSqlTime ) {
    // Assign value to attribute
    sqlTime = pSqlTime;
  }

  /**
   * Method returns attribute {@link #sqlDate}.<br/>
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
    lBuilder.append("offsetDateTime: ");
    lBuilder.append(offsetDateTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("offsetTime: ");
    lBuilder.append(offsetTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localDateTime: ");
    lBuilder.append(localDateTime);
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
    lBuilder.append("utilDate: ");
    lBuilder.append(utilDate);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("calendar: ");
    lBuilder.append(calendar);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sqlTimestamp: ");
    lBuilder.append(sqlTimestamp);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sqlTime: ");
    lBuilder.append(sqlTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("sqlDate: ");
    lBuilder.append(sqlDate);
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
