---
title: "UML Modeling Guide"
subtitle: "How to use Java Bean Validation"
toc_title: " "
menubar: how_to_menu
---

# How to use Java Bean Validation (JSR 380)

JEAF Generator also supports usage of [Java Bean Validation (JSR-380)](https://beanvalidation.org/2.0-jsr380/ "https://beanvalidation.org/2.0-jsr380/"). This means that for every constraint defined by Java Bean validation there also is a matching stereotype that can be used in UML model. To make use of them you simply have to apply them on attributes, parameters or association ends.

![Java Bean Validation](/images/java-bean-validation.png)

Depending on the concrete constraint it may be required to define additional information as tagged values.

As we do not want to repeat documentation of JSR-380 please have a look on the constraints defined there. The stereotypes of JEAF Meta Model contain an tagged value for every property of the JSR-380 annotations: [Bean Validation API 2.0.1.Final](https://javadoc.io/static/javax.validation/validation-api/2.0.1.Final/index.html?javax/validation/constraints/package-summary.html "https://javadoc.io/static/javax.validation/validation-api/2.0.1.Final/index.html?javax/validation/constraints/package-summary.html")

In addition to the standard features it is also possible to define a [JEAF X-Fun error code](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/1542415 "/wiki/spaces/JEAF/pages/1542415") instead of a plain message. JEAF Framework will convert this error code into a matching error message if the validation fails.

<br>

For further information please also refer to:

- [Java Bean Validation Stereotypes](/uml-modeling-guide/jmm/stereotypes-for-java-bean-validation/)

- [Jakarta Bean Validation 2.0 (JSR 380)](https://beanvalidation.org/2.0-jsr380/ "https://beanvalidation.org/2.0-jsr380/")

- [Javadoc Bean Validation API 2.0.1](https://javadoc.io/doc/javax.validation/validation-api/latest/index.html "https://javadoc.io/doc/javax.validation/validation-api/latest/index.html")

- [JEAF Generator and Java Bean Validation](/developer-guide/general-behavior/#java-bean-validation-jsr-380)

<br>

## How to model and use custom validations

TBD: Define how to use and model custom constraints
