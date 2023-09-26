/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.spi.ServiceProviderImplementation;
import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.jeaf.RESTRequestExecutorServiceProvider;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.service.DataTypesQueryBean;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.PathlessService;

/**
 * Class implements a service provider that acts as proxy for REST service {@link PathlessService}.
 */
public final class PathlessServiceRESTProxyServiceProviderImpl
    implements ServiceProviderImplementation, PathlessServiceRESTProxyServiceProvider {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  @JEAFServiceProvider
  private RESTRequestExecutorServiceProvider requestExecutor;

  /**
   * Determine configuration of the service provider implementation and initialize httpo client to call REST service.
   */
  @Override
  public void initialize( ) {
    // Nothing to do.
  }

  /**
   * Method checks state of this service provider implementation.
   *
   * @return {@link HealthCheckResult} Result of the check.
   */
  @Override
  public HealthCheckResult check( CheckLevel pLevel ) {
    return null;
  }

  /**
   * @return {@link String}
   */
  @Override
  public String getSomething( ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(PathlessService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("doSomething");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }

  /**
   * @param pHeaderBean
   * @param pTechContext
   */
  @Override
  public void processTechParam( MultiValuedHeaderBeanParam pHeaderBean ) {
    // Create builder for POST request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(PathlessService.class, HttpMethod.POST, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("processTechParam");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Set HTTP header(s)
    if (pHeaderBean != null) {
      if (pHeaderBean.getNames() != null) {
        lRequestBuilder.setHeader("names", pHeaderBean.getNames());
      }
      if (pHeaderBean.getInts() != null) {
        lRequestBuilder.setHeader("ints", pHeaderBean.getInts());
      }
      if (pHeaderBean.getDoubles() != null) {
        lRequestBuilder.setHeader("doubles", pHeaderBean.getDoubles());
      }
      if (pHeaderBean.getCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (StringCode lNext : pHeaderBean.getCodes()) {
          lValues.add(lNext.getCode());
        }
        lRequestBuilder.setHeader("codes", lValues);
      }
      if (pHeaderBean.getStringCodeList() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (StringCode lNext : pHeaderBean.getStringCodeList()) {
          lValues.add(lNext.getCode());
        }
        lRequestBuilder.setHeader("stringCodeList", lValues);
      }
      if (pHeaderBean.getStartDate() != null) {
        lRequestBuilder.setHeader("startDate", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDate.class, String.class).convert(pHeaderBean.getStartDate()));
      }
      if (pHeaderBean.getDates() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LocalDate lNext : pHeaderBean.getDates()) {
          lValues.add(DateTimeFormatter.ISO_DATE.format(lNext));
        }
        lRequestBuilder.setHeader("dates", lValues);
      }
      if (pHeaderBean.getTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LocalDateTime lNext : pHeaderBean.getTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setHeader("timestamps", lValues);
      }
      if (pHeaderBean.getCalendars() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (Calendar lNext : pHeaderBean.getCalendars()) {
          lValues.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(lNext.getTime()));
        }
        lRequestBuilder.setHeader("calendars", lValues);
      }
      if (pHeaderBean.getUtilDates() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (Date lNext : pHeaderBean.getUtilDates()) {
          lValues.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(lNext));
        }
        lRequestBuilder.setHeader("utilDates", lValues);
      }
      if (pHeaderBean.getSqlTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (Timestamp lNext : pHeaderBean.getSqlTimestamps()) {
          lValues.add(lNext.toString());
        }
        lRequestBuilder.setHeader("sqlTimestamps", lValues);
      }
      if (pHeaderBean.getTimeUnits() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (TimeUnit lNext : pHeaderBean.getTimeUnits()) {
          lValues.add(lNext);
        }
        lRequestBuilder.setHeader("timeUnits", lValues);
      }
      if (pHeaderBean.getTimeUnitArray() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (TimeUnit lNext : pHeaderBean.getTimeUnitArray()) {
          lValues.add(lNext);
        }
        lRequestBuilder.setHeader("timeUnitArray", lValues);
      }
      if (pHeaderBean.getBase64() != null) {
        lRequestBuilder.setHeader("base64", pHeaderBean.getBase64());
      }
    }
    // Execute request.
    RESTRequest lRequest = lRequestBuilder.build();
    requestExecutor.executeNoResultRequest(lRequest, 204);
  }

  /**
   * @param pQuery
   * @return {@link String}
   */
  @Override
  public String testQueryBeanParam( DataTypesQueryBean pQuery ) {
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(PathlessService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append('/');
    lPathBuilder.append("test-query-bean-param");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pQuery != null) {
      if (pQuery.getLongCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LongCode lNext : pQuery.getLongCodes()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setQueryParameter("longCodes", lValues);
      }
      if (pQuery.getCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (IntegerCodeType lNext : pQuery.getCodes()) {
          lValues.add(String.valueOf(lNext.getCode()));
        }
        lRequestBuilder.setQueryParameter("codes", lValues);
      }
      if (pQuery.getDoubleCodes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (DoubleCode lNext : pQuery.getDoubleCodes()) {
          lValues.add(lNext.getCode().toString());
        }
        lRequestBuilder.setQueryParameter("doubleCodes", lValues);
      }
      if (pQuery.getBookingIDs() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (BookingID lNext : pQuery.getBookingIDs()) {
          lValues.add(lNext.getBookingID());
        }
        lRequestBuilder.setQueryParameter("bookingIDs", lValues);
      }
      if (pQuery.getBookingIDsArray() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (BookingID lNext : pQuery.getBookingIDsArray()) {
          lValues.add(lNext.getBookingID());
        }
        lRequestBuilder.setQueryParameter("bookingIDsArray", lValues);
      }
      if (pQuery.getOffsetDateTime() != null) {
        lRequestBuilder.setQueryParameter("offsetDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetDateTime.class, String.class).convert(pQuery.getOffsetDateTime()));
      }
      if (pQuery.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime", XFun.getDatatypeConverterRegistry()
            .getConverter(OffsetTime.class, String.class).convert(pQuery.getOffsetTime()));
      }
      if (pQuery.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalDateTime.class, String.class).convert(pQuery.getLocalDateTime()));
      }
      if (pQuery.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", XFun.getDatatypeConverterRegistry()
            .getConverter(LocalTime.class, String.class).convert(pQuery.getLocalTime()));
      }
      if (pQuery.getTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (LocalDateTime lNext : pQuery.getTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setQueryParameter("timestamps", lValues);
      }
      if (pQuery.getTimes() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (OffsetTime lNext : pQuery.getTimes()) {
          lValues.add(DateTimeFormatter.ISO_OFFSET_TIME.format(lNext));
        }
        lRequestBuilder.setQueryParameter("times", lValues);
      }
      if (pQuery.getStartTimestamps() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (OffsetDateTime lNext : pQuery.getStartTimestamps()) {
          lValues.add(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(lNext));
        }
        lRequestBuilder.setQueryParameter("startTimestamps", lValues);
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    return requestExecutor.executeSingleObjectResultRequest(lRequest, 200, String.class);
  }
}
