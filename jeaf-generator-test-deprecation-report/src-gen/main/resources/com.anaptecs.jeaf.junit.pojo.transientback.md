# Package `com.anaptecs.jeaf.junit.pojo.transientback`


<br>

# Types
## `ClientClass`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `transientMaster` | `0..1` |  |
| `name` | `1..1` |  |
| `manyMasters` | `0..*` |  |

<br>

## `MasterClass`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `clients` | `0..*` |  |
| `name` | `1..1` |  |
| `singleClient` | `0..1` |  |

<br>

## `ReadOnlyClient`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `name` | `1..1` |  |
| `transientMaster` | `0..1` |  |

<br>

## `ReadOnlyMaster`

| Info        | Details         | 
|-------------|-----------------|
| Description |  |

<br>

### Properties / Associations
| Name | Multiplicity | Description |
|------|:------------:|-------------|
| `name` | `1..1` |  |
| `clients` | `0..*` |  |

<br>



