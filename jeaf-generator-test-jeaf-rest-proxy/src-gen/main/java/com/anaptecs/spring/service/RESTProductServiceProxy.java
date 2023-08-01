/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.io.Serializable;
import java.lang.reflect.Method;
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
import java.util.Set;
import java.util.SortedSet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.servicechannel.api.Command;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;
import com.anaptecs.spring.base.BookingCode;
import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.ChannelType;
import com.anaptecs.spring.base.ComplexBookingID;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.ExtensibleEnum;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.base.SpecialContext;
import com.anaptecs.spring.base.StringCode;
import com.anaptecs.spring.base.TimeUnit;

/**
 * ServiceProxy class for JEAF service RESTProductService.
 */
public final class RESTProductServiceProxy extends ServiceProxy implements RESTProductService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public RESTProductServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(RESTProductService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#getProducts}
   */
  @SuppressWarnings("unchecked")
  public List<Product> getProducts( int pMaxResultSize ) {
    try {
      Command lCommand = new GetProducts_int_RESTProductService_Command(pMaxResultSize);
      return (List<Product>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#getProduct}
   */
  public Product getProduct( @NotEmpty String pProductID ) {
    try {
      Command lCommand = new GetProduct_String_RESTProductService_Command(pProductID);
      return (Product) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#createProduct}
   */
  public boolean createProduct( Product pProduct ) {
    try {
      Command lCommand = new CreateProduct_Product_RESTProductService_Command(pProduct);
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#getSortiment}
   */
  public Sortiment getSortiment( Context pContext ) {
    try {
      Command lCommand = new GetSortiment_Context_RESTProductService_Command(pContext);
      return (Sortiment) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#createChannelCode}
   */
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    try {
      Command lCommand = new CreateChannelCode_String_RESTProductService_Command(pChannelCode);
      return (ChannelCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#ping}
   */
  public void ping( ) {
    try {
      Command lCommand = new Ping_RESTProductService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#testInit}
   */
  public void testInit( ) {
    try {
      Command lCommand = new TestInit_RESTProductService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#getSupportedCurrencies}
   */
  @SuppressWarnings("unchecked")
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    try {
      Command lCommand = new GetSupportedCurrencies_ChannelCode_RESTProductService_Command(pChannelCode);
      return (List<CurrencyCode>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#getSupportedCurrenciesAsync}
   */
  @SuppressWarnings("unchecked")
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    try {
      Command lCommand = new GetSupportedCurrenciesAsync_ChannelCode_RESTProductService_Command(pChannelCode);
      return (List<CurrencyCode>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#testParams}
   */
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    try {
      Command lCommand = new TestParams_BigDecimal_int_Locale_RESTProductService_Command(pBigDecimalHeader,
          pIntCookieParam, pLocaleQueryParam);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#testEnumParams}
   */
  public void testEnumParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    try {
      Command lCommand = new TestEnumParams_ChannelType_TimeUnit_ExtensibleEnum_RESTProductService_Command(pChannelType,
          pTimeUnit, pExtensibleEnum);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testEnumHeaderParams}
   */
  public void testEnumHeaderParams( ChannelType pChannelType, TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    try {
      Command lCommand = new TestEnumHeaderParams_ChannelType_TimeUnit_ExtensibleEnum_RESTProductService_Command(
          pChannelType, pTimeUnit, pExtensibleEnum);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDateQueryParams}
   */
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<Calendar> pCalendars ) {
    try {
      Command lCommand =
          new TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_Calendar_RESTProductService_Command(
              pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar,
              pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate, pCalendars);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDateQueryParamsBean}
   */
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    try {
      Command lCommand =
          new TestDateQueryParamsBean_String_DateQueryParamsBean_RESTProductService_Command(pPath, pQueryParams);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDateHeaderParams}
   */
  public void testDateHeaderParams( String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime,
      LocalDateTime pLocalDateTime, LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate,
      Set<java.util.Date> pUtilDates ) {
    try {
      Command lCommand =
          new TestDateHeaderParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_Date_RESTProductService_Command(
              pPath, pOffsetDateTime, pOffsetTime, pLocalDateTime, pLocalTime, pLocalDate, pCalendar, pUtilDate,
              pSQLTimestamp, pSQLTime, pSQLDate, pUtilDates);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDateHeaderParamsBean}
   */
  public void testDateHeaderParamsBean( String pPath, DateHeaderParamsBean pHeaderParams ) {
    try {
      Command lCommand =
          new TestDateHeaderParamsBean_String_DateHeaderParamsBean_RESTProductService_Command(pPath, pHeaderParams);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.spring.service.RESTProductService#testCookieParams}
   */
  public void testCookieParams( ChannelType pChannelTypeParam, SpecialContext pContext ) {
    try {
      Command lCommand =
          new TestCookieParams_ChannelType_SpecialContext_RESTProductService_Command(pChannelTypeParam, pContext);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testOptionalQueryParams}
   */
  public String testOptionalQueryParams( String query1, int query2 ) {
    try {
      Command lCommand = new TestOptionalQueryParams_String_int_RESTProductService_Command(query1, query2);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#processComplexBookingID}
   */
  public boolean processComplexBookingID( ComplexBookingID pComplextBookingID ) {
    try {
      Command lCommand = new ProcessComplexBookingID_ComplexBookingID_RESTProductService_Command(pComplextBookingID);
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypesAsHeaderParam}
   */
  public String testDataTypesAsHeaderParam( BookingID pBookingID, BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    try {
      Command lCommand = new TestDataTypesAsHeaderParam_BookingID_BookingCode_DoubleCode_RESTProductService_Command(
          pBookingID, pBookingCode, pDoubleCode);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypesAsHeaderBeanParam}
   */
  public String testDataTypesAsHeaderBeanParam( AdvancedHeader pContext ) {
    try {
      Command lCommand = new TestDataTypesAsHeaderBeanParam_AdvancedHeader_RESTProductService_Command(pContext);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveArrays}
   */
  public String testPrimitiveArrays( int[] pIntegerArray ) {
    try {
      Command lCommand = new TestPrimitiveArrays_int_RESTProductService_Command(pIntegerArray);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypeAsQueryParam}
   */
  public String testDataTypeAsQueryParam( BookingCode pBookingCode ) {
    try {
      Command lCommand = new TestDataTypeAsQueryParam_BookingCode_RESTProductService_Command(pBookingCode);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testDataTypeAsBeanQueryParam}
   */
  public String testDataTypeAsBeanQueryParam( QueryBeanParam pBeanParam ) {
    try {
      Command lCommand = new TestDataTypeAsBeanQueryParam_QueryBeanParam_RESTProductService_Command(pBeanParam);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveArrayAsQueryParam}
   */
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    try {
      Command lCommand = new TestPrimitiveArrayAsQueryParam_int_RESTProductService_Command(pIntValues);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testSimpleTypesAsQueryParams}
   */
  public String testSimpleTypesAsQueryParams( List<String> pStrings ) {
    try {
      Command lCommand = new TestSimpleTypesAsQueryParams_String_RESTProductService_Command(pStrings);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testPrimitiveWrapperArrayAsQueryParam}
   */
  public String testPrimitiveWrapperArrayAsQueryParam( Set<Integer> pIntegers ) {
    try {
      Command lCommand = new TestPrimitiveWrapperArrayAsQueryParam_Integer_RESTProductService_Command(pIntegers);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testMultivaluedQueryParamsBean}
   */
  public String testMultivaluedQueryParamsBean( MultivaluedQueryParamsBean pBean ) {
    try {
      Command lCommand =
          new TestMultivaluedQueryParamsBean_MultivaluedQueryParamsBean_RESTProductService_Command(pBean);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testMulitvaluedDataTypeAsQueryParam}
   */
  public String testMulitvaluedDataTypeAsQueryParam( List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes,
      List<BookingID> pBookingIDs, List<OffsetDateTime> pTimestamps, SortedSet<LocalDate> pLocalDates ) {
    try {
      Command lCommand =
          new TestMulitvaluedDataTypeAsQueryParam_IntegerCodeType_LongCode_BookingID_OffsetDateTime_LocalDate_RESTProductService_Command(
              pCodes, pLongCodes, pBookingIDs, pTimestamps, pLocalDates);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testMulitvaluedDataTypeAsBeanQueryParam}
   */
  public String testMulitvaluedDataTypeAsBeanQueryParam( DataTypesQueryBean pQueryBean ) {
    try {
      Command lCommand =
          new TestMulitvaluedDataTypeAsBeanQueryParam_DataTypesQueryBean_RESTProductService_Command(pQueryBean);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testMultiValuedHeaderFieldsInBeanParam}
   */
  public String testMultiValuedHeaderFieldsInBeanParam( MultiValuedHeaderBeanParam pMultiValuedBean ) {
    try {
      Command lCommand =
          new TestMultiValuedHeaderFieldsInBeanParam_MultiValuedHeaderBeanParam_RESTProductService_Command(
              pMultiValuedBean);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testMultiValuedHeaderFields}
   */
  public String testMultiValuedHeaderFields( Set<String> pNames, int[] pInts, Set<Double> pDoubles,
      Set<StringCode> pCodes, OffsetDateTime pStartDate, Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes ) {
    try {
      Command lCommand =
          new TestMultiValuedHeaderFields_String_int_Double_StringCode_OffsetDateTime_OffsetDateTime_OffsetTime_RESTProductService_Command(
              pNames, pInts, pDoubles, pCodes, pStartDate, pTimestamps, pTimes);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testBookingIDAsPathParam}
   */
  public void testBookingIDAsPathParam( BookingID pBookingID ) {
    try {
      Command lCommand = new TestBookingIDAsPathParam_BookingID_RESTProductService_Command(pBookingID);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.spring.service.RESTProductService#testBookingIDAsHeaderParam}
   */
  public void testBookingIDAsHeaderParam( BookingID pBookingID ) {
    try {
      Command lCommand = new TestBookingIDAsHeaderParam_BookingID_RESTProductService_Command(pBookingID);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }
}

/**
 * Generated command class for service method "getProducts".
 */
final class GetProducts_int_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("getProducts", int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "getProducts(int.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pMaxResultSize" to the service implementation via the service channel.
   */
  private final int maxResultSize;

  /**
   * Initialize object. All parameters from method "getProducts" have to be passed as parameters to this command object.
   *
   * @param pMaxResultSize int
   */
  GetProducts_int_RESTProductService_Command( int pMaxResultSize ) {
    super(RESTProductService.class);
    maxResultSize = pMaxResultSize;
    parameters = new Object[] { maxResultSize };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getProducts(maxResultSize);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getProduct".
 */
final class GetProduct_String_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("getProduct", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "getProduct(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pProductID" to the service implementation via the service channel.
   */
  private final String productID;

  /**
   * Initialize object. All parameters from method "getProduct" have to be passed as parameters to this command object.
   *
   * @param pProductID String
   */
  GetProduct_String_RESTProductService_Command( String pProductID ) {
    super(RESTProductService.class);
    productID = pProductID;
    parameters = new Object[] { productID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getProduct(productID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createProduct".
 */
final class CreateProduct_Product_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("createProduct", Product.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "createProduct(Product.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pProduct" to the service implementation via the service channel.
   */
  private final Product product;

  /**
   * Initialize object. All parameters from method "createProduct" have to be passed as parameters to this command
   * object.
   *
   * @param pProduct Product
   */
  CreateProduct_Product_RESTProductService_Command( Product pProduct ) {
    super(RESTProductService.class);
    product = pProduct;
    parameters = new Object[] { product };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createProduct(product);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getSortiment".
 */
final class GetSortiment_Context_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("getSortiment", Context.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "getSortiment(Context.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final Context context;

  /**
   * Initialize object. All parameters from method "getSortiment" have to be passed as parameters to this command
   * object.
   *
   * @param pContext Context
   */
  GetSortiment_Context_RESTProductService_Command( Context pContext ) {
    super(RESTProductService.class);
    context = pContext;
    parameters = new Object[] { context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getSortiment(context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "createChannelCode".
 */
final class CreateChannelCode_String_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("createChannelCode", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "createChannelCode(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelCode" to the service implementation via the service channel.
   */
  private final String channelCode;

  /**
   * Initialize object. All parameters from method "createChannelCode" have to be passed as parameters to this command
   * object.
   *
   * @param pChannelCode String
   */
  CreateChannelCode_String_RESTProductService_Command( String pChannelCode ) {
    super(RESTProductService.class);
    channelCode = pChannelCode;
    parameters = new Object[] { channelCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createChannelCode(channelCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "ping".
 */
final class Ping_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("ping");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "ping(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "ping" have to be passed as parameters to this command object.
   *
   *
   */
  Ping_RESTProductService_Command( ) {
    super(RESTProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.ping();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testInit".
 */
final class TestInit_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testInit");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testInit(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "testInit" have to be passed as parameters to this command object.
   *
   *
   */
  TestInit_RESTProductService_Command( ) {
    super(RESTProductService.class);
    parameters = new Object[] {};
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testInit();
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getSupportedCurrencies".
 */
final class GetSupportedCurrencies_ChannelCode_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("getSupportedCurrencies", ChannelCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "getSupportedCurrencies(ChannelCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelCode" to the service implementation via the service channel.
   */
  private final ChannelCode channelCode;

  /**
   * Initialize object. All parameters from method "getSupportedCurrencies" have to be passed as parameters to this
   * command object.
   *
   * @param pChannelCode ChannelCode
   */
  GetSupportedCurrencies_ChannelCode_RESTProductService_Command( ChannelCode pChannelCode ) {
    super(RESTProductService.class);
    channelCode = pChannelCode;
    parameters = new Object[] { channelCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getSupportedCurrencies(channelCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "getSupportedCurrenciesAsync".
 */
final class GetSupportedCurrenciesAsync_ChannelCode_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("getSupportedCurrenciesAsync", ChannelCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "getSupportedCurrenciesAsync(ChannelCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelCode" to the service implementation via the service channel.
   */
  private final ChannelCode channelCode;

  /**
   * Initialize object. All parameters from method "getSupportedCurrenciesAsync" have to be passed as parameters to this
   * command object.
   *
   * @param pChannelCode ChannelCode
   */
  GetSupportedCurrenciesAsync_ChannelCode_RESTProductService_Command( ChannelCode pChannelCode ) {
    super(RESTProductService.class);
    channelCode = pChannelCode;
    parameters = new Object[] { channelCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getSupportedCurrenciesAsync(channelCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testParams".
 */
final class TestParams_BigDecimal_int_Locale_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testParams", BigDecimal.class, int.class, Locale.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testParams(BigDecimal.class, int.class, Locale.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBigDecimalHeader" to the service implementation via the service
   * channel.
   */
  private final BigDecimal bigDecimalHeader;

  /**
   * Attribute transports the method parameter "pIntCookieParam" to the service implementation via the service channel.
   */
  private final int intCookieParam;

  /**
   * Attribute transports the method parameter "pLocaleQueryParam" to the service implementation via the service
   * channel.
   */
  private final Locale localeQueryParam;

  /**
   * Initialize object. All parameters from method "testParams" have to be passed as parameters to this command object.
   *
   * @param pBigDecimalHeader BigDecimal
   * @param pIntCookieParam int
   * @param pLocaleQueryParam Locale
   */
  TestParams_BigDecimal_int_Locale_RESTProductService_Command( BigDecimal pBigDecimalHeader, int pIntCookieParam,
      Locale pLocaleQueryParam ) {
    super(RESTProductService.class);
    bigDecimalHeader = pBigDecimalHeader;
    intCookieParam = pIntCookieParam;
    localeQueryParam = pLocaleQueryParam;
    parameters = new Object[] { bigDecimalHeader, intCookieParam, localeQueryParam };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testParams(bigDecimalHeader, intCookieParam, localeQueryParam);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testEnumParams".
 */
final class TestEnumParams_ChannelType_TimeUnit_ExtensibleEnum_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          RESTProductService.class.getMethod("testEnumParams", ChannelType.class, TimeUnit.class, ExtensibleEnum.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testEnumParams(ChannelType.class, TimeUnit.class, ExtensibleEnum.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelType" to the service implementation via the service channel.
   */
  private final ChannelType channelType;

  /**
   * Attribute transports the method parameter "pTimeUnit" to the service implementation via the service channel.
   */
  private final TimeUnit timeUnit;

  /**
   * Attribute transports the method parameter "pExtensibleEnum" to the service implementation via the service channel.
   */
  private final ExtensibleEnum extensibleEnum;

  /**
   * Initialize object. All parameters from method "testEnumParams" have to be passed as parameters to this command
   * object.
   *
   * @param pChannelType ChannelType
   * @param pTimeUnit TimeUnit
   * @param pExtensibleEnum ExtensibleEnum
   */
  TestEnumParams_ChannelType_TimeUnit_ExtensibleEnum_RESTProductService_Command( ChannelType pChannelType,
      TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    super(RESTProductService.class);
    channelType = pChannelType;
    timeUnit = pTimeUnit;
    extensibleEnum = pExtensibleEnum;
    parameters = new Object[] { channelType, timeUnit, extensibleEnum };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testEnumParams(channelType, timeUnit, extensibleEnum);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testEnumHeaderParams".
 */
final class TestEnumHeaderParams_ChannelType_TimeUnit_ExtensibleEnum_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testEnumHeaderParams", ChannelType.class, TimeUnit.class,
          ExtensibleEnum.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testEnumHeaderParams(ChannelType.class, TimeUnit.class, ExtensibleEnum.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelType" to the service implementation via the service channel.
   */
  private final ChannelType channelType;

  /**
   * Attribute transports the method parameter "pTimeUnit" to the service implementation via the service channel.
   */
  private final TimeUnit timeUnit;

  /**
   * Attribute transports the method parameter "pExtensibleEnum" to the service implementation via the service channel.
   */
  private final ExtensibleEnum extensibleEnum;

  /**
   * Initialize object. All parameters from method "testEnumHeaderParams" have to be passed as parameters to this
   * command object.
   *
   * @param pChannelType ChannelType
   * @param pTimeUnit TimeUnit
   * @param pExtensibleEnum ExtensibleEnum
   */
  TestEnumHeaderParams_ChannelType_TimeUnit_ExtensibleEnum_RESTProductService_Command( ChannelType pChannelType,
      TimeUnit pTimeUnit, ExtensibleEnum pExtensibleEnum ) {
    super(RESTProductService.class);
    channelType = pChannelType;
    timeUnit = pTimeUnit;
    extensibleEnum = pExtensibleEnum;
    parameters = new Object[] { channelType, timeUnit, extensibleEnum };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testEnumHeaderParams(channelType, timeUnit, extensibleEnum);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateQueryParams".
 */
final class TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_Calendar_RESTProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testDateQueryParams", String.class, OffsetDateTime.class,
          OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class,
          Timestamp.class, Time.class, Date.class, Set.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testDateQueryParams(String.class, OffsetDateTime.class, OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class, Timestamp.class, Time.class, Date.class, Set.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pStartTimestamp" to the service implementation via the service channel.
   */
  private final OffsetDateTime startTimestamp;

  /**
   * Attribute transports the method parameter "pStartTime" to the service implementation via the service channel.
   */
  private final OffsetTime startTime;

  /**
   * Attribute transports the method parameter "pLocalStartTimestamp" to the service implementation via the service
   * channel.
   */
  private final LocalDateTime localStartTimestamp;

  /**
   * Attribute transports the method parameter "pLocalStartTime" to the service implementation via the service channel.
   */
  private final LocalTime localStartTime;

  /**
   * Attribute transports the method parameter "pLocalStartDate" to the service implementation via the service channel.
   */
  private final LocalDate localStartDate;

  /**
   * Attribute transports the method parameter "pCalendar" to the service implementation via the service channel.
   */
  private final Calendar calendar;

  /**
   * Attribute transports the method parameter "pUtilDate" to the service implementation via the service channel.
   */
  private final java.util.Date utilDate;

  /**
   * Attribute transports the method parameter "pSQLTimestamp" to the service implementation via the service channel.
   */
  private final Timestamp sQLTimestamp;

  /**
   * Attribute transports the method parameter "pSQLTime" to the service implementation via the service channel.
   */
  private final Time sQLTime;

  /**
   * Attribute transports the method parameter "pSQLDate" to the service implementation via the service channel.
   */
  private final Date sQLDate;

  /**
   * Attribute transports the method parameter "pCalendars" to the service implementation via the service channel.
   */
  private final Set<Calendar> calendars;

  /**
   * Initialize object. All parameters from method "testDateQueryParams" have to be passed as parameters to this command
   * object.
   *
   * @param pPath String
   * @param pStartTimestamp OffsetDateTime
   * @param pStartTime OffsetTime
   * @param pLocalStartTimestamp LocalDateTime
   * @param pLocalStartTime LocalTime
   * @param pLocalStartDate LocalDate
   * @param pCalendar Calendar
   * @param pUtilDate java.util.Date
   * @param pSQLTimestamp Timestamp
   * @param pSQLTime Time
   * @param pSQLDate Date
   * @param pCalendars Set<Calendar>
   */
  TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_Calendar_RESTProductService_Command(
      String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime, LocalDateTime pLocalStartTimestamp,
      LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar, java.util.Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate, Set<Calendar> pCalendars ) {
    super(RESTProductService.class);
    path = pPath;
    startTimestamp = pStartTimestamp;
    startTime = pStartTime;
    localStartTimestamp = pLocalStartTimestamp;
    localStartTime = pLocalStartTime;
    localStartDate = pLocalStartDate;
    calendar = pCalendar;
    utilDate = pUtilDate;
    sQLTimestamp = pSQLTimestamp;
    sQLTime = pSQLTime;
    sQLDate = pSQLDate;
    calendars = pCalendars;
    parameters = new Object[] { path, startTimestamp, startTime, localStartTimestamp, localStartTime, localStartDate,
      calendar, utilDate, sQLTimestamp, sQLTime, sQLDate, calendars };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateQueryParams(path, startTimestamp, startTime, localStartTimestamp, localStartTime, localStartDate,
        calendar, utilDate, sQLTimestamp, sQLTime, sQLDate, calendars);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateQueryParamsBean".
 */
final class TestDateQueryParamsBean_String_DateQueryParamsBean_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          RESTProductService.class.getMethod("testDateQueryParamsBean", String.class, DateQueryParamsBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testDateQueryParamsBean(String.class, DateQueryParamsBean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pQueryParams" to the service implementation via the service channel.
   */
  private final DateQueryParamsBean queryParams;

  /**
   * Initialize object. All parameters from method "testDateQueryParamsBean" have to be passed as parameters to this
   * command object.
   *
   * @param pPath String
   * @param pQueryParams DateQueryParamsBean
   */
  TestDateQueryParamsBean_String_DateQueryParamsBean_RESTProductService_Command( String pPath,
      DateQueryParamsBean pQueryParams ) {
    super(RESTProductService.class);
    path = pPath;
    queryParams = pQueryParams;
    parameters = new Object[] { path, queryParams };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateQueryParamsBean(path, queryParams);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateHeaderParams".
 */
final class TestDateHeaderParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_Date_RESTProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testDateHeaderParams", String.class, OffsetDateTime.class,
          OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class,
          Timestamp.class, Time.class, Date.class, Set.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testDateHeaderParams(String.class, OffsetDateTime.class, OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class, Timestamp.class, Time.class, Date.class, Set.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pOffsetDateTime" to the service implementation via the service channel.
   */
  private final OffsetDateTime offsetDateTime;

  /**
   * Attribute transports the method parameter "pOffsetTime" to the service implementation via the service channel.
   */
  private final OffsetTime offsetTime;

  /**
   * Attribute transports the method parameter "pLocalDateTime" to the service implementation via the service channel.
   */
  private final LocalDateTime localDateTime;

  /**
   * Attribute transports the method parameter "pLocalTime" to the service implementation via the service channel.
   */
  private final LocalTime localTime;

  /**
   * Attribute transports the method parameter "pLocalDate" to the service implementation via the service channel.
   */
  private final LocalDate localDate;

  /**
   * Attribute transports the method parameter "pCalendar" to the service implementation via the service channel.
   */
  private final Calendar calendar;

  /**
   * Attribute transports the method parameter "pUtilDate" to the service implementation via the service channel.
   */
  private final java.util.Date utilDate;

  /**
   * Attribute transports the method parameter "pSQLTimestamp" to the service implementation via the service channel.
   */
  private final Timestamp sQLTimestamp;

  /**
   * Attribute transports the method parameter "pSQLTime" to the service implementation via the service channel.
   */
  private final Time sQLTime;

  /**
   * Attribute transports the method parameter "pSQLDate" to the service implementation via the service channel.
   */
  private final Date sQLDate;

  /**
   * Attribute transports the method parameter "pUtilDates" to the service implementation via the service channel.
   */
  private final Set<java.util.Date> utilDates;

  /**
   * Initialize object. All parameters from method "testDateHeaderParams" have to be passed as parameters to this
   * command object.
   *
   * @param pPath String
   * @param pOffsetDateTime OffsetDateTime
   * @param pOffsetTime OffsetTime
   * @param pLocalDateTime LocalDateTime
   * @param pLocalTime LocalTime
   * @param pLocalDate LocalDate
   * @param pCalendar Calendar
   * @param pUtilDate java.util.Date
   * @param pSQLTimestamp Timestamp
   * @param pSQLTime Time
   * @param pSQLDate Date
   * @param pUtilDates Set<java.util.Date>
   */
  TestDateHeaderParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_Date_RESTProductService_Command(
      String pPath, OffsetDateTime pOffsetDateTime, OffsetTime pOffsetTime, LocalDateTime pLocalDateTime,
      LocalTime pLocalTime, LocalDate pLocalDate, Calendar pCalendar, java.util.Date pUtilDate, Timestamp pSQLTimestamp,
      Time pSQLTime, Date pSQLDate, Set<java.util.Date> pUtilDates ) {
    super(RESTProductService.class);
    path = pPath;
    offsetDateTime = pOffsetDateTime;
    offsetTime = pOffsetTime;
    localDateTime = pLocalDateTime;
    localTime = pLocalTime;
    localDate = pLocalDate;
    calendar = pCalendar;
    utilDate = pUtilDate;
    sQLTimestamp = pSQLTimestamp;
    sQLTime = pSQLTime;
    sQLDate = pSQLDate;
    utilDates = pUtilDates;
    parameters = new Object[] { path, offsetDateTime, offsetTime, localDateTime, localTime, localDate, calendar,
      utilDate, sQLTimestamp, sQLTime, sQLDate, utilDates };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateHeaderParams(path, offsetDateTime, offsetTime, localDateTime, localTime, localDate, calendar,
        utilDate, sQLTimestamp, sQLTime, sQLDate, utilDates);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDateHeaderParamsBean".
 */
final class TestDateHeaderParamsBean_String_DateHeaderParamsBean_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          RESTProductService.class.getMethod("testDateHeaderParamsBean", String.class, DateHeaderParamsBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testDateHeaderParamsBean(String.class, DateHeaderParamsBean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pPath" to the service implementation via the service channel.
   */
  private final String path;

  /**
   * Attribute transports the method parameter "pHeaderParams" to the service implementation via the service channel.
   */
  private final DateHeaderParamsBean headerParams;

  /**
   * Initialize object. All parameters from method "testDateHeaderParamsBean" have to be passed as parameters to this
   * command object.
   *
   * @param pPath String
   * @param pHeaderParams DateHeaderParamsBean
   */
  TestDateHeaderParamsBean_String_DateHeaderParamsBean_RESTProductService_Command( String pPath,
      DateHeaderParamsBean pHeaderParams ) {
    super(RESTProductService.class);
    path = pPath;
    headerParams = pHeaderParams;
    parameters = new Object[] { path, headerParams };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateHeaderParamsBean(path, headerParams);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testCookieParams".
 */
final class TestCookieParams_ChannelType_SpecialContext_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testCookieParams", ChannelType.class, SpecialContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testCookieParams(ChannelType.class, SpecialContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelTypeParam" to the service implementation via the service
   * channel.
   */
  private final ChannelType channelTypeParam;

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final SpecialContext context;

  /**
   * Initialize object. All parameters from method "testCookieParams" have to be passed as parameters to this command
   * object.
   *
   * @param pChannelTypeParam ChannelType
   * @param pContext SpecialContext
   */
  TestCookieParams_ChannelType_SpecialContext_RESTProductService_Command( ChannelType pChannelTypeParam,
      SpecialContext pContext ) {
    super(RESTProductService.class);
    channelTypeParam = pChannelTypeParam;
    context = pContext;
    parameters = new Object[] { channelTypeParam, context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testCookieParams(channelTypeParam, context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testOptionalQueryParams".
 */
final class TestOptionalQueryParams_String_int_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testOptionalQueryParams", String.class, int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testOptionalQueryParams(String.class, int.class)");
    }
  }

  /**
   * Attribute transports the method parameter "query1" to the service implementation via the service channel.
   */
  private final String uery1;

  /**
   * Attribute transports the method parameter "query2" to the service implementation via the service channel.
   */
  private final int uery2;

  /**
   * Initialize object. All parameters from method "testOptionalQueryParams" have to be passed as parameters to this
   * command object.
   *
   * @param query1 String
   * @param query2 int
   */
  TestOptionalQueryParams_String_int_RESTProductService_Command( String query1, int query2 ) {
    super(RESTProductService.class);
    uery1 = query1;
    uery2 = query2;
    parameters = new Object[] { uery1, uery2 };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testOptionalQueryParams(uery1, uery2);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "processComplexBookingID".
 */
final class ProcessComplexBookingID_ComplexBookingID_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("processComplexBookingID", ComplexBookingID.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "processComplexBookingID(ComplexBookingID.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pComplextBookingID" to the service implementation via the service
   * channel.
   */
  private final ComplexBookingID complextBookingID;

  /**
   * Initialize object. All parameters from method "processComplexBookingID" have to be passed as parameters to this
   * command object.
   *
   * @param pComplextBookingID ComplexBookingID
   */
  ProcessComplexBookingID_ComplexBookingID_RESTProductService_Command( ComplexBookingID pComplextBookingID ) {
    super(RESTProductService.class);
    complextBookingID = pComplextBookingID;
    parameters = new Object[] { complextBookingID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.processComplexBookingID(complextBookingID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDataTypesAsHeaderParam".
 */
final class TestDataTypesAsHeaderParam_BookingID_BookingCode_DoubleCode_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testDataTypesAsHeaderParam", BookingID.class,
          BookingCode.class, DoubleCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testDataTypesAsHeaderParam(BookingID.class, BookingCode.class, DoubleCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBookingID" to the service implementation via the service channel.
   */
  private final BookingID bookingID;

  /**
   * Attribute transports the method parameter "pBookingCode" to the service implementation via the service channel.
   */
  private final BookingCode bookingCode;

  /**
   * Attribute transports the method parameter "pDoubleCode" to the service implementation via the service channel.
   */
  private final DoubleCode doubleCode;

  /**
   * Initialize object. All parameters from method "testDataTypesAsHeaderParam" have to be passed as parameters to this
   * command object.
   *
   * @param pBookingID BookingID
   * @param pBookingCode BookingCode
   * @param pDoubleCode DoubleCode
   */
  TestDataTypesAsHeaderParam_BookingID_BookingCode_DoubleCode_RESTProductService_Command( BookingID pBookingID,
      BookingCode pBookingCode, DoubleCode pDoubleCode ) {
    super(RESTProductService.class);
    bookingID = pBookingID;
    bookingCode = pBookingCode;
    doubleCode = pDoubleCode;
    parameters = new Object[] { bookingID, bookingCode, doubleCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testDataTypesAsHeaderParam(bookingID, bookingCode, doubleCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDataTypesAsHeaderBeanParam".
 */
final class TestDataTypesAsHeaderBeanParam_AdvancedHeader_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testDataTypesAsHeaderBeanParam", AdvancedHeader.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testDataTypesAsHeaderBeanParam(AdvancedHeader.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final AdvancedHeader context;

  /**
   * Initialize object. All parameters from method "testDataTypesAsHeaderBeanParam" have to be passed as parameters to
   * this command object.
   *
   * @param pContext AdvancedHeader
   */
  TestDataTypesAsHeaderBeanParam_AdvancedHeader_RESTProductService_Command( AdvancedHeader pContext ) {
    super(RESTProductService.class);
    context = pContext;
    parameters = new Object[] { context };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testDataTypesAsHeaderBeanParam(context);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testPrimitiveArrays".
 */
final class TestPrimitiveArrays_int_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testPrimitiveArrays", int[].class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testPrimitiveArrays(int[].class)");
    }
  }

  /**
   * Attribute transports the method parameter "pIntegerArray" to the service implementation via the service channel.
   */
  private final int[] integerArray;

  /**
   * Initialize object. All parameters from method "testPrimitiveArrays" have to be passed as parameters to this command
   * object.
   *
   * @param pIntegerArray int[]
   */
  TestPrimitiveArrays_int_RESTProductService_Command( int[] pIntegerArray ) {
    super(RESTProductService.class);
    integerArray = pIntegerArray;
    parameters = new Object[] { integerArray };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveArrays(integerArray);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDataTypeAsQueryParam".
 */
final class TestDataTypeAsQueryParam_BookingCode_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testDataTypeAsQueryParam", BookingCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testDataTypeAsQueryParam(BookingCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBookingCode" to the service implementation via the service channel.
   */
  private final BookingCode bookingCode;

  /**
   * Initialize object. All parameters from method "testDataTypeAsQueryParam" have to be passed as parameters to this
   * command object.
   *
   * @param pBookingCode BookingCode
   */
  TestDataTypeAsQueryParam_BookingCode_RESTProductService_Command( BookingCode pBookingCode ) {
    super(RESTProductService.class);
    bookingCode = pBookingCode;
    parameters = new Object[] { bookingCode };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testDataTypeAsQueryParam(bookingCode);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testDataTypeAsBeanQueryParam".
 */
final class TestDataTypeAsBeanQueryParam_QueryBeanParam_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testDataTypeAsBeanQueryParam", QueryBeanParam.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testDataTypeAsBeanQueryParam(QueryBeanParam.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBeanParam" to the service implementation via the service channel.
   */
  private final QueryBeanParam beanParam;

  /**
   * Initialize object. All parameters from method "testDataTypeAsBeanQueryParam" have to be passed as parameters to
   * this command object.
   *
   * @param pBeanParam QueryBeanParam
   */
  TestDataTypeAsBeanQueryParam_QueryBeanParam_RESTProductService_Command( QueryBeanParam pBeanParam ) {
    super(RESTProductService.class);
    beanParam = pBeanParam;
    parameters = new Object[] { beanParam };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testDataTypeAsBeanQueryParam(beanParam);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testPrimitiveArrayAsQueryParam".
 */
final class TestPrimitiveArrayAsQueryParam_int_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testPrimitiveArrayAsQueryParam", int[].class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testPrimitiveArrayAsQueryParam(int[].class)");
    }
  }

  /**
   * Attribute transports the method parameter "pIntValues" to the service implementation via the service channel.
   */
  private final int[] intValues;

  /**
   * Initialize object. All parameters from method "testPrimitiveArrayAsQueryParam" have to be passed as parameters to
   * this command object.
   *
   * @param pIntValues int[]
   */
  TestPrimitiveArrayAsQueryParam_int_RESTProductService_Command( int[] pIntValues ) {
    super(RESTProductService.class);
    intValues = pIntValues;
    parameters = new Object[] { intValues };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveArrayAsQueryParam(intValues);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testSimpleTypesAsQueryParams".
 */
final class TestSimpleTypesAsQueryParams_String_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testSimpleTypesAsQueryParams", List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testSimpleTypesAsQueryParams(List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pStrings" to the service implementation via the service channel.
   */
  private final List<String> strings;

  /**
   * Initialize object. All parameters from method "testSimpleTypesAsQueryParams" have to be passed as parameters to
   * this command object.
   *
   * @param pStrings List<String>
   */
  TestSimpleTypesAsQueryParams_String_RESTProductService_Command( List<String> pStrings ) {
    super(RESTProductService.class);
    strings = pStrings;
    parameters = new Object[] { strings };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testSimpleTypesAsQueryParams(strings);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testPrimitiveWrapperArrayAsQueryParam".
 */
final class TestPrimitiveWrapperArrayAsQueryParam_Integer_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testPrimitiveWrapperArrayAsQueryParam", Set.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testPrimitiveWrapperArrayAsQueryParam(Set.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pIntegers" to the service implementation via the service channel.
   */
  private final Set<Integer> integers;

  /**
   * Initialize object. All parameters from method "testPrimitiveWrapperArrayAsQueryParam" have to be passed as
   * parameters to this command object.
   *
   * @param pIntegers Set<Integer>
   */
  TestPrimitiveWrapperArrayAsQueryParam_Integer_RESTProductService_Command( Set<Integer> pIntegers ) {
    super(RESTProductService.class);
    integers = pIntegers;
    parameters = new Object[] { integers };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testPrimitiveWrapperArrayAsQueryParam(integers);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testMultivaluedQueryParamsBean".
 */
final class TestMultivaluedQueryParamsBean_MultivaluedQueryParamsBean_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          RESTProductService.class.getMethod("testMultivaluedQueryParamsBean", MultivaluedQueryParamsBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testMultivaluedQueryParamsBean(MultivaluedQueryParamsBean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBean" to the service implementation via the service channel.
   */
  private final MultivaluedQueryParamsBean bean;

  /**
   * Initialize object. All parameters from method "testMultivaluedQueryParamsBean" have to be passed as parameters to
   * this command object.
   *
   * @param pBean MultivaluedQueryParamsBean
   */
  TestMultivaluedQueryParamsBean_MultivaluedQueryParamsBean_RESTProductService_Command(
      MultivaluedQueryParamsBean pBean ) {
    super(RESTProductService.class);
    bean = pBean;
    parameters = new Object[] { bean };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMultivaluedQueryParamsBean(bean);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testMulitvaluedDataTypeAsQueryParam".
 */
final class TestMulitvaluedDataTypeAsQueryParam_IntegerCodeType_LongCode_BookingID_OffsetDateTime_LocalDate_RESTProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testMulitvaluedDataTypeAsQueryParam", List.class, Set.class,
          List.class, List.class, SortedSet.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testMulitvaluedDataTypeAsQueryParam(List.class, Set.class, List.class, List.class, SortedSet.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCodes" to the service implementation via the service channel.
   */
  private final List<IntegerCodeType> codes;

  /**
   * Attribute transports the method parameter "pLongCodes" to the service implementation via the service channel.
   */
  private final Set<LongCode> longCodes;

  /**
   * Attribute transports the method parameter "pBookingIDs" to the service implementation via the service channel.
   */
  private final List<BookingID> bookingIDs;

  /**
   * Attribute transports the method parameter "pTimestamps" to the service implementation via the service channel.
   */
  private final List<OffsetDateTime> timestamps;

  /**
   * Attribute transports the method parameter "pLocalDates" to the service implementation via the service channel.
   */
  private final SortedSet<LocalDate> localDates;

  /**
   * Initialize object. All parameters from method "testMulitvaluedDataTypeAsQueryParam" have to be passed as parameters
   * to this command object.
   *
   * @param pCodes List<IntegerCodeType>
   * @param pLongCodes Set<LongCode>
   * @param pBookingIDs List<BookingID>
   * @param pTimestamps List<OffsetDateTime>
   * @param pLocalDates SortedSet<LocalDate>
   */
  TestMulitvaluedDataTypeAsQueryParam_IntegerCodeType_LongCode_BookingID_OffsetDateTime_LocalDate_RESTProductService_Command(
      List<IntegerCodeType> pCodes, Set<LongCode> pLongCodes, List<BookingID> pBookingIDs,
      List<OffsetDateTime> pTimestamps, SortedSet<LocalDate> pLocalDates ) {
    super(RESTProductService.class);
    codes = pCodes;
    longCodes = pLongCodes;
    bookingIDs = pBookingIDs;
    timestamps = pTimestamps;
    localDates = pLocalDates;
    parameters = new Object[] { codes, longCodes, bookingIDs, timestamps, localDates };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMulitvaluedDataTypeAsQueryParam(codes, longCodes, bookingIDs,
        timestamps, localDates);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testMulitvaluedDataTypeAsBeanQueryParam".
 */
final class TestMulitvaluedDataTypeAsBeanQueryParam_DataTypesQueryBean_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD =
          RESTProductService.class.getMethod("testMulitvaluedDataTypeAsBeanQueryParam", DataTypesQueryBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testMulitvaluedDataTypeAsBeanQueryParam(DataTypesQueryBean.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pQueryBean" to the service implementation via the service channel.
   */
  private final DataTypesQueryBean queryBean;

  /**
   * Initialize object. All parameters from method "testMulitvaluedDataTypeAsBeanQueryParam" have to be passed as
   * parameters to this command object.
   *
   * @param pQueryBean DataTypesQueryBean
   */
  TestMulitvaluedDataTypeAsBeanQueryParam_DataTypesQueryBean_RESTProductService_Command(
      DataTypesQueryBean pQueryBean ) {
    super(RESTProductService.class);
    queryBean = pQueryBean;
    parameters = new Object[] { queryBean };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMulitvaluedDataTypeAsBeanQueryParam(queryBean);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testMultiValuedHeaderFieldsInBeanParam".
 */
final class TestMultiValuedHeaderFieldsInBeanParam_MultiValuedHeaderBeanParam_RESTProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testMultiValuedHeaderFieldsInBeanParam",
          MultiValuedHeaderBeanParam.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testMultiValuedHeaderFieldsInBeanParam(MultiValuedHeaderBeanParam.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pMultiValuedBean" to the service implementation via the service channel.
   */
  private final MultiValuedHeaderBeanParam multiValuedBean;

  /**
   * Initialize object. All parameters from method "testMultiValuedHeaderFieldsInBeanParam" have to be passed as
   * parameters to this command object.
   *
   * @param pMultiValuedBean MultiValuedHeaderBeanParam
   */
  TestMultiValuedHeaderFieldsInBeanParam_MultiValuedHeaderBeanParam_RESTProductService_Command(
      MultiValuedHeaderBeanParam pMultiValuedBean ) {
    super(RESTProductService.class);
    multiValuedBean = pMultiValuedBean;
    parameters = new Object[] { multiValuedBean };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMultiValuedHeaderFieldsInBeanParam(multiValuedBean);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testMultiValuedHeaderFields".
 */
final class TestMultiValuedHeaderFields_String_int_Double_StringCode_OffsetDateTime_OffsetDateTime_OffsetTime_RESTProductService_Command
    extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testMultiValuedHeaderFields", Set.class, int[].class,
          Set.class, Set.class, OffsetDateTime.class, Set.class, Set.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(),
          "testMultiValuedHeaderFields(Set.class, int[].class, Set.class, Set.class, OffsetDateTime.class, Set.class, Set.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pNames" to the service implementation via the service channel.
   */
  private final Set<String> names;

  /**
   * Attribute transports the method parameter "pInts" to the service implementation via the service channel.
   */
  private final int[] ints;

  /**
   * Attribute transports the method parameter "pDoubles" to the service implementation via the service channel.
   */
  private final Set<Double> doubles;

  /**
   * Attribute transports the method parameter "pCodes" to the service implementation via the service channel.
   */
  private final Set<StringCode> codes;

  /**
   * Attribute transports the method parameter "pStartDate" to the service implementation via the service channel.
   */
  private final OffsetDateTime startDate;

  /**
   * Attribute transports the method parameter "pTimestamps" to the service implementation via the service channel.
   */
  private final Set<OffsetDateTime> timestamps;

  /**
   * Attribute transports the method parameter "pTimes" to the service implementation via the service channel.
   */
  private final Set<OffsetTime> times;

  /**
   * Initialize object. All parameters from method "testMultiValuedHeaderFields" have to be passed as parameters to this
   * command object.
   *
   * @param pNames Set<String>
   * @param pInts int[]
   * @param pDoubles Set<Double>
   * @param pCodes Set<StringCode>
   * @param pStartDate OffsetDateTime
   * @param pTimestamps Set<OffsetDateTime>
   * @param pTimes Set<OffsetTime>
   */
  TestMultiValuedHeaderFields_String_int_Double_StringCode_OffsetDateTime_OffsetDateTime_OffsetTime_RESTProductService_Command(
      Set<String> pNames, int[] pInts, Set<Double> pDoubles, Set<StringCode> pCodes, OffsetDateTime pStartDate,
      Set<OffsetDateTime> pTimestamps, Set<OffsetTime> pTimes ) {
    super(RESTProductService.class);
    names = pNames;
    ints = pInts;
    doubles = pDoubles;
    codes = pCodes;
    startDate = pStartDate;
    timestamps = pTimestamps;
    times = pTimes;
    parameters = new Object[] { names, ints, doubles, codes, startDate, timestamps, times };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult =
        (Serializable) lService.testMultiValuedHeaderFields(names, ints, doubles, codes, startDate, timestamps, times);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    return lResult;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testBookingIDAsPathParam".
 */
final class TestBookingIDAsPathParam_BookingID_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testBookingIDAsPathParam", BookingID.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testBookingIDAsPathParam(BookingID.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBookingID" to the service implementation via the service channel.
   */
  private final BookingID bookingID;

  /**
   * Initialize object. All parameters from method "testBookingIDAsPathParam" have to be passed as parameters to this
   * command object.
   *
   * @param pBookingID BookingID
   */
  TestBookingIDAsPathParam_BookingID_RESTProductService_Command( BookingID pBookingID ) {
    super(RESTProductService.class);
    bookingID = pBookingID;
    parameters = new Object[] { bookingID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testBookingIDAsPathParam(bookingID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}

/**
 * Generated command class for service method "testBookingIDAsHeaderParam".
 */
final class TestBookingIDAsHeaderParam_BookingID_RESTProductService_Command extends Command {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for factor to convert nano seconds to milliseconds.
   */
  private static final int MILLISECONDS = 1000 * 1000;

  /**
   * Constant describes the service method that is called by this proxy class.
   */
  private static final Method SERVICE_METHOD;

  /**
   * Object array with all parameters that are passed to the service.
   */
  private final Object[] parameters;
  /**
   * Initializer is used to get the method object describing the called service method only once.
   */
  static {
    try {
      SERVICE_METHOD = RESTProductService.class.getMethod("testBookingIDAsHeaderParam", BookingID.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e,
          RESTProductService.class.getName(), "testBookingIDAsHeaderParam(BookingID.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBookingID" to the service implementation via the service channel.
   */
  private final BookingID bookingID;

  /**
   * Initialize object. All parameters from method "testBookingIDAsHeaderParam" have to be passed as parameters to this
   * command object.
   *
   * @param pBookingID BookingID
   */
  TestBookingIDAsHeaderParam_BookingID_RESTProductService_Command( BookingID pBookingID ) {
    super(RESTProductService.class);
    bookingID = pBookingID;
    parameters = new Object[] { bookingID };
  }

  /**
   * Method executes the service call represented by this command object via JEAFs service channel.
   *
   * @param pTargetService Reference to the service which should be called by this command. The parameter must not be
   * null.
   * @return Serializable Result object of the service call. Due to the fact that all returned objects of remote calls
   * in Java (EJBs e.g.) have to be serializable services always have to return serializable objects no matter if it
   * will be serialized or not. If a service method has no return type (void) then the method returns null. Service
   * methods also may return null as return value.
   */
  @Override
  public Serializable execute( Service pTargetService ) {
    // Execute service call.
    RESTProductService lService = (RESTProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testBookingIDAsHeaderParam(bookingID);
    // Calculate duration of service call in milliseconds
    String lDuration = Long.toString((System.nanoTime() - lStartTime) / MILLISECONDS);
    // Trace result of service call.
    lTrace.write(MessageConstants.RETURNING_FROM_SERVICE_CALL, this.getCalledServiceMethod(), lDuration);
    // Method has no return type thus the method returns null.
    return null;
  }

  /**
   * Method returns a method object describing the service method that will be called by this command object.
   *
   * @return {@link Method} Method object describing the called service method. The method never returns null.
   */
  @Override
  public final Method getServiceMethod( ) {
    return SERVICE_METHOD;
  }

  /**
   * Method returns all parameters that will be passed to the service.
   *
   * @return {@link Object} Object array with all parameters that will be passed to the service. The method may return
   * an empty array in case that the method has no parameters.
   */
  @Override
  public Object[] getParameters( ) {
    return parameters;
  }
}
