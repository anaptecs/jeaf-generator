/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.io.Serializable;
import java.lang.reflect.Method;
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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.anaptecs.jeaf.core.api.MessageConstants;
import com.anaptecs.jeaf.core.api.Service;
import com.anaptecs.jeaf.core.servicechannel.api.Command;
import com.anaptecs.jeaf.core.servicechannel.api.ServiceProxy;
import com.anaptecs.jeaf.core.spi.TransactionBehavior;
import com.anaptecs.jeaf.junit.openapi.base.BeanParameter;
import com.anaptecs.jeaf.junit.openapi.base.BigDecimalCode;
import com.anaptecs.jeaf.junit.openapi.base.BooleanLiteralsEnum;
import com.anaptecs.jeaf.junit.openapi.base.Channel;
import com.anaptecs.jeaf.junit.openapi.base.ChannelCode;
import com.anaptecs.jeaf.junit.openapi.base.ChannelType;
import com.anaptecs.jeaf.junit.openapi.base.Context;
import com.anaptecs.jeaf.junit.openapi.base.CurrencyCode;
import com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext;
import com.anaptecs.jeaf.junit.openapi.base.IntegerCodeType;
import com.anaptecs.jeaf.junit.openapi.base.MultiValuedDataType;
import com.anaptecs.jeaf.junit.openapi.base.NotInlinedBeanParam;
import com.anaptecs.jeaf.junit.openapi.base.ParentBeanParamType;
import com.anaptecs.jeaf.junit.openapi.base.Product;
import com.anaptecs.jeaf.junit.openapi.base.Sortiment;
import com.anaptecs.jeaf.junit.openapi.base.SpecialContext;
import com.anaptecs.jeaf.junit.openapi.base.StringCodeType;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.errorhandling.ApplicationException;
import com.anaptecs.jeaf.xfun.api.errorhandling.JEAFSystemException;
import com.anaptecs.jeaf.xfun.api.trace.Trace;

/**
 * ServiceProxy class for JEAF service ProductService.
 */
public final class ProductServiceProxy extends ServiceProxy implements ProductService {
  /**
   * Serial version uid for the proxy class.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize object.
   *
   * @param pTransactionBehavior Definition of transactional behavior. The Parameter must not be null.
   */
  public ProductServiceProxy( TransactionBehavior pTransactionBehavior ) {
    super(ProductService.class, pTransactionBehavior);
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getProducts}
   */
  @SuppressWarnings("unchecked")
  public List<Product> getProducts( ) {
    try {
      Command lCommand = new GetProducts_ProductService_Command();
      return (List<Product>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getProduct}
   */
  public Product getProduct( @NotEmpty String pProductID ) {
    try {
      Command lCommand = new GetProduct_String_ProductService_Command(pProductID);
      return (Product) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#createProduct}
   */
  public boolean createProduct( Product pProduct ) {
    try {
      Command lCommand = new CreateProduct_Product_ProductService_Command(pProduct);
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getSortiment}
   */
  public Sortiment getSortiment( Context pContext ) {
    try {
      Command lCommand = new GetSortiment_Context_ProductService_Command(pContext);
      return (Sortiment) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#createChannelCode}
   */
  public ChannelCode createChannelCode( @NotBlank String pChannelCode ) {
    try {
      Command lCommand = new CreateChannelCode_String_ProductService_Command(pChannelCode);
      return (ChannelCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#ping}
   */
  public void ping( ) {
    try {
      Command lCommand = new Ping_ProductService_Command();
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprecatedOperation}
   */
  @Deprecated
  public String deprecatedOperation( ) {
    try {
      Command lCommand = new DeprecatedOperation_ProductService_Command();
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprecatedContext}
   */
  public String deprecatedContext( DeprecatedContext pContext ) {
    try {
      Command lCommand = new DeprecatedContext_DeprecatedContext_ProductService_Command(pContext);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprecatedBeanParam}
   */
  public void deprecatedBeanParam( BeanParameter pBeanParam ) {
    try {
      Command lCommand = new DeprecatedBeanParam_BeanParameter_ProductService_Command(pBeanParam);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprecatedParams}
   */
  @Deprecated
  public String deprecatedParams( @Deprecated int pParam1 ) {
    try {
      Command lCommand = new DeprecatedParams_int_ProductService_Command(pParam1);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprecatedBody}
   */
  public String deprecatedBody( @Deprecated String pBody ) {
    try {
      Command lCommand = new DeprecatedBody_String_ProductService_Command(pBody);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprectedComplexRequestBody}
   */
  public void deprectedComplexRequestBody( @Deprecated Product pProduct ) {
    try {
      Command lCommand = new DeprectedComplexRequestBody_Product_ProductService_Command(pProduct);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deprecatedComplexReturn}
   */
  @Deprecated
  public Product deprecatedComplexReturn( ) {
    try {
      Command lCommand = new DeprecatedComplexReturn_ProductService_Command();
      return (Product) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#loadSpecificThings}
   */
  public void loadSpecificThings( SpecialContext pContext ) {
    try {
      Command lCommand = new LoadSpecificThings_SpecialContext_ProductService_Command(pContext);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#createChannelCodeFromObject}
   */
  public ChannelCode createChannelCodeFromObject( ChannelCode pChannelCode ) {
    try {
      Command lCommand = new CreateChannelCodeFromObject_ChannelCode_ProductService_Command(pChannelCode);
      return (ChannelCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#addCurrencies}
   */
  @SuppressWarnings("unchecked")
  public List<CurrencyCode> addCurrencies( List<CurrencyCode> pCurrencies ) {
    try {
      Command lCommand = new AddCurrencies_CurrencyCode_ProductService_Command(pCurrencies);
      return (List<CurrencyCode>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#isCurrencySupported}
   */
  public CurrencyCode isCurrencySupported( CurrencyCode pCurrency ) {
    try {
      Command lCommand = new IsCurrencySupported_CurrencyCode_ProductService_Command(pCurrency);
      return (CurrencyCode) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testCodeTypeUsage}
   */
  public IntegerCodeType testCodeTypeUsage( StringCodeType pStringCode ) {
    try {
      Command lCommand = new TestCodeTypeUsage_StringCodeType_ProductService_Command(pStringCode);
      return (IntegerCodeType) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testLocalBeanParamType}
   */
  public String testLocalBeanParamType( LocalBeanParamType pBeanParam ) {
    try {
      Command lCommand = new TestLocalBeanParamType_LocalBeanParamType_ProductService_Command(pBeanParam);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testExternalBeanParameterType}
   */
  public String testExternalBeanParameterType( ParentBeanParamType pParent ) {
    try {
      Command lCommand = new TestExternalBeanParameterType_ParentBeanParamType_ProductService_Command(pParent);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testChildBeanParameter}
   */
  public String testChildBeanParameter( ChildBeanParameterType pChild ) {
    try {
      Command lCommand = new TestChildBeanParameter_ChildBeanParameterType_ProductService_Command(pChild);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#checkIBAN}
   */
  public boolean checkIBAN( String pIBAN ) {
    try {
      Command lCommand = new CheckIBAN_String_ProductService_Command(pIBAN);
      return (boolean) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getChannels}
   */
  @SuppressWarnings("unchecked")
  public List<Channel> getChannels( List<ChannelType> pChannelTypes ) {
    try {
      Command lCommand = new GetChannels_ChannelType_ProductService_Command(pChannelTypes);
      return (List<Channel>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getDefaultChannel}
   */
  public Channel getDefaultChannel( ChannelType pChannelType ) {
    try {
      Command lCommand = new GetDefaultChannel_ChannelType_ProductService_Command(pChannelType);
      return (Channel) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getSupportedCurrencies}
   */
  @SuppressWarnings("unchecked")
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    try {
      Command lCommand = new GetSupportedCurrencies_ChannelCode_ProductService_Command(pChannelCode);
      return (List<CurrencyCode>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#getSupportedCurrenciesAsync}
   */
  @SuppressWarnings("unchecked")
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    try {
      Command lCommand = new GetSupportedCurrenciesAsync_ChannelCode_ProductService_Command(pChannelCode);
      return (List<CurrencyCode>) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testDateQueryParams}
   */
  public void testDateQueryParams( String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime,
      LocalDateTime pLocalStartTimestamp, LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar,
      java.util.Date pUtilDate, Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    try {
      Command lCommand =
          new TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command(
              pPath, pStartTimestamp, pStartTime, pLocalStartTimestamp, pLocalStartTime, pLocalStartDate, pCalendar,
              pUtilDate, pSQLTimestamp, pSQLTime, pSQLDate);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testDateQueryParamsBean}
   */
  public void testDateQueryParamsBean( String pPath, DateQueryParamsBean pQueryParams ) {
    try {
      Command lCommand =
          new TestDateQueryParamsBean_String_DateQueryParamsBean_ProductService_Command(pPath, pQueryParams);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testOptionalQueryParams}
   */
  public String testOptionalQueryParams( String query1, int query2 ) {
    try {
      Command lCommand = new TestOptionalQueryParams_String_int_ProductService_Command(query1, query2);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testSpecialHeaderParams}
   */
  public void testSpecialHeaderParams( String authorization, String pContentType, String pAccept ) {
    try {
      Command lCommand =
          new TestSpecialHeaderParams_String_String_String_ProductService_Command(authorization, pContentType, pAccept);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testTechnicalHeaderBean}
   */
  public String testTechnicalHeaderBean( TechnicalHeaderContext pContext ) {
    try {
      Command lCommand = new TestTechnicalHeaderBean_TechnicalHeaderContext_ProductService_Command(pContext);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testTechnicalHeaderParam}
   */
  public String testTechnicalHeaderParam( String pReseller ) {
    try {
      Command lCommand = new TestTechnicalHeaderParam_String_String_ProductService_Command(pReseller);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testNotInlinedBeanParam}
   */
  public void testNotInlinedBeanParam( NotInlinedBeanParam pInlinedBeanParam ) {
    try {
      Command lCommand = new TestNotInlinedBeanParam_NotInlinedBeanParam_ProductService_Command(pInlinedBeanParam);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testPrimitiveArray}
   */
  public void testPrimitiveArray( int[] pIntegerArray ) {
    try {
      Command lCommand = new TestPrimitiveArray_int_ProductService_Command(pIntegerArray);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testPrimitiveArrayAsQueryParam}
   */
  public String testPrimitiveArrayAsQueryParam( int[] pIntValues ) {
    try {
      Command lCommand = new TestPrimitiveArrayAsQueryParam_int_ProductService_Command(pIntValues);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testMultivaluedHeader}
   */
  public String testMultivaluedHeader( List<BigDecimalCode> pCodes ) {
    try {
      Command lCommand = new TestMultivaluedHeader_BigDecimalCode_ProductService_Command(pCodes);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testMultivaluedQueryParams}
   */
  public String testMultivaluedQueryParams( List<BigDecimalCode> pCodes, List<BooleanLiteralsEnum> pEnums ) {
    try {
      Command lCommand =
          new TestMultivaluedQueryParams_BigDecimalCode_BooleanLiteralsEnum_ProductService_Command(pCodes, pEnums);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#testMulitValuedBeanParams}
   */
  public String testMulitValuedBeanParams( MultiValuedDataType pBeanParam, BooleanLiteralsEnum pTheEnum ) {
    try {
      Command lCommand = new TestMulitValuedBeanParams_MultiValuedDataType_BooleanLiteralsEnum_ProductService_Command(
          pBeanParam, pTheEnum);
      return (String) this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#noReturnType}
   */
  public void noReturnType( String pHeader, MultiValuedDataType pContext ) {
    try {
      Command lCommand = new NoReturnType_String_MultiValuedDataType_ProductService_Command(pHeader, pContext);
      this.executeCommand(lCommand);
    }
    catch (ApplicationException e) {
      throw new JEAFSystemException(e.getErrorCode(), e, e.getMessageParameters());
    }
  }

  /**
   * Generated proxy implementation for method
   * {@link com.anaptecs.jeaf.junit.openapi.service1.ProductService#deleteSomething}
   */
  public void deleteSomething( String pID ) {
    try {
      Command lCommand = new DeleteSomething_String_ProductService_Command(pID);
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
final class GetProducts_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getProducts");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getProducts(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "getProducts" have to be passed as parameters to this command object.
   *
   *
   */
  GetProducts_ProductService_Command( ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getProducts();
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
final class GetProduct_String_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getProduct", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getProduct(String.class)");
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
  GetProduct_String_ProductService_Command( @NotEmpty String pProductID ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
final class CreateProduct_Product_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("createProduct", Product.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "createProduct(Product.class)");
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
  CreateProduct_Product_ProductService_Command( Product pProduct ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
final class GetSortiment_Context_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getSortiment", Context.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getSortiment(Context.class)");
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
  GetSortiment_Context_ProductService_Command( Context pContext ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
final class CreateChannelCode_String_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("createChannelCode", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "createChannelCode(String.class)");
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
  CreateChannelCode_String_ProductService_Command( @NotBlank String pChannelCode ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
final class Ping_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("ping");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "ping(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "ping" have to be passed as parameters to this command object.
   *
   *
   */
  Ping_ProductService_Command( ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
 * Generated command class for service method "deprecatedOperation".
 */
final class DeprecatedOperation_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedOperation");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedOperation(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "deprecatedOperation" have to be passed as parameters to this command
   * object.
   *
   *
   */
  DeprecatedOperation_ProductService_Command( ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedOperation();
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
 * Generated command class for service method "deprecatedContext".
 */
final class DeprecatedContext_DeprecatedContext_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedContext", DeprecatedContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedContext(DeprecatedContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final DeprecatedContext context;

  /**
   * Initialize object. All parameters from method "deprecatedContext" have to be passed as parameters to this command
   * object.
   *
   * @param pContext DeprecatedContext
   */
  DeprecatedContext_DeprecatedContext_ProductService_Command( DeprecatedContext pContext ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedContext(context);
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
 * Generated command class for service method "deprecatedBeanParam".
 */
final class DeprecatedBeanParam_BeanParameter_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedBeanParam", BeanParameter.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedBeanParam(BeanParameter.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBeanParam" to the service implementation via the service channel.
   */
  private final BeanParameter beanParam;

  /**
   * Initialize object. All parameters from method "deprecatedBeanParam" have to be passed as parameters to this command
   * object.
   *
   * @param pBeanParam BeanParameter
   */
  DeprecatedBeanParam_BeanParameter_ProductService_Command( BeanParameter pBeanParam ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.deprecatedBeanParam(beanParam);
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
 * Generated command class for service method "deprecatedParams".
 */
final class DeprecatedParams_int_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedParams", int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedParams(int.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pParam1" to the service implementation via the service channel.
   */
  private final int param1;

  /**
   * Initialize object. All parameters from method "deprecatedParams" have to be passed as parameters to this command
   * object.
   *
   * @param pParam1 int
   */
  DeprecatedParams_int_ProductService_Command( @Deprecated int pParam1 ) {
    super(ProductService.class);
    param1 = pParam1;
    parameters = new Object[] { param1 };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedParams(param1);
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
 * Generated command class for service method "deprecatedBody".
 */
final class DeprecatedBody_String_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedBody", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedBody(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBody" to the service implementation via the service channel.
   */
  private final String body;

  /**
   * Initialize object. All parameters from method "deprecatedBody" have to be passed as parameters to this command
   * object.
   *
   * @param pBody String
   */
  DeprecatedBody_String_ProductService_Command( @Deprecated String pBody ) {
    super(ProductService.class);
    body = pBody;
    parameters = new Object[] { body };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedBody(body);
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
 * Generated command class for service method "deprectedComplexRequestBody".
 */
final class DeprectedComplexRequestBody_Product_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprectedComplexRequestBody", Product.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprectedComplexRequestBody(Product.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pProduct" to the service implementation via the service channel.
   */
  private final Product product;

  /**
   * Initialize object. All parameters from method "deprectedComplexRequestBody" have to be passed as parameters to this
   * command object.
   *
   * @param pProduct Product
   */
  DeprectedComplexRequestBody_Product_ProductService_Command( @Deprecated Product pProduct ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.deprectedComplexRequestBody(product);
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
 * Generated command class for service method "deprecatedComplexReturn".
 */
final class DeprecatedComplexReturn_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deprecatedComplexReturn");
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deprecatedComplexReturn(null)");
    }
  }

  /**
   * Initialize object. All parameters from method "deprecatedComplexReturn" have to be passed as parameters to this
   * command object.
   *
   *
   */
  DeprecatedComplexReturn_ProductService_Command( ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.deprecatedComplexReturn();
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
 * Generated command class for service method "loadSpecificThings".
 */
final class LoadSpecificThings_SpecialContext_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("loadSpecificThings", SpecialContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "loadSpecificThings(SpecialContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final SpecialContext context;

  /**
   * Initialize object. All parameters from method "loadSpecificThings" have to be passed as parameters to this command
   * object.
   *
   * @param pContext SpecialContext
   */
  LoadSpecificThings_SpecialContext_ProductService_Command( SpecialContext pContext ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.loadSpecificThings(context);
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
 * Generated command class for service method "createChannelCodeFromObject".
 */
final class CreateChannelCodeFromObject_ChannelCode_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("createChannelCodeFromObject", ChannelCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "createChannelCodeFromObject(ChannelCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelCode" to the service implementation via the service channel.
   */
  private final ChannelCode channelCode;

  /**
   * Initialize object. All parameters from method "createChannelCodeFromObject" have to be passed as parameters to this
   * command object.
   *
   * @param pChannelCode ChannelCode
   */
  CreateChannelCodeFromObject_ChannelCode_ProductService_Command( ChannelCode pChannelCode ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.createChannelCodeFromObject(channelCode);
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
 * Generated command class for service method "addCurrencies".
 */
final class AddCurrencies_CurrencyCode_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("addCurrencies", List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "addCurrencies(List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCurrencies" to the service implementation via the service channel.
   */
  private final List<CurrencyCode> currencies;

  /**
   * Initialize object. All parameters from method "addCurrencies" have to be passed as parameters to this command
   * object.
   *
   * @param pCurrencies List<CurrencyCode>
   */
  AddCurrencies_CurrencyCode_ProductService_Command( List<CurrencyCode> pCurrencies ) {
    super(ProductService.class);
    currencies = pCurrencies;
    parameters = new Object[] { currencies };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.addCurrencies(currencies);
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
 * Generated command class for service method "isCurrencySupported".
 */
final class IsCurrencySupported_CurrencyCode_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("isCurrencySupported", CurrencyCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "isCurrencySupported(CurrencyCode.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCurrency" to the service implementation via the service channel.
   */
  private final CurrencyCode currency;

  /**
   * Initialize object. All parameters from method "isCurrencySupported" have to be passed as parameters to this command
   * object.
   *
   * @param pCurrency CurrencyCode
   */
  IsCurrencySupported_CurrencyCode_ProductService_Command( CurrencyCode pCurrency ) {
    super(ProductService.class);
    currency = pCurrency;
    parameters = new Object[] { currency };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.isCurrencySupported(currency);
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
 * Generated command class for service method "testCodeTypeUsage".
 */
final class TestCodeTypeUsage_StringCodeType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testCodeTypeUsage", StringCodeType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testCodeTypeUsage(StringCodeType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pStringCode" to the service implementation via the service channel.
   */
  private final StringCodeType stringCode;

  /**
   * Initialize object. All parameters from method "testCodeTypeUsage" have to be passed as parameters to this command
   * object.
   *
   * @param pStringCode StringCodeType
   */
  TestCodeTypeUsage_StringCodeType_ProductService_Command( StringCodeType pStringCode ) {
    super(ProductService.class);
    stringCode = pStringCode;
    parameters = new Object[] { stringCode };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testCodeTypeUsage(stringCode);
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
 * Generated command class for service method "testLocalBeanParamType".
 */
final class TestLocalBeanParamType_LocalBeanParamType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testLocalBeanParamType", LocalBeanParamType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testLocalBeanParamType(LocalBeanParamType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBeanParam" to the service implementation via the service channel.
   */
  private final LocalBeanParamType beanParam;

  /**
   * Initialize object. All parameters from method "testLocalBeanParamType" have to be passed as parameters to this
   * command object.
   *
   * @param pBeanParam LocalBeanParamType
   */
  TestLocalBeanParamType_LocalBeanParamType_ProductService_Command( LocalBeanParamType pBeanParam ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testLocalBeanParamType(beanParam);
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
 * Generated command class for service method "testExternalBeanParameterType".
 */
final class TestExternalBeanParameterType_ParentBeanParamType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testExternalBeanParameterType", ParentBeanParamType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testExternalBeanParameterType(ParentBeanParamType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pParent" to the service implementation via the service channel.
   */
  private final ParentBeanParamType parent;

  /**
   * Initialize object. All parameters from method "testExternalBeanParameterType" have to be passed as parameters to
   * this command object.
   *
   * @param pParent ParentBeanParamType
   */
  TestExternalBeanParameterType_ParentBeanParamType_ProductService_Command( ParentBeanParamType pParent ) {
    super(ProductService.class);
    parent = pParent;
    parameters = new Object[] { parent };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testExternalBeanParameterType(parent);
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
 * Generated command class for service method "testChildBeanParameter".
 */
final class TestChildBeanParameter_ChildBeanParameterType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testChildBeanParameter", ChildBeanParameterType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testChildBeanParameter(ChildBeanParameterType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChild" to the service implementation via the service channel.
   */
  private final ChildBeanParameterType child;

  /**
   * Initialize object. All parameters from method "testChildBeanParameter" have to be passed as parameters to this
   * command object.
   *
   * @param pChild ChildBeanParameterType
   */
  TestChildBeanParameter_ChildBeanParameterType_ProductService_Command( ChildBeanParameterType pChild ) {
    super(ProductService.class);
    child = pChild;
    parameters = new Object[] { child };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testChildBeanParameter(child);
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
 * Generated command class for service method "checkIBAN".
 */
final class CheckIBAN_String_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("checkIBAN", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "checkIBAN(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pIBAN" to the service implementation via the service channel.
   */
  private final String iBAN;

  /**
   * Initialize object. All parameters from method "checkIBAN" have to be passed as parameters to this command object.
   *
   * @param pIBAN String
   */
  CheckIBAN_String_ProductService_Command( String pIBAN ) {
    super(ProductService.class);
    iBAN = pIBAN;
    parameters = new Object[] { iBAN };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.checkIBAN(iBAN);
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
 * Generated command class for service method "getChannels".
 */
final class GetChannels_ChannelType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getChannels", List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getChannels(List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelTypes" to the service implementation via the service channel.
   */
  private final List<ChannelType> channelTypes;

  /**
   * Initialize object. All parameters from method "getChannels" have to be passed as parameters to this command object.
   *
   * @param pChannelTypes List<ChannelType>
   */
  GetChannels_ChannelType_ProductService_Command( List<ChannelType> pChannelTypes ) {
    super(ProductService.class);
    channelTypes = pChannelTypes;
    parameters = new Object[] { channelTypes };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getChannels(channelTypes);
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
 * Generated command class for service method "getDefaultChannel".
 */
final class GetDefaultChannel_ChannelType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getDefaultChannel", ChannelType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getDefaultChannel(ChannelType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pChannelType" to the service implementation via the service channel.
   */
  private final ChannelType channelType;

  /**
   * Initialize object. All parameters from method "getDefaultChannel" have to be passed as parameters to this command
   * object.
   *
   * @param pChannelType ChannelType
   */
  GetDefaultChannel_ChannelType_ProductService_Command( ChannelType pChannelType ) {
    super(ProductService.class);
    channelType = pChannelType;
    parameters = new Object[] { channelType };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.getDefaultChannel(channelType);
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
 * Generated command class for service method "getSupportedCurrencies".
 */
final class GetSupportedCurrencies_ChannelCode_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getSupportedCurrencies", ChannelCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getSupportedCurrencies(ChannelCode.class)");
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
  GetSupportedCurrencies_ChannelCode_ProductService_Command( ChannelCode pChannelCode ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
final class GetSupportedCurrenciesAsync_ChannelCode_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("getSupportedCurrenciesAsync", ChannelCode.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "getSupportedCurrenciesAsync(ChannelCode.class)");
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
  GetSupportedCurrenciesAsync_ChannelCode_ProductService_Command( ChannelCode pChannelCode ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
 * Generated command class for service method "testDateQueryParams".
 */
final class TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command
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
      SERVICE_METHOD = ProductService.class.getMethod("testDateQueryParams", String.class, OffsetDateTime.class,
          OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class,
          Timestamp.class, Time.class, Date.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testDateQueryParams(String.class, OffsetDateTime.class, OffsetTime.class, LocalDateTime.class, LocalTime.class, LocalDate.class, Calendar.class, java.util.Date.class, Timestamp.class, Time.class, Date.class)");
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
   */
  TestDateQueryParams_String_OffsetDateTime_OffsetTime_LocalDateTime_LocalTime_LocalDate_Calendar_Date_Timestamp_Time_Date_ProductService_Command(
      String pPath, OffsetDateTime pStartTimestamp, OffsetTime pStartTime, LocalDateTime pLocalStartTimestamp,
      LocalTime pLocalStartTime, LocalDate pLocalStartDate, Calendar pCalendar, java.util.Date pUtilDate,
      Timestamp pSQLTimestamp, Time pSQLTime, Date pSQLDate ) {
    super(ProductService.class);
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
    parameters = new Object[] { path, startTimestamp, startTime, localStartTimestamp, localStartTime, localStartDate,
      calendar, utilDate, sQLTimestamp, sQLTime, sQLDate };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testDateQueryParams(path, startTimestamp, startTime, localStartTimestamp, localStartTime, localStartDate,
        calendar, utilDate, sQLTimestamp, sQLTime, sQLDate);
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
final class TestDateQueryParamsBean_String_DateQueryParamsBean_ProductService_Command extends Command {
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
          ProductService.class.getMethod("testDateQueryParamsBean", String.class, DateQueryParamsBean.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testDateQueryParamsBean(String.class, DateQueryParamsBean.class)");
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
  TestDateQueryParamsBean_String_DateQueryParamsBean_ProductService_Command( String pPath,
      DateQueryParamsBean pQueryParams ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
 * Generated command class for service method "testOptionalQueryParams".
 */
final class TestOptionalQueryParams_String_int_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testOptionalQueryParams", String.class, int.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testOptionalQueryParams(String.class, int.class)");
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
  TestOptionalQueryParams_String_int_ProductService_Command( String query1, int query2 ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
 * Generated command class for service method "testSpecialHeaderParams".
 */
final class TestSpecialHeaderParams_String_String_String_ProductService_Command extends Command {
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
          ProductService.class.getMethod("testSpecialHeaderParams", String.class, String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testSpecialHeaderParams(String.class, String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "authorization" to the service implementation via the service channel.
   */
  private final String uthorization;

  /**
   * Attribute transports the method parameter "pContentType" to the service implementation via the service channel.
   */
  private final String contentType;

  /**
   * Attribute transports the method parameter "pAccept" to the service implementation via the service channel.
   */
  private final String accept;

  /**
   * Initialize object. All parameters from method "testSpecialHeaderParams" have to be passed as parameters to this
   * command object.
   *
   * @param authorization String
   * @param pContentType String
   * @param pAccept String
   */
  TestSpecialHeaderParams_String_String_String_ProductService_Command( String authorization, String pContentType,
      String pAccept ) {
    super(ProductService.class);
    uthorization = authorization;
    contentType = pContentType;
    accept = pAccept;
    parameters = new Object[] { uthorization, contentType, accept };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testSpecialHeaderParams(uthorization, contentType, accept);
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
 * Generated command class for service method "testTechnicalHeaderBean".
 */
final class TestTechnicalHeaderBean_TechnicalHeaderContext_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testTechnicalHeaderBean", TechnicalHeaderContext.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testTechnicalHeaderBean(TechnicalHeaderContext.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final TechnicalHeaderContext context;

  /**
   * Initialize object. All parameters from method "testTechnicalHeaderBean" have to be passed as parameters to this
   * command object.
   *
   * @param pContext TechnicalHeaderContext
   */
  TestTechnicalHeaderBean_TechnicalHeaderContext_ProductService_Command( TechnicalHeaderContext pContext ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testTechnicalHeaderBean(context);
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
 * Generated command class for service method "testTechnicalHeaderParam".
 */
final class TestTechnicalHeaderParam_String_String_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testTechnicalHeaderParam", String.class, String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testTechnicalHeaderParam(String.class, String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pReseller" to the service implementation via the service channel.
   */
  private final String reseller;

  /**
   * Initialize object. All parameters from method "testTechnicalHeaderParam" have to be passed as parameters to this
   * command object.
   *
   * @param pReseller String
   * @param pAuthenticationToken String
   */
  TestTechnicalHeaderParam_String_String_ProductService_Command( String pReseller ) {
    super(ProductService.class);
    reseller = pReseller;
    parameters = new Object[] { reseller };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testTechnicalHeaderParam(reseller);
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
 * Generated command class for service method "testNotInlinedBeanParam".
 */
final class TestNotInlinedBeanParam_NotInlinedBeanParam_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testNotInlinedBeanParam", NotInlinedBeanParam.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testNotInlinedBeanParam(NotInlinedBeanParam.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pInlinedBeanParam" to the service implementation via the service
   * channel.
   */
  private final NotInlinedBeanParam inlinedBeanParam;

  /**
   * Initialize object. All parameters from method "testNotInlinedBeanParam" have to be passed as parameters to this
   * command object.
   *
   * @param pInlinedBeanParam NotInlinedBeanParam
   */
  TestNotInlinedBeanParam_NotInlinedBeanParam_ProductService_Command( NotInlinedBeanParam pInlinedBeanParam ) {
    super(ProductService.class);
    inlinedBeanParam = pInlinedBeanParam;
    parameters = new Object[] { inlinedBeanParam };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testNotInlinedBeanParam(inlinedBeanParam);
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
 * Generated command class for service method "testPrimitiveArray".
 */
final class TestPrimitiveArray_int_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testPrimitiveArray", int[].class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testPrimitiveArray(int[].class)");
    }
  }

  /**
   * Attribute transports the method parameter "pIntegerArray" to the service implementation via the service channel.
   */
  private final int[] integerArray;

  /**
   * Initialize object. All parameters from method "testPrimitiveArray" have to be passed as parameters to this command
   * object.
   *
   * @param pIntegerArray int[]
   */
  TestPrimitiveArray_int_ProductService_Command( int[] pIntegerArray ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.testPrimitiveArray(integerArray);
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
 * Generated command class for service method "testPrimitiveArrayAsQueryParam".
 */
final class TestPrimitiveArrayAsQueryParam_int_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testPrimitiveArrayAsQueryParam", int[].class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testPrimitiveArrayAsQueryParam(int[].class)");
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
  TestPrimitiveArrayAsQueryParam_int_ProductService_Command( int[] pIntValues ) {
    super(ProductService.class);
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
    ProductService lService = (ProductService) pTargetService;
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
 * Generated command class for service method "testMultivaluedHeader".
 */
final class TestMultivaluedHeader_BigDecimalCode_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testMultivaluedHeader", List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testMultivaluedHeader(List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCodes" to the service implementation via the service channel.
   */
  private final List<BigDecimalCode> codes;

  /**
   * Initialize object. All parameters from method "testMultivaluedHeader" have to be passed as parameters to this
   * command object.
   *
   * @param pCodes List<BigDecimalCode>
   */
  TestMultivaluedHeader_BigDecimalCode_ProductService_Command( List<BigDecimalCode> pCodes ) {
    super(ProductService.class);
    codes = pCodes;
    parameters = new Object[] { codes };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMultivaluedHeader(codes);
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
 * Generated command class for service method "testMultivaluedQueryParams".
 */
final class TestMultivaluedQueryParams_BigDecimalCode_BooleanLiteralsEnum_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testMultivaluedQueryParams", List.class, List.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testMultivaluedQueryParams(List.class, List.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pCodes" to the service implementation via the service channel.
   */
  private final List<BigDecimalCode> codes;

  /**
   * Attribute transports the method parameter "pEnums" to the service implementation via the service channel.
   */
  private final List<BooleanLiteralsEnum> enums;

  /**
   * Initialize object. All parameters from method "testMultivaluedQueryParams" have to be passed as parameters to this
   * command object.
   *
   * @param pCodes List<BigDecimalCode>
   * @param pEnums List<BooleanLiteralsEnum>
   */
  TestMultivaluedQueryParams_BigDecimalCode_BooleanLiteralsEnum_ProductService_Command( List<BigDecimalCode> pCodes,
      List<BooleanLiteralsEnum> pEnums ) {
    super(ProductService.class);
    codes = pCodes;
    enums = pEnums;
    parameters = new Object[] { codes, enums };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMultivaluedQueryParams(codes, enums);
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
 * Generated command class for service method "testMulitValuedBeanParams".
 */
final class TestMulitValuedBeanParams_MultiValuedDataType_BooleanLiteralsEnum_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("testMulitValuedBeanParams", MultiValuedDataType.class,
          BooleanLiteralsEnum.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "testMulitValuedBeanParams(MultiValuedDataType.class, BooleanLiteralsEnum.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pBeanParam" to the service implementation via the service channel.
   */
  private final MultiValuedDataType beanParam;

  /**
   * Attribute transports the method parameter "pTheEnum" to the service implementation via the service channel.
   */
  private final BooleanLiteralsEnum theEnum;

  /**
   * Initialize object. All parameters from method "testMulitValuedBeanParams" have to be passed as parameters to this
   * command object.
   *
   * @param pBeanParam MultiValuedDataType
   * @param pTheEnum BooleanLiteralsEnum
   */
  TestMulitValuedBeanParams_MultiValuedDataType_BooleanLiteralsEnum_ProductService_Command(
      MultiValuedDataType pBeanParam, BooleanLiteralsEnum pTheEnum ) {
    super(ProductService.class);
    beanParam = pBeanParam;
    theEnum = pTheEnum;
    parameters = new Object[] { beanParam, theEnum };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    Serializable lResult = (Serializable) lService.testMulitValuedBeanParams(beanParam, theEnum);
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
 * Generated command class for service method "noReturnType".
 */
final class NoReturnType_String_MultiValuedDataType_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("noReturnType", String.class, MultiValuedDataType.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "noReturnType(String.class, MultiValuedDataType.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pHeader" to the service implementation via the service channel.
   */
  private final String header;

  /**
   * Attribute transports the method parameter "pContext" to the service implementation via the service channel.
   */
  private final MultiValuedDataType context;

  /**
   * Initialize object. All parameters from method "noReturnType" have to be passed as parameters to this command
   * object.
   *
   * @param pHeader String
   * @param pContext MultiValuedDataType
   */
  NoReturnType_String_MultiValuedDataType_ProductService_Command( String pHeader, MultiValuedDataType pContext ) {
    super(ProductService.class);
    header = pHeader;
    context = pContext;
    parameters = new Object[] { header, context };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.noReturnType(header, context);
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
 * Generated command class for service method "deleteSomething".
 */
final class DeleteSomething_String_ProductService_Command extends Command {
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
      SERVICE_METHOD = ProductService.class.getMethod("deleteSomething", String.class);
    }
    catch (NoSuchMethodException e) {
      throw new JEAFSystemException(MessageConstants.SERVICE_METHOD_DOES_NOT_EXIST, e, ProductService.class.getName(),
          "deleteSomething(String.class)");
    }
  }

  /**
   * Attribute transports the method parameter "pID" to the service implementation via the service channel.
   */
  private final String iD;

  /**
   * Initialize object. All parameters from method "deleteSomething" have to be passed as parameters to this command
   * object.
   *
   * @param pID String
   */
  DeleteSomething_String_ProductService_Command( String pID ) {
    super(ProductService.class);
    iD = pID;
    parameters = new Object[] { iD };
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
    ProductService lService = (ProductService) pTargetService;
    // Trace service call.
    Trace lTrace = XFun.getTrace();
    lTrace.write(MessageConstants.EXECUTING_SERVICE_CALL, this.getCalledServiceMethod());
    long lStartTime = System.nanoTime();
    lService.deleteSomething(iD);
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
