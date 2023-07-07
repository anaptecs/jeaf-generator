# REST Deprecation Report

<br>

## Deprecated REST Resources

<br>

| Deprecated Resource   | Service Name   | Description   | Deprecated since   | Planned to be removed   |
|-----------------------|----------------|---------------|:------------------:|:-----------------------:|
| `/api` | `com.anaptecs.jeaf.junit.rest.RESTTestService` |  |  |  |
| `/deprecation` | `com.anaptecs.jeaf.junit.deprecation.DeprecatedService` | This service does not make sense any more.<br><br>The functionality is completely wrong. | 1.0 | 2023-12-31 |
| `/do/something` | `com.anaptecs.jeaf.junit.rest.DeprecatedRESTService` |  |  |  |
| `/products` | `com.anaptecs.jeaf.junit.openapi.service1.ProductService` |  |  |  |
| `/with-deprecations` | `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations` |  |  |  |

<br>

## REST Operations with Deprecations

<br>

| Path   | Type   | Deprecated Element   | Description   | Deprecated since   | Planned to be removed   |
|--------|--------|----------------------|---------------|:------------------:|:-----------------------:|
| `/api/beanParam2 [POST]` | `REST Operation` | `RESTTestService.handleBeanParam1(BeanParameter)` |  |  |  |
| `/api/dep/async [POST]` | `REST Operation` | `RESTTestService.deprecatedAsyncParam(int)` |  |  |  |
|   | `Body` | `int pParam1` |  |  |  |
|   | `Response` | `String ` |  |  |  |
| `/api/dep/async [POST]` | `REST Operation` | `RESTTestService.deprecatedAsync(int)` |  |  |  |
| `/api/deprcation/dep1 [GET]` | `REST Operation` | `RESTTestService.deprecatedOperation()` | Please use something else.<br><br>This is not the right operation any longer.<br><br>Sorry!!! | a very long time | 2023-12-13 |
| `/api/deprecation/dep2 [GET]` | `REST Operation` | `RESTTestService.deprecatedParameter(int, int)` |  |  |  |
|   | `Header Param` | `int pParam2` |  |  |  |
| `/api/deprecation/dep3 [GET]` | `REST Operation` | `RESTTestService.deprectaedReturnValue(int)` |  |  |  |
|   | `Response` | `int ` |  |  |  |
| `/products/deprecated/beanParams [POST]` | `REST Operation` | `ProductService.deprecatedBeanParam(BeanParameter)` |  |  |  |
| `/products/deprecated/body [POST]` | `REST Operation` | `ProductService.deprecatedBody(String)` |  |  |  |
|   | `Body` | `String pBody` |  |  |  |
| `/products/deprecated/complexBody [POST]` | `REST Operation` | `ProductService.deprectedComplexRequestBody(Product)` |  |  |  |
|   | `Body` | `Product pProduct` |  |  |  |
| `/products/deprecated/complexReturn [GET]` | `REST Operation` | `ProductService.deprecatedComplexReturn()` |  |  |  |
|   | `Response` | `Product ` |  |  |  |
| `/products/deprecated/operation [GET]` | `REST Operation` | `ProductService.deprecatedOperation()` | This request is no longer supported. | 1.1.1 | 2.3 |
| `/products/deprecated/params [POST]` | `REST Operation` | `ProductService.deprecatedParams(int)` |  |  |  |
|   | `Header Param` | `int param1` |  |  |  |
|   | `Response` | `String ` |  |  |  |
| `/with-deprecations [POST]` | `REST Operation` | `ServiceWithDeprecations.createSomething()` | Resources can no longer be explicitly be created. | 0.9 | 1.2.3 |
| `/with-deprecations [POST]` | `REST Operation` | `ServiceWithDeprecations.createSomething(JustAType, String, String, BeanParamWithDeprecations)` |  |  |  |
|   | `Header Param` | `String header-xxx` | Please do not use this header any longer. No matter what you pass here it will be ignored. |  |  |
|   | `Query Param` | `String query` |  |  |  |
|   | `Header Param` | `String deprecatedHeader` | this header param is no longer supported. Please use "xxx" instead. | 1.2.3 | PI.2.3 |

<br>

## OpenAPI Types with Deprecations

<br>

| Type   | Element   | Description   | Deprecated since   | Planned to be removed   |
|--------|-----------|---------------|:------------------:|:-----------------------:|
| `Campaign` | |  |  |  |
|   | `theLink` | Please use "moreLinks" instead. | 2.3.1 | 2.4 |
|   | `moreLinks` | No good any more | 1.2 | 3.0 |
|   | `discountOffers` |  |  |  |
| `ChildAA` | | Please do not use this class any longer. There are better alternatives but I do not tell you which ones. | 0.5 | 2.0 |
| `ChildBB` | |  |  |  |
|   | `deprecatedAttribute` |  |  |  |
|   | `deprecatedBs` |  |  |  |
|   | `deprecatedParent` |  |  |  |
|   | `deprecatedArray` |  |  |  |
| `DataTypeWithDeprecation` | |  |  |  |
|   | `code` | Time to say goodbye ...<br><br>... blub, blub, blub<br> | just recently | Next version |
| `DeprecatedDataType` | |  |  |  |
| `DeprecatedType` | | This type will be replaced with .... |  |  |
| `DiscountOffer` | |  |  |  |
|   | `campaigns` |  |  |  |
| `JustAType` | |  |  |  |
|   | `legacy` | Hello |  |  |
| `POI` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `evenMoreLinks` |  |  |  |
| `ParentClass` | |  |  |  |
|   | `theBankAccount` |  |  |  |
|   | `legacyBankAccounts` |  |  |  |

<br>


## OpenAPI Enumerations with Deprecations

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `ChannelType` | |  |  |  |
|   | `LEGACY_POS` |  |  |  |
| `DeprecatedEnum` | |  |  |  |
| `DeprecatedEnum` | |  |  |  |
| `EnumWithDeprecation` | |  |  |  |
|   | `EGG` | Eggs do not belong to apples. | 0.9 | 1.2 |

<br>

