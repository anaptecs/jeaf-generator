# Planned Breaking Changes

<br>

## Package `com.anaptecs.jeaf.junit.deprecation`

| Element  | Details    | Description  | Active with |
|----------|------------|--------------|:-----------:|
| `ServiceWithDeprecations.createSomething` | `pQueryParam` | Parameter will be mandatory. | PI 13 | 

<br>

## Package `com.anaptecs.jeaf.junit.openapi.base`

| Element  | Details    | Description  | Active with |
|----------|------------|--------------|:-----------:|
| `Reseller` | `name` | Maximum size will be increased. | 1.1 | 
| `ChannelType` | `WEB` | Added new literal | 1.47.11 | 
| `WeirdBooking` | `realBooking` | Association will be mandatory. | 2.0 | 
| `WeirdBooking` | `inventories` | Association will required at least 1 object. | 2.1 | 
| `InventoryType` | `DB` | New literal will occur | 3.x | 
| `MultivaluedQueryParamsBean` | `intArray` | At least one will become mandatory | 47.11 | 
| `POI` | `stops` | New mandatory association is required to support upcoming features. | PI 15 | 
| `TheReadOnlyServiceObject` | `bits` | At least one bit will be expected. | PI 16 | 
| `ComplexBookingType` | | Class was changed to an extensible enum. New literals will not be introduced before PI 17. | PI 17 | 

<br>

## Package `com.anaptecs.jeaf.junit.openapi.service1`

| Element  | Details    | Description  | Active with |
|----------|------------|--------------|:-----------:|
| `ProductService.createChannelCode` | `pChannelCode` | Parameter will be mandatory | 2.0 | 
| `DateQueryParamsBean` | `localDateTime` | Has to be in the past | 2.0 | 

<br>

