# Package `com.anaptecs.jeaf.junit.generics`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## AndOneMorePOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `genericProperty` | [`DoSomethingResponse`](#dosomethingresponse) | `1..1` |  |  |
| `genericResponses` | [`DoSomethingResponse`](#dosomethingresponse) | `0..*` |  |  |
| `multiTemplateClassImpl` | [`MultiTemplateClassImpl`](#multitemplateclassimpl) | `1..1` |  |  |

<br>

## GenericResponsePOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `errors` | [`Message`](#message) | `0..*` |  |  |
| `warnings` | [`Message`](#message) | `0..*` |  |  |
| `value` | [`T`](#t) | `1..1` |  |  |

<br>

## Message



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `text` | `String` | `1..1` |  |  |

<br>

## MultiTemplateClass



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `object` | [`T`](#t) | `1..1` |  |  |
| `previousState` | [`E`](#e) | `0..1` |  |  |
| `newState` | [`E`](#e) | `1..1` |  |  |

<br>

## MyBusinessObject



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `myBusinessAttribute` | `int` | `1..1` |  |  |

<br>

## YetAnotherPOJO



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|

<br>




<br>

# Enumerations
## TemplateEnumTest


### Literals

| Name | Description |
|------|-------------|
| `ONE` |  |
| `TWO` |  |
| `THREE` |  |

