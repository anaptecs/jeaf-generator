package com.anaptecs.jeaf.fwk.generator.workflow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import org.openarchitectureware.expression.Resource;
import org.openarchitectureware.type.Type;
import org.openarchitectureware.xtend.ast.Extension;

/**
 * Caches the resolution of called Xtend extensions. oAW 4.3.1 searches linearly through all visible extensions on every
 * call (also for <code>cached</code> ones), which took about 60% of the generation time. The result only depends on
 * current resource, name and parameter types. Shared by a context and its clones; oAW runs single-threaded.
 */
public class ExtensionResolutionCache {
  /**
   * Value <code>null</code>: no matching extension exists.
   */
  private final Map<Key, Extension> resolvedExtensions = new HashMap<>();

  public Extension getExtension( Resource pResource, String pName, Type[] pParameterTypes,
      Supplier<Extension> pResolver ) {
    Key lKey = new Key(pResource, pName, pParameterTypes);
    Extension lExtension = resolvedExtensions.get(lKey);
    if (lExtension == null && resolvedExtensions.containsKey(lKey) == false) {
      lExtension = pResolver.get();
      resolvedExtensions.put(lKey, lExtension);
    }
    return lExtension;
  }

  /**
   * Resources are compared by identity, as oAW loads each resource only once.
   */
  private static final class Key {
    private final Resource resource;

    private final String name;

    private final List<Type> parameterTypes;

    private final int hashCode;

    Key( Resource pResource, String pName, Type[] pParameterTypes ) {
      resource = pResource;
      name = pName;
      parameterTypes = Arrays.asList(pParameterTypes.clone());
      hashCode = Objects.hash(System.identityHashCode(resource), name, parameterTypes);
    }

    @Override
    public int hashCode( ) {
      return hashCode;
    }

    @Override
    public boolean equals( Object pObject ) {
      boolean lEqual;
      if (this == pObject) {
        lEqual = true;
      }
      else if (pObject instanceof Key) {
        Key lOther = (Key) pObject;
        lEqual = resource == lOther.resource && name.equals(lOther.name) && parameterTypes.equals(lOther.parameterTypes);
      }
      else {
        lEqual = false;
      }
      return lEqual;
    }
  }
}
