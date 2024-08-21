# Package `com.anaptecs.jeaf.accounting.impl.pojo`


<br>

# Types
## `Account`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `iban` | `1..1` |  |
| `owner` | `1..1` |  |
| `currency` | `1..1` |  |
| `allBookings` | `0..*` |  |

<br>

## `Booking`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `sourceAccount` | `1..1` |  |
| `targetAccount` | `1..1` |  |
| `amount` | `1..1` |  |
| `currency` | `1..1` |  |
| `executionTimestamp` | `1..1` |  |

<br>

## `Customer`

| Info        | Details         | 
|-------------|-----------------|
| Base Class  | `com.anaptecs.jeaf.accounting.impl.pojo.Partner` |
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `name` | `1..1` |  |
| `firstName` | `1..1` |  |
| `email` | `1..1` |  |
| `accounts` | `0..*` |  |

<br>

## `Partner`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|

<br>



