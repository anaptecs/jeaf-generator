**Types / Enumerations:**
[TOC levels=2]

<br>

# Package `com.anaptecs.jeaf.junit.product.pojo`


<br>

# Types
## Assortment



<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `products` | [`Product`](#product) | `0..*` |  |  |
| `name` | `String` | `1..1` |  |  |

<br>

## Price



<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `amount` | `java.math.BigDecimal` | `1..1` |  |  |
| `currency` | `java.util.Currency` | `1..1` |  |  |

<br>

## Product



<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `assortments` | [`Assortment`](#assortment) | `0..*` |  |  |
| `pricesPerCurrency` | [`Price`](#price) | `1..*` |  |  |
| `name` | `String` | `1..1` |  |  |
| `description` | `String` | `1..1` |  |  |
| `vat` | [`VAT`](#vat) | `1..1` |  |  |
| `productCategory` | [`ProductCategory`](com.anaptecs.jeaf.junit.product.html#productcategory) | `0..1` |  |  |

<br>

## VAT



<br>

### Properties / Associations
| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `rate` | `double` | `1..1` |  |  |

<br>



