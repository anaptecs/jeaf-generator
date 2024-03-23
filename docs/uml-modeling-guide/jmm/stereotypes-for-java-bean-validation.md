---
title: "UML Modeling Guide"
subtitle: "Stereotypes for Java Bean Validation «Alias»"
toc: false
menubar: jmm_menu
---

# Stereotypes for Java Bean Validation (JSR 380)

JEAF Generator also support of [Java Bean Validation (JSR-380)](https://beanvalidation.org/2.0-jsr380/ "https://beanvalidation.org/2.0-jsr380/"). This means that for every constraint of defined by Java Bean validation there also is a matching stereotype that can be used in UML model.

| **Stereotype**          | `«Size»`, `«PositiveOrZero»`, `«Positive»`, `«Pattern»`, `«Email»`, `«PastOrPresent»`, `«Past»`, `«Null»`, `«NotNull»`, `«NotEmpty»`, `«NotBlank»`, `«NegativeOrZero»`, `«Negative»`, `«FutureOrPresent»`, `«Future»`, `«AssertTrue»`, `«AssertFalse»`, `«Digits»`, `«Valid»`, `«DecimalMin»`, `«DecimalMax»`, `«Min»`, `«Max»`, `«CustomValidation»`, `«CustomConstraint»` |                                                                                                                                                                                               |
| ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Applicable Elements** | Parameter, Property<br>Stereotype `«Valid»` also for Class                                                                                                                                                                                                                                                                                                                  |                                                                                                                                                                                               |
| **Tagged Values**       |                                                                                                                                                                                                                                                                                                                                                                             |                                                                                                                                                                                               |
| **Name**                | **Type**                                                                                                                                                                                                                                                                                                                                                                    | **Description**                                                                                                                                                                               |
| `severity`              | `Severity`                                                                                                                                                                                                                                                                                                                                                                  | Attribute is used to define the severity if the validation fails. Possible values are: `Info`, `Warning`, `Error` and `NotUsed`                                                               |
| `errorCode`             | `int`                                                                                                                                                                                                                                                                                                                                                                       | Instead of using hard coded error message for validations JEAF  Framework also supports to define a JEAF X-Fun `LocalizationID`. Using the id it is possible to use localized error messages. |

Additional tagged values may be supported depending on the constraint. Those additional tagged values are equivalent to the possibilities as defined by the Java annotations (see https://javadoc.io/doc/javax.validation/validation-api/latest/index.html )

<br>

## Custom Bean Validation Constraints

In addition to the already predefined constraints Java Bean Validation also supports to use custom validations.

TBD: Define how to use and model custom constraints