# Package `com.anaptecs.jeaf.junit.deprecatedparents.types`

**Types / Enumerations:**
[TOC levels=2]

<br>

# Types
## Bike
Expected: allOf references Vehicle, no properties.

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`LegacyVehicle`](#legacyvehicle) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|

<br>

## Car
Expected: allOf references Vehicle, only own property seats.

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`MotorVehicle`](#motorvehicle) |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`seats`** : `int`   `[1..1]`<br> |  | Number of seats. |

<br>

## LegacyVehicle
Removed by its compatibility group. Expected: not part of the specification, including its properties.

:exclamation:**Deprecation Notice (since: 1.0, removed with: 2.0):**<br>Removed from the API.

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`Vehicle`](#vehicle) |
| Abstract | `true` |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`registration`** : `String`   `[0..1]`<br> |  | Registration of the vehicle. |

<br>

## MotorVehicle
Removed by its compatibility group. Expected: not part of the specification, including its properties.

:exclamation:**Deprecation Notice (since: 1.0, removed with: 2.0):**<br>Removed from the API.

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Parent Class  | [`LegacyVehicle`](#legacyvehicle) |
| Abstract | `true` |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`enginePower`** : `int`   `[1..1]`<br> |  | Engine power in kW. |

<br>

## Vehicle
Top of the hierarchy. Expected: part of the specification.

<br>

| Type Details | Details         | 
|--------------|-----------------|
| Abstract | `true` |


<br>

**Properties / Associations**

| Name |  Legacy Name | Description |
|------| ----------------------|-------------|
| **`vehicleID`** : `String`   `[1..1]`<br> |  | ID of the vehicle. |

<br>




