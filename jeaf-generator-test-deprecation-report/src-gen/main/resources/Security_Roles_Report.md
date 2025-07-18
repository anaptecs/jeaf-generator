# My Roles Report
## Role `Accounting Basic Data Admin`

<br>

**Service `AccountingBasicDataService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `createBank(Bank)` |  |
| `createEmployee(Person, ResponsibilityType, Bank)` |  |
| `createResponsibilityType(ResponsibilityType)` |  |

## Role `Accounting User`

<br>

**Service `AccountingService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `createAccount(Customer, Person)` |  |
| `createCustomer(Customer, ServiceObjectID)` |  |
| `createPerson(Person)` |  |
| `getAccount(ServiceObjectID)` |  |
| `getCustomer(ServiceObjectID, CustomerLoadStrategy)` |  |
| `lockAccount(Account)` |  |
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |
| `searchCustomers(CustomerQuery)` |  |
| `unlock(Account)` |  |

## Role `Advanced User`

<br>

**Service `AccountingBasicDataService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `createBank(Bank)` |  |
| `createEmployee(Person, ResponsibilityType, Bank)` |  |
| `createResponsibilityType(ResponsibilityType)` |  |

<br>

**Service `AccountingService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `createAccount(Customer, Person)` |  |
| `createCustomer(Customer, ServiceObjectID)` |  |
| `createPerson(Person)` |  |
| `getAccount(ServiceObjectID)` |  |
| `getCustomer(ServiceObjectID, CustomerLoadStrategy)` |  |
| `lockAccount(Account)` |  |
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |
| `searchCustomers(CustomerQuery)` |  |
| `unlock(Account)` |  |

## Role `Customer`

<br>

**Service `RESTProductService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `getProducts(int)` | `/rest-products [GET]` |
| `ping()` | `/rest-products [HEAD]` |

## Role `Sales Agent`

<br>

**Service `RESTProductService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `createChannelCode(String)` | `/rest-products/ChannelCode [POST]` |
| `createProduct(Product)` | `/rest-products [POST]` |
| `getProduct(String)` | `/rest-products/{id} [GET]` |
| `getProducts(int)` | `/rest-products [GET]` |
| `getSortiment(Context)` | `/rest-products/sortiment/{id} [GET]` |
| `getSupportedCurrencies(ChannelCode)` | `/rest-products/currencies/{channelCode} [GET]` |
| `getSupportedCurrenciesAsync(ChannelCode)` | `/rest-products/async-currencies/{channelCode} [GET]` |
| `ping()` | `/rest-products [HEAD]` |
| `processComplexBookingID(ComplexBookingID)` | `/rest-products/complex/{bookingID} [GET]` |
| `testBookingIDAsHeaderParam(BookingID)` | `/rest-products/booking-id-as-header-param [PATCH]` |
| `testBookingIDAsPathParam(BookingID)` | `/rest-products/booking-id-as-path-param/{bookingID} [PATCH]` |
| `testContextWithPrimitives(ContextWithPrimitives)` | `/rest-products/test-context-with-primitives [GET]` |
| `testCookieParams(ChannelType, SpecialContext)` | `/rest-products/cookies [GET]` |
| `testDataTypeAsBeanQueryParam(QueryBeanParam)` | `/rest-products/testDataTypeAsBeanQueryParam [GET]` |
| `testDataTypeAsQueryParam(BookingCode)` | `/rest-products/testDataTypeAsQueryParam [GET]` |
| `testDataTypesAsHeaderBeanParam(AdvancedHeader)` | `/rest-products/dataTypesInBeanHeader [GET]` |
| `testDataTypesAsHeaderParam(BookingID, BookingCode, DoubleCode)` | `/rest-products/dataTypesInHeader [GET]` |
| `testDateHeaderParams(String, OffsetDateTime, OffsetTime, LocalDateTime, LocalTime, LocalDate, Calendar, Date, Timestamp, Time, Date, Date)` | `/rest-products/test-date-header-params/{path} [GET]` |
| `testDateHeaderParamsBean(String, DateHeaderParamsBean)` | `/rest-products/test-date-header-params-beans/{path} [GET]` |
| `testDateQueryParams(String, OffsetDateTime, OffsetTime, LocalDateTime, LocalTime, LocalDate, Calendar, Date, Timestamp, Time, Date, Calendar)` | `/rest-products/test-date-query-params/{path} [GET]` |
| `testDateQueryParamsBean(String, DateQueryParamsBean)` | `/rest-products/test-date-query-params-beans/{path} [GET]` |
| `testEnumHeaderParams(ChannelType, TimeUnit, ExtensibleEnum)` | `/rest-products/test-enum-header-params [GET]` |
| `testEnumParams(ChannelType, TimeUnit, ExtensibleEnum)` | `/rest-products/test-enum-params/{channelType} [GET]` |
| `testInit()` | `/rest-products/test-init [GET]` |
| `testMulitvaluedDataTypeAsBeanQueryParam(DataTypesQueryBean)` | `/rest-products/testMulitvaluedDataTypeAsBeanQueryParam [GET]` |
| `testMulitvaluedDataTypeAsQueryParam(IntegerCodeType, LongCode, BookingID, OffsetDateTime, LocalDate)` | `/rest-products/testMulitvaluedDataTypeAsQueryParam [GET]` |
| `testMultiValuedHeaderFields(String, int, Double, StringCode, OffsetDateTime, OffsetDateTime, OffsetTime, byte)` | `/rest-products/testMultiValuedHeaderFields [GET]` |
| `testMultiValuedHeaderFieldsInBeanParam(MultiValuedHeaderBeanParam)` | `/rest-products/testMultiValuedHeaderFieldsInBeanParam [GET]` |
| `testMultivaluedQueryParamsBean(MultivaluedQueryParamsBean)` | `/rest-products/testMultivaluedQueryParamsBean [GET]` |
| `testOptionalQueryParams(String, int)` | `/rest-products/test-optional-query-params [GET]` |
| `testParams(BigDecimal, int, Locale)` | `/rest-products/test-params [GET]` |
| `testPrimitiveArrayAsQueryParam(int)` | `/rest-products/testPrimitiveArrayAsQueryParam [GET]` |
| `testPrimitiveArrays(int)` | `/rest-products/testPrimitiveArrayAsBody [POST]` |
| `testPrimitiveWrapperArrayAsQueryParam(Integer)` | `/rest-products/testPrimitiveWrapperArrayAsQueryParam [GET]` |
| `testPrimitivesAsParams(int, Integer, Boolean, Boolean, long, Long)` | `/rest-products/test-primitives-as-params [GET]` |
| `testSimpleTypesAsQueryParams(String)` | `/rest-products/testSimpleTypesAsQueryParams [GET]` |

## Role `Standard User`

<br>

**Service `AccountingService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `performBooking(Booking, SecurityToken)` | `/api/v1/accounting/bookings [PUT]` |
| `searchCustomers(CustomerQuery)` |  |

<br>

**Service `JEAFSecurityTestService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `checkCurrentAnonymousUser()` |  |
| `checkCurrentUser()` |  |
| `checkInvalidServiceAccess()` |  |

## Role `Support User`

<br>

**Service `AccountingService`**

| Operation        | REST Resource Path |
|------------------|--------------------|
| `unlock(Account)` |  |


<br>

## Unsecured REST Operations

| Service          | Operation     | REST Resource Path |
|------------------|---------------|--------------------|
| `DeprecatedRESTService` | `doSomething()` | `/do/something [GET]` |
| `IgnorableService` | `ignore()` | `/ignore [GET]` |
| `ProductService` | `addCurrencies(CurrencyCode)` | `/products/currencies [POST]` |
| `ProductService` | `checkIBAN(String)` | `/products/IBAN [POST]` |
| `ProductService` | `createChannelCode(String)` | `/products/ChannelCode [POST]` |
| `ProductService` | `createChannelCodeFromObject(ChannelCode)` | `/products/ChannelCodeObject [POST]` |
| `ProductService` | `createProduct(Product)` | `/products [POST]` |
| `ProductService` | `deleteSomething(String)` | `/products/delete-something/{id} [DELETE]` |
| `ProductService` | `deprecatedBeanParam(BeanParameter)` | `/products/deprecated/beanParams [POST]` |
| `ProductService` | `deprecatedBody(String)` | `/products/deprecated/body [POST]` |
| `ProductService` | `deprecatedComplexReturn()` | `/products/deprecated/complexReturn [GET]` |
| `ProductService` | `deprecatedContext(DeprecatedContext)` | `/products/deprecated/context [POST]` |
| `ProductService` | `deprecatedOperation()` | `/products/deprecated/operation [GET]` |
| `ProductService` | `deprecatedParams(int)` | `/products/deprecated/params [POST]` |
| `ProductService` | `deprectedComplexRequestBody(Product)` | `/products/deprecated/complexBody [POST]` |
| `ProductService` | `genericMultiValueResponse()` | `/products/generic-multi-value [GET]` |
| `ProductService` | `genericSingleValueResponse()` | `/products/generic-single-value [GET]` |
| `ProductService` | `getChannels(ChannelType)` | `/products/channels [GET]` |
| `ProductService` | `getDefaultChannel(ChannelType)` | `/products/DefaultChannel [GET]` |
| `ProductService` | `getProduct(String)` | `/products/{id} [GET]` |
| `ProductService` | `getProducts()` | `/products [GET]` |
| `ProductService` | `getSortiment(Context)` | `/products/sortiment/{id} [GET]` |
| `ProductService` | `getSupportedCurrencies(ChannelCode)` | `/products/currencies/{channelCode} [GET]` |
| `ProductService` | `getSupportedCurrenciesAsync(ChannelCode)` | `/products/async-currencies/{channelCode} [GET]` |
| `ProductService` | `isCurrencySupported(CurrencyCode)` | `/products/currencies/valid [POST]` |
| `ProductService` | `loadSpecificThings(SpecialContext)` | `/products/specific/{id} [PATCH]` |
| `ProductService` | `noReturnType(String, MultiValuedDataType)` | `/products/no-return-type [POST]` |
| `ProductService` | `ping()` | `/products [HEAD]` |
| `ProductService` | `testChildBeanParameter(ChildBeanParameterType)` | `/products/ChildBeanParam [GET]` |
| `ProductService` | `testCodeTypeUsage(StringCodeType)` | `/products/codeTypeUsages [POST]` |
| `ProductService` | `testContext(Context)` | `/products/testContext [GET]` |
| `ProductService` | `testDataTypeWithRestrition(StringCode, ShortCode, Byte)` | `/products/test-string-code-with-restriction/{string-code} [POST]` |
| `ProductService` | `testDateQueryParams(String, OffsetDateTime, OffsetTime, LocalDateTime, LocalTime, LocalDate, Calendar, Date, Timestamp, Time, Date)` | `/products/test-date-query-params/{path} [GET]` |
| `ProductService` | `testDateQueryParamsBean(String, DateQueryParamsBean)` | `/products/test-date-query-params-beans/{path} [GET]` |
| `ProductService` | `testDuplicateGenerics1()` | `/products/testDuplicateGenerics1 [GET]` |
| `ProductService` | `testDuplicateGenerics2()` | `/products/testDuplicateGenerics2 [GET]` |
| `ProductService` | `testExternalBeanParameterType(ParentBeanParamType)` | `/products/ExternalBeanParam [GET]` |
| `ProductService` | `testLocalBeanParamType(LocalBeanParamType)` | `/products/LocalBeanParam [GET]` |
| `ProductService` | `testMulitValuedBeanParams(MultiValuedDataType, BooleanLiteralsEnum)` | `/products/testMulitValuedBeanParams [GET]` |
| `ProductService` | `testMultivaluedHeader(BigDecimalCode)` | `/products/big-decimal-codes-header [GET]` |
| `ProductService` | `testMultivaluedQueryParams(BigDecimalCode, BooleanLiteralsEnum)` | `/products/big-decimal-codes-query [GET]` |
| `ProductService` | `testNestedGenericsResponse()` | `/products/nested-generics [GET]` |
| `ProductService` | `testNestedMultivaluedResponse()` | `/products/multivalued-generics [GET]` |
| `ProductService` | `testNotInlinedBeanParam(NotInlinedBeanParam)` | `/products/testNotInlinedBeanParam [POST]` |
| `ProductService` | `testOptionalQueryParams(String, int)` | `/products/test-optional-query-params [GET]` |
| `ProductService` | `testPrimitiveArray(int)` | `/products/testStringArray [POST]` |
| `ProductService` | `testPrimitiveArrayAsQueryParam(int)` | `/products/testPrimitiveArrayAsQueryParam [GET]` |
| `ProductService` | `testSpecialHeaderParams(String, String, String)` | `/products/special-header-params [GET]` |
| `ProductService` | `testTechnicalHeaderBean(TechnicalHeaderContext)` | `/products/technicalHeaderBeanParam [GET]` |
| `ProductService` | `testTechnicalHeaderParam(String, String)` | `/products/technicalHeaderParam [GET]` |
| `RESTTestService` | `deprecatedAsync(int)` | `/api/dep/async [POST]` |
| `RESTTestService` | `deprecatedAsyncParam(int)` | `/api/dep/async [POST]` |
| `RESTTestService` | `deprecatedOperation()` | `/api/deprcation/dep1 [GET]` |
| `RESTTestService` | `deprecatedParameter(int, int)` | `/api/deprecation/dep2 [GET]` |
| `RESTTestService` | `deprectaedReturnValue(int)` | `/api/deprecation/dep3 [GET]` |
| `RESTTestService` | `doSomethingRESTy()` | `/api/very/special/path [PUT]` |
| `RESTTestService` | `getResource(String)` | `/api [GET]` |
| `RESTTestService` | `handleBeanParam1(Context)` | `/api/beanParam1 [GET]` |
| `RESTTestService` | `handleBeanParam1(BeanParameter)` | `/api/beanParam2 [POST]` |
| `RESTTestService` | `provideGenericResponse()` | `/api/generic-response [GET]` |
| `RESTTestService` | `updateTestServiceObject(TestServiceObject)` | `/api [POST]` |
| `RESTTestService` | `yetAnotherRESTOperation(String, String, String, String)` | `/api/something/{id} [GET]` |
| `ServiceWithDeprecations` | `createSomething()` | `/with-deprecations [POST]` |
| `ServiceWithDeprecations` | `createSomething(JustAType, String, String, BeanParamWithDeprecations)` | `/with-deprecations [POST]` |
