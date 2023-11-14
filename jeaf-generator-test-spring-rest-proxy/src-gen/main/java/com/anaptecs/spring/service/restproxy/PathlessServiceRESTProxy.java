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
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.RESTRequestExecutor;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;
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
 * Class implements a proxy for REST Service {@link PathlessService}. The proxy is implemented as Spring services. This
 * way to developers it looks like a plain Spring Service.
 *
 * This implementation deals with everything that is required to call the external REST service including the following
 * things:
 * <ul>
 * <li>Serialization / deserialization between Java and JSON</li>
 * <li>Proper connection pooling and timeouts for HTTP requests</li>
 * <li>Proper setting of HTTP header</li>
 * <li>Circuit breaker in case of availabilities problems of the REST service</li>
 * </ul>
 *
 * However, as an transactional context can not be propagated to another REST resource developers still have to take
 * care about proper transaction handling if needed.
 */
@Service
public class PathlessServiceRESTProxy implements PathlessService {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  private final RESTRequestExecutor requestExecutor;

  /**
   * REST Service Proxy was generated with request / response validation enabled. The actual validation will be
   * delegated to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * Initialize object.
   *
   * @param pRequestExecutor Dependency on concrete {@link RESTRequestExecutor} implementation that should be used.
   */
  public PathlessServiceRESTProxy( RESTRequestExecutor pRequestExecutor, ValidationExecutor pValidationExecutor ) {
    requestExecutor = pRequestExecutor;
    validationExecutor = pValidationExecutor;
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
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResult);
    return lResult;
  }

  /**
   * @param pHeaderBean
   * @param pTechContext
   */
  @Override
  public void processTechParam( MultiValuedHeaderBeanParam pHeaderBean ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(PathlessService.class, pHeaderBean);
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
        lRequestBuilder.setHeader("startDate", DateTimeFormatter.ISO_DATE.format(pHeaderBean.getStartDate()));
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
    // Validate request parameter(s).
    validationExecutor.validateRequest(PathlessService.class, pQuery);
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
        lRequestBuilder.setQueryParameter("offsetDateTime",
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pQuery.getOffsetDateTime()));
      }
      if (pQuery.getOffsetTime() != null) {
        lRequestBuilder.setQueryParameter("offsetTime",
            DateTimeFormatter.ISO_OFFSET_TIME.format(pQuery.getOffsetTime()));
      }
      if (pQuery.getLocalDateTime() != null) {
        lRequestBuilder.setQueryParameter("localDateTime",
            DateTimeFormatter.ISO_DATE_TIME.format(pQuery.getLocalDateTime()));
      }
      if (pQuery.getLocalTime() != null) {
        lRequestBuilder.setQueryParameter("localTime", DateTimeFormatter.ISO_TIME.format(pQuery.getLocalTime()));
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
    ObjectType lObjectType = ObjectType.createObjectType(String.class);
    String lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResult);
    return lResult;
  }
}
