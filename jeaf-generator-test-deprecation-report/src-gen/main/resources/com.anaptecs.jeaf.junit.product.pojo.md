# Package `com.anaptecs.jeaf.junit.product.pojo`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## Assortment



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`products`** : [`Product`](#product)   `[0..*]`<br> |  |  |
| **`name`** : `String`   `[1..1]`<br> |  |  |

<br>

## Price



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`amount`** : `java.math.BigDecimal`   `[1..1]`<br> |  |  |
| **`currency`** : `java.util.Currency`   `[1..1]`<br> |  |  |

<br>

## Product



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`assortments`** : [`Assortment`](#assortment)   `[0..*]`<br> |  |  |
| **`pricesPerCurrency`** : [`Price`](#price)   `[1..*]`<br> |  |  |
| **`name`** : `String`   `[1..1]`<br> |  |  |
| **`description`** : `String`   `[1..1]`<br> |  |  |
| **`vat`** : [`VAT`](#vat)   `[1..1]`<br> |  |  |
| **`productCategory`** : [`ProductCategory`](com.anaptecs.jeaf.junit.product#productcategory)   `[0..1]`<br> |  |  |

<br>

## VAT



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`rate`** : `double`   `[1..1]`<br> |  |  |

<br>




