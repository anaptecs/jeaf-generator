/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.TimeUnit;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.RESTProductService;

@Service
public class RESTProductServiceImpl implements RESTProductService {

  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    return null;
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    return null;
  }

  @Override
  public boolean createProduct( Product pProduct ) {
    return false;
  }

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return null;
  }

  @Override
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    return null;
  }

  @Override
  public void ping( ) {
  }

  @Override
  public void testInit( ) {
  }

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    return null;
  }

  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    return null;
  }

  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    return null;
  }

  @Override
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
  }

  @Override
  public void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
  }

  @Override
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate ) {
  }

  @Override
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
  }

  @Override
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar, Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, java.sql.Date pSQLDate ) {
  }

  @Override
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
  }

  @Override
  public void testCookieParams( ChannelType pChannelType, SpecialContext pContext ) {
  }
}
