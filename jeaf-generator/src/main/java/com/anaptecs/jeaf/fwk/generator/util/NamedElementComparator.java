/*
 * anaptecs GmbH, Burgstr. 96, 72764 Reutlingen, Germany
 * 
 * Copyright 2004 - 2013 All rights reserved.
 */
package com.anaptecs.jeaf.fwk.generator.util;

import java.util.Comparator;

import org.eclipse.uml2.uml.NamedElement;

/**
 * Class implements comparator for named elements from UML2 meta model.
 * 
 * @author JEAF Development Team
 * @version JEAF Release 1.3
 */
public class NamedElementComparator implements Comparator<NamedElement> {
  public int compare( NamedElement pFirstNamedElement, NamedElement pSecondNamedElement ) {
    return pFirstNamedElement.getName().compareTo(pSecondNamedElement.getLabel());
  }
}
