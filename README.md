![Maven Central Version](https://img.shields.io/maven-central/v/com.anaptecs.jeaf.generator/jeaf-generator-project)


<br>

# JEAF Generator
JEAF Generator uses UML models to generate code for Spring, REST, OpenAPI, Java and others.

Boost your software development efficiency and time-to-market. Bye bye handwritten boiler blade code. Let your developers concentrate on what is really important: delivering business features

This repository contains the source code for JEAF Generator. JEAF Generator can be used for code generation based on UML models. Besides the code of the generator itself the repository also contains lot's of test projects that are used to ensure quality. 

<br>

## How to use it?
JEAF Generator is provided as Maven Plugin and so can be easily integrated into your build process.

For further details please have a look on [Maven Integration](https://www.jeaf-generator.io/developer-guide/maven-integration/) in our developer guide.

<br>

## Releases, Backward Compatibility and Versioning Scheme
* In general we try to keep JEAF Generator and especially the generated code backward compatible when ever possible / meaningful
* The same we also try to apply to JEAF Generator Maven Plugin
* Within the release notes, we will always provide information about hot to upgrade to the next version

<br>

### Verisoning Schema
Concerning the version number s of JEAF Generator Maven Plugin we stick to `MAJOR.MINOR.PATCH` version scheme: 
* `MAJOR`: We increase the major version if the generated code will become incompatible due to generator changes
* `MINOR`: We will increase the minor version when changes to the Maven Plugin configuration or UML model are required before upgrading to a new version
* `PATCH`: We increase the patch level in case that upgrade to next version can just be done without any further changes. Please be aware that in many cases new features are made available with just a new patch version as they do not require and further changes.

<br>

## Links
For further information please refer to our documentation:

* [JEAF Generator](https://www.jeaf-generator.io/)
* [UML Modeling Guide](https://www.jeaf-generator.io/uml-modeling-guide/)
* [Developer Guide](https://www.jeaf-generator.io/developer-guide/)
* [Quickstart Guide](https://www.jeaf-generator.io/developer-guide/quickstart/)
* [Releases](https://github.com/anaptecs/jeaf-generator/releases)

