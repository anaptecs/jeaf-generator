---
title: "Developer Guide"
subtitle: "Introduction"
menubar: developer_guide_menu
---

![Current Version](https://maven-badges.herokuapp.com/maven-central/com.anaptecs.jeaf.generator/jeaf-generator/badge.svg)

# Developer Guide

JEAF Generator can be used for code generation based on UML models. JEAF Generator supports a wide variety of artifacts that can be generated like Services, REST Resources, POJO's, OpenAPI specs, persistent classes and many more. As JEAF Generator is designed to be used in all kinds of enterprise projects it offers a large set of features that are required to provide scalable, high performant enterprise applications.<br>

JEAF Generator is provided as Maven Plugin that is supposed to be integrated into your standard build process. All required configurations are done through the plugin configuration.<br>

Main input for JEAF Generator is an XMI Export of your UML model. In addition you have to configure for Maven Plugin which parts of the model  should be taken into account during the generation process and what should be generated.

<br>

## Development Process

In general the development consists of the following steps:

| Steps                                               | Additional Information                                                                    |
| --------------------------------------------------- |:----------------------------------------------------------------------------------------- |
| `1. Create / update classes etc. in UML model`      | - [UML Modeling Guide](/uml-modeling-guide)<br/>- [UML Modeling Guidelines]()           |
| `2. Export UML model to XMI`                        | - [MagicDraw XMI Export](/uml-modeling-guide/magic-draw-xmi-export)                                           |
| `3. Run JEAF Generator as part of your Maven build` | - [Maven Integration](maven-integration)<br>- [Generating Code](overview-generating-code) |
| `4. Implement parts that need to be done manually`  |                                                                                           |
| `5. Test and integrate your changes`                |                                                                                           |

<br>

## Next Steps

For further information we recommend to have a look at the following sections:

- [JEAF Generator General Behavior](general-behavior) 
- [Quickstart Guide](/developer-guide/quickstart)
- [Checkout the example project from our Git repository](https://bitbucket.org/anaptecs/jeaf-generator-samples)
- [Check UML Modeling Guide](/uml-modeling-guide)