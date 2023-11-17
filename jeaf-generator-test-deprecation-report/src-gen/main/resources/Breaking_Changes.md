# Planned Breaking Changes

<br>

| Element  | Details    | Description  | Active with |
|----------|------------|--------------|:-----------:|
| `com.anaptecs.jeaf.junit.openapi.base.Reseller` | `name` | Maximum size will be increased. | 1.1 | 
| `com.anaptecs.jeaf.junit.openapi.base.WeirdBooking` | `realBooking` | Association will be mandatory. | 2.0 | 
| `com.anaptecs.jeaf.junit.openapi.service1.ProductService.createChannelCode` | `pChannelCode` | Parameter will be mandatory | 2.0 | 
| `com.anaptecs.jeaf.junit.openapi.service1.DateQueryParamsBean` | `localDateTime` | Has to be in the past | 2.0 | 
| `com.anaptecs.jeaf.junit.openapi.base.WeirdBooking` | `inventories` | Association will required at least 1 object. | 2.1 | 
| `com.anaptecs.jeaf.junit.openapi.base.InventoryType` | `DB` | New literal will occur | 3.x | 
| `com.anaptecs.jeaf.junit.openapi.base.MultivaluedQueryParamsBean` | `intArray` | At least one will become mandatory | 47.11 | 
| `com.anaptecs.jeaf.junit.deprecation.ServiceWithDeprecations.createSomething` | `pQueryParam` | Parameter will be mandatory. | PI 13 | 
| `com.anaptecs.jeaf.junit.openapi.base.POI` | `stops` | New mandatory association is required to support upcoming features. | PI 15 | 
| `com.anaptecs.jeaf.junit.openapi.base.TheReadOnlyServiceObject` | `bits` | At least one bit will be expected. | PI 16 | 
| `com.anaptecs.jeaf.junit.openapi.base.ComplexBookingType` | | Class was changed to an extensible enum. New literals will not be introduced before PI 17. | PI 17 | 

