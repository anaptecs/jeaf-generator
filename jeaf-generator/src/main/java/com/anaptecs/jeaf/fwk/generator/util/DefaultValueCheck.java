package com.anaptecs.jeaf.fwk.generator.util;

import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Checks whether the default value of a property fits its type (check 9209). Only numbers, booleans and enumerations are
 * checked. Opaque expressions are written into the generated code as they are and are therefore not checked.
 */
public final class DefaultValueCheck {
  private static final Set<String> INTEGER_TYPES = Set.of("byte", "short", "int", "long", "Integer", "Byte", "Short",
      "Long", "java.lang.Byte", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.math.BigInteger");

  private static final Set<String> DECIMAL_TYPES = Set.of("float", "double", "Real", "Float", "Double",
      "java.lang.Float", "java.lang.Double", "java.math.BigDecimal");

  private static final Set<String> BOOLEAN_TYPES = Set.of("boolean", "java.lang.Boolean");

  private static final Pattern INTEGER = Pattern.compile("[+-]?\\d+[lL]?");

  private static final Pattern DECIMAL = Pattern.compile("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?[fFdD]?");

  private DefaultValueCheck( ) {
  }

  public static boolean isValidDefaultValue( Property pProperty ) {
    ValueSpecification lDefaultValue = pProperty.getDefaultValue();
    Type lType = pProperty.getType();
    boolean lValid;
    if (lDefaultValue == null || lType == null || lDefaultValue instanceof OpaqueExpression) {
      lValid = true;
    }
    else if (lType instanceof Enumeration) {
      lValid = isValidEnumerationValue((Enumeration) lType, lDefaultValue);
    }
    else {
      lValid = isValidValue(Naming.getFullyQualifiedName(lType), lDefaultValue.stringValue());
    }
    return lValid;
  }

  /**
   * @param pTypeName Fully qualified name of the type as returned by {@link Naming#getFullyQualifiedName}.
   * @param pValue Default value. May be null.
   * @return boolean false if the type is a number or boolean and the value doesn't fit, otherwise true.
   */
  public static boolean isValidValue( String pTypeName, String pValue ) {
    String lValue = pValue != null ? pValue.trim() : "";
    boolean lValid;
    if (INTEGER_TYPES.contains(pTypeName)) {
      lValid = INTEGER.matcher(lValue).matches();
    }
    else if (DECIMAL_TYPES.contains(pTypeName)) {
      lValid = DECIMAL.matcher(lValue).matches();
    }
    else if (BOOLEAN_TYPES.contains(pTypeName)) {
      lValid = "true".equals(lValue) || "false".equals(lValue);
    }
    else {
      lValid = true;
    }
    return lValid;
  }

  private static boolean isValidEnumerationValue( Enumeration pEnumeration, ValueSpecification pDefaultValue ) {
    boolean lValid;
    if (pDefaultValue instanceof InstanceValue) {
      InstanceSpecification lInstance = ((InstanceValue) pDefaultValue).getInstance();
      lValid = lInstance instanceof EnumerationLiteral && ((EnumerationLiteral) lInstance).getEnumeration() == pEnumeration;
    }
    else {
      // Literal name, optionally qualified with the name of the enumeration.
      String lValue = pDefaultValue.stringValue() != null ? pDefaultValue.stringValue().trim() : "";
      String lPrefix = pEnumeration.getName() + ".";
      if (lValue.startsWith(lPrefix)) {
        lValue = lValue.substring(lPrefix.length());
      }
      lValid = pEnumeration.getOwnedLiteral(lValue) != null;
    }
    return lValid;
  }
}
