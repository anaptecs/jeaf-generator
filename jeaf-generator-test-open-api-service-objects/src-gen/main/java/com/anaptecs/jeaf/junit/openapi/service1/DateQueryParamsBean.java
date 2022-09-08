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

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class DateQueryParamsBean implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @QueryParam("offsetDateTime")
  @NotNull
  private OffsetDateTime offsetDateTime;

  /**
   * 
   */
  @QueryParam("offsetTime")
  @NotNull
  private OffsetTime offsetTime;

  /**
   * 
   */
  @QueryParam("localDateTime")
  @NotNull
  private LocalDateTime localDateTime;

  /**
   * 
   */
  @QueryParam("localTime")
  @NotNull
  private LocalTime localTime;

  /**
   * 
   */
  @QueryParam("localDate")
  @NotNull
  private LocalDate localDate;

  /**
   * 
   */
  @QueryParam("utilDate")
  @NotNull
  private java.util.Date utilDate;

  /**
   * 
   */
  @QueryParam("calendar")
  @NotNull
  private Calendar calendar;

  /**
   * 
   */
  @QueryParam("sqlTimestamp")
  @NotNull
  private Timestamp sqlTimestamp;

  /**
   * 
   */
  @QueryParam("sqlTime")
  @NotNull
  private Time sqlTime;

  /**
   * 
   */
  @QueryParam("sqlDate")
  @NotNull
  private Date sqlDate;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected DateQueryParamsBean( ) {
    // Nothing to do.
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
   * Class implements builder to create a new instance of class DateQueryParamsBean. As the class has read only
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
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(DateQueryParamsBean)} instead of private constructor to create new builder.
     */
    protected Builder( DateQueryParamsBean pObject ) {
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
     * @return {@link Builder} New builder that can be used to create new DateQueryParamsBean objects. The method never
     * returns null.
     */
    public static Builder newBuilder( DateQueryParamsBean pObject ) {
      return new Builder(pObject);
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
      DateQueryParamsBean lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "offsetDateTime".
   * 
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
   * Method returns the attribute "offsetTime".
   * 
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
   * Method returns the attribute "sqlTimestamp".
   * 
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
   * Method returns the attribute "sqlTime".
   * 
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
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "offsetDateTime", "" + offsetDateTime));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "offsetTime", "" + offsetTime));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "localDateTime", "" + localDateTime));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "localTime", "" + localTime));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "localDate", "" + localDate));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "utilDate", "" + utilDate));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "calendar", "" + calendar));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "sqlTimestamp", "" + sqlTimestamp));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "sqlTime", "" + sqlTime));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "sqlDate", "" + sqlDate));
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
