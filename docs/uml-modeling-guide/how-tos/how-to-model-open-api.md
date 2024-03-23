---
title: "UML Modeling Guide"
subtitle: "How to publish REST Services as OpenAPI 3 specification"
toc_title: " "
menubar: how_to_menu
---

# How to publish REST Services as OpenAPI 3 specification

When you want to publish your REST services also using OpenAPI 3 specification standard then this can be done very simple. Only a small amount of additional information inside the UML model is required and then JEAF Generator can generate a complete OpenAPI 3 specification of your services.

<br>

Therefore the following steps need to be done:

- Define an OpenAPI Specification component with stereotype `«OpenAPI3Specification»`

- Define one or more OpenAPI Server that are hosting your REST services

- Mark the classes that should be published as OpenAPI types

- Link your OpenAPI Specification with the packages that contain your data type definitions

- Link your OpenAPI Specification with the REST services you want to publish

![OpenAPI Spec Example](/images/open-api-spec-example.png)

The example model above shows what needs to be done the publish your REST services as OpenAPI Specification.

As you can see you need to create a component that is tagged with stereotype `«OpenAPI3Specification»`. This component represents the YAML file that will be generated as OpenAPI Specification. To generate a valid OpenAPI Specification it is required that you provide some additional information. They can be defined using the tagged values of stereotype (for details please see page [«OpenAPI 3 Specification»](/uml-modeling-guide/jmm/OpenAPI3Specification/)).

If you like you can also define the servers on which your REST services are available. To do so you again need to create a new component in your UML model. This time it has to be tagged with stereotype `«OpenAPIServer»`. In addition also a dependency between your specification component and your server has to be defined.

In most cases your REST service will not only work with simple types but will also make use of complex types which are already defined as classed in your model. In this case you need to mark your classes with stereotype `«OpenAPIType»` and that’s it. Most likely you will also have some enumerations. Here it’s the same. Mark them with stereotype `«OpenAPIEnumeration»` and they will also be part of your OpenAPI specification.

When generating code for OpenAPI types JEAF Generator will also respect information about access type of properties (read-only, read-write and write-only). They can either be defined for OpenAPI only using stereotype [«OpenAPIProperty»](/uml-modeling-guide/jmm/OpenAPIProperty/) or through UML standard fields (`readOnly` in UML) or through Java Validation annotations ([Java Bean Validation Stereotypes](/uml-modeling-guide/jmm/stereotypes-for-java-bean-validation/)).

As you can see in the diagram above also so called bean parameters are supported. [Bean parameters](/uml-modeling-guide/jmm/BeanParam/) can be used for REST services to group a set of parameters together e.g. you always have the same context parameters that are supported on requests.

To define which data type definitions belong to your OpenAPI Specification you simply need to define a dependency to their packages. JEAF Generator will then add all of them to your specification.

![OpenAPI Spec Example Service](/images/open-api-spec-example-service.png)

The final step is to also connect your REST services with the specification. To do so you need to define a dependency between your OpenAPI Specification and your REST services.

<br>

## How to modularize OpenAPI Specifications

As soon as you will start to work with OpenAPI on a more complex scenario you will find out that the YAML files will become rather big and confusing. Of course you still have your UML model where you have a way better overview. However also from the life cycle perspective it might be a good idea to split a large specifications into smaller pieces.

![OpenAPI Spec References](/images/open-api-spec-references.png)

OpenAPI does not define an explicit concept of modules or anything like that but it allows to reference elements that are located in another OpenAPI Specification. And this is exactly the way how we can modularize our specs. Instead of defining one large OpenAPI Specification in the UML model we define multiple of them and them link them together using dependencies with stereotype `«OpenAPISpecReference»`.

As you can see in the diagram above OpenAPI Specification `Product Services` has a dependency on `Product Base Definitions`. This means that all types from `Product Base Definitions` can also be used in `Product Services`. By default it is assumed that the referenced specification is located in the same directory as the other one. However it it also supported to define an URL for the referenced specification (for details please refer to stereotype [«OpenAPISpecReference»](/uml-modeling-guide/jmm/OpenAPISpecReference/)).

When you define dependencies between OpenAPI Specifications please ensure that all of them support [Semantic Versioning](https://semver.org/ "https://semver.org/") otherwise changes of dependent specification might make your API incompatible to previous versions.

<br>

Please also refer to:

- [How to model REST Services](/uml-modeling-guide/how-to-model-rest-service-apis/)
