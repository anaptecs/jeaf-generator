# Package `com.anaptecs.jeaf.junit.product.pojo`


<br>

# Types
## `Assortment`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `products` | `0..*` |  |
| `name` | `1..1` |  |

<br>

## `Price`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `amount` | `1..1` |  |
| `currency` | `1..1` |  |

<br>

## `Product`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `assortments` | `0..*` |  |
| `pricesPerCurrency` | `1..*` |  |
| `name` | `1..1` |  |
| `description` | `1..1` |  |
| `vat` | `1..1` |  |
| `productCategory` | `0..1` |  |

<br>

## `VAT`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `rate` | `1..1` |  |

<br>



