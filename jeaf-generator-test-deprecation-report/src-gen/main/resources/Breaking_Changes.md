# Planned Breaking Changes

<br>

| Element  | Details    | Description  | Active with |
|----------|------------|--------------|:-----------:|
| `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations.createSomething` | `pQueryParam` | Parameter will be mandatory. | PI 13 | 
| `com.anaptecs.jeaf.junit.openapi.base.POI` | `stops` | New mandatory association is required to support upcoming features. | PI 15 | 
| `com.anaptecs.jeaf.junit.openapi.base.TheReadOnlyServiceObject` | `bits` | At least one bit will be expected. | PI 16 | 
| `com.anaptecs.jeaf.junit.openapi.base.ComplexBookingType` | | Class was changed to an extensible enum. New literals will not be introduced before PI 17. | PI 17 | 

