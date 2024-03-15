/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

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

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.junit.extension.BuilderPropertyDeclaration;
import com.anaptecs.jeaf.junit.extension.ClassPropertyDeclaration;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class DateQueryParamsBean implements ServiceObject {
  /**
   * Default serial version uid.
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

  // "java.time.OffsetDateTime"
  @ClassPropertyDeclaration
  private OffsetDateTime offsetDateTime;

  // "java.time.OffsetDateTime"
  private int offsetDateTimeXYZ = 0;

  // "java.time.OffsetTime"
  @ClassPropertyDeclaration
  private OffsetTime offsetTime;

  // "java.time.OffsetTime"
  private int offsetTimeXYZ = 0;

  // "java.time.LocalDateTime"
  @ClassPropertyDeclaration
  /**
   * <p/>
   * <b>Breaking Change with 2.0:</b> Has to be in the past
   */
  private LocalDateTime localDateTime;

  // "java.time.LocalDateTime"
  private int localDateTimeXYZ = 0;

  // "java.time.LocalTime"
  @ClassPropertyDeclaration
  private LocalTime localTime;

  // "java.time.LocalTime"
  private int localTimeXYZ = 0;

  // "java.time.LocalDate"
  @ClassPropertyDeclaration
  private LocalDate localDate;

  // "java.time.LocalDate"
  private int localDateXYZ = 0;

  // "java.util.Date"
  @ClassPropertyDeclaration
  private java.util.Date utilDate;

  // "java.util.Date"
  private int utilDateXYZ = 0;

  // "java.util.Calendar"
  @ClassPropertyDeclaration
  private Calendar calendar;

  // "java.util.Calendar"
  private int calendarXYZ = 0;

  // "java.sql.Timestamp"
  @ClassPropertyDeclaration
  private Timestamp sqlTimestamp;

  // "java.sql.Timestamp"
  private int sqlTimestampXYZ = 0;

  // "java.sql.Time"
  @ClassPropertyDeclaration
  private Time sqlTime;

  // "java.sql.Time"
  private int sqlTimeXYZ = 0;

  // "java.sql.Date"
  @ClassPropertyDeclaration
  private Date sqlDate;

  // "java.sql.Date"
  private int sqlDateXYZ = 0;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected DateQueryParamsBean( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DateQueryParamsBean( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    offsetDateTime = pBuilder.offsetDateTime;
    // "java.time.OffsetDateTime"
    offsetDateTimeXYZ = pBuilder.offsetDateTimeXYZ;
    offsetTime = pBuilder.offsetTime;
    // "java.time.OffsetTime"
    offsetTimeXYZ = pBuilder.offsetTimeXYZ;
    localDateTime = pBuilder.localDateTime;
    // "java.time.LocalDateTime"
    localDateTimeXYZ = pBuilder.localDateTimeXYZ;
    localTime = pBuilder.localTime;
    // "java.time.LocalTime"
    localTimeXYZ = pBuilder.localTimeXYZ;
    localDate = pBuilder.localDate;
    // "java.time.LocalDate"
    localDateXYZ = pBuilder.localDateXYZ;
    utilDate = pBuilder.utilDate;
    // "java.util.Date"
    utilDateXYZ = pBuilder.utilDateXYZ;
    calendar = pBuilder.calendar;
    // "java.util.Calendar"
    calendarXYZ = pBuilder.calendarXYZ;
    sqlTimestamp = pBuilder.sqlTimestamp;
    // "java.sql.Timestamp"
    sqlTimestampXYZ = pBuilder.sqlTimestampXYZ;
    sqlTime = pBuilder.sqlTime;
    // "java.sql.Time"
    sqlTimeXYZ = pBuilder.sqlTimeXYZ;
    sqlDate = pBuilder.sqlDate;
    // "java.sql.Date"
    sqlDateXYZ = pBuilder.sqlDateXYZ;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DateQueryParamsBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>DateQueryParamsBean</code>.
   */
  public static class Builder {
    // "java.time.OffsetDateTime"
    @BuilderPropertyDeclaration
    private OffsetDateTime offsetDateTime;

    // "java.time.OffsetDateTime"
    private int offsetDateTimeXYZ = 0;

    // "java.time.OffsetTime"
    @BuilderPropertyDeclaration
    private OffsetTime offsetTime;

    // "java.time.OffsetTime"
    private int offsetTimeXYZ = 0;

    /**
     * <p/>
     * <b>Breaking Change with 2.0:</b> Has to be in the past
     */
    // "java.time.LocalDateTime"
    @BuilderPropertyDeclaration
    private LocalDateTime localDateTime;

    // "java.time.LocalDateTime"
    private int localDateTimeXYZ = 0;

    // "java.time.LocalTime"
    @BuilderPropertyDeclaration
    private LocalTime localTime;

    // "java.time.LocalTime"
    private int localTimeXYZ = 0;

    // "java.time.LocalDate"
    @BuilderPropertyDeclaration
    private LocalDate localDate;

    // "java.time.LocalDate"
    private int localDateXYZ = 0;

    // "java.util.Date"
    @BuilderPropertyDeclaration
    private java.util.Date utilDate;

    // "java.util.Date"
    private int utilDateXYZ = 0;

    // "java.util.Calendar"
    @BuilderPropertyDeclaration
    private Calendar calendar;

    // "java.util.Calendar"
    private int calendarXYZ = 0;

    // "java.sql.Timestamp"
    @BuilderPropertyDeclaration
    private Timestamp sqlTimestamp;

    // "java.sql.Timestamp"
    private int sqlTimestampXYZ = 0;

    // "java.sql.Time"
    @BuilderPropertyDeclaration
    private Time sqlTime;

    // "java.sql.Time"
    private int sqlTimeXYZ = 0;

    // "java.sql.Date"
    @BuilderPropertyDeclaration
    private Date sqlDate;

    // "java.sql.Date"
    private int sqlDateXYZ = 0;

    /**
     * Use {@link DateQueryParamsBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DateQueryParamsBean#builder(DateQueryParamsBean)} instead of private constructor to create new
     * builder.
     */
    protected Builder( DateQueryParamsBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setOffsetDateTime(pObject.offsetDateTime);
        this.setOffsetTime(pObject.offsetTime);
        this.setLocalDateTime(pObject.localDateTime);
        this.setLocalTime(pObject.localTime);
        this.setLocalDate(pObject.localDate);
        this.setUtilDate(pObject.utilDate);
        this.setCalendar(pObject.calendar);
        this.setSqlTimestamp(pObject.sqlTimestamp);
        this.setSqlTime(pObject.sqlTime);
        this.setSqlDate(pObject.sqlDate);
      }
    }

    /**
     * Method sets attribute {@link #offsetDateTime}.<br/>
     *
     * @param pOffsetDateTime Value to which {@link #offsetDateTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
      // Assign value to attribute
      offsetDateTime = pOffsetDateTime;
      return this;
    }

    public Builder setOffsetDateTimeXYZ( int value ) {
      // "java.time.OffsetDateTime"
      offsetDateTimeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #offsetTime}.<br/>
     *
     * @param pOffsetTime Value to which {@link #offsetTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOffsetTime( OffsetTime pOffsetTime ) {
      // Assign value to attribute
      offsetTime = pOffsetTime;
      return this;
    }

    public Builder setOffsetTimeXYZ( int value ) {
      // "java.time.OffsetTime"
      offsetTimeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #localDateTime}.<br/>
     * <p/>
     * <b>Breaking Change with 2.0:</b> Has to be in the past
     *
     * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalDateTime( LocalDateTime pLocalDateTime ) {
      // Assign value to attribute
      localDateTime = pLocalDateTime;
      return this;
    }

    public Builder setLocalDateTimeXYZ( int value ) {
      // "java.time.LocalDateTime"
      localDateTimeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #localTime}.<br/>
     *
     * @param pLocalTime Value to which {@link #localTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalTime( LocalTime pLocalTime ) {
      // Assign value to attribute
      localTime = pLocalTime;
      return this;
    }

    public Builder setLocalTimeXYZ( int value ) {
      // "java.time.LocalTime"
      localTimeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #localDate}.<br/>
     *
     * @param pLocalDate Value to which {@link #localDate} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalDate( LocalDate pLocalDate ) {
      // Assign value to attribute
      localDate = pLocalDate;
      return this;
    }

    public Builder setLocalDateXYZ( int value ) {
      // "java.time.LocalDate"
      localDateXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #utilDate}.<br/>
     *
     * @param pUtilDate Value to which {@link #utilDate} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setUtilDate( java.util.Date pUtilDate ) {
      // Assign value to attribute
      utilDate = pUtilDate;
      return this;
    }

    public Builder setUtilDateXYZ( int value ) {
      // "java.util.Date"
      utilDateXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #calendar}.<br/>
     *
     * @param pCalendar Value to which {@link #calendar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCalendar( Calendar pCalendar ) {
      // Assign value to attribute
      calendar = pCalendar;
      return this;
    }

    public Builder setCalendarXYZ( int value ) {
      // "java.util.Calendar"
      calendarXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #sqlTimestamp}.<br/>
     *
     * @param pSqlTimestamp Value to which {@link #sqlTimestamp} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSqlTimestamp( Timestamp pSqlTimestamp ) {
      // Assign value to attribute
      sqlTimestamp = pSqlTimestamp;
      return this;
    }

    public Builder setSqlTimestampXYZ( int value ) {
      // "java.sql.Timestamp"
      sqlTimestampXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #sqlTime}.<br/>
     *
     * @param pSqlTime Value to which {@link #sqlTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSqlTime( Time pSqlTime ) {
      // Assign value to attribute
      sqlTime = pSqlTime;
      return this;
    }

    public Builder setSqlTimeXYZ( int value ) {
      // "java.sql.Time"
      sqlTimeXYZ = value;
      return this;
    }

    /**
     * Method sets attribute {@link #sqlDate}.<br/>
     *
     * @param pSqlDate Value to which {@link #sqlDate} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSqlDate( Date pSqlDate ) {
      // Assign value to attribute
      sqlDate = pSqlDate;
      return this;
    }

    public Builder setSqlDateXYZ( int value ) {
      // "java.sql.Date"
      sqlDateXYZ = value;
      return this;
    }

    /**
     * Method creates a new instance of class DateQueryParamsBean. The object will be initialized with the values of the
     * builder.
     *
     * @return DateQueryParamsBean Created object. The method never returns null.
     */
    public DateQueryParamsBean build( ) {
      return new DateQueryParamsBean(this);
    }

    /**
     * Method creates a new validated instance of class DateQueryParamsBean. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return DateQueryParamsBean Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DateQueryParamsBean buildValidated( ) throws ConstraintViolationException {
      DateQueryParamsBean lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #offsetDateTime}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #offsetDateTime} is set.
   */
  public OffsetDateTime getOffsetDateTime( ) {
    return offsetDateTime;
  }

  /**
   * Method sets attribute {@link #offsetDateTime}.<br/>
   *
   * @param pOffsetDateTime Value to which {@link #offsetDateTime} should be set.
   */
  public void setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
    // Assign value to attribute
    offsetDateTime = pOffsetDateTime;
  }

  public int getOffsetDateTimeXYZ( ) {
    // "java.time.OffsetDateTime"
    return offsetDateTimeXYZ;
  }

  public void setOffsetDateTimeXYZ( int value ) {
    offsetDateTimeXYZ = value;
  }

  /**
   * Method returns attribute {@link #offsetTime}.<br/>
   *
   * @return {@link OffsetTime} Value to which {@link #offsetTime} is set.
   */
  public OffsetTime getOffsetTime( ) {
    return offsetTime;
  }

  /**
   * Method sets attribute {@link #offsetTime}.<br/>
   *
   * @param pOffsetTime Value to which {@link #offsetTime} should be set.
   */
  public void setOffsetTime( OffsetTime pOffsetTime ) {
    // Assign value to attribute
    offsetTime = pOffsetTime;
  }

  public int getOffsetTimeXYZ( ) {
    // "java.time.OffsetTime"
    return offsetTimeXYZ;
  }

  public void setOffsetTimeXYZ( int value ) {
    offsetTimeXYZ = value;
  }

  /**
   * Method returns attribute {@link #localDateTime}.<br/>
   * <p/>
   * <b>Breaking Change with 2.0:</b> Has to be in the past
   *
   * @return {@link LocalDateTime} Value to which {@link #localDateTime} is set.
   */
  public LocalDateTime getLocalDateTime( ) {
    return localDateTime;
  }

  /**
   * Method sets attribute {@link #localDateTime}.<br/>
   * <p/>
   * <b>Breaking Change with 2.0:</b> Has to be in the past
   *
   * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
   */
  public void setLocalDateTime( LocalDateTime pLocalDateTime ) {
    // Assign value to attribute
    localDateTime = pLocalDateTime;
  }

  public int getLocalDateTimeXYZ( ) {
    // "java.time.LocalDateTime"
    return localDateTimeXYZ;
  }

  public void setLocalDateTimeXYZ( int value ) {
    localDateTimeXYZ = value;
  }

  /**
   * Method returns attribute {@link #localTime}.<br/>
   *
   * @return {@link LocalTime} Value to which {@link #localTime} is set.
   */
  public LocalTime getLocalTime( ) {
    return localTime;
  }

  /**
   * Method sets attribute {@link #localTime}.<br/>
   *
   * @param pLocalTime Value to which {@link #localTime} should be set.
   */
  public void setLocalTime( LocalTime pLocalTime ) {
    // Assign value to attribute
    localTime = pLocalTime;
  }

  public int getLocalTimeXYZ( ) {
    // "java.time.LocalTime"
    return localTimeXYZ;
  }

  public void setLocalTimeXYZ( int value ) {
    localTimeXYZ = value;
  }

  /**
   * Method returns attribute {@link #localDate}.<br/>
   *
   * @return {@link LocalDate} Value to which {@link #localDate} is set.
   */
  public LocalDate getLocalDate( ) {
    return localDate;
  }

  /**
   * Method sets attribute {@link #localDate}.<br/>
   *
   * @param pLocalDate Value to which {@link #localDate} should be set.
   */
  public void setLocalDate( LocalDate pLocalDate ) {
    // Assign value to attribute
    localDate = pLocalDate;
  }

  public int getLocalDateXYZ( ) {
    // "java.time.LocalDate"
    return localDateXYZ;
  }

  public void setLocalDateXYZ( int value ) {
    localDateXYZ = value;
  }

  /**
   * Method returns attribute {@link #utilDate}.<br/>
   *
   * @return {@link java.util.Date} Value to which {@link #utilDate} is set.
   */
  public java.util.Date getUtilDate( ) {
    return utilDate;
  }

  /**
   * Method sets attribute {@link #utilDate}.<br/>
   *
   * @param pUtilDate Value to which {@link #utilDate} should be set.
   */
  public void setUtilDate( java.util.Date pUtilDate ) {
    // Assign value to attribute
    utilDate = pUtilDate;
  }

  public int getUtilDateXYZ( ) {
    // "java.util.Date"
    return utilDateXYZ;
  }

  public void setUtilDateXYZ( int value ) {
    utilDateXYZ = value;
  }

  /**
   * Method returns attribute {@link #calendar}.<br/>
   *
   * @return {@link Calendar} Value to which {@link #calendar} is set.
   */
  public Calendar getCalendar( ) {
    return calendar;
  }

  /**
   * Method sets attribute {@link #calendar}.<br/>
   *
   * @param pCalendar Value to which {@link #calendar} should be set.
   */
  public void setCalendar( Calendar pCalendar ) {
    // Assign value to attribute
    calendar = pCalendar;
  }

  public int getCalendarXYZ( ) {
    // "java.util.Calendar"
    return calendarXYZ;
  }

  public void setCalendarXYZ( int value ) {
    calendarXYZ = value;
  }

  /**
   * Method returns attribute {@link #sqlTimestamp}.<br/>
   *
   * @return {@link Timestamp} Value to which {@link #sqlTimestamp} is set.
   */
  public Timestamp getSqlTimestamp( ) {
    return sqlTimestamp;
  }

  /**
   * Method sets attribute {@link #sqlTimestamp}.<br/>
   *
   * @param pSqlTimestamp Value to which {@link #sqlTimestamp} should be set.
   */
  public void setSqlTimestamp( Timestamp pSqlTimestamp ) {
    // Assign value to attribute
    sqlTimestamp = pSqlTimestamp;
  }

  public int getSqlTimestampXYZ( ) {
    // "java.sql.Timestamp"
    return sqlTimestampXYZ;
  }

  public void setSqlTimestampXYZ( int value ) {
    sqlTimestampXYZ = value;
  }

  /**
   * Method returns attribute {@link #sqlTime}.<br/>
   *
   * @return {@link Time} Value to which {@link #sqlTime} is set.
   */
  public Time getSqlTime( ) {
    return sqlTime;
  }

  /**
   * Method sets attribute {@link #sqlTime}.<br/>
   *
   * @param pSqlTime Value to which {@link #sqlTime} should be set.
   */
  public void setSqlTime( Time pSqlTime ) {
    // Assign value to attribute
    sqlTime = pSqlTime;
  }

  public int getSqlTimeXYZ( ) {
    // "java.sql.Time"
    return sqlTimeXYZ;
  }

  public void setSqlTimeXYZ( int value ) {
    sqlTimeXYZ = value;
  }

  /**
   * Method returns attribute {@link #sqlDate}.<br/>
   *
   * @return {@link Date} Value to which {@link #sqlDate} is set.
   */
  public Date getSqlDate( ) {
    return sqlDate;
  }

  /**
   * Method sets attribute {@link #sqlDate}.<br/>
   *
   * @param pSqlDate Value to which {@link #sqlDate} should be set.
   */
  public void setSqlDate( Date pSqlDate ) {
    // Assign value to attribute
    sqlDate = pSqlDate;
  }

  public int getSqlDateXYZ( ) {
    // "java.sql.Date"
    return sqlDateXYZ;
  }

  public void setSqlDateXYZ( int value ) {
    sqlDateXYZ = value;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new DateQueryParamsBean objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}
