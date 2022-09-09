/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.TimeUnit;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@RequestMapping(path = "/rest-products", consumes = { "application/json" }, produces = { "application/json" })
@RestController
public class RESTProductServiceResource {
  @Inject
  private RESTProductService rESTProductService;

  /**
   * {@link RESTProductService#getProducts()}
   */
  @RequestMapping(method = { RequestMethod.GET })
  public List<Product> getProducts( @RequestParam(name = "maxResult", required = true) int pMaxResultSize ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.getProducts(pMaxResultSize);
  }

  /**
   * {@link RESTProductService#getProduct()}
   */
  @RequestMapping(path = "{id}", method = { RequestMethod.GET })
  public Product getProduct( @PathVariable(name = "id", required = true) String pProductID ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.getProduct(pProductID);
  }

  /**
   * {@link RESTProductService#createProduct()}
   */
  @RequestMapping(method = { RequestMethod.POST })
  public boolean createProduct( @RequestBody(required = true) Product pProduct ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.createProduct(pProduct);
  }

  /**
   * {@link RESTProductService#getSortiment()}
   */
  @RequestMapping(path = "sortiment/{id}", method = { RequestMethod.GET })
  public Sortiment getSortiment( @RequestHeader(name = "token", required = true) String pAccessToken,
      @RequestHeader(name = "lang", required = true) Locale pLanguage,
      @CookieValue(name = "reseller", required = true) long pResellerID,
      @PathVariable(name = "id", required = true) long pPathParam,
      @RequestParam(name = "q1", required = true) String pQueryParam ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    Context.Builder lBuilder = Context.Builder.newBuilder();
    lBuilder.setAccessToken(pAccessToken);
    lBuilder.setLanguage(pLanguage);
    lBuilder.setResellerID(pResellerID);
    lBuilder.setPathParam(pPathParam);
    lBuilder.setQueryParam(pQueryParam);
    Context pContext = lBuilder.build();
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.getSortiment(pContext);
  }

  /**
   * {@link RESTProductService#createChannelCode()}
   */
  @RequestMapping(path = "ChannelCode", method = { RequestMethod.POST })
  public ChannelCode createChannelCode( @RequestBody(required = true) String pChannelCode ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.createChannelCode(pChannelCode);
  }

  /**
   * {@link RESTProductService#ping()}
   */
  @RequestMapping(method = { RequestMethod.HEAD })
  public void ping( ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.ping();
  }

  /**
   * {@link RESTProductService#testInit()}
   */
  @RequestMapping(path = "test-init", method = { RequestMethod.GET })
  public void testInit( ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testInit();
  }

  /**
   * {@link RESTProductService#getSupportedCurrencies()}
   */
  @RequestMapping(path = "currencies/{channelCode}", method = { RequestMethod.GET })
  public List<CurrencyCode> getSupportedCurrencies(
      @PathVariable(name = "channelCode", required = true) String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode = ChannelCode.Builder.newBuilder().setCode(pChannelCodeAsBasicType).build();
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.getSupportedCurrencies(pChannelCode);
  }

  /**
   * {@link RESTProductService#getSupportedCurrenciesAsync()}
   */
  @RequestMapping(path = "async-currencies/{channelCode}", method = { RequestMethod.GET })
  public List<CurrencyCode> getSupportedCurrenciesAsync(
      @PathVariable(name = "channelCode", required = true) String pChannelCodeAsBasicType ) {
    // Convert basic type parameters into "real" objects.
    ChannelCode pChannelCode = ChannelCode.Builder.newBuilder().setCode(pChannelCodeAsBasicType).build();
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.getSupportedCurrenciesAsync(pChannelCode);
  }

  /**
   * {@link RESTProductService#testParams()}
   */
  @RequestMapping(path = "test-params", method = { RequestMethod.GET })
  public String testParams( @RequestHeader(name = "Big-Header", required = true) BigDecimal pBigDecimalHeader,
      @CookieValue(name = "giveMeMoreCookies", required = true) @RequestBody(required = true) int pIntCookieParam,
      @RequestParam(name = "locale", required = true) Locale pLocaleQueryParam ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    return lService.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
  }

  /**
   * {@link RESTProductService#testEnumParams()}
   */
  @RequestMapping(path = "test-enum-params/{channelType}", method = { RequestMethod.GET })
  public void testEnumParams( @PathVariable(name = "channelType", required = true) ChannelType pChannelType,
      @RequestParam(name = "timeUnit", required = true) TimeUnit pTimeUnit,
      @RequestParam(name = "extensibleEnum", required = true) ExtensibleEnum pExtensibleEnum ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testEnumParams(pChannelType, pTimeUnit, pExtensibleEnum);
  }

  /**
   * {@link RESTProductService#testEnumHeaderParams()}
   */
  @RequestMapping(path = "test-enum-header-params", method = { RequestMethod.GET })
  public void testEnumHeaderParams( @RequestHeader(name = "Channel-Type", required = true) ChannelType pChannelType,
      @RequestHeader(name = "Time-Unit", required = true) TimeUnit pTimeUnit,
      @RequestHeader(name = "Extensible-Enum", required = true) ExtensibleEnum pExtensibleEnum ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testEnumHeaderParams(pChannelType, pTimeUnit, pExtensibleEnum);
  }

  /**
   * {@link RESTProductService#testDateQueryParams()}
   */
  @RequestMapping(path = "test-date-query-params/{path}", method = { RequestMethod.GET })
  public void testDateQueryParams( @PathVariable(name = "path", required = true) String pPath,
      @RequestParam(name = "startTimestamp", required = true) OffsetDateTime pStartTimestamp,
      @RequestParam(name = "startTime", required = true) OffsetTime pStartTime,
      @RequestParam(name = "localStartTimestamp", required = true) LocalDateTime pLocalStartTimestamp,
      @RequestParam(name = "localStartTime", required = true) LocalTime pLocalStartTime,
      @RequestParam(name = "localStartDate", required = true) LocalDate pLocalStartDate,
      @RequestParam(name = "calendar", required = true) Calendar pCalendar,
      @RequestParam(name = "utilDate", required = true) java.util.Date pUtilDate,
      @RequestParam(name = "sqlTimestamp", required = true) Timestamp pSQLTimestamp,
      @RequestParam(name = "sqlTime", required = true) Time pSQLTime,
      @RequestParam(name = "sqlDate", required = true) Date pSQLDate ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testDateQueryParams(pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime,
        pLocalStartDate, pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link RESTProductService#testDateQueryParamsBean()}
   */
  @RequestMapping(path = "test-date-query-params-beans/{path}", method = { RequestMethod.GET })
  public void testDateQueryParamsBean( @PathVariable(name = "path", required = true) String pPath,
      @RequestParam(name = "offsetDateTime", required = true) OffsetDateTime pOffsetDateTime,
      @RequestParam(name = "offsetTime", required = true) OffsetTime pOffsetTime,
      @RequestParam(name = "localDateTime", required = true) LocalDateTime pLocalDateTime,
      @RequestParam(name = "localTime", required = true) LocalTime pLocalTime,
      @RequestParam(name = "localDate", required = true) LocalDate pLocalDate,
      @RequestParam(name = "utilDate", required = true) java.util.Date pUtilDate,
      @RequestParam(name = "calendar", required = true) Calendar pCalendar,
      @RequestParam(name = "sqlTimestamp", required = true) Timestamp pSqlTimestamp,
      @RequestParam(name = "sqlTime", required = true) Time pSqlTime,
      @RequestParam(name = "sqlDate", required = true) Date pSqlDate ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DateQueryParamsBean.Builder lBuilder = DateQueryParamsBean.Builder.newBuilder();
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
    DateQueryParamsBean pQueryParams = lBuilder.build();
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testDateQueryParamsBean(pPath, pQueryParams);
  }

  /**
   * {@link RESTProductService#testDateHeaderParams()}
   */
  @RequestMapping(path = "test-date-header-params/{path}", method = { RequestMethod.GET })
  public void testDateHeaderParams( @PathVariable(name = "path", required = true) String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) OffsetDateTime pOffsetDateTime,
      @RequestHeader(name = "Offset-Time", required = true) OffsetTime pOffsetTime,
      @RequestHeader(name = "Local-Date-Time", required = true) LocalDateTime pLocalDateTime,
      @RequestHeader(name = "Local-Time", required = true) LocalTime pLocalTime,
      @RequestHeader(name = "Local-Date", required = true) LocalDate pLocalDate,
      @RequestHeader(name = "Calendar", required = true) Calendar pCalendar,
      @RequestHeader(name = "Util-Date", required = true) java.util.Date pUtilDate,
      @RequestHeader(name = "SQL-Timestamp", required = true) Timestamp pSQLTimestamp,
      @RequestHeader(name = "SQL-Time", required = true) Time pSQLTime,
      @RequestHeader(name = "SQL-Date", required = true) Date pSQLDate ) {
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testDateHeaderParams(pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate,
        pCalendar, pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
  }

  /**
   * {@link RESTProductService#testDateHeaderParamsBean()}
   */
  @RequestMapping(path = "test-date-header-params-beans/{path}", method = { RequestMethod.GET })
  public void testDateHeaderParamsBean( @PathVariable(name = "path", required = true) String pPath,
      @RequestHeader(name = "Offset-Date-Time", required = true) OffsetDateTime pOffsetDateTime,
      @RequestHeader(name = "Offset-Time", required = true) OffsetTime pOffsetTime,
      @RequestHeader(name = "Local-Date-Time", required = true) LocalDateTime pLocalDateTime,
      @RequestHeader(name = "Local-Time", required = true) LocalTime pLocalTime,
      @RequestHeader(name = "Local-Date", required = true) LocalDate pLocalDate,
      @RequestHeader(name = "Util-Date", required = true) java.util.Date pUtilDate,
      @RequestHeader(name = "Calendar", required = true) Calendar pCalendar,
      @RequestHeader(name = "SQL-Timestamp", required = true) Timestamp pSqlTimestamp,
      @RequestHeader(name = "SQL-Time", required = true) Time pSqlTime,
      @RequestHeader(name = "SQL-Date", required = true) Date pSqlDate ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    DateHeaderParamsBean.Builder lBuilder = DateHeaderParamsBean.Builder.newBuilder();
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
    DateHeaderParamsBean pHeaderParams = lBuilder.build();
    // Get Spring service and delegate call.
    RESTProductService lService = this.getRESTProductService();
    lService.testDateHeaderParamsBean(pPath, pHeaderParams);
  }

  /**
   * Method returns reference to service to which all REST requests will be delegated.
   *
   * @return RESTProductService Service instance to which all requests will be delegated.
   */
  private RESTProductService getRESTProductService( ) {
    return rESTProductService;
  }
}
