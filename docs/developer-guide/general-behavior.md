---
title: "Developer Guide"
subtitle: "General Behavior"
toc: true
menubar: developer_guide_menu
---

![Current Version](https://maven-badges.herokuapp.com/maven-central/com.anaptecs.jeaf.generator/jeaf-generator/badge.svg)

# General Behavior

## Directory Layout for Generated Output

In order to ensure a strict separation between generated and hand-written code and resources JEAF Generator is working with the following directories / output slots:

- `src-gen`<br>This slot contains all generated Java classes. Every time JEAF Generator is executed all files in this directory will be at first deleted and then written again. Files in this directory must not be edited manually.  <br><br>

- `src`  <br>This slot contains all the classes that are intended to be edited manually. In case that a class does not exist in this directory then it will be written also into this directory. But JEAF Generator will never overwrite or edit any existing classes here.
  
  This is the slot where classes that contain any kind of business logic will be located. Usually this slot will point to your standard source code location.  <br><br>

- `res-gen`  <br>This slot contains all the generated resource files. All file in the directory and all of its sub directories will be overwritten every time when JEAF Generator will be executed. Files in this directory must not be edited manually.  <br><br>

- `res`  <br>This slot contains all the resources that are intended to be edited manually. In case that a resource does not exist in this directory then it will be written also into this directory. But JEAF Generator will never overwrite or edit any existing files here.  
  
  Usually this slot will point to your standard resource location.  <br><br>

- `src-test-gen`<br>This slot contains all the generated test sources.<br><br>

- `src-test`<br>This slot contains test source that will not be overwritten by a subsequent run of JEAF Generator.<br><br>

- `res-test-gen`<br>This slot contains all the generated test resources.<br><br>

- `res-test`<br>This slot contains test resources that will not be overwritten by a subsequent run of JEAF Generator.<br><br>

Of course it’s possible to configure a concrete directory for each of these output slots according to your project settings. For further details about path configuration please see: [Common Configuration Parameter section of Maven Plugin Configuration](/developer-guide/maven-plugin-configuration)

<br>

## Error Handling

JEAF Generator is supposed to work as fault tolerant as possible. When ever possible we try to avoid that the whole code generation process is aborted. In general JEAF Generator distinguishes between errors and warnings.

Both of them will be listed at the end of the generator output as a summary. So to get an overview it’s not required to check the complete log. When JEAF Generator detects a warning for a specific model element it tries to point out the exact element that caused the problem as well as an description of the identified issue. The same is done for errors. However in case of a warning code generation for the model element is still possible whereas this is not the case when an error is found. In this case the model element will be ignored and JEAF Generator will try to process the next element of the UML model.

You can find the complete list of all error messages / warnings on site [JEAF Generator Error Codes](../error-codes).

<br>

## Final Modifier for Attributes

JEAF Generator makes us of the so called builder pattern for Service Objects and POJOs. In case that attributes in the UML model are marked to be `readonly`, then these attributes can only be set using the builder but not directly using methods on the generated class itself.

![Final Modifier](/images/final_modifier.png)

<br>

## Transient Modifier for Attributes / Roles

Using stereotype `«Transient»` it is possible to add keyword transient to generated code.

<br>

## Reduce visibility of Attributes / Roles

Using stereotype `«Internal»` it is possible to change the visibility of generated access methods to package visibility.

<br>

## Usage of Derived Properties

UML supports so called derived properties. This means that a property can 
be derived (calculated) from other properties of an object. JEAF 
Generator also supports derived properties. In the generated Java code 
this will lead to a `getXYZ( )` operation that has to be implemented manually.

![Derived Properties](/images/derived_properties.png)

<br>

## Usage of Java Collection Types

When modeling an association between classes then inside the UML model already its multiplicity will be defined. If the multiplicity is `0..*` or `1..*` then in the generated code some kind of Java Collection class is expected to be generated. As there are many types of Collection classes the table below will explain how the information from the model will be used the find the best matching Java Collection type.

|                  |                |               |                                     |
| ---------------- | -------------- | ------------- | ----------------------------------- |
| **Multiplicity** | **Is Ordered** | **Is Unique** | **Type**                            |
| `0..1` or `1`    | `n/a`          | `n/a`         | Referenced Class from the UML model |
| `0..*` or `1..*` | `true`         | `true`        | `java.util.SortedSet`               |
| `0..*` or `1..*` | `false`        | `true`        | `java.util.Set`                     |
| `0..*` or `1..*` | `true`         | `false`       | `java.util.List`                    |
| `0..*` or `1..*` | `false`        | `false`       | `java.util.Collection`              |

The screenshot below shows an example of an `0..*` association where attributes for Java Collections are defined. According to the table above class `java.util.Set` will be used in the generated code.

<br>

![derived Properties](/images/collection.properties.png)

<br>

## Access Methods for Attributes and Associations

For classes with stereotypes `«POJO»`, `«ServiceObject»`, `«DomainObject»`, `«PersistentObject»` and `«QueryObject»` it is not required to define access methods for attributes or associations explicitly in the UML model. JEAF Generator will generate them by default. For attributes there will be set and get methods. 

In case of associations depending on the multiplicity of the association ends there either will be get and set methods (`0..1` or `1`) or add, set, get and remove methods (`1..*` or `0..*`):

- Attribute (e.g. `name`)
  
  - `String getName( )`
  
  - `void setName(String pName)`

- `0..1` or `1` Association (e.g. `owner`)
  
  - `Person getOwner()`
  
  - `void setOwner(Person pOwner)`
  
  - `unsetOwner()`

- `0..*` or `1..*` Association (e.g. `bookings`)
  
  - `Set<Booking> getBookings()`
  
  - `void setBookings(Set<Booking> pBookings)`
  
  - `void addToBookings(Booking pBooking)`
  
  - `void addToBookings(Collection<Booking> pBookings)`
  
  - `void removeFromBookings(Booking pBooking)`
  
  - `void clearBookings()`

<br>

## Associations between Classes

UML supports a wide variety of associations between classes (associations, aggregation, directed associations and composition). All of them have a little different semantics. However when it comes to their representation in the Java code then they are all the same.

<br>

**Bidirectional and Directed Associations**

However, it is important to understand that there is a big difference between directed and bidirectional associations. From the model perspective the difference seems to be just a detail but when it comes to the generated code it has a big impact:

- **Bidirectional Associations**<br>
  If a association is modeled to be bidirectional then the generated code will ensure the consistency of that association in both directions.<br>Example:
  
  - Class `A` has a bidirectional many-to-many association with class `B`. If we now add an object of class `B` to `A` then the generated code will ensure that the association from `B` to `A` is also set accordingly.<br><br>

- **Directed Associations**<br>In case of directed associations the references are only maintained into one direction as the association is not bidirectional.

<br>

## Java Bean Validation (JSR-380)

JEAF Generator also support Java Bean Validation. To make use of it operations, properties and parameters can be tagged using the matching stereotypes as described in [Java Bean Validation](../uml-modeling-guide/java-bean-validation). JEAF Generator will use this information and will generated the appropriate annotation.

In addition it is possible to add automated validation to the following artifacts:

- Request and Response Validation in REST Controllers (Maven configuration parameter)

- Request and Response Validation in REST Client Classes (aka REST Service Proxies) (Maven configuration parameter)

- Object Validation inside builders when objects are created (defined in UML model or as Maven configuration parameter for all generated objects)<br>

<br>

**Note:**

- Please be aware that for all stereotypes / annotations `null` is considered to be a valid value. Only exception is `@NotNull`.
  
  <br>

**JEAF Generator supports the following validation annotations:**<br>
<br>

| **Stereotype**     | **Description** <sup>1)</sup>                                                                                                                                                                                                                                          | **Applicable Types** <sup>2)</sup>                                             |
| ------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| `@AssertFalse`     | The annotated element must be false.                                                                                                                                                                                                                                   | `boolean`                                                                      |
| `@AssertTrue`      | The annotated element must be true.                                                                                                                                                                                                                                    | `boolean`                                                                      |
| `@DecimalMax`      | The annotated element must be a number whose value must be lower or equal to the specified maximum. Note that `double` and `float` are not supported due to rounding errors.                                                                                           | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long`                     |
| `@DecimalMin`      | The annotated element must be a number whose value must be higher or equal to the specified minimum. Note that `double` and `float` are not supported due to rounding errors.                                                                                          | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long`                     |
| `@Digits`          | The annotated element must be a number within accepted range.                                                                                                                                                                                                          | `BigDecimal`, `BigInteger`, `String`, `byte`, `short, int`, `long`             |
| `@Email`           | The string has to be a well-formed email address. Exact semantics of what makes up a valid email address are left to Jakarta Bean Validation providers.                                                                                                                | `String`                                                                       |
| `@Future`          | The annotated element must be an instant, date or time in the future.                                                                                                                                                                                                  | Java date types                                                                |
| `@FutureOrPresent` | The annotated element must be an instant, date or time in the present or in the future.                                                                                                                                                                                | Java date types                                                                |
| `@Max`             | The annotated element must be a number whose value must be lower or equal to the specified maximum. Note that `double` and `float` are not supported due to rounding errors.                                                                                           | `BigDecimal, BigInteger, byte, short, int, long`                               |
| `@Min`             | The annotated element must be a number whose value must be higher or equal to the specified minimum. Note that `double` and `float` are not supported due to rounding errors.                                                                                          | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long`                     |
| `@Negative`        | The annotated element must be a strictly negative number (e.g. 0 is considered as an invalid value).                                                                                                                                                                   | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long` , `float`, `double` |
| `@NegativeOrZero`  | The annotated element must be a negative number or 0.                                                                                                                                                                                                                  | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long` , `float`, `double` |
| `@NotBlank`        | The annotated element must not be `null` and must contain at least one non-whitespace character.                                                                                                                                                                       | `String`                                                                       |
| `@NotEmpty`        | The annotated element must not be `null` nor empty.                                                                                                                                                                                                                    | `String`                                                                       |
| `@NotNull`         | The annotated element must not be `null`.                                                                                                                                                                                                                              | any type                                                                       |
| `@Null`            | The annotated element must be `null`.                                                                                                                                                                                                                                  | any type                                                                       |
| `@Past`            | The annotated element must be an instant, date or time in the past.                                                                                                                                                                                                    | Java date types                                                                |
| `@PastOrPresent`   | The annotated element must be an instant, date or time in the past or in the present.                                                                                                                                                                                  | Java date types                                                                |
| `@Pattern`         | The annotated `String` must match the specified regular expression. The regular expression follows the Java regular expression conventions see `java.util.regex.Pattern`.                                                                                              | `String`                                                                       |
| `@Positive`        | The annotated element must be a strictly positive number (e.g. 0 is considered an invalid value).                                                                                                                                                                      | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long` , `float`, `double` |
| `@PositiveOrZero`  | The annotated element must be a positive number or 0.                                                                                                                                                                                                                  | `BigDecimal`, `BigInteger`, `byte`, `short`, `int`, `long` , `float`, `double` |
| `@Size`            | The annotated element size must be between the specified boundaries (included).                                                                                                                                                                                        | `String`, `Collection`, `Map`, `Array`                                         |
| `@Valid`           | Marks a property, method parameter or method return type for validation cascading. Constraints defined on the object and its properties are be validated when the property, method parameter or method return type is validated. This behavior is applied recursively. | Property, parameter or return type                                             |

<br>

<sup>1)</sup> *Description is taken from [OpenJDK](https://openjdk.org/)*<br>
<sup>2)</sup> *In case of primitives also their respective wrapper types*