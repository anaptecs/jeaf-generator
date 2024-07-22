/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.resource;

@org.springframework.web.bind.annotation.RequestMapping(path = "/nova/prefix")
@org.springframework.web.bind.annotation.RestController
public class PathlessServiceReactiveResource {
  /**
   * REST interface makes usage of so called composite data types. As Spring itself is not able to do conversions from a
   * String representation into a real object this is done in the generated REST Controller.
   */
  private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final com.anaptecs.jeaf.validation.api.ValidationExecutor validationExecutor;

  /**
   * All request to this class will be delegated to {@link com.anaptecs.spring.service.PathlessService}.
   */
  private final com.anaptecs.spring.service.PathlessServiceReactive pathlessService;

  /**
   * Initialize object.
   *
   * @param pPathlessService Dependency on concrete {@link com.anaptecs.spring.service.PathlessService} implementation
   * that should be used.
   * @param pCompositeTypeConverter Composite type converter is used convert types from their string representation to a
   * real object that can be processed internally.
   */
  public PathlessServiceReactiveResource( com.anaptecs.spring.service.PathlessServiceReactive pPathlessService,
      com.fasterxml.jackson.databind.ObjectMapper pObjectMapper,
      com.anaptecs.jeaf.validation.api.ValidationExecutor pValidationExecutor ) {
    pathlessService = pPathlessService;
    objectMapper = pObjectMapper;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link com.anaptecs.spring.service.PathlessService#getSomething()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "doSomething",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> getSomething(
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Delegate request to service.
      return pathlessService.getSomething();
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.PathlessServiceReactive.class, lResponse));
  }

  /**
   * {@link com.anaptecs.spring.service.PathlessService#processTechParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "processTechParam",
      method = { org.springframework.web.bind.annotation.RequestMethod.POST })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<Void> processTechParam(
      @org.springframework.web.bind.annotation.RequestHeader(name = "names", required = false) String[] pNames,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "ints",
          required = true) @com.anaptecs.annotations.MyNotEmptyRESTParam int[] pInts,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "doubles",
          required = false) java.lang.Double[] pDoubles,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "codes",
          required = false) String[] pCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "stringCodeList",
          required = false) String[] pStringCodeListAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "startDate",
          required = false) String pStartDateAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "dates",
          required = false) String[] pDatesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timestamps",
          required = false) String[] pTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "calendars",
          required = false) String[] pCalendarsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "utilDates",
          required = false) String[] pUtilDatesAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "sqlTimestamps",
          required = false) String[] pSqlTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timeUnits",
          required = false) java.util.Set<com.anaptecs.spring.base.TimeUnit> pTimeUnits,
      @org.springframework.web.bind.annotation.RequestHeader(
          name = "timeUnitArray",
          required = false) com.anaptecs.spring.base.TimeUnit[] pTimeUnitArray,
      @org.springframework.web.bind.annotation.RequestHeader(name = "base64", required = false) String pBase64,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.MultiValuedHeaderBeanParam.Builder lHeaderBeanBuilder =
        com.anaptecs.spring.service.MultiValuedHeaderBeanParam.builder();
    lHeaderBeanBuilder.setNames(pNames);
    lHeaderBeanBuilder.setInts(pInts);
    lHeaderBeanBuilder.setDoubles(pDoubles);
    // Handle bean parameter pHeaderBean.codes
    if (pCodesAsBasicType != null) {
      com.anaptecs.spring.base.StringCode[] lCodes = new com.anaptecs.spring.base.StringCode[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = com.anaptecs.spring.base.StringCode.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lHeaderBeanBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pHeaderBean.stringCodeList
    if (pStringCodeListAsBasicType != null) {
      java.util.Set<com.anaptecs.spring.base.StringCode> lStringCodeList =
          new java.util.HashSet<com.anaptecs.spring.base.StringCode>();
      for (String lNext : pStringCodeListAsBasicType) {
        lStringCodeList.add(com.anaptecs.spring.base.StringCode.builder().setCode(lNext).build());
      }
      lHeaderBeanBuilder.setStringCodeList(lStringCodeList);
    }
    // Handle bean parameter pHeaderBean.startDate
    if (pStartDateAsBasicType != null) {
      lHeaderBeanBuilder.setStartDate(java.time.LocalDate.parse(pStartDateAsBasicType));
    }
    // Handle bean parameter pHeaderBean.dates
    if (pDatesAsBasicType != null) {
      java.time.LocalDate[] lDates = new java.time.LocalDate[pDatesAsBasicType.length];
      for (int i = 0; i < pDatesAsBasicType.length; i++) {
        lDates[i] = java.time.LocalDate.parse(pDatesAsBasicType[i]);
      }
      lHeaderBeanBuilder.setDates(lDates);
    }
    // Handle bean parameter pHeaderBean.timestamps
    if (pTimestampsAsBasicType != null) {
      java.util.Set<java.time.LocalDateTime> lTimestamps = new java.util.HashSet<java.time.LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(java.time.LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lHeaderBeanBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pHeaderBean.calendars
    if (pCalendarsAsBasicType != null) {
      try {
        java.util.Calendar[] lCalendars = new java.util.Calendar[pCalendarsAsBasicType.length];
        for (int i = 0; i < pCalendarsAsBasicType.length; i++) {
          java.text.SimpleDateFormat lDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pCalendarsAsBasicType[i]);
          java.util.Calendar lCalendar = java.util.Calendar.getInstance();
          lCalendar.setTime(lDate);
          lCalendars[i] = lCalendar;
        }
        lHeaderBeanBuilder.setCalendars(lCalendars);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderBean.utilDates
    if (pUtilDatesAsBasicType != null) {
      try {
        java.util.Date[] lUtilDates = new java.util.Date[pUtilDatesAsBasicType.length];
        for (int i = 0; i < pUtilDatesAsBasicType.length; i++) {
          java.text.SimpleDateFormat lDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
          java.util.Date lDate = lDateFormat.parse(pUtilDatesAsBasicType[i]);
          lUtilDates[i] = lDate;
        }
        lHeaderBeanBuilder.setUtilDates(lUtilDates);
      }
      catch (java.text.ParseException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
    // Handle bean parameter pHeaderBean.sqlTimestamps
    if (pSqlTimestampsAsBasicType != null) {
      java.sql.Timestamp[] lSqlTimestamps = new java.sql.Timestamp[pSqlTimestampsAsBasicType.length];
      for (int i = 0; i < pSqlTimestampsAsBasicType.length; i++) {
        lSqlTimestamps[i] = java.sql.Timestamp.valueOf(pSqlTimestampsAsBasicType[i]);
      }
      lHeaderBeanBuilder.setSqlTimestamps(lSqlTimestamps);
    }
    lHeaderBeanBuilder.setTimeUnits(pTimeUnits);
    lHeaderBeanBuilder.setTimeUnitArray(pTimeUnitArray);
    // Decode base64 encoded String back to byte[]
    if (pBase64 != null) {
      lHeaderBeanBuilder.setBase64(java.util.Base64.getDecoder().decode(pBase64));
    }
    com.anaptecs.spring.service.MultiValuedHeaderBeanParam pHeaderBean = lHeaderBeanBuilder.build();
    com.anaptecs.spring.service.TechOnlyBeanParam.Builder lTechContextBuilder =
        com.anaptecs.spring.service.TechOnlyBeanParam.builder();
    com.anaptecs.spring.service.TechOnlyBeanParam pTechContext = lTechContextBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.PathlessServiceReactive.class, pHeaderBean);
      // Delegate request to service.
      return pathlessService.processTechParam(pHeaderBean);
    });
  }

  /**
   * {@link com.anaptecs.spring.service.PathlessService#testQueryBeanParam()}
   */
  @org.springframework.security.access.prepost.PreAuthorize("hasAnyRole('NO_ACCESS')")
  @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.OK)
  @org.springframework.web.bind.annotation.RequestMapping(
      path = "test-query-bean-param",
      method = { org.springframework.web.bind.annotation.RequestMethod.GET })
  @com.anaptecs.annotations.MyNotNullRESTParam
  public reactor.core.publisher.Mono<String> testQueryBeanParam(
      @org.springframework.web.bind.annotation.RequestParam(
          name = "longCodes",
          required = false) java.lang.Long[] pLongCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(name = "codes", required = false) int[] pCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "doubleCodes",
          required = false) java.lang.Double[] pDoubleCodesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingIDs",
          required = false) String[] pBookingIDsAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "bookingIDsArray",
          required = false) String[] pBookingIDsArrayAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "offsetDateTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "offsetTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pOffsetTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localDateTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalDateTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "localTime",
          required = true) @com.anaptecs.annotations.MyNotNullRESTParam String pLocalTimeAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "timestamps",
          required = false) String[] pTimestampsAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "times",
          required = false) String[] pTimesAsBasicType,
      @org.springframework.web.bind.annotation.RequestParam(
          name = "startTimestamps",
          required = false) String[] pStartTimestampsAsBasicType,
      org.springframework.web.server.ServerWebExchange pServerWebExchange ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    com.anaptecs.spring.service.DataTypesQueryBean.Builder lQueryBuilder =
        com.anaptecs.spring.service.DataTypesQueryBean.builder();
    // Handle bean parameter pQuery.longCodes
    if (pLongCodesAsBasicType != null) {
      com.anaptecs.spring.base.LongCode[] lLongCodes =
          new com.anaptecs.spring.base.LongCode[pLongCodesAsBasicType.length];
      for (int i = 0; i < pLongCodesAsBasicType.length; i++) {
        lLongCodes[i] = com.anaptecs.spring.base.LongCode.builder().setCode(pLongCodesAsBasicType[i]).build();
      }
      lQueryBuilder.setLongCodes(lLongCodes);
    }
    // Handle bean parameter pQuery.codes
    if (pCodesAsBasicType != null) {
      com.anaptecs.spring.base.IntegerCodeType[] lCodes =
          new com.anaptecs.spring.base.IntegerCodeType[pCodesAsBasicType.length];
      for (int i = 0; i < pCodesAsBasicType.length; i++) {
        lCodes[i] = com.anaptecs.spring.base.IntegerCodeType.builder().setCode(pCodesAsBasicType[i]).build();
      }
      lQueryBuilder.setCodes(lCodes);
    }
    // Handle bean parameter pQuery.doubleCodes
    if (pDoubleCodesAsBasicType != null) {
      java.util.Set<com.anaptecs.spring.base.DoubleCode> lDoubleCodes =
          new java.util.HashSet<com.anaptecs.spring.base.DoubleCode>();
      for (java.lang.Double lNext : pDoubleCodesAsBasicType) {
        lDoubleCodes.add(com.anaptecs.spring.base.DoubleCode.builder().setCode(lNext).build());
      }
      lQueryBuilder.setDoubleCodes(lDoubleCodes);
    }
    // Handle bean parameter pQuery.bookingIDs
    if (pBookingIDsAsBasicType != null) {
      // Handle bean parameter pQuery.bookingIDs
      java.util.Set<com.anaptecs.spring.base.BookingID> lBookingIDs =
          new java.util.HashSet<com.anaptecs.spring.base.BookingID>();
      for (String lNext : pBookingIDsAsBasicType) {
        lBookingIDs.add(this.deserializeCompositeDataType(lNext, com.anaptecs.spring.base.BookingID.class));
      }
      lQueryBuilder.setBookingIDs(lBookingIDs);
    }
    // Handle bean parameter pQuery.bookingIDsArray
    if (pBookingIDsArrayAsBasicType != null) {
      // Handle bean parameter pQuery.bookingIDsArray
      com.anaptecs.spring.base.BookingID[] lBookingIDsArray =
          new com.anaptecs.spring.base.BookingID[pBookingIDsArrayAsBasicType.length];
      for (int i = 0; i < pBookingIDsArrayAsBasicType.length; i++) {
        lBookingIDsArray[i] =
            this.deserializeCompositeDataType(pBookingIDsArrayAsBasicType[i], com.anaptecs.spring.base.BookingID.class);
      }
      lQueryBuilder.setBookingIDsArray(lBookingIDsArray);
    }
    // Handle bean parameter pQuery.offsetDateTime
    if (pOffsetDateTimeAsBasicType != null) {
      lQueryBuilder.setOffsetDateTime(java.time.OffsetDateTime.parse(pOffsetDateTimeAsBasicType));
    }
    // Handle bean parameter pQuery.offsetTime
    if (pOffsetTimeAsBasicType != null) {
      lQueryBuilder.setOffsetTime(java.time.OffsetTime.parse(pOffsetTimeAsBasicType));
    }
    // Handle bean parameter pQuery.localDateTime
    if (pLocalDateTimeAsBasicType != null) {
      lQueryBuilder.setLocalDateTime(java.time.LocalDateTime.parse(pLocalDateTimeAsBasicType));
    }
    // Handle bean parameter pQuery.localTime
    if (pLocalTimeAsBasicType != null) {
      lQueryBuilder.setLocalTime(java.time.LocalTime.parse(pLocalTimeAsBasicType));
    }
    // Handle bean parameter pQuery.timestamps
    if (pTimestampsAsBasicType != null) {
      java.util.List<java.time.LocalDateTime> lTimestamps = new java.util.ArrayList<java.time.LocalDateTime>();
      for (int i = 0; i < pTimestampsAsBasicType.length; i++) {
        lTimestamps.add(java.time.LocalDateTime.parse(pTimestampsAsBasicType[i]));
      }
      lQueryBuilder.setTimestamps(lTimestamps);
    }
    // Handle bean parameter pQuery.times
    if (pTimesAsBasicType != null) {
      java.util.Set<java.time.OffsetTime> lTimes = new java.util.HashSet<java.time.OffsetTime>();
      for (int i = 0; i < pTimesAsBasicType.length; i++) {
        lTimes.add(java.time.OffsetTime.parse(pTimesAsBasicType[i]));
      }
      lQueryBuilder.setTimes(lTimes);
    }
    // Handle bean parameter pQuery.startTimestamps
    if (pStartTimestampsAsBasicType != null) {
      java.time.OffsetDateTime[] lStartTimestamps = new java.time.OffsetDateTime[pStartTimestampsAsBasicType.length];
      for (int i = 0; i < pStartTimestampsAsBasicType.length; i++) {
        lStartTimestamps[i] = java.time.OffsetDateTime.parse(pStartTimestampsAsBasicType[i]);
      }
      lQueryBuilder.setStartTimestamps(lStartTimestamps);
    }
    com.anaptecs.spring.service.DataTypesQueryBean pQuery = lQueryBuilder.build();
    return reactor.core.publisher.Mono.defer(( ) -> {
      // Validate request parameter(s).
      validationExecutor.validateRequest(com.anaptecs.spring.service.PathlessServiceReactive.class, pQuery);
      // Delegate request to service.
      return pathlessService.testQueryBeanParam(pQuery);
    }).doOnNext(lResponse ->
    // Validate response.
    validationExecutor.validateResponse(com.anaptecs.spring.service.PathlessServiceReactive.class, lResponse));
  }

  /**
   * Method is used to deserialize composite data types that are passed as some kind of parameter (not body) to this
   * class. They need to be deserialized in the generated code as this is not supported by the used REST framework.
   *
   * @param pCompositeDataTypeAsString String representation of the composite data type. The parameter may be null.
   * @param pType Type of which the returned objects is supposed to be. The parameter must not be null.
   * @return T Instance of the expected type or null if <code>pCompositeDataTypeAsString</code> is null.
   */
  private <T> T deserializeCompositeDataType( String pCompositeDataTypeAsString, java.lang.Class<T> pType ) {
    try {
      T lObject;
      if (pCompositeDataTypeAsString != null) {
        java.lang.StringBuilder lBuilder = new StringBuilder(pCompositeDataTypeAsString.length() + 4);
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
    catch (com.fasterxml.jackson.core.JsonProcessingException e) {
      throw new IllegalArgumentException("Unable to deserialize composite data type " + pType.getName()
          + " from String '" + pCompositeDataTypeAsString + "'. Details: " + e.getMessage(), e);
    }
  }
}
