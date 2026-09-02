# Package `com.anaptecs.jeaf.junit.pojo.transientback`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## ClientClass



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`transientMaster`** : [`MasterClass`](#masterclass)   `[0..1]`<br> |  |  |
| **`name`** : `String`   `[1..1]`<br> |  |  |
| **`manyMasters`** : [`MasterClass`](#masterclass)   `[0..*]`<br> |  |  |

<br>

## MasterClass



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`clients`** : [`ClientClass`](#clientclass)   `[0..*]`<br> |  |  |
| **`name`** : `String`   `[1..1]`<br> |  |  |
| **`singleClient`** : [`ClientClass`](#clientclass)   `[0..1]`<br> |  |  |

<br>

## ReadOnlyClient



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`name`** : `String`   `[1..1]`<br> |  |  |
| **`transientMaster`** : [`ReadOnlyMaster`](#readonlymaster)   `[0..1]`<br> |  |  |

<br>

## ReadOnlyMaster



<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`name`** : `String`   `[1..1]`<br> |  |  |
| **`clients`** : [`ReadOnlyClient`](#readonlyclient)   `[0..*]`<br> |  |  |

<br>




