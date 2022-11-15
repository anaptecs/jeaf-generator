/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.UseCase;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * Class contains all helper method for the generation of JEAF Authorization mechanism.
 * 
 * @author JEAF Development Team
 * @version 1.0
 */
public class AuthorizationHelper {

  /**
   * Constant for the separator of the method name and the name of the service interface
   */
  public static final char SEPARATOR = '.';

  public static final String PREFIX = "public static final String ";

  public static final String ASSIGNMENT = "_AUTH_TYPE = \"";

  public static final String END = "\";";

  /**
   * Method returns the names of all authorization types of the passed service interface. The names are created by using
   * the following pattern: <method name>.<class name service>
   * 
   * @param pService Interface for which the authorization type names should be returned. The parameter must not be
   * null.
   * @return {@link Set} Set containing the names of all authorization types. The method never returns null.
   */
  public static List<String> getAuthorizationTypeNames( Interface pService ) {
    // Get all operations an add them to a set. This causes that for all operations with the same name only one
    // authorization type name will exist.
    EList<Operation> lOperations = pService.getOwnedOperations();

    Set<String> lAuthorizationTypeNames = new HashSet<String>();
    for (Operation lNextOperation : lOperations) {
      final String lServiceName = Naming.getFullyQualifiedName(pService);
      String lOperationName = lNextOperation.getName();

      // Calculate length of created string.
      int lLength =
          AuthorizationHelper.PREFIX.length() + lOperationName.length() + AuthorizationHelper.ASSIGNMENT.length()
              + lOperationName.length() + 1 + lServiceName.length() + AuthorizationHelper.END.length();

      StringBuffer lBuffer = new StringBuffer(lLength);
      lBuffer.append(AuthorizationHelper.PREFIX);
      lBuffer.append(lOperationName.toUpperCase());
      lBuffer.append(AuthorizationHelper.ASSIGNMENT);
      lBuffer.append(lOperationName);
      lBuffer.append(AuthorizationHelper.SEPARATOR);
      lBuffer.append(lServiceName);
      lBuffer.append(AuthorizationHelper.END);
      lAuthorizationTypeNames.add(lBuffer.toString());
    }
    // Return set with the names of all authorization types.
    List<String> lResult = new ArrayList<String>(lAuthorizationTypeNames);
    Collections.sort(lResult);
    return lResult;
  }

  /**
   * Method returns all authorization types that are defined due to the services that are defined within the passed
   * model.
   * 
   * @param pModel UML model for which all authorization type names should be returned. The parameter must not be null.
   * @return Set Set containing the names of all authorization types. The method never returns null.
   */
  public static List<String> getAllAuthorizationTypes( Model pModel ) {
    // Check parameter for null
    Check.checkInvalidParameterNull(pModel, "pModel");

    final EList<Element> lAllOwnedElements = pModel.allOwnedElements();
    Set<String> lAuthorizationTypes = new HashSet<String>();

    for (Element lNextElement : lAllOwnedElements) {
      if (lNextElement instanceof Interface && ClassUtil.isStereotypeApplied(lNextElement, "JEAFService")
          && GeneratorCommons.isInGeneratorWhitelist((NamedElement) lNextElement)) {
        Interface lService = (Interface) lNextElement;
        final String lServiceName = "." + Naming.getFullyQualifiedName(lService);
        // Get names of all authorization types of the current service.
        for (Operation lOperation : lService.getOwnedOperations()) {
          lAuthorizationTypes.add(lOperation.getName() + lServiceName);
        }
      }
    }

    // Return set with the name of all authorization types.
    List<String> lResult = new ArrayList<String>(lAuthorizationTypes);
    Collections.sort(lResult);
    return lResult;
  }

  /**
   * Method returns all actors from UML model that have the stereotype "JEAF Actor" assigned.
   * 
   * @param pModel UML model for which all JEAF Actors should be returned. The parameter must not be null.
   * @return Set Set containing all actors. The method never returns null.
   */
  public static List<Actor> getAllJEAFActors( Model pModel ) {
    // Check parameter for null
    Check.checkInvalidParameterNull(pModel, "pModel");

    final EList<Element> lAllOwnedElements = pModel.allOwnedElements();
    Set<Actor> lActors = new HashSet<Actor>();

    for (Element lNextElement : lAllOwnedElements) {
      if (lNextElement instanceof Actor && ClassUtil.isStereotypeApplied(lNextElement, "JEAF Actor")) {
        lActors.add((Actor) lNextElement);
      }
    }

    // Return set with all JEAF Actors.
    List<Actor> lResult = new ArrayList<Actor>(lActors);
    Collections.sort(lResult, new NamedElementComparator());
    return lResult;
  }

  /**
   * Method returns all use cases from UML model.
   * 
   * @param pModel UML model for which all use cases should be returned. The parameter must not be null.
   * @return Set Set containing all use cases. The method never returns null.
   */
  public static List<UseCase> getAllUseCases( Model pModel ) {
    // Check parameter for null
    Check.checkInvalidParameterNull(pModel, "pModel");

    final EList<Element> lAllOwnedElements = pModel.allOwnedElements();
    Set<UseCase> lUseCases = new HashSet<UseCase>();

    for (Element lNextElement : lAllOwnedElements) {
      if (lNextElement instanceof UseCase) {
        lUseCases.add((UseCase) lNextElement);
      }
    }

    // Return set with all use cases.
    List<UseCase> lResult = new ArrayList<UseCase>(lUseCases);
    Collections.sort(lResult, new NamedElementComparator());
    return lResult;
  }

  /**
   * Method returns all uses cases that are associated to the passed actor.
   * 
   * @param pActor Actor whose associated use cases should be returned. The parameter must not be null.
   * @return {@link Set} All use cases that are associated to the passed actor. The method never returns null.
   */
  public static List<UseCase> getAssociatedUseCases( Actor pActor ) {
    final Iterator<Relationship> lIterator = pActor.getRelationships().iterator();
    Set<UseCase> lUseCases = new HashSet<UseCase>();
    while (lIterator.hasNext()) {
      Relationship lRelationship = lIterator.next();
      if (lRelationship instanceof Association) {
        Association lAssociation = (Association) lRelationship;
        final Iterator<Element> lElementIterator = lAssociation.getRelatedElements().iterator();
        while (lElementIterator.hasNext()) {
          Element lNextElement = lElementIterator.next();
          if (lNextElement instanceof UseCase) {
            lUseCases.add((UseCase) lNextElement);
          }
        }
      }
    }
    List<UseCase> lResult = new ArrayList<UseCase>(lUseCases);
    Collections.sort(lResult, new NamedElementComparator());
    return lResult;
  }

  /**
   * Method returns the name of all authorization types that are referenced by the passed actor.
   * 
   * @param pActor Actor whose referenced authorization type names should be returned. The parameter must not be null.
   * @return {@link Set} Names of all authorization types that are referenced by the passed actor. The method never
   * returns null.
   */
  public static List<String> getReferencedAuthorizationTypeNames( Actor pActor ) {
    final Iterator<Relationship> lIterator = pActor.getRelationships().iterator();
    Set<String> lAuthorizationTypeNames = new HashSet<String>();
    while (lIterator.hasNext()) {
      Relationship lRelationship = lIterator.next();

      if (lRelationship instanceof Dependency) {
        Dependency lDependency = (Dependency) lRelationship;

        final List<Element> lRelatedElements = lDependency.getTargets();
        final Iterator<Element> lIterator2 = lRelatedElements.iterator();
        while (lIterator2.hasNext()) {
          Element lElement = lIterator2.next();
          // JEAF Service
          if (lElement instanceof Interface && ClassUtil.isStereotypeApplied(lElement, "JEAFService")) {
            final Interface lService = (Interface) lElement;
            for (Operation lOperation : lService.getOwnedOperations()) {
              lAuthorizationTypeNames.add(AuthorizationHelper.getAuthorizationTypeName(lService, lOperation));
            }
          }

          // Method
          if (lElement instanceof Operation) {
            Operation lOperation = (Operation) lElement;
            final Interface lService = lOperation.getInterface();
            lAuthorizationTypeNames.add(AuthorizationHelper.getAuthorizationTypeName(lService, lOperation));
          }
        }
      }
    }
    List<String> lResult = new ArrayList<String>(lAuthorizationTypeNames);
    Collections.sort(lResult);
    return lResult;
  }

  /**
   * Method creates the authorization type name from the passed service interface and method.
   * 
   * @param pService Interface object describing the service. The parameter must not be null.
   * @param pOperation Object describing the method. The parameter must not be null
   * @return {@link String} Name of the authorization type for the passed method and service. The method never returns
   * null.
   */
  private static String getAuthorizationTypeName( Interface pService, Operation pOperation ) {
    // Calculate size.
    String lServiceName = Naming.getFullyQualifiedName(pService);
    String lOperationName = pOperation.getName();

    StringBuffer lBuffer = new StringBuffer(lServiceName.length() + lOperationName.length() + 1);

    lBuffer.append(lOperationName);
    lBuffer.append(AuthorizationHelper.SEPARATOR);
    lBuffer.append(lServiceName);
    return lBuffer.toString();
  }
}
