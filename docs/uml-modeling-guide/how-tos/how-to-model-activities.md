---
title: "UML Modeling Guide"
subtitle: "How to model Activities"
toc_title: " "
menubar: how_to_menu
---

# How to model Activities

Components use activities to implement non-trivial functionality of the services they offer. Activities are used to structure the internal dynamic aspects of a component and help to achieve a better testability.

As for other parts of your UML model JEAF Generator also here supports developers. Therefore JEAF Generator takes activities as an input and generates an interface and an empty implementation class for every activity. In- and output of an activity can be defined using so called in- and output pins in the UML model. If you look at them for a code perspective then input pins will end up as parameter and output pins as return value. This also leads to the situation that you should only have one output pin for every activity. Of course it’s also possible to have activities with no in- and / or output pins.

![Activities](/images/activities.png)

As you can see from the diagram above activities need to be marked with stereotype `JEAFActivity»` and as mentioned before in- and output pins have to be defined. Further information are not required.

![Activity Flow](/images/activity-flow.png)

UML also supports to define a flow of activities (object and control flow). Of course it’s very meaningful to model that. However JEAF Generator is currently not able to take this as an input for code generation.

<br>

For further information please also refer to:

- [«JEAFActivity»](/uml-modeling-guide/jmm/JEAFActivity/)

- [Generating Code for JEAF Activities](/developer-guide/code-for-jeaf-activities/)
