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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

import com.anaptecs.annotations.MyNotNullProperty;
import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Valid
public class DateQueryParamsBean implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  @QueryParam("offsetDateTime")
  @NotNull
  private OffsetDateTime offsetDateTime;

  @QueryParam("offsetTime")
  @NotNull
  private OffsetTime offsetTime;

  /**
   * <p/>
   * <b>Breaking Change with 2.0:</b> Has to be in the past
   */
  @QueryParam("localDateTime")
  @NotNull
  private LocalDateTime localDateTime;

  @QueryParam("localTime")
  @NotNull
  private LocalTime localTime;

  @QueryParam("localDate")
  @NotNull
  private LocalDate localDate;

  @QueryParam("utilDate")
  @NotNull
  private java.util.Date utilDate;

  @QueryParam("calendar")
  @NotNull
  private Calendar calendar;

  @QueryParam("sqlTimestamp")
  @NotNull
  private Timestamp sqlTimestamp;

  @QueryParam("sqlTime")
  @NotNull
  private Time sqlTime;

  @QueryParam("sqlDate")
  @NotNull
  private Date sqlDate;

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
   * @return {@link Builder} New builder that can be used to create new DateQueryParamsBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class DateQueryParamsBean.
   *
   *
   * @param pOffsetDateTime Value to which {@link #offsetDateTime} should be set.
   *
   * @param pOffsetTime Value to which {@link #offsetTime} should be set.
   *
   * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
   *
   * @param pLocalTime Value to which {@link #localTime} should be set.
   *
   * @param pLocalDate Value to which {@link #localDate} should be set.
   *
   * @param pUtilDate Value to which {@link #utilDate} should be set.
   *
   * @param pCalendar Value to which {@link #calendar} should be set.
   *
   * @param pSqlTimestamp Value to which {@link #sqlTimestamp} should be set.
   *
   * @param pSqlTime Value to which {@link #sqlTime} should be set.
   *
   * @param pSqlDate Value to which {@link #sqlDate} should be set.
   *
   * @return {@link DateQueryParamsBean}
   */
  public static DateQueryParamsBean of( OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, java.util.Date pUtilDate,
      Calendar pCalendar, Timestamp pSqlTimestamp, Time pSqlTime, Date pSqlDate ) {
    var lBuilder = DateQueryParamsBean.builder();
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
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DateQueryParamsBean</code>.
   */
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private OffsetDateTime offsetDateTime;

    private OffsetTime offsetTime;

    /**
     * <p/>
     * <b>Breaking Change with 2.0:</b> Has to be in the past
     */
    private LocalDateTime localDateTime;

    private LocalTime localTime;

    private LocalDate localDate;

    private java.util.Date utilDate;

    private Calendar calendar;

    private Timestamp sqlTimestamp;

    private Time sqlTime;

    private Date sqlDate;

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
    public Builder setOffsetDateTime( @MyNotNullProperty OffsetDateTime pOffsetDateTime ) {
      // Assign value to attribute
      offsetDateTime = pOffsetDateTime;
      return this;
    }

    /**
     * Method sets attribute {@link #offsetTime}.<br/>
     *
     * @param pOffsetTime Value to which {@link #offsetTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setOffsetTime( @MyNotNullProperty OffsetTime pOffsetTime ) {
      // Assign value to attribute
      offsetTime = pOffsetTime;
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
    public Builder setLocalDateTime( @MyNotNullProperty LocalDateTime pLocalDateTime ) {
      // Assign value to attribute
      localDateTime = pLocalDateTime;
      return this;
    }

    /**
     * Method sets attribute {@link #localTime}.<br/>
     *
     * @param pLocalTime Value to which {@link #localTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalTime( @MyNotNullProperty LocalTime pLocalTime ) {
      // Assign value to attribute
      localTime = pLocalTime;
      return this;
    }

    /**
     * Method sets attribute {@link #localDate}.<br/>
     *
     * @param pLocalDate Value to which {@link #localDate} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalDate( @MyNotNullProperty LocalDate pLocalDate ) {
      // Assign value to attribute
      localDate = pLocalDate;
      return this;
    }

    /**
     * Method sets attribute {@link #utilDate}.<br/>
     *
     * @param pUtilDate Value to which {@link #utilDate} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setUtilDate( @MyNotNullProperty java.util.Date pUtilDate ) {
      // Assign value to attribute
      utilDate = pUtilDate;
      return this;
    }

    /**
     * Method sets attribute {@link #calendar}.<br/>
     *
     * @param pCalendar Value to which {@link #calendar} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setCalendar( @MyNotNullProperty Calendar pCalendar ) {
      // Assign value to attribute
      calendar = pCalendar;
      return this;
    }

    /**
     * Method sets attribute {@link #sqlTimestamp}.<br/>
     *
     * @param pSqlTimestamp Value to which {@link #sqlTimestamp} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSqlTimestamp( @MyNotNullProperty Timestamp pSqlTimestamp ) {
      // Assign value to attribute
      sqlTimestamp = pSqlTimestamp;
      return this;
    }

    /**
     * Method sets attribute {@link #sqlTime}.<br/>
     *
     * @param pSqlTime Value to which {@link #sqlTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSqlTime( @MyNotNullProperty Time pSqlTime ) {
      // Assign value to attribute
      sqlTime = pSqlTime;
      return this;
    }

    /**
     * Method sets attribute {@link #sqlDate}.<br/>
     *
     * @param pSqlDate Value to which {@link #sqlDate} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setSqlDate( @MyNotNullProperty Date pSqlDate ) {
      // Assign value to attribute
      sqlDate = pSqlDate;
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
  @MyNotNullProperty
  public OffsetDateTime getOffsetDateTime( ) {
    return offsetDateTime;
  }

  /**
   * Method sets attribute {@link #offsetDateTime}.<br/>
   *
   * @param pOffsetDateTime Value to which {@link #offsetDateTime} should be set.
   */
  public void setOffsetDateTime( @MyNotNullProperty OffsetDateTime pOffsetDateTime ) {
    // Assign value to attribute
    offsetDateTime = pOffsetDateTime;
  }

  /**
   * Method returns attribute {@link #offsetTime}.<br/>
   *
   * @return {@link OffsetTime} Value to which {@link #offsetTime} is set.
   */
  @MyNotNullProperty
  public OffsetTime getOffsetTime( ) {
    return offsetTime;
  }

  /**
   * Method sets attribute {@link #offsetTime}.<br/>
   *
   * @param pOffsetTime Value to which {@link #offsetTime} should be set.
   */
  public void setOffsetTime( @MyNotNullProperty OffsetTime pOffsetTime ) {
    // Assign value to attribute
    offsetTime = pOffsetTime;
  }

  /**
   * Method returns attribute {@link #localDateTime}.<br/>
   * <p/>
   * <b>Breaking Change with 2.0:</b> Has to be in the past
   *
   * @return {@link LocalDateTime} Value to which {@link #localDateTime} is set.
   */
  @MyNotNullProperty
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
  public void setLocalDateTime( @MyNotNullProperty LocalDateTime pLocalDateTime ) {
    // Assign value to attribute
    localDateTime = pLocalDateTime;
  }

  /**
   * Method returns attribute {@link #localTime}.<br/>
   *
   * @return {@link LocalTime} Value to which {@link #localTime} is set.
   */
  @MyNotNullProperty
  public LocalTime getLocalTime( ) {
    return localTime;
  }

  /**
   * Method sets attribute {@link #localTime}.<br/>
   *
   * @param pLocalTime Value to which {@link #localTime} should be set.
   */
  public void setLocalTime( @MyNotNullProperty LocalTime pLocalTime ) {
    // Assign value to attribute
    localTime = pLocalTime;
  }

  /**
   * Method returns attribute {@link #localDate}.<br/>
   *
   * @return {@link LocalDate} Value to which {@link #localDate} is set.
   */
  @MyNotNullProperty
  public LocalDate getLocalDate( ) {
    return localDate;
  }

  /**
   * Method sets attribute {@link #localDate}.<br/>
   *
   * @param pLocalDate Value to which {@link #localDate} should be set.
   */
  public void setLocalDate( @MyNotNullProperty LocalDate pLocalDate ) {
    // Assign value to attribute
    localDate = pLocalDate;
  }

  /**
   * Method returns attribute {@link #utilDate}.<br/>
   *
   * @return {@link java.util.Date} Value to which {@link #utilDate} is set.
   */
  @MyNotNullProperty
  public java.util.Date getUtilDate( ) {
    return utilDate;
  }

  /**
   * Method sets attribute {@link #utilDate}.<br/>
   *
   * @param pUtilDate Value to which {@link #utilDate} should be set.
   */
  public void setUtilDate( @MyNotNullProperty java.util.Date pUtilDate ) {
    // Assign value to attribute
    utilDate = pUtilDate;
  }

  /**
   * Method returns attribute {@link #calendar}.<br/>
   *
   * @return {@link Calendar} Value to which {@link #calendar} is set.
   */
  @MyNotNullProperty
  public Calendar getCalendar( ) {
    return calendar;
  }

  /**
   * Method sets attribute {@link #calendar}.<br/>
   *
   * @param pCalendar Value to which {@link #calendar} should be set.
   */
  public void setCalendar( @MyNotNullProperty Calendar pCalendar ) {
    // Assign value to attribute
    calendar = pCalendar;
  }

  /**
   * Method returns attribute {@link #sqlTimestamp}.<br/>
   *
   * @return {@link Timestamp} Value to which {@link #sqlTimestamp} is set.
   */
  @MyNotNullProperty
  public Timestamp getSqlTimestamp( ) {
    return sqlTimestamp;
  }

  /**
   * Method sets attribute {@link #sqlTimestamp}.<br/>
   *
   * @param pSqlTimestamp Value to which {@link #sqlTimestamp} should be set.
   */
  public void setSqlTimestamp( @MyNotNullProperty Timestamp pSqlTimestamp ) {
    // Assign value to attribute
    sqlTimestamp = pSqlTimestamp;
  }

  /**
   * Method returns attribute {@link #sqlTime}.<br/>
   *
   * @return {@link Time} Value to which {@link #sqlTime} is set.
   */
  @MyNotNullProperty
  public Time getSqlTime( ) {
    return sqlTime;
  }

  /**
   * Method sets attribute {@link #sqlTime}.<br/>
   *
   * @param pSqlTime Value to which {@link #sqlTime} should be set.
   */
  public void setSqlTime( @MyNotNullProperty Time pSqlTime ) {
    // Assign value to attribute
    sqlTime = pSqlTime;
  }

  /**
   * Method returns attribute {@link #sqlDate}.<br/>
   *
   * @return {@link Date} Value to which {@link #sqlDate} is set.
   */
  @MyNotNullProperty
  public Date getSqlDate( ) {
    return sqlDate;
  }

  /**
   * Method sets attribute {@link #sqlDate}.<br/>
   *
   * @param pSqlDate Value to which {@link #sqlDate} should be set.
   */
  public void setSqlDate( @MyNotNullProperty Date pSqlDate ) {
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