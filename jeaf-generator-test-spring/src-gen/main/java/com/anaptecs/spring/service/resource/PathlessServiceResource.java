/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.jeaf.validation.api.ValidationExecutor;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.service.MultiValuedHeaderBeanParam;
import com.anaptecs.spring.service.PathlessService;
import com.anaptecs.spring.service.TechOnlyBeanParam;

@RequestMapping(path = "/nova/prefix")
@RestController
public class PathlessServiceResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * All request to this class will be delegated to {@link PathlessService}.
   */
  private final PathlessService pathlessService;

  /**
   * Initialize object.
   *
   * @param pPathlessService Dependency on concrete {@link PathlessService} implementation that should be used.
   */
  public PathlessServiceResource( PathlessService pPathlessService, ValidationExecutor pValidationExecutor ) {
    pathlessService = pPathlessService;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link PathlessService#getSomething()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "doSomething", method = { RequestMethod.GET })
  public String getSomething( ) {
    // Delegate request to service.
    String lResponse = pathlessService.getSomething();
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link PathlessService#processTechParam()}
   */
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(path = "processTechParam", method = { RequestMethod.POST })
  public void processTechParam( @RequestHeader(name = "names", required = false) String[] pNames,
      @RequestHeader(name = "ints", required = true) int[] pInts,
      @RequestHeader(name = "doubles", required = false) Double[] pDoubles,
      @RequestHeader(name = "codes", required = false) String[] pCodesAsBasicType,
      @RequestHeader(name = "stringCodeList", required = false) String[] pStringCodeListAsBasicType,
      @RequestHeader(name = "startDate", required = false) String pStartDateAsBasicType,
      @RequestHeader(name = "dates", required = false) String[] pDatesAsBasicType,
      @RequestHeader(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestHeader(name = "calendars", required = false) String[] pCalendarsAsBasicType,
      @RequestHeader(name = "utilDates", required = false) String[] pUtilDatesAsBasicType,
      @RequestHeader(name = "sqlTimestamps", required = false) String[] pSqlTimestampsAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    MultiValuedHeaderBeanParam.Builder lHeaderBeanBuilder = MultiValuedHeaderBeanParam.builder();
    lHeaderBeanBuilder.setNames(pNames);
    lHeaderBeanBuilder.setInts(pInts);
    lHeaderBeanBuilder.setDoubles(pDoubles);
    // Handle bean parameter pHeaderBean.codes
    if (pCodesAsBasicType != null) {
      StringCode[] lCodes = new StringCode[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = StringCode.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lHeaderBeanBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pHeaderBean.stringCodeList
    if (pStringCodeListAsBasicType != null) {
      Set<StringCode> lStringCodeList = new HashSet<StringCode>();
      for (String lNext : pStringCodeListAsBasicType) {
        lStringCodeList.add(StringCode.builder().setCode(lNext).build());
      }
      lHeaderBeanBuilder.setStringCodeList(lStringCodeList);
    }
    // Handle bean parameter pHeaderBean.startDate
    if (pStartDateAsBasicType != null) {
      lHeaderBeanBuilder.setStartDate(LocalDate.parse(pStartDateAsBasicType));
    }
    // Handle bean parameter pHeaderBean.dates
    if (pDatesAsBasicType != null) {
      LocalDate[] lDates = new LocalDate[pDatesAsBasicType.length];
      for (int i = 0; i < pDatesAsBasicType.length; i++) {
        lDates[i] = LocalDate.parse(pDatesAsBasicType[i]);
      }
      lHeaderBeanBuilder.setDates(lDates);
    }
    // Handle bean parameter pHeaderBean.timestamps
    if (pTimestampsAsBasicType != null) {
      Set<LocalDateTime> lTimestamps = new HashSet<LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lHeaderBeanBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pHeaderBean.calendars
    if (pCalendarsAsBasicType != null) {
      try {
        Calendar[] lCalendars = new Calendar[pCalendarsAsBasicType.length];
        for (int i = 0; i < pCalendarsAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          Date lDate = lDateFormat.parse(pCalendarsAsBasicType[i]);
          Calendar lCalendar = Calendar.getInstance();
          lCalendar.setTime(lDate);
          lCalendars[i] = lCalendar;
        }
        lHeaderBeanBuilder.setCalendars(lCalendars);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderBean.utilDates
    if (pUtilDatesAsBasicType != null) {
      try {
        Date[] lUtilDates = new Date[pUtilDatesAsBasicType.length];
        for (int i = 0; i < pUtilDatesAsBasicType.length; i++) {
          SimpleDateFormat lDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          Date lDate = lDateFormat.parse(pUtilDatesAsBasicType[i]);
          lUtilDates[i] = lDate;
        }
        lHeaderBeanBuilder.setUtilDates(lUtilDates);
      }
      catch (ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderBean.sqlTimestamps
    if (pSqlTimestampsAsBasicType != null) {
      Timestamp[] lSqlTimestamps = new Timestamp[pSqlTimestampsAsBasicType.length];
      for (int i = 0; i < pSqlTimestampsAsBasicType.length; i++) {
        lSqlTimestamps[i] = Timestamp.valueOf(pSqlTimestampsAsBasicType[i]);
      }
      lHeaderBeanBuilder.setSqlTimestamps(lSqlTimestamps);
    }
    MultiValuedHeaderBeanParam pHeaderBean = lHeaderBeanBuilder.build();
    TechOnlyBeanParam.Builder lTechContextBuilder = TechOnlyBeanParam.builder();
    TechOnlyBeanParam pTechContext = lTechContextBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(PathlessService.class, pHeaderBean);
    // Delegate request to service.
    pathlessService.processTechParam(pHeaderBean);
  }
}
