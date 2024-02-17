# My Java Deprecation Report

<br>

## Deprecated Services

<br>

| Service Name   | Description   | Deprecated since   | Planned to be removed   |
|----------------|---------------|:------------------:|:-----------------------:|
| `com.anaptecs.jeaf.junit.core.BusinessObjectTestService` |  |  |  |
| `com.anaptecs.jeaf.junit.core.DeprecatedTestService` |  |  |  |
| `com.anaptecs.jeaf.junit.core.JEAFTestService` |  |  |  |
| `com.anaptecs.jeaf.junit.deprecation.DeprecatedService` | This service does not make sense any more.<br><br>The functionality is completely wrong. | 1.0 | 2023-12-31 |
| `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.service1.ProductService` |  |  |  |
| `com.anaptecs.jeaf.junit.rest.DeprecatedRESTService` |  |  |  |
| `com.anaptecs.jeaf.junit.rest.RESTTestService` |  |  |  |

<br>


### `com.anaptecs.jeaf.junit.core.BusinessObjectTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprectedOperation()` | |  |  |  |

<br>




### `com.anaptecs.jeaf.junit.core.JEAFTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `checkRequiredService_2()` | |  |  |  |

<br>




### `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `createSomething()` | | Resources can no longer be explicitly be created. | 0.9 | 1.2.3 |
| `createSomething(JustAType, String, String, BeanParamWithDeprecations)` | |  |  |  |
|   | `String pHeader` | Please do not use this header any longer. No matter what you pass here it will be ignored. |  |  |
|   | `String pQueryParam` |  |  |  |

<br>



### `com.anaptecs.jeaf.junit.openapi.service1.ProductService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprecatedBody(String)` | |  |  |  |
|   | `String pBody` |  |  |  |
| `deprecatedComplexReturn()` | |  |  |  |
|   | `Product ` |  |  |  |
| `deprecatedOperation()` | | This request is no longer supported. | 1.1.1 | 2.3 |
| `deprecatedParams(int)` | |  |  |  |
|   | `int pParam1` |  |  |  |
|   | `String ` |  |  |  |
| `deprectedComplexRequestBody(Product)` | |  |  |  |
|   | `Product pProduct` |  |  |  |

<br>




### `com.anaptecs.jeaf.junit.rest.RESTTestService`

| Operation   |  Parameter   | Description   | Deprecated since   | Planned to be removed   |
|-------------|--------------|---------------|:------------------:|:-----------------------:|
| `deprecatedAsync(int)` | |  |  |  |
| `deprecatedAsyncParam(int)` | |  |  |  |
|   | `int pParam1` |  |  |  |
|   | `String ` |  |  |  |
| `deprecatedOperation()` | | Please use something else.<br><br>This is not the right operation any longer.<br><br>Sorry!!! | a very long time | 2023-12-13 |
| `deprecatedParameter(int, int)` | |  |  |  |
|   | `int pParam2` |  |  |  |
| `deprectaedReturnValue(int)` | |  |  |  |
|   | `int ` |  |  |  |

<br>




## Classes with Deprecations

<br>

| Type   | Attribute   | Description   | Deprecated since   | Planned to be removed   |
|--------|-------------|---------------|:------------------:|:-----------------------:|
| `com.anaptecs.jeaf.junit.core.DeprecatedServiceObject` | |  |  |  |
| `com.anaptecs.jeaf.junit.core.PartiallyDeprecatedServiceObject` | |  |  |  |
|   | `outdated` |  |  |  |
|   | `deprecatedRef` |  |  |  |
|   | `deprecatedRefs` |  |  |  |
| `com.anaptecs.jeaf.junit.deprecation.BeanParamWithDeprecations` | |  |  |  |
|   | `deprecatedHeader` | this header param is no longer supported. Please use "xxx" instead. | 1.2.3 | PI.2.3 |
| `com.anaptecs.jeaf.junit.deprecation.JustAType` | |  |  |  |
|   | `legacy` | Hello |  |  |
| `com.anaptecs.jeaf.junit.domainObjects.DeprecatedDomainObject` | |  |  |  |
| `com.anaptecs.jeaf.junit.domainObjects.Price` | |  |  |  |
|   | `price` |  |  |  |
|   | `reiseweg` |  |  |  |
|   | `verbindungspunkte` |  |  |  |
| `com.anaptecs.jeaf.junit.domainObjects.Reiseweg` | |  |  |  |
| `com.anaptecs.jeaf.junit.impl.domain.DeprecatedPO` | |  |  |  |
|   | `deprecated` |  |  |  |
|   | `publicClass` |  |  |  |
|   | `baseClasses` |  |  |  |
| `com.anaptecs.jeaf.junit.impl.domain.PublicClassBO` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.BeanParameter` | |  |  |  |
|   | `oldStyle` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.Campaign` | |  |  |  |
|   | `theLink` | Please use "moreLinks" instead. | 2.3.1 | 2.4 |
|   | `moreLinks` | No good any more | 1.2 | 3.0 |
|   | `discountOffers` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ChildAA` | | Please do not use this class any longer. There are better alternatives but I do not tell you which ones. May be `java.lang.Nothing` | 0.5 | 2.0 |
| `com.anaptecs.jeaf.junit.openapi.base.ChildBB` | |  |  |  |
|   | `deprecatedAttribute` | Please  keep `hands off`. |  |  |
|   | `deprecatedBs` |  |  |  |
|   | `deprecatedParent` |  |  |  |
|   | `deprecatedArray` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.DeprecatedContext` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.DiscountOffer` | |  |  |  |
|   | `campaigns` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.POI` | |  |  |  |
|   | `theLink` |  |  |  |
|   | `evenMoreLinks` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ParentClass` | |  |  |  |
|   | `theBankAccount` |  |  |  |
|   | `legacyBankAccounts` |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.SpecialContext` | |  |  |  |
|   | `deprecatedHeader` |  |  |  |
| `com.anaptecs.jeaf.junit.pojo.BChildPOJO` | |  |  |  |
| `com.anaptecs.jeaf.junit.pojo.ChildPOJO` | | We do not like this class any more. | Big bang | Last X-Mas |
| `com.anaptecs.jeaf.junit.pojo.ImmutableAssociationPOJO` | |  |  |  |
|   | `deprecatedRefs` |  |  |  |
| `com.anaptecs.jeaf.junit.pojo.ParentPOJO` | |  |  |  |
|   | `weirdAttribute` |  |  |  |

<br>


## Enumerations with Deprecations

<br>

| Enumeration   | Literal   | Description   | Deprecated since   | Planned to be removed   |
|---------------|-----------|---------------|:------------------:|:-----------------------:|
| `com.anaptecs.jeaf.junit.core.Color` | |  |  |  |
|   | `LightGreen` | We do not like this color any more. |  |  |
| `com.anaptecs.jeaf.junit.core.Farbe` | |  |  |  |
| `com.anaptecs.jeaf.junit.openapi.base.ChannelType` | |  |  |  |
|   | `LEGACY_POS` | I'm `DEPRECATED`. |  |  |

<br>

