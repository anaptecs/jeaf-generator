# Planned Breaking Changes

<br>

| Element  | Owner   | Element Type |Description   | Active with |
|----------|---------|:------------:|--------------|:-----------:|
| `pQueryParam` | `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations.createSomething` | Parameter | Parameter will be mandatory. | PI 13 | 
| `stops` | `com.anaptecs.jeaf.junit.openapi.base.POI` | Property | New mandatory association is required to support upcoming features. | PI 15 | 
| `bits` | `com.anaptecs.jeaf.junit.openapi.base.TheReadOnlyServiceObject` | Property | At least one bit will be expected. | PI 16 | 
| `ComplexBookingType` | `com.anaptecs.jeaf.junit.openapi.base` | Type | Class was changed to an extensible enum. New literals will not be introduced before PI 17. | PI 17 | 

