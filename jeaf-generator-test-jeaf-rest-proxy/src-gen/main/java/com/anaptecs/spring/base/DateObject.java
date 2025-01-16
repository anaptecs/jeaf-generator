/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateObject implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

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
   * <b>Example(s):</b> <br/>
   * <ul>
   * <li><code>12:07</code></li>
   * </ul>
   */
  private LocalTime localTime;

  private LocalDate localDate;

  private LocalDateTime localDateTime;

  private Calendar calendar;

  private Date sqlDate;

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
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
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
   * Method creates a new builder and initializes it with the passed attributes.
   */
  public static Builder builder( LocalTime pLocalTime, LocalDate pLocalDate, LocalDateTime pLocalDateTime,
      Calendar pCalendar, Date pSqlDate, java.util.Date pUtilDate ) {
    Builder lBuilder = builder();
    lBuilder.setLocalTime(pLocalTime);
    lBuilder.setLocalDate(pLocalDate);
    lBuilder.setLocalDateTime(pLocalDateTime);
    lBuilder.setCalendar(pCalendar);
    lBuilder.setSqlDate(pSqlDate);
    lBuilder.setUtilDate(pUtilDate);
    return lBuilder;
  }

  /**
   * Convenience method to create new instance of class DateObject.
   *
   *
   * @param pLocalTime Value to which {@link #localTime} should be set.
   *
   * @param pLocalDate Value to which {@link #localDate} should be set.
   *
   * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
   *
   * @param pCalendar Value to which {@link #calendar} should be set.
   *
   * @param pSqlDate Value to which {@link #sqlDate} should be set.
   *
   * @param pUtilDate Value to which {@link #utilDate} should be set.
   *
   * @return {@link com.anaptecs.spring.base.DateObject}
   */
  public static DateObject of( LocalTime pLocalTime, LocalDate pLocalDate, LocalDateTime pLocalDateTime,
      Calendar pCalendar, Date pSqlDate, java.util.Date pUtilDate ) {
    DateObject.Builder lBuilder = DateObject.builder();
    lBuilder.setLocalTime(pLocalTime);
    lBuilder.setLocalDate(pLocalDate);
    lBuilder.setLocalDateTime(pLocalDateTime);
    lBuilder.setCalendar(pCalendar);
    lBuilder.setSqlDate(pSqlDate);
    lBuilder.setUtilDate(pUtilDate);
    return lBuilder.build();
  }

  /**
   * Class implements builder to create a new instance of class <code>DateObject</code>.
   */
  public static class Builder {
    /**
     * <br/>
     * <b>Example(s):</b> <br/>
     * <ul>
     * <li><code>12:07</code></li>
     * </ul>
     */
    private LocalTime localTime;

    private LocalDate localDate;

    private LocalDateTime localDateTime;

    private Calendar calendar;

    private Date sqlDate;

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
        this.setLocalTime(pObject.localTime);
        this.setLocalDate(pObject.localDate);
        this.setLocalDateTime(pObject.localDateTime);
        this.setCalendar(pObject.calendar);
        this.setSqlDate(pObject.sqlDate);
        this.setUtilDate(pObject.utilDate);
      }
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

    /**
     * Method sets attribute {@link #localDateTime}.<br/>
     *
     * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setLocalDateTime( LocalDateTime pLocalDateTime ) {
      // Assign value to attribute
      localDateTime = pLocalDateTime;
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

    /**
     * Method creates a new instance of class DateObject. The object will be initialized with the values of the builder.
     *
     * @return DateObject Created object. The method never returns null.
     */
    public DateObject build( ) {
      return new DateObject(this);
    }

    /**
     * Method creates a new validated instance of class DateObject. The object will be initialized with the values of
     * the builder and validated afterwards.
     *
     * @return DateObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public DateObject buildValidated( ) throws ConstraintViolationException {
      DateObject lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
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

  /**
   * Method returns attribute {@link #localDateTime}.<br/>
   *
   * @return {@link LocalDateTime} Value to which {@link #localDateTime} is set.
   */
  public LocalDateTime getLocalDateTime( ) {
    return localDateTime;
  }

  /**
   * Method sets attribute {@link #localDateTime}.<br/>
   *
   * @param pLocalDateTime Value to which {@link #localDateTime} should be set.
   */
  public void setLocalDateTime( LocalDateTime pLocalDateTime ) {
    // Assign value to attribute
    localDateTime = pLocalDateTime;
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

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new DateObject objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}