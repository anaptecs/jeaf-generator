# Package `com.anaptecs.jeaf.junit.pojo.transientback`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## ClientClass



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `transientMaster` | [`MasterClass`](#masterclass) | `0..1` |  |  |
| `name` | `String` | `1..1` |  |  |
| `manyMasters` | [`MasterClass`](#masterclass) | `0..*` |  |  |

<br>

## MasterClass



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `clients` | [`ClientClass`](#clientclass) | `0..*` |  |  |
| `name` | `String` | `1..1` |  |  |
| `singleClient` | [`ClientClass`](#clientclass) | `0..1` |  |  |

<br>

## ReadOnlyClient



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `name` | `String` | `1..1` |  |  |
| `transientMaster` | [`ReadOnlyMaster`](#readonlymaster) | `0..1` |  |  |

<br>

## ReadOnlyMaster



<br>

**Properties / Associations**

| Name | Type | Multiplicity | Constraints | Description |
|------|------|:------------:|-------------|-------------|
| `name` | `String` | `1..1` |  |  |
| `clients` | [`ReadOnlyClient`](#readonlyclient) | `0..*` |  |  |

<br>




