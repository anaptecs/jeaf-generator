# Package `com.anaptecs.jeaf.junit.generics`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## AndOneMorePOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`genericProperty`** : [`DoSomethingResponse`](#dosomethingresponse)   `[1..1]`<br> |  |  |
| **`genericResponses`** : [`DoSomethingResponse`](#dosomethingresponse)   `[0..*]`<br> |  |  |
| **`multiTemplateClassImpl`** : [`MultiTemplateClassImpl`](#multitemplateclassimpl)   `[1..1]`<br> |  |  |
| **`many`** : [`MultiTemplateClassImpl`](#multitemplateclassimpl)   `[0..*]`<br> |  |  |

<br>

## GenericResponsePOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`errors`** : [`Message`](#message)   `[0..*]`<br> |  |  |
| **`warnings`** : [`Message`](#message)   `[0..*]`<br> |  |  |
| **`value`** : [`T`](#t)   `[1..1]`<br> |  |  |

<br>

## Message



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`text`** : `String`   `[1..1]`<br> |  |  |

<br>

## MultiTemplateClass



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`object`** : [`T`](#t)   `[1..1]`<br> |  |  |
| **`previousState`** : [`E`](#e)   `[0..1]`<br> |  |  |
| **`newState`** : [`E`](#e)   `[1..1]`<br> |  |  |

<br>

## MyBusinessObject



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`myBusinessAttribute`** : `int`   `[1..1]`<br> |  |  |

<br>

## YetAnotherPOJO



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|

<br>




<br>

# Enumerations
## TemplateEnumTest


### Literals

| Name |  Legacy Name | Description |
|------|----------------------|----------------------------|
| `ONE` |   |  |
| `TWO` |   |  |
| `THREE` |   |  |

