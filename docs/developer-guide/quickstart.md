---
title: "Developer Guide"
subtitle: "Quickstart"
toc: true
menubar: developer_guide_menu
---

## Preconditions

Please ensure, before you jump into the sample code, that you are familiar with the model driven development process in general. You will find further information about that on the following sides:<br>

- [JEAF Generator](../)

- [UML Modelling Guide](/uml-modeling-guide)

<br>

## Download JEAF Generator Sample Project

If you want to work with JEAF Generator we strongly recommend to checkout our sample project. Jumping through the code is a very meaningful thing to do besides reading all the documentation.<br>

- **anaptecs GitHub Repository**  
  Clone latest version directly from our [GitHub repository](https://github.com/anaptecs/jeaf-generator-samples)

<br>

## Structure of the example project

As you can see in our [Modeling Guide](/uml-modeling-guide) JEAF Generator is able to generate lots of different types of code based on the UML model. To ensure a better overview in the example project we created an independent Maven sub module for every content 
type that will be generated.

<br>

| **Maven Project**                   | **Description**                                                                                                                                                                                                                                                                                                                                                                            | **Git Repository Link**                                                                                                                                                                                                                        |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `jeaf-generator-sample-project`     | Top level project of sample.                                                                                                                                                                                                                                                                                                                                                               |                                                                                                                                                                                                                                                |
| `accounting-model`                  | Project contains the UML model of the sample project as well as the appropriate XMI export (sub directory `xmi`) and a HTML export (sub directory `html`) of the model. Sub modules that make use of JEAF Generator reference the packaged UML model via Maven dependency.<br>[Define XMI as Input for JEAF Generator](../maven-integration/#configuration-of-jeaf-generator-maven-plugin) | [accounting-model](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-model)                                                                                                                                                                                                         |
| `accounting-service-objects`        | Project contains the service objects that are generated from the UML model.<br>[Generating Code for Services](../code-for-jeaf-services)                                                                                                                                                                                                                                                   | [accounting-service-objects](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-service-objects)                      |
| `accounting-services-api`           | Project contains the service interfaces of the generated services of the sample project.<br>[Generating Code for Services](../code-for-jeaf-services)                                                                                                                                                                                                                                      | [accounting-services-api](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-services-api)                               |
| `accounting-services-api-runtime`   | Project contains the generated runtime classes for services that are required by JEAF Framework<br>[Generating Code for Services](../code-for-jeaf-services)                                                                                                                                                                                                                               | [accounting-services-api-runtime](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-services-api-runtime)       |
| `accounting-rest`                   | Project contains the generated REST facade for services<br>[Generating Code for Services](../code-for-jeaf-services)                                                                                                                                                                                                                                                                       | [accounting-rest](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-rest)                                                       |
| `accounting-services-impl`          | Project contains the generated stubs for service implementations.<br>[Generating Code for JEAF Components](../code-for-jeaf-components)                                                                                                                                                                                                                                                    | [accounting-services-impl](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-services-impl)                            |
| `accounting-services-impl-runtime`  | Project contains the generated runtime classes for JEAF Components<br>[Generating Code for JEAF Components](../code-for-jeaf-components)                                                                                                                                                                                                                                                   | [accounting-services-impl-runtime](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-services-impl-runtime)    |
| `accounting-persistent-objects`     | Project contains the generated persistent classes.<br>[Generating Code for JEAF Persistence](../code-for-jeaf-persistence)                                                                                                                                                                                                                                                                 | [accounting-persistent-objects](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-persistent-objects)             |
| `accounting-domain-objects`         | Project contains the generated domain objects.<br>[Generating Code for Domain Objects](../code-for-domain-objects)                                                                                                                                                                                                                                                                         | [accounting-domain-objects](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-domain-objects)                         |
| `accounting-pojos`                  | Project contains the generated POJOs.<br>[Generating Code for POJOs](../code-for-pojos)                                                                                                                                                                                                                                                                                                    | [accounting-pojos](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-pojos)                                                    |
| `accounting-object-mappers`         | Project contains generated Object Mappers.<br>[Generating Code for Object Mappings](../code-for-object-mappings)                                                                                                                                                                                                                                                                           | [accounting-object-mappers](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-object-mappers)                         |
| `accounting-activities-api`         | Project contains the generated interfaces for activities.<br>[Generating Code for JEAF Activities](../developer-guide/code-for-jeaf-activities)                                                                                                                                                                                                                                            | [accounting-activities-api](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-activities-api)                         |
| `accounting-activities-impl`        | Project contains the generated stubs for activities.<br>[Generating Code for JEAF Activities](../developer-guide/code-for-jeaf-activities)                                                                                                                                                                                                                                                 | [accounting-activities-impl](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-activities-impl)                      |
| `accounting-service-providers-api`  | Project contains the generated interface for service providers.<br>[Generating Code for JEAF Service Providers](../code-for-jeaf-service-providers)                                                                                                                                                                                                                                        | [accounting-service-providers-api](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-service-providers-api)    |
| `accounting-service-providers-impl` | Project contains the generated stubs for service provider implementations.<br>[Generating Code for JEAF Service Providers](../code-for-jeaf-service-providers)                                                                                                                                                                                                                             | [accounting-service-providers-impl](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-service-providers-impl) |
| `accounting-junit-testcases`        | Project contains the generated stubs to test services.<br>[Generating Code for JEAF Service](../code-for-jeaf-services)                                                                                                                                                                                                                                                                    | [accounting-junit-testcases](https://github.com/anaptecs/jeaf-generator-samples/tree/main/accounting-junit-testcases)                      |

<br>

**Note:**

* In general the configuration of the sample project is a very good baseline to setup your projects.<br>
  
  However in case of the sample project all output will be written to `src-gen` / `res-gen`. This will ensure that also code / resources that actually are only generated once are always up-to-date. However in real life this is not a good setup as manual code will be overwritten every time JEAF Generator will be executed :wink:

<br>

## UML Model

As mentioned several times before JEAF Generator needs an UML model as input for code generation. This sample project here uses a very simple UML model that was created to demonstrate modeling and code generation. Thus the model concentrates mostly on how to model but not on correct representation of a special business.<br>

Most important parts of the model will be shown here. In addition the sample project also contains the MagicDraw UML project files as well as an HTML export of the model.

<br>

### POJOs

<a href="../../images/model_pojos.jpg" target="_blank">
<img src="../../images/model_pojos.jpg" alt="Model of POJOs">
</a>

**Examples**

<details>
  <summary><code>Account.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-pojos%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fpojo%2FAccount.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>AccountBase.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-pojos%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fpojo%2FAccountBase.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>Booking.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-pojos%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fpojo%2FBooking.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

### Service Interface

<a href="../../images/model_accounting_service.jpg" target="_blank">
<img src="../../images/model_accounting_service.jpg" alt="Model of AccountingService">
</a>

**Examples**

<details>
  <summary><code>AccountingService.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-services-api%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FAccountingService.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>Company.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FCompany.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>BankType.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FBankType.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>CustomerQuery.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FCustomerQuery.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>
<details>
  <summary><code>CustomerLoadStrategy.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-service-objects%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2FCustomerLoadStrategy.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

### Components

<a href="../../images/model_accounting_component.jpg" target="_blank">
<img src="../../images/model_accounting_component.jpg" alt="Model of component">
</a>

<br>

### Activities

<a href="../../images/model_activities.jpg" target="_blank">
<img src="../../images/model_activities.jpg" alt="Model of activities">
</a>

**Examples**

<details>
  <summary><code>CreateCustomerActivity.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-activities-api%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Factivities%2FCreateCustomerActivity.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<details>
  <summary><code>CreateCustomerActivityImpl.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-activities-impl%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Factivities%2FCreateCustomerActivityImpl.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

### Object Mappings

<a href="../../images/model_object_mappings.jpg" target="_blank">
<img src="../../images/model_object_mappings.jpg" alt="Model of object mappings">
</a>

**Examples**

<details>
  <summary><code>CustomerToCustomerBOConverter.java</code></summary>
  <script src="https://emgithub.com/embed-v2.js?target=https%3A%2F%2Fgithub.com%2Fanaptecs%2Fjeaf-generator-samples%2Fblob%2Fmain%2Faccounting-object-mappers%2Fsrc-gen%2Fmain%2Fjava%2Fcom%2Fanaptecs%2Fjeaf%2Faccounting%2Fimpl%2Fdomain%2Fmapper%2FCustomerToCustomerBOConverter.java&style=base16%2Fatelier-forest-light&type=code&showBorder=on&showFileMeta=on&showFullPath=on&showCopy=on"></script>
</details>

<br>

### Role Definitions

<a href="../../images/model_role_definitions.jpg" target="_blank">
<img src="../../images/model_role_definitions.jpg" alt="Model of role definitions">
</a>

<br>

### Service Providers

<a href="../../images/model_service_providers.jpg" target="_blank">
<img src="../../images/model_service_providers.jpg" alt="Model of service providers">
</a>

<br>

### Persistent Classes

<a href="../../images/model_persistent_classes.jpg" target="_blank">
<img src="../../images/model_persistent_classes.jpg" alt="Model of persistent classes">
</a>
