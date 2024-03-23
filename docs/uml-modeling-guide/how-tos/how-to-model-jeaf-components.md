---
title: "UML Modeling Guide"
subtitle: "How to model Activities"
toc_title: " "
menubar: how_to_menu
---

# How to model JEAF Components

## Components

Components are, according to [JEAF Architecture](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/515276970 "/wiki/spaces/JEAF/pages/515276970"), self-contained, reusable pieces of software. They provide their functionality as one or more services.

![Components](/images/components.png)

The diagram above shows an example model for a component. As you can see there component Accounting implements the services `AccountingService` and `AccountingBasicDataService`. In addition the component also depends on services `SchufaService` of component `SCHUFA` and `SwiftAccountingService` of component `SWIFTAccounting`.

When modelling components it is also very important that components are marked with stereotype `«JEAFComponent»`. In section “Required / Provided Interfaces” of the component specification the services shown in the diagram above need to defined.

![Requeired & Provided Services](/images/required_provided_services.png)

Also tagged values of the component have to be set, at least if you do not want to work with the defined default values.

![Tagged Values for Components](/images/component_tagged_values.png)

It is important to define all these information as part of your UML model as JEAF Generator will make use of the when [generating code for components](/developer-guide/code-for-jeaf-components/).

<br>

For further information please also refer to:

- [Generating Code for Components](/developer-guide/code-for-jeaf-components/)

- [«JEAFComponent»](/uml-modeling-guide/jmm/JEAFComponent/)

<br>

## Properties for Components

![Properties for Components](/images/component_properties.png)

As you can see from the diagram directly above it is also possible to define properties for components. When using JEAF and JEAF Generator these properties will be treated as configuration parameters for the component (aka Dynamic Properties). As for any other property also here it is possible to define a default value.

Currently the following types can be used for component properties:

- Java Primitive Types or the corresponding wrappers

- `java.lang.String`

- `java.lang.Class`

- `java.utilCalendar`

- `java.util.Locale`

<br>

For further information about component configuration and dynamic properties please refer to: [Configuration Component Configuration](https://anaptecs.atlassian.net/wiki/spaces/JEAF/pages/558301303/Configuration+Services#Component-Configuration)

<br>

## Usage of UML Ports

UML standard also defines so called ports. Ports are access points for the functionality that is provided by a component. A port, like a component, can provide one or more services.

![Usage of Ports](/images/port.png)

As you can see from the diagram above JEAF and JEAF Generator also support ports. The big benefit of ports in combination with JEAF arises from the fact, that in this case a shared base class for the port will be generated. This class will be the base class for all service implementations. This offers the opportunity to move common functionality of all services to a shared location.

![Port Specification](/images/port_specification.png)

When working with ports then a class for the port has to be defined in the UML model. In the example below this would be `InternalServicePort`. We propose to put the port class into the same package as the component.

<br>

## Usage of persistence units

In case that a component has persistent objects then, due to requirements from Java Persistence API and how it is integrated with JEAF, it is required that the component defines the persistence unit to which it belongs to. To do so just a regular dependency from the component to its persistence unit is required. JEAF and JEAF Generator will take care about the rest.

![Usage of Persistence Units](/images/components_persistence_unit.png)

For further information please also refer to:

- [How to model Persistence Units](/uml-modeling-guide/how-tos/how-to-model-persistence-units/)

- [«PersistenceUnit»](/uml-modeling-guide/jmm/PersistenceUnit/)
