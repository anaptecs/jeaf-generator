/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.Type;

import com.anaptecs.jeaf.xfun.api.checks.Check;

public class Naming {

  public static final String STEREOTYPE_PERSISTENT_OBJECT = "JMM::PersistentObject";

  public static final String STEREOTYPE_DOMAIN_OBJECT = "JMM::DomainObject";

  private static final String PARAM_SEPERATOR = ", ";

  public static final char PARAM_PREFIX = 'p';

  public static final char COMMAND_CLASS_NAME_SEPERATOR = '_';

  public static String getUMLQualifiedName( org.eclipse.uml2.uml.NamedElement pNamedElement ) {
    return Naming.getFullyQualifiedName(pNamedElement, true);
  }

  public static String getFullyQualifiedName( org.eclipse.uml2.uml.NamedElement pNamedElement ) {
    return Naming.getFullyQualifiedName(pNamedElement, false);
  }

  private static String getFullyQualifiedName( org.eclipse.uml2.uml.NamedElement pNamedElement,
      boolean pIgnoreTemplateBinding ) {
    // Check parameter.
    String lQualifiedName;
    if (pNamedElement != null) {
      // Is primitive type
      if (pNamedElement instanceof PrimitiveType) {
        lQualifiedName = pNamedElement.getName();
      }
      else if (pNamedElement instanceof Class || pNamedElement instanceof Interface
          || pNamedElement instanceof Enumeration) {

        // Generate FQN for class with template binding
        if (pNamedElement instanceof Class && ((Class) pNamedElement).getTemplateBindings().isEmpty() == false
            && pIgnoreTemplateBinding == false) {
          lQualifiedName = Naming.getTemplateBindingFQN((Class) pNamedElement);
        }
        else {
          Element lOwner = pNamedElement.getOwner();
          if (lOwner instanceof NamedElement) {
            String lPackageName = Naming.getFullyQualifiedName((NamedElement) lOwner);
            if (lPackageName != null && lPackageName.length() > 0) {
              lQualifiedName = lPackageName + '.' + pNamedElement.getName();
            }
            else {
              lQualifiedName = pNamedElement.getName();
            }
          }
          // In case of template types no package is present.
          else {
            lQualifiedName = pNamedElement.getName();
          }
        }
      }
      // Get type of port.
      else if (pNamedElement instanceof Port) {
        Port lPort = (Port) pNamedElement;
        final Type lPortType = lPort.getType();
        String lPackageName = ClassUtil.getPackageName(lPortType);
        if (lPackageName != null && lPackageName.length() > 0) {
          lQualifiedName = lPackageName + '.' + lPortType.getName();
        }
        else {
          lQualifiedName = lPortType.getName();
        }
      }
      // Get type of property
      else if (pNamedElement instanceof Property) {
        Property lProperty = (Property) pNamedElement;
        lQualifiedName = ClassUtil.getTypeName(lProperty);
      }
      else if (pNamedElement instanceof Operation) {
        Element lOwner = pNamedElement.getOwner();
        String lOwnerName = getFullyQualifiedName((NamedElement) lOwner);
        lQualifiedName = lOwnerName + "." + pNamedElement.getName();
      }
      else if (pNamedElement instanceof Package) {
        lQualifiedName = ClassUtil.getPackageName(pNamedElement);
      }
      else {
        lQualifiedName = pNamedElement.getName();
      }
      if (lQualifiedName.equals("java.lang.Class")) {
        lQualifiedName = "java.lang.Class<?>";
      }
    }
    else {
      lQualifiedName = "unknown";
    }

    return lQualifiedName;
  }

  public static String getTemplateBindingFQN( Class pTemplateClass ) {
    Class lClass = (Class) pTemplateClass;

    TemplateBinding lTemplateBinding = lClass.getTemplateBindings().get(0);

    boolean lMultivalued;
    boolean lOrdered;
    boolean lUnique;
    if (ClassUtil.isStereotypeApplied(lTemplateBinding, "TemplateBindingMultiplicity")) {
      lMultivalued =
          Boolean.valueOf(ClassUtil.getStereotypeValue(lTemplateBinding, "TemplateBindingMultiplicity", "multivalued"));
      lOrdered =
          Boolean.valueOf(ClassUtil.getStereotypeValue(lTemplateBinding, "TemplateBindingMultiplicity", "ordered"));
      lUnique =
          Boolean.valueOf(ClassUtil.getStereotypeValue(lTemplateBinding, "TemplateBindingMultiplicity", "unique"));
    }
    else {
      lMultivalued = false;
      lOrdered = false;
      lUnique = false;
    }
    Class lGenericClass = (Class) lTemplateBinding.getTargets().get(0).getOwner();

    StringBuilder lTemplateParameter = new StringBuilder();
    lTemplateParameter.append(Naming.getFullyQualifiedName(lGenericClass.getPackage()));
    lTemplateParameter.append(".");
    lTemplateParameter.append(lGenericClass.getName());
    lTemplateParameter.append("<");

    if (lMultivalued == true) {
      lTemplateParameter.append(Naming.getCollectionType(lOrdered, lUnique));
      lTemplateParameter.append("<");
    }

    TemplateParameterSubstitution lParameterSubstitution = lTemplateBinding.getParameterSubstitutions().get(0);
    Class lTypeParameterClass = (Class) lParameterSubstitution.getActuals().get(0);
    lTemplateParameter.append(Naming.getFullyQualifiedName(lTypeParameterClass));

    if (lMultivalued == true) {
      lTemplateParameter.append(">");
    }
    lTemplateParameter.append(">");

    return lTemplateParameter.toString();
  }

  public static String getCollectionType( boolean pOrdered, boolean pUnique ) {
    String lCollectionType;
    if (pOrdered == false && pUnique == false) {
      // Type is not unique and not ordered -> Collection
      lCollectionType = Collection.class.getName();
    }
    else if (pOrdered == false && pUnique == true) {
      lCollectionType = Set.class.getName();
    }
    else if (pOrdered == true && pUnique == false) {
      lCollectionType = List.class.getName();
    }
    else {
      lCollectionType = SortedSet.class.getName();
    }
    return lCollectionType;
  }

  public static String getFullyQualifiedNameForXML( org.eclipse.uml2.uml.NamedElement pNamedElement ) {
    String lFullyQualifiedName = Naming.getFullyQualifiedName(pNamedElement);
    if (lFullyQualifiedName.endsWith("<?>")) {
      lFullyQualifiedName = lFullyQualifiedName.substring(0, lFullyQualifiedName.length() - 3);
    }
    return lFullyQualifiedName;
  }

  /**
   * Method checks whether the passed object is a business object. The method returns true if the stereotype business
   * object was applied to the passed object.
   * 
   * @param pNamedElement
   * @return
   */
  public static boolean isPersistentObject( org.eclipse.uml2.uml.NamedElement pNamedElement ) {
    return pNamedElement.getAppliedStereotype(STEREOTYPE_PERSISTENT_OBJECT) != null;
  }

  /**
   * Method uses the passed named element and returns its name as parameter name according to the code conventions.
   * Example: name = "person" return value "pPerson"
   * 
   * @param pNamedElement Named element that should be used as parameter. The parameter must not be null and the name
   * must consist of at least one character.
   * @return String Named element as parameter name. The method never returns null.
   */
  public static String asParameterName( NamedElement pNamedElement ) {
    // Check parameter
    Check.checkInvalidParameterNull(pNamedElement, "pNamedElement");
    Check.checkIsRealString(pNamedElement.getName(), "pNamedElement.getName()");

    final String lName = pNamedElement.getName();

    StringBuffer lBuffer = new StringBuffer(lName.length() + 1);
    lBuffer.append(PARAM_PREFIX);
    lBuffer.append(Character.toUpperCase(lName.charAt(0)));
    lBuffer.append(lName.substring(1));

    return lBuffer.toString();
  }

  /**
   * Method uses the passed named element and returns its name as parameter name according to the code conventions.
   * Example: name = "person" return value "pPerson"
   * 
   * @param pNamedElement Named element that should be used as parameter. The parameter must not be null and the name
   * must consist of at least one character.
   * @return String Named element as parameter name. The method never returns null.
   */
  public static String asInstanceName( NamedElement pNamedElement ) {
    // Check parameter
    Check.checkInvalidParameterNull(pNamedElement, "pNamedElement");
    Check.checkIsRealString(pNamedElement.getName(), "pNamedElement.getName()");

    final String lName = pNamedElement.getName();

    StringBuffer lBuffer = new StringBuffer(lName.length() + 1);
    lBuffer.append(Character.toLowerCase(lName.charAt(0)));
    lBuffer.append(lName.substring(1));

    return lBuffer.toString();
  }

  /**
   * Method returns the name for the JEAF Command class or the passed method object. The returned name will be created
   * from the name of the method and the type of each parameter.
   * 
   * @param pOperation
   * @return
   */
  public static String getCommandClassName( Operation pOperation ) {
    // Check parameter for null.
    Check.checkInvalidParameterNull(pOperation, "pOperation");

    StringBuffer lBuffer = new StringBuffer(128);
    lBuffer.append(Naming.firstToUpper(pOperation.getName()));
    lBuffer.append(COMMAND_CLASS_NAME_SEPERATOR);

    // Append type name of all parameters.
    List<Parameter> lInputParameters = ClassUtil.getInputParameters(pOperation);
    for (Parameter lNextParameter : lInputParameters) {
      lBuffer.append(lNextParameter.getType().getName());
      lBuffer.append(COMMAND_CLASS_NAME_SEPERATOR);
    }

    // Append "Command" as suffix
    lBuffer.append(((NamedElement) pOperation.getOwner()).getName());
    lBuffer.append("_Command");

    // Return name of command class.
    return lBuffer.toString();
  }

  /**
   * Method converts the list of named elements to a Java parameter list for an method call
   * 
   * @param pNamedElements
   * @return
   */
  public static String asParameterDefinitionList( List<? extends NamedElement> pNamedElements ) {
    // Check parameter
    Check.checkInvalidParameterNull(pNamedElements, "pElements");

    StringBuffer lBuffer = new StringBuffer();

    final int lSize = pNamedElements.size();
    for (int i = 0; i < lSize; i++) {
      NamedElement lElement = pNamedElements.get(i);
      lBuffer.append(Naming.getFullyQualifiedName(lElement));
      lBuffer.append(' ');
      lBuffer.append(Naming.asParameterName(lElement));
      if (i < lSize - 1) {
        lBuffer.append(PARAM_SEPERATOR);
      }
    }
    return lBuffer.toString();
  }

  /**
   * Method converts the list of named elements to a Java parameter list for an method call
   * 
   * @param pNamedElements
   * @return
   */
  public static String asParameterList( List<? extends NamedElement> pNamedElements ) {
    // Check parameter
    Check.checkInvalidParameterNull(pNamedElements, "pElements");

    StringBuffer lBuffer = new StringBuffer();

    final int lSize = pNamedElements.size();
    for (int i = 0; i < lSize; i++) {
      NamedElement lElement = pNamedElements.get(i);
      lBuffer.append(Naming.asParameterName(lElement));
      if (i < lSize - 1) {
        lBuffer.append(PARAM_SEPERATOR);
      }
    }
    return lBuffer.toString();
  }

  /**
   * Method changes the first character of the passed string to its upper case character.
   * 
   * @param pString
   * @return
   */
  public static String firstToUpper( String pString ) {
    String lFirstUpperString;
    // String has at least 2 characters
    if (pString.length() > 1) {
      String lFirstCharacter = pString.substring(0, 1);
      String lTail = pString.substring(1, pString.length());
      lFirstUpperString = lFirstCharacter.toUpperCase() + lTail;
    }
    // Not more than one character
    else {
      lFirstUpperString = pString.toUpperCase();
    }
    return lFirstUpperString;
  }

  /**
   * Method changes the first character of the passed string to its lower case character.
   * 
   * @param pString
   * @return
   */
  public static String firstToLower( String pString ) {
    String lFirstLowerString;
    // String has at least 2 characters
    if (pString.length() > 1) {
      String lFirstCharacter = pString.substring(0, 1);
      String lTail = pString.substring(1, pString.length());
      lFirstLowerString = lFirstCharacter.toLowerCase() + lTail;
    }
    // Not more than one character
    else {
      lFirstLowerString = pString.toLowerCase();
    }
    return lFirstLowerString;
  }

  public static Set<String> getOperationNames( Interface pInterface ) {
    Set<String> lNames = new HashSet<String>();
    for (Operation lOperation : pInterface.getOwnedOperations()) {
      lNames.add(lOperation.getName());
    }
    return lNames;
  }

  public static String fromParameterToInstance( NamedElement pElement ) {
    String lName = pElement.getName();
    if (lName.length() > 1) {
      lName = lName.substring(1);
    }
    return Naming.firstToLower(lName);
  }
}
