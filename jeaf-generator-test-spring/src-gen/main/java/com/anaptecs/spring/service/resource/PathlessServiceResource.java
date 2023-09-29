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
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
import com.anaptecs.spring.service.TechOnlyBeanParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(path = "/nova/prefix")
@RestController
public class PathlessServiceResource {
  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  private final ObjectMapper objectMapper;

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
   * @param pCompositeTypeConverter Composite type converter is used convert types from their string representation to a
   * real object that can be processed internally.
   */
  public PathlessServiceResource( PathlessService pPathlessService, ObjectMapper pObjectMapper,
      ValidationExecutor pValidationExecutor ) {
    pathlessService = pPathlessService;
    objectMapper = pObjectMapper;
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
      @RequestHeader(name = "sqlTimestamps", required = false) String[] pSqlTimestampsAsBasicType,
      @RequestHeader(name = "timeUnits", required = false) Set<TimeUnit> pTimeUnits,
      @RequestHeader(name = "timeUnitArray", required = false) TimeUnit[] pTimeUnitArray,
      @RequestHeader(name = "base64", required = false) String pBase64 ) {
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
    lHeaderBeanBuilder.setTimeUnits(pTimeUnits);
    lHeaderBeanBuilder.setTimeUnitArray(pTimeUnitArray);
    // Decode base64 encoded String back to byte[]
    if (pBase64 != null) {
      lHeaderBeanBuilder.setBase64(Base64.getDecoder().decode(pBase64));
    }
    MultiValuedHeaderBeanParam pHeaderBean = lHeaderBeanBuilder.build();
    TechOnlyBeanParam.Builder lTechContextBuilder = TechOnlyBeanParam.builder();
    TechOnlyBeanParam pTechContext = lTechContextBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(PathlessService.class, pHeaderBean);
    // Delegate request to service.
    pathlessService.processTechParam(pHeaderBean);
  }

  /**
   * {@link PathlessService#testQueryBeanParam()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "test-query-bean-param", method = { RequestMethod.GET })
  public String testQueryBeanParam( @RequestParam(name = "longCodes", required = false) Long[] pLongCodesAsBasicType,
      @RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @RequestParam(name = "doubleCodes", required = false) Double[] pDoubleCodesAsBasicType,
      @RequestParam(name = "bookingIDs", required = false) String[] pBookingIDsAsBasicType,
      @RequestParam(name = "bookingIDsArray", required = false) String[] pBookingIDsArrayAsBasicType,
      @RequestParam(name = "offsetDateTime", required = true) String pOffsetDateTimeAsBasicType,
      @RequestParam(name = "offsetTime", required = true) String pOffsetTimeAsBasicType,
      @RequestParam(name = "localDateTime", required = true) String pLocalDateTimeAsBasicType,
      @RequestParam(name = "localTime", required = true) String pLocalTimeAsBasicType,
      @RequestParam(name = "timestamps", required = false) String[] pTimestampsAsBasicType,
      @RequestParam(name = "times", required = false) String[] pTimesAsBasicType,
      @RequestParam(name = "startTimestamps", required = false) String[] pStartTimestampsAsBasicType ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DataTypesQueryBean.Builder lQueryBuilder = DataTypesQueryBean.builder();
    // Handle bean parameter pQuery.longCodes
    if (pLongCodesAsBasicType != null) {
      LongCode[] lLongCodes = new LongCode[pLongCodesAsBasicType.length];
      for (int i = 0; i < pLongCodesAsBasicType.length; i++) {
        lLongCodes[i] = LongCode.builder().setCode(pLongCodesAsBasicType[i]).build();
      }
      lQueryBuilder.setLongCodes(lLongCodes);
    }
    // Handle bean parameter pQuery.codes
    if (pCodesAsBasicType != null) {
      IntegerCodeType[] lCodes = new IntegerCodeType[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = IntegerCodeType.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lQueryBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pQuery.doubleCodes
    if (pDoubleCodesAsBasicType != null) {
      Set<DoubleCode> lDoubleCodes = new HashSet<DoubleCode>();
      for (Double lNext : pDoubleCodesAsBasicType) {
        lDoubleCodes.add(DoubleCode.builder().setCode(lNext).build());
      }
      lQueryBuilder.setDoubleCodes(lDoubleCodes);
    }
    // Handle bean parameter pQuery.bookingIDs
    if (pBookingIDsAsBasicType != null) {
      // Handle bean parameter pQuery.bookingIDs
      Set<BookingID> lBookingIDs = new HashSet<BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        lBookingIDs.add(this.deserializeCompositeDataType(lNext, BookingID.class));
      }
      lQueryBuilder.setBookingIDs(lBookingIDs);
    }
    // Handle bean parameter pQuery.bookingIDsArray
    if (pBookingIDsArrayAsBasicType != null) {
      // Handle bean parameter pQuery.bookingIDsArray
      BookingID[] lBookingIDsArray = new BookingID[pBookingIDsArrayAsBasicType.length];
      for (int i = 0; i < pBookingIDsArrayAsBasicType.length; i++) {
        lBookingIDsArray[i] = this.deserializeCompositeDataType(pBookingIDsArrayAsBasicType[i], BookingID.class);
      }
      lQueryBuilder.setBookingIDsArray(lBookingIDsArray);
    }
    // Handle bean parameter pQuery.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lQueryBuilder.setOffsetDateTime(OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pQuery.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lQueryBuilder.setOffsetTime(OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pQuery.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lQueryBuilder.setLocalDateTime(LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pQuery.localTime
    if (pLocalTimeAsBasicType != null) {
      lQueryBuilder.setLocalTime(LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pQuery.timestamps
    if (pTimestampsAsBasicType != null) {
      List<LocalDateTime> lTimestamps = new ArrayList<LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lQueryBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pQuery.times
    if (pTimesAsBasicType != null) {
      Set<OffsetTime> lTimes = new HashSet<OffsetTime>();
      for (int i = 0; i < pTimesAsBasicType.length; i++) {
        lTimes.add(OffsetTime.parse(pTimesAsBasicType[i]));
      }
      lQueryBuilder.setTimes(lTimes);
    }
    // Handle bean parameter pQuery.startTimestamps
    if (pStartTimestampsAsBasicType != null) {
      OffsetDateTime[] lStartTimestamps = new OffsetDateTime[pStartTimestampsAsBasicType.length];
      for (int i = 0; i < pStartTimestampsAsBasicType.length; i++) {
        lStartTimestamps[i] = OffsetDateTime.parse(pStartTimestampsAsBasicType[i]);
      }
      lQueryBuilder.setStartTimestamps(lStartTimestamps);
    }
    DataTypesQueryBean pQuery = lQueryBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(PathlessService.class, pQuery);
    // Delegate request to service.
    String lResponse = pathlessService.testQueryBeanParam(pQuery);
    // Validate response and return it.
    validationExecutor.validateResponse(PathlessService.class, lResponse);
    return lResponse;
  }

  /**
   * Method is used to deserialize composite data types that are passed as some kind of parameter (not body) to this
   * class. They need to be deserialized in the generated code as this is not supported by the used REST framework.
   *
   * @param pCompositeDataTypeAsString String representation of the composite data type. The parameter may be null.
   * @param pType Type of which the returned objects is supposed to be. The parameter must not be null.
   * @return T Instance of the expected type or null if <code>pCompositeDataTypeAsString</code> is null.
   */
  private <T> T deserializeCompositeDataType( String pCompositeDataTypeAsString, Class<T> pType ) {
    try {
      T lObject;
      if (pCompositeDataTypeAsString != null) {
        StringBuilder lBuilder = new StringBuilder(pCompositeDataTypeAsString.length() + 4);
        lBuilder.append("\"");
        lBuilder.append(pCompositeDataTypeAsString);
        lBuilder.append("\"");
        lObject = objectMapper.readValue(lBuilder.toString(), pType);
      }
      else {
        lObject = null;
      }
      return lObject;
    }
    catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Unable to deserialize composite data type " + pType.getName()
          + " from String '" + pCompositeDataTypeAsString + "'. Details: " + e.getMessage(), e);
    }
  }
}
