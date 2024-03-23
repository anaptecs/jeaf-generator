---
title: "UML Modeling Guide"
subtitle: "How to model Object Mappings"
toc_title: " "
menubar: how_to_menu

---

# How to model Object Mappings

JEAF Generator offers the possibility to free developers from error-prawn and boring job of mapping objects from one into another. To do so, a so called object mapping can be defined in the UML model by defining dependencies between attributes using stereotype `«ObjectMapping»`. Object mappings distinguish between creating, updating and reading of objects. As you will see below behavior of an object mapping can be defined for each of the cases.

![Object Mapping](/images/object-mapping.png)

As you can see above, to define an object mapping a dependency between attributes of two classes is required. This dependency is to be tagged with stereotype `«ObjectMapping»`. Using tagged value `onCreate`, `onUpdate` and `onRead` you can define when the dependencies should be taken into account from the generated code.

As you can it’s also possible to use operations on the target side instead of properties. However this is only possible for objects mapping with `onRead` only strategy.

| **Source**    | **Target**                       |                 |
| ------------- | -------------------------------- | --------------- |
|               | **Attribute**                    | **Operation**   |
| **Attribute** | `onCreate`, `onUpdate`, `onRead` | `onRead`        |
| **Operation** | `not supported`                  | `not supported` |

When defining object mappings it’s also important to have a look on the table below. As you can see only some combinations between source and target object types are supported.

| **Source**            | **Target**                                                |                                                           |                                                           |                                                           |
| --------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
|                       | **Service Object**                                        | **POJO**                                                  | **Domain Object**                                         | **Persistent Object**                                     |
| **Service Object**    | <i class="fa-solid fa-check" style="color: #008040;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> |
| **POJO**              | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> |
| **Domain Object**     | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> | <i class="fa-solid fa-check" style="color: #008040;"></i> |
| **Persistent Object** | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> | <i class="fa-solid fa-xmark" style="color: #DE3255;"></i> |

<br>

For further information please also refer to:

- [Generating Code for Object Mappings](/developer-guide/code-for-object-mappings/)

- [«ObjectMapping»](/uml-modeling-guide/jmm/ObjectMapping/)
