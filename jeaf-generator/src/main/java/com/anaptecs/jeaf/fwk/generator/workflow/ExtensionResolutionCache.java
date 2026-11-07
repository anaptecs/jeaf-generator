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
 * Cache for the resolution of Xtend extensions (functions) that are called from checks, extensions and templates.
 *
 * oAW 4.3.1 resolves the called extension on every call by searching linearly through all extensions that are visible
 * from the current resource ({@link org.openarchitectureware.type.baseimpl.PolymorphicResolver#getExtension}). This
 * also applies to extensions marked as <code>cached</code>, as their result is only cached after the extension was
 * resolved. Profiling showed that about 60% of the time for model checks and code generation is spent there.
 *
 * The result of the resolution only depends on the current resource (it defines the visible extensions), the name of
 * the extension and the types of the parameters. So it can be cached for the whole execution of a workflow component.
 *
 * One instance is shared between an execution context and all its clones. oAW executes workflows single-threaded, so no
 * synchronization is needed.
 */
public class ExtensionResolutionCache {
  /**
   * Resolved extensions. Value <code>null</code> means that no matching extension exists.
   */
  private final Map<Key, Extension> resolvedExtensions = new HashMap<>();

  /**
   * Returns the cached extension or resolves it using the passed resolver.
   *
   * @param pResource Resource from which the extension is called. May be <code>null</code>.
   * @param pName Name of the called extension.
   * @param pParameterTypes Types of the parameters.
   * @param pResolver Resolves the extension if it isn't cached yet.
   * @return {@link Extension} Resolved extension or <code>null</code> if there is none.
   */
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
   * Key of the cache. Resources are compared by identity, as oAW loads each resource only once.
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
