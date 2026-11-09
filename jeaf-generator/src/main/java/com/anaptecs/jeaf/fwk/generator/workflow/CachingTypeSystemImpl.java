package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.openarchitectureware.expression.TypeSystemImpl;
import org.openarchitectureware.type.Operation;
import org.openarchitectureware.type.Type;
import org.openarchitectureware.uml2.profile.MultipleStereotypeType;

/**
 * Type system that speeds up type lookups and operation calls of oAW 4.3.1:
 * <ul>
 * <li>For model elements with more than one stereotype oAW creates a new {@link MultipleStereotypeType} on every lookup,
 * so its caches for operations and features never hit and every operation call is resolved again. Here all elements
 * with the same stereotypes share one type.</li>
 * <li>Types of model elements are cached by identity, strings get the string type directly and collections a type per
 * class. oAW asks all metamodels for every collection and uses <code>WeakHashMap</code> lookups otherwise.</li>
 * <li>Results of UML operation <code>allOwnedElements()</code> are cached per element, as UML2 collects all contained
 * elements on every call. The model isn't changed during generation and UML2 returns an unmodifiable list.</li>
 * </ul>
 * oAW runs single-threaded.
 */
public class CachingTypeSystemImpl extends TypeSystemImpl {
  private static final String ALL_OWNED_ELEMENTS = "allOwnedElements";

  private final Map<EObject, Type> elementTypes = new IdentityHashMap<>();

  /**
   * Shared types for elements with multiple stereotypes, by type name (names of all stereotypes).
   */
  private final Map<String, Type> multipleStereotypeTypes = new HashMap<>();

  private final Map<Class<?>, Type> collectionTypes = new HashMap<>();

  /**
   * Caching variants of the operations returned by oAW for <code>allOwnedElements()</code>.
   */
  private final Map<Operation, Operation> allOwnedElementsOperations = new IdentityHashMap<>();

  private final Map<Object, Object> allOwnedElements = new IdentityHashMap<>();

  @Override
  public Type getType( Object pObject ) {
    Type lType;
    if (pObject instanceof String) {
      lType = this.getStringType();
    }
    else if (pObject instanceof EObject) {
      lType = elementTypes.get(pObject);
      if (lType == null) {
        lType = this.toSharedType(super.getType(pObject));
        elementTypes.put((EObject) pObject, lType);
      }
    }
    else if (pObject instanceof Collection) {
      lType = collectionTypes.get(pObject.getClass());
      if (lType == null) {
        lType = super.getType(pObject);
        collectionTypes.put(pObject.getClass(), lType);
      }
    }
    else {
      lType = super.getType(pObject);
    }
    return lType;
  }

  @Override
  public Operation findOperation( String pName, Object pTarget, Object[] pParameters ) {
    Operation lOperation = super.findOperation(pName, pTarget, pParameters);
    if (lOperation != null && ALL_OWNED_ELEMENTS.equals(pName) && pTarget instanceof Element
        && (pParameters == null || pParameters.length == 0)) {
      lOperation = allOwnedElementsOperations.computeIfAbsent(lOperation, CachedResultOperation::new);
    }
    return lOperation;
  }

  private Type toSharedType( Type pType ) {
    Type lType;
    if (pType instanceof MultipleStereotypeType) {
      lType = multipleStereotypeTypes.computeIfAbsent(pType.getName(), lName -> pType);
    }
    else {
      lType = pType;
    }
    return lType;
  }

  /**
   * Operation without parameters whose result is cached per target.
   */
  private final class CachedResultOperation implements Operation {
    private final Operation operation;

    CachedResultOperation( Operation pOperation ) {
      operation = pOperation;
    }

    @Override
    public Object evaluate( Object pTarget, Object[] pParameters ) {
      Object lResult = allOwnedElements.get(pTarget);
      if (lResult == null) {
        lResult = operation.evaluate(pTarget, pParameters);
        allOwnedElements.put(pTarget, lResult);
      }
      return lResult;
    }

    @Override
    public Type getReturnType( Type pTargetType, Type[] pParameterTypes ) {
      return operation.getReturnType(pTargetType, pParameterTypes);
    }

    @Override
    public List<Type> getParameterTypes( ) {
      return operation.getParameterTypes();
    }

    @Override
    public Type getOwner( ) {
      return operation.getOwner();
    }

    @Override
    public String getDocumentation( ) {
      return operation.getDocumentation();
    }

    @Override
    public String getName( ) {
      return operation.getName();
    }

    @Override
    public Type getReturnType( ) {
      return operation.getReturnType();
    }
  }
}
