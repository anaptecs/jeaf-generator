/**
 * Copyright 2004 - 2022 anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 *
 * All rights reserved.
 */
package com.anaptecs.spring.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.anaptecs.spring.base.BeanParameter;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DeprecatedContext;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.ParentBeanParamType;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Product.Builder;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCodeType;
import com.anaptecs.spring.service.ChildBeanParameterType;
import com.anaptecs.spring.service.DateHeaderParamsBean;
import com.anaptecs.spring.service.DateQueryParamsBean;
import com.anaptecs.spring.service.LocalBeanParamType;
import com.anaptecs.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Override
  public List<Product> getProducts( ) {
    Builder lBuilder = Product.builder();
    lBuilder.setName("Cool Product");

    List<Product> lProducts = new ArrayList<>();
    lProducts.add(lBuilder.build());

    return lProducts;
  }

  @Override
  public Product getProduct( @NotEmpty String pProductID ) {
    assertEquals("12345", pProductID);
    return null;
  }

  @Override
  public boolean createProduct( Product pProduct ) {
    assertNotNull(pProduct, "Parameter pProduct must not be null.");
    assertEquals("My First Product", pProduct.getName());
    return true;
  }

  @Override
  public Sortiment getSortiment( Context pContext ) {
    assertEquals("12345", pContext.getAccessToken());
    assertEquals(Locale.GERMAN, pContext.getLanguage());
    assertEquals(4711, pContext.getPathParam());
    assertEquals("QUERY_ME", pContext.getQueryParam());
    assertEquals(47110815L, pContext.getResellerID());
    return null;
  }

  @Override
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    assertEquals("MyMobile", pChannelCode);
    return ChannelCode.builder().setCode(pChannelCode).build();
  }

  @Override
  public void ping( ) {
  }

  @Override
  public String deprecatedOperation( ) {
    return null;
  }

  @Override
  public String deprecatedContext( DeprecatedContext pContext ) {
    return null;
  }

  @Override
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
  }

  @Override
  public String deprecatedParams( int pParam1 ) {
    return null;
  }

  @Override
  public String deprecatedBody( String pBody ) {
    return null;
  }

  @Override
  public void deprectedComplexRequestBody( Product pProduct ) {
  }

  @Override
  public Product deprecatedComplexReturn( ) {
    return null;
  }

  @Override
  public void loadSpecificThings( SpecialContext pContext ) {
  }

  @Override
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    return null;
  }

  @Override
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    return null;
  }

  @Override
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    return null;
  }

  @Override
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    return null;
  }

  @Override
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    return null;
  }

  @Override
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    return null;
  }

  @Override
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    return null;
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

}
